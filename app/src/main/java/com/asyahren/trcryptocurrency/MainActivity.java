package com.asyahren.trcryptocurrency;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.asyahren.trcryptocurrency.ConsumeRes.APIList;
import com.asyahren.trcryptocurrency.ConsumeRes.RetrofitClient;
import com.asyahren.trcryptocurrency.adapter.ListCryptoAdapter;
import com.asyahren.trcryptocurrency.model.CryptoData;
import com.asyahren.trcryptocurrency.model.DataItem;
import com.asyahren.trcryptocurrency.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference dbRef;
    private String userId = null;
    private RecyclerView rvCrypto;
    private ArrayList<DataItem> data = null;
    ListCryptoAdapter listCryptoAdapter;
    private final int REQUEST_CODE_USERPROFILE = 1;

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
        user = FirebaseAuth.getInstance().getCurrentUser();
        dbRef = FirebaseDatabase.getInstance().getReference("Users");

        try {
            if (user.getUid() != null) {
                userId = user.getUid();
                dbRef.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        User currUser = snapshot.getValue(User.class);
                        if (currUser != null) {
                            Intent intent = new Intent(MainActivity.this, UserProfile.class);
                            String email = currUser.getEmail();
                            String name = currUser.getName();
                            String phone = currUser.getPhone();
                            String password = currUser.getPassword();

                            intent.putExtra("email", email);
                            intent.putExtra("name", name);
                            intent.putExtra("phone", phone);
                            intent.putExtra("password", password);

                            startActivity(intent);
                        } else {
                            startActivity(new Intent(MainActivity.this, LoginActivity.class));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            } else {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        }catch (Exception e){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }

//        FirebaseUser user;
//        user = FirebaseAuth.getInstance().getCurrentUser();
//        if(user != null){
//            startActivity(new Intent(MainActivity.this, UserProfile.class));
//        }else{
//            startActivity(new Intent(MainActivity.this, LoginActivity.class));
//        }
       }
}