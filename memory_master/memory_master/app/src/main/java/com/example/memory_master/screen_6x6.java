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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class screen_6x6 extends AppCompatActivity {

    TextView scor, time;
    ImageView hl_11, hl_12, hl_13, hl_14, hl_15, hl_16, hl_21, hl_22 , hl_23, hl_24, hl_25, hl_26, hl_31, hl_32, hl_33, hl_34, hl_35, hl_36,
            hl_41, hl_42, hl_43, hl_44, hl_45, hl_46, hl_51, hl_52, hl_53, hl_54, hl_55, hl_56, hl_61, hl_62, hl_63, hl_64,  hl_65, hl_66;

    // array for the images
    Integer[] cardarray= {101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118,
            201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218};

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
        setContentView(R.layout.activity_main_six);

        info.main(5,4);

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
        hl_15 = (ImageView) findViewById(R.id.hl_15);
        hl_16 = (ImageView) findViewById(R.id.hl_16);

        hl_21 = (ImageView) findViewById(R.id.hl_21);
        hl_22 = (ImageView) findViewById(R.id.hl_22);
        hl_23 = (ImageView) findViewById(R.id.hl_23);
        hl_24 = (ImageView) findViewById(R.id.hl_24);
        hl_25 = (ImageView) findViewById(R.id.hl_25);
        hl_26 = (ImageView) findViewById(R.id.hl_26);

        hl_31 = (ImageView) findViewById(R.id.hl_31);
        hl_32 = (ImageView) findViewById(R.id.hl_32);
        hl_33 = (ImageView) findViewById(R.id.hl_33);
        hl_34 = (ImageView) findViewById(R.id.hl_34);
        hl_35 = (ImageView) findViewById(R.id.hl_35);
        hl_36 = (ImageView) findViewById(R.id.hl_36);

        hl_41 = (ImageView) findViewById(R.id.hl_41);
        hl_42 = (ImageView) findViewById(R.id.hl_42);
        hl_43 = (ImageView) findViewById(R.id.hl_43);
        hl_44 = (ImageView) findViewById(R.id.hl_44);
        hl_45 = (ImageView) findViewById(R.id.hl_45);
        hl_46 = (ImageView) findViewById(R.id.hl_46);

        hl_51 = (ImageView) findViewById(R.id.hl_51);
        hl_52 = (ImageView) findViewById(R.id.hl_52);
        hl_53 = (ImageView) findViewById(R.id.hl_53);
        hl_54 = (ImageView) findViewById(R.id.hl_54);
        hl_55 = (ImageView) findViewById(R.id.hl_55);
        hl_56 = (ImageView) findViewById(R.id.hl_56);

        hl_61 = (ImageView) findViewById(R.id.hl_61);
        hl_62 = (ImageView) findViewById(R.id.hl_62);
        hl_63 = (ImageView) findViewById(R.id.hl_63);
        hl_64 = (ImageView) findViewById(R.id.hl_64);
        hl_65 = (ImageView) findViewById(R.id.hl_65);
        hl_66 = (ImageView) findViewById(R.id.hl_66);

        hl_11.setTag("0");
        hl_12.setTag("1");
        hl_13.setTag("2");
        hl_14.setTag("3");
        hl_15.setTag("4");
        hl_16.setTag("5");

        hl_21.setTag("6");
        hl_22.setTag("7");
        hl_23.setTag("8");
        hl_24.setTag("9");
        hl_25.setTag("10");
        hl_26.setTag("11");

        hl_31.setTag("12");
        hl_32.setTag("13");
        hl_33.setTag("14");
        hl_34.setTag("15");
        hl_35.setTag("16");
        hl_36.setTag("17");

        hl_41.setTag("18");
        hl_42.setTag("19");
        hl_43.setTag("20");
        hl_44.setTag("21");
        hl_45.setTag("22");
        hl_46.setTag("23");

        hl_51.setTag("24");
        hl_52.setTag("25");
        hl_53.setTag("26");
        hl_54.setTag("27");
        hl_55.setTag("28");
        hl_56.setTag("29");

        hl_61.setTag("30");
        hl_62.setTag("31");
        hl_63.setTag("32");
        hl_64.setTag("33");
        hl_65.setTag("34");
        hl_66.setTag("35");

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
        hl_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_15, theCard);
            }
        });
        hl_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_16, theCard);
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
        hl_25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_25, theCard);
            }
        });
        hl_26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_26, theCard);
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
        hl_35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_35, theCard);
            }
        });
        hl_36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_36, theCard);
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
        hl_45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_45, theCard);
            }
        });
        hl_46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_46, theCard);
            }
        });
        hl_51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_51, theCard);
            }
        });
        hl_52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_52, theCard);
            }
        });
        hl_53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_53, theCard);
            }
        });
        hl_54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_54, theCard);
            }
        });
        hl_55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_55, theCard);
            }
        });
        hl_56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_56, theCard);
            }
        });
        hl_61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_61, theCard);
            }
        });
        hl_62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_62, theCard);
            }
        });
        hl_63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_63, theCard);}});
        hl_64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_64, theCard);}});
        hl_65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_65, theCard);}});
        hl_66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(hl_66, theCard);}});
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
        } else if (cardarray[card] == 109){
            hl.setImageResource(info.cardss.get(8).getCard_picture());
            i = 8;
        } else if (cardarray[card] == 110){
            hl.setImageResource(info.cardss.get(9).getCard_picture());
            i = 9;
        } else if (cardarray[card] == 111){
            hl.setImageResource(info.cardss.get(10).getCard_picture());
            i = 10;
        } else if (cardarray[card] == 112){
            hl.setImageResource(info.cardss.get(11).getCard_picture());
            i = 11;
        } else if (cardarray[card] == 113){
            hl.setImageResource(info.cardss.get(12).getCard_picture());
            i = 12;
        } else if (cardarray[card] == 114){
            hl.setImageResource(info.cardss.get(13).getCard_picture());
            i = 13;
        } else if (cardarray[card] == 115){
            hl.setImageResource(info.cardss.get(14).getCard_picture());
            i = 14;
        } else if (cardarray[card] == 116){
            hl.setImageResource(info.cardss.get(15).getCard_picture());
            i = 15;
        } else if (cardarray[card] == 117){
            hl.setImageResource(info.cardss.get(16).getCard_picture());
            i = 16;
        } else if (cardarray[card] == 118){
            hl.setImageResource(info.cardss.get(17).getCard_picture());
            i = 17;
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
        } else if (cardarray[card] == 209){
            hl.setImageResource(info.cardss.get(8).getCard_picture());
            i = 8;
        } else if (cardarray[card] == 210){
            hl.setImageResource(info.cardss.get(9).getCard_picture());
            i = 9;
        } else if (cardarray[card] == 211){
            hl.setImageResource(info.cardss.get(10).getCard_picture());
            i = 10;
        } else if (cardarray[card] == 212){
            hl.setImageResource(info.cardss.get(11).getCard_picture());
            i = 11;
        } else if (cardarray[card] == 213){
            hl.setImageResource(info.cardss.get(12).getCard_picture());
            i = 12;
        } else if (cardarray[card] == 214){
            hl.setImageResource(info.cardss.get(13).getCard_picture());
            i = 13;
        } else if (cardarray[card] == 215){
            hl.setImageResource(info.cardss.get(14).getCard_picture());
            i = 14;
        } else if (cardarray[card] == 216){
            hl.setImageResource(info.cardss.get(15).getCard_picture());
            i = 15;
        } else if (cardarray[card] == 217){
            hl.setImageResource(info.cardss.get(16).getCard_picture());
            i = 16;
        } else if (cardarray[card] == 218){
            hl.setImageResource(info.cardss.get(17).getCard_picture());
            i = 17;
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
            hl_15.setEnabled (false);
            hl_16.setEnabled (false);

            hl_21.setEnabled (false);
            hl_22.setEnabled (false);
            hl_23.setEnabled (false);
            hl_24.setEnabled (false);
            hl_25.setEnabled (false);
            hl_26.setEnabled (false);

            hl_31.setEnabled (false);
            hl_32.setEnabled (false);
            hl_33.setEnabled (false);
            hl_34.setEnabled (false);
            hl_35.setEnabled (false);
            hl_36.setEnabled (false);

            hl_41.setEnabled (false);
            hl_42.setEnabled (false);
            hl_43.setEnabled (false);
            hl_44.setEnabled (false);
            hl_45.setEnabled (false);
            hl_46.setEnabled (false);

            hl_51.setEnabled (false);
            hl_52.setEnabled (false);
            hl_53.setEnabled (false);
            hl_54.setEnabled (false);
            hl_55.setEnabled (false);
            hl_56.setEnabled (false);

            hl_61.setEnabled (false);
            hl_62.setEnabled (false);
            hl_63.setEnabled (false);
            hl_64.setEnabled (false);
            hl_65.setEnabled (false);
            hl_66.setEnabled (false);

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
                hl_15.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 5){
                hl_16.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 6){
                hl_21.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 7){
                hl_22.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 8){
                hl_23.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 9){
                hl_24.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 10){
                hl_25.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 11){
                hl_26.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 12){
                hl_31.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 13){
                hl_32.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 14){
                hl_33.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 15){
                hl_34.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 16){
                hl_35.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 17){
                hl_36.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 18){
                hl_41.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 19){
                hl_42.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 20){
                hl_43.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 21){
                hl_44.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 22){
                hl_45.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 23){
                hl_46.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 24){
                hl_51.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 25){
                hl_52.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 26){
                hl_53.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 27){
                hl_54.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 28){
                hl_55.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 29){
                hl_56.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 30){
                hl_61.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 31){
                hl_62.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 32){
                hl_63.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 33){
                hl_64.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 34){
                hl_65.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 35){
                hl_66.setVisibility(View.INVISIBLE);
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
                hl_15.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 5){
                hl_16.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 6){
                hl_21.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 7){
                hl_22.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 8){
                hl_23.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 9){
                hl_24.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 10){
                hl_25.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 11){
                hl_26.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 12){
                hl_31.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 13){
                hl_32.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 14){
                hl_33.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 15){
                hl_34.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 16){
                hl_35.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 17){
                hl_36.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 18){
                hl_41.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 19){
                hl_42.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 20){
                hl_43.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 21){
                hl_44.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 22){
                hl_45.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 23){
                hl_46.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 24){
                hl_51.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 25){
                hl_52.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 26){
                hl_53.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 27){
                hl_54.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 28){
                hl_55.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 29){
                hl_56.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 30){
                hl_61.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 31){
                hl_62.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 32){
                hl_63.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 33){
                hl_64.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 34){
                hl_65.setVisibility(View.INVISIBLE);
            } else if(clickedSecond == 35){
                hl_66.setVisibility(View.INVISIBLE);
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
            hl_15.setImageResource(R.drawable.hogwarts);
            hl_16.setImageResource(R.drawable.hogwarts);
            hl_21.setImageResource(R.drawable.hogwarts);
            hl_22.setImageResource(R.drawable.hogwarts);
            hl_23.setImageResource(R.drawable.hogwarts);
            hl_24.setImageResource(R.drawable.hogwarts);
            hl_25.setImageResource(R.drawable.hogwarts);
            hl_26.setImageResource(R.drawable.hogwarts);
            hl_31.setImageResource(R.drawable.hogwarts);
            hl_32.setImageResource(R.drawable.hogwarts);
            hl_33.setImageResource(R.drawable.hogwarts);
            hl_34.setImageResource(R.drawable.hogwarts);
            hl_35.setImageResource(R.drawable.hogwarts);
            hl_36.setImageResource(R.drawable.hogwarts);
            hl_41.setImageResource(R.drawable.hogwarts);
            hl_42.setImageResource(R.drawable.hogwarts);
            hl_43.setImageResource(R.drawable.hogwarts);
            hl_44.setImageResource(R.drawable.hogwarts);
            hl_45.setImageResource(R.drawable.hogwarts);
            hl_46.setImageResource(R.drawable.hogwarts);
            hl_51.setImageResource(R.drawable.hogwarts);
            hl_52.setImageResource(R.drawable.hogwarts);
            hl_53.setImageResource(R.drawable.hogwarts);
            hl_54.setImageResource(R.drawable.hogwarts);
            hl_55.setImageResource(R.drawable.hogwarts);
            hl_56.setImageResource(R.drawable.hogwarts);
            hl_61.setImageResource(R.drawable.hogwarts);
            hl_62.setImageResource(R.drawable.hogwarts);
            hl_63.setImageResource(R.drawable.hogwarts);
            hl_64.setImageResource(R.drawable.hogwarts);
            hl_65.setImageResource(R.drawable.hogwarts);
            hl_66.setImageResource(R.drawable.hogwarts);

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
        hl_15.setEnabled (true);
        hl_16.setEnabled (true);

        hl_21.setEnabled (true);
        hl_22.setEnabled (true);
        hl_23.setEnabled (true);
        hl_24.setEnabled (true);
        hl_25.setEnabled (true);
        hl_26.setEnabled (true);

        hl_31.setEnabled (true);
        hl_32.setEnabled (true);
        hl_33.setEnabled (true);
        hl_34.setEnabled (true);
        hl_35.setEnabled (true);
        hl_36.setEnabled (true);

        hl_41.setEnabled (true);
        hl_42.setEnabled (true);
        hl_43.setEnabled (true);
        hl_44.setEnabled (true);
        hl_45.setEnabled (true);
        hl_46.setEnabled (true);

        hl_51.setEnabled (true);
        hl_52.setEnabled (true);
        hl_53.setEnabled (true);
        hl_54.setEnabled (true);
        hl_55.setEnabled (true);
        hl_56.setEnabled (true);

        hl_61.setEnabled (true);
        hl_62.setEnabled (true);
        hl_63.setEnabled (true);
        hl_64.setEnabled (true);
        hl_65.setEnabled (true);
        hl_66.setEnabled (true);

        //  check if the game is over
        checkEnd();

    }

    private void checkEnd(){
        if (hl_11.getVisibility() == View.INVISIBLE &&
                hl_12.getVisibility() == View.INVISIBLE &&
                hl_13.getVisibility() == View.INVISIBLE &&
                hl_14.getVisibility() == View.INVISIBLE &&
                hl_15.getVisibility() == View.INVISIBLE &&
                hl_16.getVisibility() == View.INVISIBLE &&
                hl_21.getVisibility() == View.INVISIBLE &&
                hl_22.getVisibility() == View.INVISIBLE &&
                hl_23.getVisibility() == View.INVISIBLE &&
                hl_24.getVisibility() == View.INVISIBLE &&
                hl_25.getVisibility() == View.INVISIBLE &&
                hl_26.getVisibility() == View.INVISIBLE &&
                hl_31.getVisibility() == View.INVISIBLE &&
                hl_32.getVisibility() == View.INVISIBLE &&
                hl_33.getVisibility() == View.INVISIBLE &&
                hl_34.getVisibility() == View.INVISIBLE &&
                hl_35.getVisibility() == View.INVISIBLE &&
                hl_36.getVisibility() == View.INVISIBLE &&
                hl_41.getVisibility() == View.INVISIBLE &&
                hl_42.getVisibility() == View.INVISIBLE &&
                hl_43.getVisibility() == View.INVISIBLE &&
                hl_44.getVisibility() == View.INVISIBLE &&
                hl_45.getVisibility() == View.INVISIBLE &&
                hl_46.getVisibility() == View.INVISIBLE &&
                hl_51.getVisibility() == View.INVISIBLE &&
                hl_52.getVisibility() == View.INVISIBLE &&
                hl_53.getVisibility() == View.INVISIBLE &&
                hl_54.getVisibility() == View.INVISIBLE &&
                hl_55.getVisibility() == View.INVISIBLE &&
                hl_56.getVisibility() == View.INVISIBLE &&
                hl_61.getVisibility() == View.INVISIBLE &&
                hl_62.getVisibility() == View.INVISIBLE &&
                hl_63.getVisibility() == View.INVISIBLE &&
                hl_64.getVisibility() == View.INVISIBLE &&
                hl_65.getVisibility() == View.INVISIBLE &&
                hl_66.getVisibility() == View.INVISIBLE){

            player_finish.start();
            timerEnd = true;

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(screen_6x6.this);
            alertDialogBuilder
                    .setMessage("GAME OVER!\nPuan: " + playerPoints + "\nSüRE: " + (45-son_sure))
                    .setCancelable(false)
                    .setPositiveButton("YENİ OYUN", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), screen_6x6.class);
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

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(screen_6x6.this);
            alertDialogBuilder
                    .setMessage("GAME OVER!\nSÜRE BİTTİ\nPuan:" + playerPoints)
                    .setCancelable(false)
                    .setPositiveButton("YENİ OYUN", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), screen_6x6.class);
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