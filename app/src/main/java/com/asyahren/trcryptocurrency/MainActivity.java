package com.asyahren.trcryptocurrency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCrypto;
    private ArrayList<Cryptocurrency> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCrypto = findViewById(R.id.rvCrypto);
        rvCrypto.setHasFixedSize(true);

        for(int i=0;i<3;i++){
            Cryptocurrency cryptocurrency = new Cryptocurrency();
            cryptocurrency.setName("Bitcoin"+i);
            cryptocurrency.setSymbol("BTC"+i);
            cryptocurrency.setPrice(1000);
            list.add(cryptocurrency);

        }
        showRecyclerList();
    }


//    public void startRequest(){
//        APIList apiList = RetrofitClient.getRetrofitClient().create(APIList.class);
//        Call<ArrayList<Cryptocurrency>> call = apiList.getAllCryptocurrency();
//        call.enqueue(new Callback<ArrayList<Cryptocurrency>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Cryptocurrency>> call, Response<ArrayList<Cryptocurrency>> response) {
//                if(response.isSuccessful()){
//                    ArrayList<Cryptocurrency> data = response.body();
//                    for(int i=0;i<data.size();i++){
//                        Cryptocurrency cryptocurrency = new Cryptocurrency();
//                        cryptocurrency.setName(data.get(i).getName());
//                        cryptocurrency.setSymbol(data.get(i).getSymbol());
//                        cryptocurrency.setPrice(data.get(i).getPrice());
//                        list.add(cryptocurrency);
//                    }
//                }else {
//                    Log.e("ini", ""+response);
//                    Toast.makeText(getApplicationContext(),
//                            "Response from Server is Failed" + response, Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Cryptocurrency>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(),
//                        "Failed to get/send data from Server", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    private void showRecyclerList(){
        //startRequest();
        rvCrypto.setLayoutManager(new LinearLayoutManager(this));
        ListCryptoAdapter listCryptoAdapter = new ListCryptoAdapter(list);
        rvCrypto.setAdapter(listCryptoAdapter);
    }
}