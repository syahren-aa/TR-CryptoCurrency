package com.asyahren.trcryptocurrency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.asyahren.trcryptocurrency.ConsumeRes.APIList;
import com.asyahren.trcryptocurrency.ConsumeRes.RetrofitClient;
import com.asyahren.trcryptocurrency.adapter.ListCryptoAdapter;
import com.asyahren.trcryptocurrency.model.CryptoData;
import com.asyahren.trcryptocurrency.model.DataItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCrypto;
    private ArrayList<DataItem> data = null;
    ListCryptoAdapter listCryptoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCrypto = findViewById(R.id.rvCrypto);
        rvCrypto.setHasFixedSize(true);

        startRequest();
        showRecyclerList();
    }


    public void startRequest() {
        APIList apiList = RetrofitClient.getRetrofitClient().create(APIList.class);
        Call<CryptoData> call = apiList.getAllCryptocurrency();
        call.enqueue(new Callback<CryptoData>() {
            @Override
            public void onResponse(Call<CryptoData> call, Response<CryptoData> response) {
                if(response.isSuccessful()){
                    CryptoData crypto = response.body();
                    data.clear();
                    data.addAll(crypto.getData());
                    listCryptoAdapter.notifyDataSetChanged();
                }else {
                    Log.e("ini", ""+response);
                    Log.e("Responya", "Response from Server is Failed" + response);
                }
            }
            @Override
            public void onFailure(Call<CryptoData> call, Throwable t) {
                Log.e("Responya", "Response from Server is Failed" + t.toString());
            }
        });
    }


    private void showRecyclerList(){
        data = new ArrayList<>();
        rvCrypto.setLayoutManager(new LinearLayoutManager(this));
        listCryptoAdapter = new ListCryptoAdapter(data);
        rvCrypto.setAdapter(listCryptoAdapter);
    }

    public void Mulai(View view) {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
}