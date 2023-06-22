package com.example.memory_master;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class screen_2x2 extends AppCompatActivity {

    TextView scor, time;
    ImageView hl_11, hl_12, hl_21, hl_22;

    // array for the images
    Integer[] cardarray= {101, 102, 201, 202};

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;
    long son_sure;

    int i,j;
    int playerPoints = 0;
    MediaPlayer player_match, player_timeout, player_finish;

    boolean timerEnd = false;

    cards_info info = new cards_info();
    hesapla hesapla = new hesapla();
    text_cards text_cards = new text_cards();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);

        info.main(1,1);

        player_match = MediaPlayer.create(this, R.raw.match);
        player_timeout= MediaPlayer.create(this, R.raw.timeout);
        player_finish= MediaPlayer.create(this, R.raw.finish);

        scor = (TextView) findViewById(R.id.textView);
        time = (TextView) findViewById(R.id.textView2);
        scor.setText("0");

        hl_11 = (ImageView) findViewById(R.id.hl_11);
        hl_12 = (ImageView) findViewById(R.id.hl_12);

        hl_21 = (ImageView) findViewById(R.id.hl_21);
        hl_22 = (ImageView) findViewById(R.id.hl_22);

        hl_11.setTag("0");
        hl_12.setTag("1");

        hl_21.setTag("2");
        hl_22.setTag("3");

        timer();

        //suffle the images
        Collections.shuffle(Arrays.asList(cardarray));


        card_txt(cardarray);



        hl_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_11, theCard);
            }
        });
        hl_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_12, theCard);
            }
        });
        hl_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_21, theCard);
            }
        });
        hl_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_22, theCard);
            }
        });



    }
    private void doStuff(ImageView hl, int card){
        // set the correct image to imageView

        if (cardarray[card] == 101){
            hl.setImageResource(info.cardss.get(0).getCard_picture());
            i = 0;
        } else if (cardarray[card] == 102){
            hl.setImageResource(info.cardss.get(1).getCard_picture());
            i = 1;
        } else if (cardarray[card] == 201){
            hl.setImageResource(info.cardss.get(0).getCard_picture());
            j=0;
        } else if (cardarray[card] == 202){
            hl.setImageResource(info.cardss.get(1).getCard_picture());
            j=1;
        }

        // check which image is selected and save it to temporary variable
        if (cardNumber == 1) {
            firstCard = cardarray[card];
            if(firstCard > 200) {
                firstCard= firstCard - 100;
            }   cardNumber = 2;
            clickedFirst = card;
            hl.setEnabled (false);
        } else if (cardNumber == 2) {
            secondCard = cardarray[card];
            if(secondCard > 200) {
                secondCard = secondCard - 100;
            }   cardNumber = 1;
            clickedSecond = card;

            hl_11.setEnabled (false);
            hl_12.setEnabled (false);

            hl_21.setEnabled (false);
            hl_22.setEnabled (false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // check if the selected images are equal
                    calculate();
                }
            },1000);
        }
    }

    private void calculate(){
        // if images equal remove them and add point
        if (firstCard== secondCard){
            if(clickedFirst == 0){
                hl_11.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 1){
                hl_12.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 2){
                hl_21.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 3){
                hl_22.setVisibility(View.INVISIBLE);
            }

            if(clickedSecond == 0){
                hl_11.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 1){
                hl_12.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 2){
                hl_21.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 3){
                hl_22.setVisibility(View.INVISIBLE);
            }

            // Match durumunda eklenen puan
            hesapla.match(info.cardss.get(i).getCard_point(), (int) son_sure,info.cardss.get(i).getCard_home());
            playerPoints+= hesapla.skor;
            player_match.start();


        }else {
            hl_11.setImageResource(R.drawable.hogwarts);
            hl_12.setImageResource(R.drawable.hogwarts);
            hl_21.setImageResource(R.drawable.hogwarts);
            hl_22.setImageResource(R.drawable.hogwarts);

            // not match durumunda çıkarılan puan

            hesapla.not_match(info.cardss.get(i).getCard_point(),
                    info.cardss.get(j).getCard_point(),
                    (int) son_sure,
                    info.cardss.get(i).getCard_home(),
                    info.cardss.get(j).getCard_home());
            playerPoints-= hesapla.skor;

        }
        scor.setText("" + playerPoints);

        hl_11.setEnabled (true);
        hl_12.setEnabled (true);

        hl_21.setEnabled (true);
        hl_22.setEnabled (true);

        //  check if the game is over
        checkEnd();

    }

    private void checkEnd(){
        if (hl_11.getVisibility() == View.INVISIBLE &&
                hl_12.getVisibility() == View.INVISIBLE &&
                hl_21.getVisibility() == View.INVISIBLE &&
                hl_22.getVisibility() == View.INVISIBLE ){

            player_finish.start();
            timerEnd = true;

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(screen_2x2.this);
            alertDialogBuilder
                    .setMessage("GAME OVER!\nPuan: " + playerPoints + "\nSüRE: " + (45-son_sure))
                    .setCancelable(false)
                    .setPositiveButton("YENİ OYUN", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), screen_2x2.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("ÇIKIŞ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                            player_finish.release();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }else if (son_sure == 0){

            player_timeout.start();

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(screen_2x2.this);
            alertDialogBuilder
                    .setMessage("GAME OVER!\nSÜRE BİTTİ\nPuan:" + playerPoints)
                    .setCancelable(false)
                    .setPositiveButton("YENİ OYUN", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), screen_2x2.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("ÇIKIŞ", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }


    private void timer(){
        new CountDownTimer(46000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                if(timerEnd){
                    time.setText("" + son_sure);
                }else {
                    son_sure = millisUntilFinished / 1000;
                    time.setText("" + millisUntilFinished/1000);
                }
            }

            @Override
            public void onFinish() {
                time.setText("0");
            }
        }.start();

    }
    public void card_txt(Integer[] cards){
        List<Integer> card_copy=new ArrayList<Integer>();
        List<String> cards_list=new ArrayList<String>();
        for (int a=0;a<cards.length;a++){
            if (cards[a]<200){
                card_copy.add(cards[a]-100);
            }else {
                card_copy.add(cards[a]-200);
            }
        }
        for (int a=0;a<card_copy.size();a++){
            cards_list.add(info.cardss.get(card_copy.get(a)-1).getCard_name());
        }
        text_cards.add_text(cards_list);
    }


}
