package com.example.memory_master;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class forgot_password extends AppCompatActivity {

    private EditText email;
    private String txt_email;
    private FirebaseAuth mAuth;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);

        email = findViewById(R.id.email);
        mAuth = FirebaseAuth.getInstance();
    }

    public void reset_(View v){
        txt_email = email.getText().toString();
        if (!TextUtils.isEmpty(txt_email)){
            mAuth.sendPasswordResetEmail(txt_email)
                    .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                                Toast.makeText(forgot_password.this, "Mail Gönderildi", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(forgot_password.this,MainActivity.class));
                        }})
                    .addOnFailureListener(this, new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(forgot_password.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

        }else{
            Toast.makeText(this, "Lütfen Emailinizi Giriniz", Toast.LENGTH_SHORT).show();
        }
    }
}
