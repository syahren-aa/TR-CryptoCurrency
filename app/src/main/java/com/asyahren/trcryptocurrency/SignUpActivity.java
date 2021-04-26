package com.asyahren.trcryptocurrency;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.asyahren.trcryptocurrency.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText etEmail, etFirstName, etLastName, etPassword, etPhone;
    private Button btnSignUp;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        etEmail = findViewById(R.id.etEmail);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etPassword = findViewById(R.id.etPassword);
        etPhone = findViewById(R.id.etPhone);
        btnSignUp = findViewById(R.id.btnSignUp);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etEmail.getText().toString().isEmpty()){
                    etEmail.setError(String.format("Email %d", R.string.required));
                    etEmail.requestFocus();
                }
                if(Patterns.EMAIL_ADDRESS.matcher(etEmail.toString()).matches()){
                    etEmail.setError(String.valueOf(R.string.matchEmail));
                    etEmail.requestFocus();
                }
                if(etFirstName.toString().isEmpty()){
                    etFirstName.setError(String.format("First Name %d", R.string.required));
                    etFirstName.requestFocus();
                }
                if(etLastName.toString().isEmpty()){
                    etLastName.setError(String.format("Last Name %d", R.string.required));
                    etLastName.requestFocus();
                }
                if(etPassword.toString().isEmpty()){
                    etPassword.setError(String.format("Password %d", R.string.required));
                    etPassword.requestFocus();
                }
                if(etPassword.length()<6){
                    etPassword.setError(String.format("Password %d", R.string.passwordChar));
                }
                if(etPhone.toString().isEmpty()){
                    etFirstName.setError(String.format("Phone %d", R.string.required));
                    etFirstName.requestFocus();
                }
                    String email = etEmail.getText().toString();
                    String password = etPassword.getText().toString();
                    String name = etFirstName.getText().toString()+" "+etLastName.getText().toString();
                    String phone = etPhone.getText().toString();
                    double balance = (double) 0;
                    ArrayList<User.HasCrypto> hasCrypto = new ArrayList<User.HasCrypto>();

                    if(!email.isEmpty() && !password.isEmpty() && !name.isEmpty()
                    && !phone.isEmpty())
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        User user = new User(email, password, name, phone, balance, hasCrypto);

                                        FirebaseDatabase.getInstance().getReference("Users")
                                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                                    Toast.makeText(SignUpActivity.this, R.string.succesSignUp, Toast.LENGTH_SHORT).show();
                                                    user.sendEmailVerification();
                                                    startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                                                }else{
                                                    Toast.makeText(SignUpActivity.this, R.string.failedSignUp, Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                    }else{
                                        Toast.makeText(SignUpActivity.this, R.string.failedSignUp, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
        });

    }

}