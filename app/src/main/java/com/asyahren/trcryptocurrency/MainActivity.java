package com.asyahren.trcryptocurrency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.asyahren.trcryptocurrency.adapter.ListCryptoAdapter;
import com.asyahren.trcryptocurrency.model.Cryptocurrency;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCrypto;
    private ArrayList<Cryptocurrency> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCrypto = findViewById(R.id.rvCrypto);
        rvCrypto.setHasFixedSize(true);

        list.addAll(RequestData.getListData());
        Toast.makeText(this, list.get(0).getName(), Toast.LENGTH_SHORT).show();
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvCrypto.setLayoutManager(new LinearLayoutManager(this));
        ListCryptoAdapter listCryptoAdapter = new ListCryptoAdapter(list);
        rvCrypto.setAdapter(listCryptoAdapter);
    }

    public void Mulai(View view) {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
}