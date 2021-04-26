package com.asyahren.trcryptocurrency;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmailLogin);
        etPassword = findViewById(R.id.etPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);

        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (email.isEmpty()) {
                    etEmail.setError(String.format("Email %s", getResources().getString(R.string.required)));
                    etEmail.requestFocus();
                }
                if (password.isEmpty()) {
                    etPassword.setError(String.format("Password %s", getResources().getString(R.string.required)));
                    etPassword.requestFocus();
                }

                if(!password.isEmpty() && !email.isEmpty()){
                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            if(user.isEmailVerified()){
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            }else{
                                user.sendEmailVerification();
                                Toast.makeText(LoginActivity.this, R.string.emailCheck, Toast.LENGTH_SHORT).show();
                            }


                               } else {
                            Toast.makeText(LoginActivity.this, R.string.failedLogin, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            }
        });
    }

    public void SignUp(View view) {
        startActivity(new Intent(this, SignUpActivity.class));
    }

    public void ForgotPassword(View view) {
        startActivity(new Intent(this, ForgotPasswordActivity.class));
    }
}