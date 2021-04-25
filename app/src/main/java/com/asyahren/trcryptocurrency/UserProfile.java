package com.asyahren.trcryptocurrency;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.asyahren.trcryptocurrency.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfile extends AppCompatActivity{


    private TextView tvEmail;
    private EditText etName, etPhoneUser, etPasswordUser;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        btnLogout = findViewById(R.id.btnLogout);
        tvEmail = findViewById(R.id.tvEmail);
        etName = findViewById(R.id.etName);
        etPasswordUser = findViewById(R.id.etPasswordUser);
        etPhoneUser = findViewById(R.id.etPhoneUser);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");
        String password = intent.getStringExtra("password");

        tvEmail.setText(email);
        etName.setText(name);
        etPhoneUser.setText(phone);
        etPasswordUser.setText(password);
    }

    public void Logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(UserProfile.this, MainActivity.class));
    }
}