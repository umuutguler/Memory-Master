package com.example.memory_master;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.List;


public class screen_4x4 extends AppCompatActivity {

    TextView scor, time;
    ImageView hl_11, hl_12, hl_13, hl_14, hl_21, hl_22 , hl_23, hl_24, hl_31, hl_32, hl_33, hl_34, hl_41, hl_42, hl_43, hl_44;

    // array for the images
    Integer[] cardarray= {101, 102, 103, 104, 105, 106, 107, 108, 201, 202, 203, 204, 205, 206, 207, 208};


    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;
    long son_sure;

    int i,j;
    boolean timerEnd = false;
    int playerPoints = 0;
    MediaPlayer player_match, player_timeout, player_finish;

    cards_info info = new cards_info();
    hesapla hesapla = new hesapla();
    text_cards text_cards = new text_cards();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info.main(2,2);

        player_match = MediaPlayer.create(this, R.raw.match);
        player_timeout= MediaPlayer.create(this, R.raw.timeout);
        player_finish= MediaPlayer.create(this, R.raw.finish);


        scor = (TextView) findViewById(R.id.textView);
        time = (TextView) findViewById(R.id.textView2);
        scor.setText("0");

        hl_11 = (ImageView) findViewById(R.id.hl_11);
        hl_12 = (ImageView) findViewById(R.id.hl_12);
        hl_13 = (ImageView) findViewById(R.id.hl_13);
        hl_14 = (ImageView) findViewById(R.id.hl_14);

        hl_21 = (ImageView) findViewById(R.id.hl_21);
        hl_22 = (ImageView) findViewById(R.id.hl_22);
        hl_23 = (ImageView) findViewById(R.id.hl_23);
        hl_24 = (ImageView) findViewById(R.id.hl_24);

        hl_31 = (ImageView) findViewById(R.id.hl_31);
        hl_32 = (ImageView) findViewById(R.id.hl_32);
        hl_33 = (ImageView) findViewById(R.id.hl_33);
        hl_34 = (ImageView) findViewById(R.id.hl_34);

        hl_41 = (ImageView) findViewById(R.id.hl_41);
        hl_42 = (ImageView) findViewById(R.id.hl_42);
        hl_43 = (ImageView) findViewById(R.id.hl_43);
        hl_44 = (ImageView) findViewById(R.id.hl_44);

        hl_11.setTag("0");
        hl_12.setTag("1");
        hl_13.setTag("2");
        hl_14.setTag("3");

        hl_21.setTag("4");
        hl_22.setTag("5");
        hl_23.setTag("6");
        hl_24.setTag("7");

        hl_31.setTag("8");
        hl_32.setTag("9");
        hl_33.setTag("10");
        hl_34 .setTag("11");

        hl_41.setTag("12");
        hl_42.setTag("13");
        hl_43.setTag("14");
        hl_44.setTag("15");

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
        hl_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_13, theCard);
            }
        });
        hl_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_14, theCard);
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
        hl_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_23, theCard);
            }
        });
        hl_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_24, theCard);
            }
        });
        hl_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_31, theCard);
            }
        });
        hl_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_32, theCard);
            }
        });
        hl_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_33, theCard);
            }
        });
        hl_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_34, theCard);
            }
        });
        hl_41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_41, theCard);
            }
        });
        hl_42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_42, theCard);
            }
        });
        hl_43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_43, theCard);
            }
        });
        hl_44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_44, theCard);
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
        } else if (cardarray[card] == 103){
            hl.setImageResource(info.cardss.get(2).getCard_picture());
            i = 2;
        } else if (cardarray[card] == 104){
            hl.setImageResource(info.cardss.get(3).getCard_picture());
            i = 3;
        } else if (cardarray[card] == 105){
            hl.setImageResource(info.cardss.get(4).getCard_picture());
            i = 4;
        } else if (cardarray[card] == 106){
            hl.setImageResource(info.cardss.get(5).getCard_picture());
            i = 5;
        } else if (cardarray[card] == 107){
            hl.setImageResource(info.cardss.get(6).getCard_picture());
            i = 6;
        } else if (cardarray[card] == 108){
            hl.setImageResource(info.cardss.get(7).getCard_picture());
            i = 7;
        } else if (cardarray[card] == 201){
            hl.setImageResource(info.cardss.get(0).getCard_picture());
            i = 0;
        } else if (cardarray[card] == 202){
            hl.setImageResource(info.cardss.get(1).getCard_picture());
            i = 1;
        } else if (cardarray[card] == 203){
            hl.setImageResource(info.cardss.get(2).getCard_picture());
            i = 2;
        } else if (cardarray[card] == 204){
            hl.setImageResource(info.cardss.get(3).getCard_picture());
            i = 3;
        } else if (cardarray[card] == 205){
            hl.setImageResource(info.cardss.get(4).getCard_picture());
            i = 4;
        } else if (cardarray[card] == 206){
            hl.setImageResource(info.cardss.get(5).getCard_picture());
            i = 5;
        } else if (cardarray[card] == 207){
            hl.setImageResource(info.cardss.get(6).getCard_picture());
            i = 6;
        } else if (cardarray[card] == 208){
            hl.setImageResource(info.cardss.get(7).getCard_picture());
            i = 7;
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
            hl_13.setEnabled (false);
            hl_14.setEnabled (false);

            hl_21.setEnabled (false);
            hl_22.setEnabled (false);
            hl_23.setEnabled (false);
            hl_24.setEnabled (false);

            hl_31.setEnabled (false);
            hl_32.setEnabled (false);
            hl_33.setEnabled (false);
            hl_34.setEnabled (false);

            hl_41.setEnabled (false);
            hl_42.setEnabled (false);
            hl_43.setEnabled (false);
            hl_44.setEnabled (false);

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
                hl_13.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 3){
                hl_14.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 4){
                hl_21.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 5){
                hl_22.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 6){
                hl_23.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 7){
                hl_24.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 8){
                hl_31.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 9){
                hl_32.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 10){
                hl_33.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 11){
                hl_34.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 12){
                hl_41.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 13){
                hl_42.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 14){
                hl_43.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 15){
                hl_44.setVisibility(View.INVISIBLE);
            }

            if(clickedSecond == 0){
                hl_11.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 1){
                hl_12.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 2){
                hl_13.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 3){
                hl_14.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 4){
                hl_21.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 5){
                hl_22.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 6){
                hl_23.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 7){
                hl_24.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 8){
                hl_31.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 9){
                hl_32.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 10){
                hl_33.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 11){
                hl_34.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 12){
                hl_41.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 13){
                hl_42.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 14){
                hl_43.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 15){
                hl_44.setVisibility(View.INVISIBLE);
            }
            // Match durumunda eklenen puan
            hesapla.match(info.cardss.get(i).getCard_point(), (int) son_sure,info.cardss.get(i).getCard_home());
            playerPoints+= hesapla.skor;
            player_match.start();


        }else {
            hl_11.setImageResource(R.drawable.hogwarts);
            hl_12.setImageResource(R.drawable.hogwarts);
            hl_13.setImageResource(R.drawable.hogwarts);
            hl_14.setImageResource(R.drawable.hogwarts);
            hl_21.setImageResource(R.drawable.hogwarts);
            hl_22.setImageResource(R.drawable.hogwarts);
            hl_23.setImageResource(R.drawable.hogwarts);
            hl_24.setImageResource(R.drawable.hogwarts);
            hl_31.setImageResource(R.drawable.hogwarts);
            hl_32.setImageResource(R.drawable.hogwarts);
            hl_33.setImageResource(R.drawable.hogwarts);
            hl_34.setImageResource(R.drawable.hogwarts);
            hl_41.setImageResource(R.drawable.hogwarts);
            hl_42.setImageResource(R.drawable.hogwarts);
            hl_43.setImageResource(R.drawable.hogwarts);
            hl_44.setImageResource(R.drawable.hogwarts);

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
        hl_13.setEnabled (true);
        hl_14.setEnabled (true);

        hl_21.setEnabled (true);
        hl_22.setEnabled (true);
        hl_23.setEnabled (true);
        hl_24.setEnabled (true);

        hl_31.setEnabled (true);
        hl_32.setEnabled (true);
        hl_33.setEnabled (true);
        hl_34.setEnabled (true);

        hl_41.setEnabled (true);
        hl_42.setEnabled (true);
        hl_43.setEnabled (true);
        hl_44.setEnabled (true);

        //  check if the game is over
        checkEnd();

    }

    private void checkEnd(){
        if (hl_11.getVisibility() == View.INVISIBLE &&
                hl_12.getVisibility() == View.INVISIBLE &&
                hl_13.getVisibility() == View.INVISIBLE &&
                hl_14.getVisibility() == View.INVISIBLE &&
                hl_21.getVisibility() == View.INVISIBLE &&
                hl_22.getVisibility() == View.INVISIBLE &&
                hl_23.getVisibility() == View.INVISIBLE &&
                hl_24.getVisibility() == View.INVISIBLE &&
                hl_31.getVisibility() == View.INVISIBLE &&
                hl_32.getVisibility() == View.INVISIBLE &&
                hl_33.getVisibility() == View.INVISIBLE &&
                hl_34.getVisibility() == View.INVISIBLE &&
                hl_41.getVisibility() == View.INVISIBLE &&
                hl_42.getVisibility() == View.INVISIBLE &&
                hl_43.getVisibility() == View.INVISIBLE &&
                hl_44.getVisibility() == View.INVISIBLE ){

            player_finish.start();
            timerEnd = true;

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(screen_4x4.this);
            alertDialogBuilder
                    .setMessage("GAME OVER!\nPuan: " + playerPoints + "\nSüRE: " + (45-son_sure))
                    .setCancelable(false)
                    .setPositiveButton("YENİ OYUN", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), screen_4x4.class);
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
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(screen_4x4.this);
            alertDialogBuilder
                    .setMessage("GAME OVER!\nSÜRE BİTTİ\nPuan:" + playerPoints)
                    .setCancelable(false)
                    .setPositiveButton("YENİ OYUN", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), screen_4x4.class);
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

