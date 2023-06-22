package com.example.memory_master;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


public class MainActivity extends AppCompatActivity {

    Button signin, forgot_pass;
    private EditText email, password;
    private String txt_username, txt_password;
    private FirebaseAuth mAuth;
    String username_S, email_S, user_email;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        signin = findViewById(R.id.button_signin);
        forgot_pass = findViewById(R.id.button_forgot);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();

        buttons();
    }


    public void login_(View v){
        //startActivity(new Intent(MainActivity.this,player_screen.class));  ///---------sil-----------

        txt_username = email.getText().toString();
        txt_password = password.getText().toString();
        if (!TextUtils.isEmpty(txt_username) && !TextUtils.isEmpty(txt_password)){
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            db.collection("Kullanıcılar")
                    .get()
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if(task.isSuccessful()){
                                        for(QueryDocumentSnapshot documend: task.getResult()){
                                            System.out.println("    "+documend.getId() + "=>" + documend.getData());
                                            username_S = documend.getString("Kullanıcı Adı");
                                            email_S = documend.getString("Kullanıcı Email");
                                            if (txt_username.equals(username_S)){
                                                user_email = email_S;
                                                System.out.println(username_S + "    " + email_S + "    " + user_email);
                                                mAuth.signInWithEmailAndPassword(user_email,txt_password)
                                                        .addOnSuccessListener(MainActivity.this, new OnSuccessListener<AuthResult>() {
                                                            @Override
                                                            public void onSuccess(AuthResult authResult) {
                                                                Toast.makeText(MainActivity.this, "Giriş Başarılı", Toast.LENGTH_SHORT).show();
                                                                startActivity(new Intent(MainActivity.this,player_screen.class));
                                                            }
                                                        }).addOnFailureListener(MainActivity.this, new OnFailureListener() {
                                                            @Override
                                                            public void onFailure(@NonNull Exception e) {
                                                                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                                            }
                                                        });
                                            }
                                        }
                                    }
                                }
                            });
        }else {
            Toast.makeText(this, "Kullanıcı Adı ve Şifre Boş Olmamalı", Toast.LENGTH_SHORT).show();
        }
    }



    public void buttons(){
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,signin.class));
            }});
        forgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,forgot_password.class));
            }});
    }



    public void onBackPressed() {
        moveTaskToBack(true);
    }
}

