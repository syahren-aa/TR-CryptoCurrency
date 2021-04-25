package com.asyahren.trcryptocurrency;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText etResetByEmail;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        etResetByEmail = findViewById(R.id.etResetByEmail);

        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void ResetPassword(View view) {
        String email = etResetByEmail.getText().toString();

        if(email.isEmpty()){
            etResetByEmail.setError(String.format("Email%d", R.string.required));
            etResetByEmail.requestFocus();
        }
        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(ForgotPasswordActivity.this, R.string.emailCheck , Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(ForgotPasswordActivity.this, R.string.resetFailure, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}