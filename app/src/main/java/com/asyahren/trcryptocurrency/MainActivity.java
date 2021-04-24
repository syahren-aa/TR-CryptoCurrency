package com.asyahren.trcryptocurrency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.asyahren.trcryptocurrency.ConsumeRes.APIList;
import com.asyahren.trcryptocurrency.ConsumeRes.RetrofitClient;
import com.asyahren.trcryptocurrency.adapter.ListCryptoAdapter;
import com.asyahren.trcryptocurrency.model.Cryptocurrency;
import com.asyahren.trcryptocurrency.model.Datum;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCrypto;
    private List<Datum> data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCrypto = findViewById(R.id.rvCrypto);
        rvCrypto.setHasFixedSize(true);

//        for(int i=0;i<3;i++){
//            Cryptocurrency cryptocurrency = new Cryptocurrency();
//            cryptocurrency.setName("Bitcoin"+i);
//            cryptocurrency.setSymbol("BTC"+i);
//            cryptocurrency.setPrice(1000);
//            list.add(cryptocurrency);
//
//        }
        startRequest();
        showRecyclerList();
    }


    public void startRequest(){
        APIList apiList = RetrofitClient.getRetrofitClient().create(APIList.class);
        Call<Cryptocurrency> call = apiList.getAllCryptocurrency("100");
        call.enqueue(new Callback<Cryptocurrency>() {
            @Override
            public void onResponse(Call<Cryptocurrency> call, Response<Cryptocurrency> response) {
                if(response.isSuccessful()){
                    Cryptocurrency crypto = response.body();

                    // do not reinitialize an existing reference used by an adapter
                    // add to the existing list
                    data.clear();
                    data.addAll(crypto.getData());
//                    for(int i=0;i<data.size();i++){
//                        Datum datum = new Datum();
//                        datum.setName(data.get(i).getName());
//                        datum.setSymbol(data.get(i).getSymbol());
////                        datum.setPrice(data.get(i).getPrice());
//                        list.add(datum);
//                    }
                    Toast.makeText(getApplicationContext(), "hasil "+ data.get(0).getName(), Toast.LENGTH_SHORT).show();

                }else {
                    Log.e("ini", ""+response);
                    Toast.makeText(getApplicationContext(),
                            "Response from Server is Failed" + response, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Cryptocurrency> call, Throwable t) {
                Toast.makeText(getApplicationContext(),
                        "Failed to get/send data from Server", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showRecyclerList(){
        //startRequest();
        data = new ArrayList<>();
        rvCrypto.setLayoutManager(new LinearLayoutManager(this));
        ListCryptoAdapter listCryptoAdapter = new ListCryptoAdapter(data);
        rvCrypto.setAdapter(listCryptoAdapter);
    }
}