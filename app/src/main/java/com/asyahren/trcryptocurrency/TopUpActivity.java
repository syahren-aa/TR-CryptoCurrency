package com.asyahren.trcryptocurrency;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.asyahren.trcryptocurrency.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TopUpActivity extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference dbRef;

    EditText etTopUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);
        etTopUp = findViewById(R.id.etTopUp);

    }

    public void TopUp(View view) {
        user = FirebaseAuth.getInstance().getCurrentUser();
        dbRef = FirebaseDatabase.getInstance().getReference("Users");
        try {
            String userId = user.getUid();
            dbRef.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    User currUser = snapshot.getValue(User.class);
                    Double biaya1 = currUser.getBalance();
                    String biaya = etTopUp.getText().toString();
                    biaya1 = biaya1+Double.parseDouble(biaya);
                    dbRef.child(user.getUid()).child("balance").setValue(biaya1);
                    startActivity(new Intent(TopUpActivity.this, MainActivity.class));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }catch (Exception e){

        }

    }
}