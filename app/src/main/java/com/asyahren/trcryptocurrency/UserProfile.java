package com.asyahren.trcryptocurrency;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.asyahren.trcryptocurrency.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfile extends AppCompatActivity{

    private FirebaseUser user;
    private DatabaseReference dbRef;
    private String userId = null;
    private TextView tvEmail;
    private EditText etName, etPhoneUser;
    private Button btnLogout, etPasswordUser;

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
    }

    public void Logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(UserProfile.this, MainActivity.class));
    }

    public void PhotoProfil(View view) {
    }

    public void UpdateUser(View view) {
        user = FirebaseAuth.getInstance().getCurrentUser();
        dbRef = FirebaseDatabase.getInstance().getReference("Users");


        try{
            userId = user.getUid();
            dbRef.child(userId).child("name").setValue(etName.getText().toString());
            dbRef.child(userId).child("phone").setValue(etPhoneUser.getText().toString());
            Toast.makeText(this, R.string.dataUpdatedSuccess, Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, R.string.dataUpdatedFailed, Toast.LENGTH_SHORT).show();
        }

    }

    public void ForgotPassword(View view) {
        startActivity(new Intent(this, ForgotPasswordActivity.class));
    }
}