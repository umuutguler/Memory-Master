package com.example.memory_master;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;


public class player_screen extends AppCompatActivity {

    Button tekSayfaBtn, cokSayfaBtn, cikisSayfaBtn;
    MediaPlayer player;
    ImageView sesBtn;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_selection);
        tekSayfaBtn = findViewById(R.id.button_tek);
        cokSayfaBtn = findViewById(R.id.button_cok);
        cikisSayfaBtn = findViewById(R.id.button_cikis);
        sesBtn = findViewById(R.id.imageView);


        if (player==null) {
            player = MediaPlayer.create(this, R.raw.song);
            player.setLooping(true);
        }
        player.start();


        sesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player.isPlaying()){
                    player.pause();
                    sesBtn.setImageResource(R.drawable.mute);
                }else {
                    player.start();
                    sesBtn.setImageResource(R.drawable.audio);
                }
            }
        });


        tekSayfaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(player_screen.this,difficulty_selection.class));
            }});
        cokSayfaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(player_screen.this,difficulty_selection_online.class));
            }});
        cikisSayfaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(player_screen.this,MainActivity.class));
                player.release();
            }});

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            player.release();
            /*AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setTitle("Çıkmak istediğinizden emin misiniz?")
                    .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    }).setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    }).create().show();*/
        }
        return super.onKeyDown(keyCode, event);
    }



    public void onBackPressed() {
        moveTaskToBack(true);
    }
}

