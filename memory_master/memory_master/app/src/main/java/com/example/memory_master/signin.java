package com.example.memory_master;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class signin extends AppCompatActivity {

    private EditText username, email, password;
    private String txt_username, txt_email, txt_password;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private FirebaseFirestore mFirestore;
    private HashMap<String, Object> mData;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();

    }
    public void signin(View v){
        txt_username = username.getText().toString();
        txt_email = email.getText().toString();
        txt_password = password.getText().toString();




        if (!TextUtils.isEmpty(txt_username) && !TextUtils.isEmpty(txt_email) && !TextUtils.isEmpty(txt_password)){

            mAuth.createUserWithEmailAndPassword(txt_email,txt_password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {  // senkron kontrolü
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                mUser = mAuth.getCurrentUser();

                                mData = new HashMap<>();
                                mData.put("Kullanıcı Adı", txt_username);
                                mData.put("Kullanıcı Email", txt_email);
                                mData.put("Kullanıcı ID", mUser.getUid());

                                mFirestore.collection("Kullanıcılar").document(mUser.getUid())
                                                .set(mData)
                                                        .addOnCompleteListener(signin.this, new OnCompleteListener<Void>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                if (task.isSuccessful()){
                                                                    Toast.makeText(signin.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                                                                }else{
                                                                    Toast.makeText(signin.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                                }
                                                            }
                                                        });

                                Toast.makeText(signin.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(signin.this,MainActivity.class));
                            } else {
                                Toast.makeText(signin.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }else {
            Toast.makeText(this, "Lütfen Boşlukları Doldurunuz", Toast.LENGTH_SHORT).show();
        }

    }
}
