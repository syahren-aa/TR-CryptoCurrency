package com.asyahren.trcryptocurrency;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.asyahren.trcryptocurrency.model.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class UserProfile extends AppCompatActivity{

    private FirebaseUser user;
    private DatabaseReference dbRef;
    private String userId = null;
    private TextView tvEmail, balanceTV;
    private EditText etName, etPhoneUser;
    private Button btnLogout, etPasswordUser;
    private de.hdodenhof.circleimageview.CircleImageView profilePhoto;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        btnLogout = findViewById(R.id.btnLogout);
        tvEmail = findViewById(R.id.tvEmail);
        etName = findViewById(R.id.etName);
        etPasswordUser = findViewById(R.id.etPasswordUser);
        etPhoneUser = findViewById(R.id.etPhoneUser);
        profilePhoto = findViewById(R.id.profilePhoto);
        balanceTV = findViewById(R.id.balanceTV);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");
        String password = intent.getStringExtra("password");
        String balance = intent.getStringExtra("balances");


        storageReference = FirebaseStorage.getInstance().getReference();
        StorageReference profileRef = storageReference.child("users/"+FirebaseAuth.getInstance().getCurrentUser().getUid()+"profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(profilePhoto);
            }
        });

        balanceTV.setText(balance);
        tvEmail.setText(email);
        etName.setText(name);
        etPhoneUser.setText(phone);
    }

    public void Logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(UserProfile.this, MainActivity.class));
    }

    public void PhotoProfil(View view) {
        Intent openGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(openGallery, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode == Activity.RESULT_OK){
                Uri imageUri = data.getData();
                profilePhoto.setImageURI(imageUri);

                uploadImageToFirebase(imageUri);
            }
        }
    }

    private void uploadImageToFirebase(Uri imageUri){

        final StorageReference fileRef = storageReference.child("users/"+FirebaseAuth.getInstance().getCurrentUser().getUid()+"profile.jpg");
        fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.get().load(uri).into(profilePhoto);
                    }
                });
                Toast.makeText(UserProfile.this, "Success", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UserProfile.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
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