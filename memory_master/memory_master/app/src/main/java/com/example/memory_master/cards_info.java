package com.example.memory_master;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;


public class cards_info {
    public ArrayList<cards> cardss = new ArrayList();
    int g=0, r=0, s=0, h=0;

    public void main(int sayi_card, int sayi_card2) {

         //Gryffindor
        cardss.add(new cards("Harry Potter", "Gryffindor", 10, R.drawable.harry_potter));
        cardss.add(new cards("Albus Dumbledore", "Gryffindor", 20, R.drawable.albus_dumbledore));
        cardss.add(new cards("Sirius Black", "Gryffindor", 18, R.drawable.sirius_black));
        cardss.add(new cards("Hermione Granger", "Gryffindor", 10, R.drawable.hermione_granger));
        cardss.add(new cards("Rubeus Hagrid", "Gryffindor", 12, R.drawable.rubeus_hagrid));
        cardss.add(new cards("Minerva McGonagall", "Gryffindor", 13, R.drawable.minerva_mcgonagall));
        cardss.add(new cards("Arthur Weasley", "Gryffindor", 10, R.drawable.arthur_weasley));
        cardss.add(new cards("Lily Potter", "Gryffindor", 12, R.drawable.lily_potter));
        cardss.add(new cards("Remus Lupin", "Gryffindor", 10, R.drawable.remus_lupin));
        cardss.add(new cards("Peter Pettigrew", "Gryffindor", 5, R.drawable.peter_pettigrew));
        cardss.add(new cards("Ron Weasley", "Gryffindor", 8, R.drawable.ron_weasley));

        //Ravenclaw
        cardss.add(new cards("Rowena Ravenclaw", "Ravenclaw", 20, R.drawable.rowena_ravenclaw));
        cardss.add(new cards("Luna Lovegood", "Ravenclaw", 9, R.drawable.luna_lovegood));
        cardss.add(new cards("Gilderoy Lockhart", "Ravenclaw", 13, R.drawable.gilderoy_lockhart));
        cardss.add(new cards("Filius Flitwick", "Ravenclaw", 10, R.drawable.filius_flitwick));
        cardss.add(new cards("Cho Chang", "Ravenclaw", 11, R.drawable.cho_chang));
        cardss.add(new cards("Sybill Trelawney", "Ravenclaw", 14, R.drawable.sybill_trelawney));
        cardss.add(new cards("Marcus Belby", "Ravenclaw", 10, R.drawable.marcus_belby));
        cardss.add(new cards("Myrtle Warren", "Ravenclaw", 5, R.drawable.myrtle_warren));
        cardss.add(new cards("Padma Patil", "Ravenclaw", 10, R.drawable.padma_patil));
        cardss.add(new cards("Quirinus Quirrell", "Ravenclaw", 15, R.drawable.quirinus_quirrell));
        cardss.add(new cards("Garrick Ollivander", "Ravenclaw", 15, R.drawable.garrick_ollivander));

        //Slytherin
        cardss.add(new cards("Tom Riddle", "Slytherin", 20, R.drawable.tom_riddle));
        cardss.add(new cards("Horace Slughorn", "Slytherin", 12, R.drawable.horace_slughorn));
        cardss.add(new cards("Bellatrix Lestrange", "Slytherin", 13, R.drawable.bellatrix_lestrange));
        cardss.add(new cards("Narcissa Malfoy", "Slytherin", 10, R.drawable.narcissa_malfoy));
        cardss.add(new cards("Andromeda Tonks", "Slytherin", 16, R.drawable.andromeda_tonks));
        cardss.add(new cards("Lucius Malfoy", "Slytherin", 12, R.drawable.lucius_malfoy));
        cardss.add(new cards("Evan Rosier", "Slytherin", 10, R.drawable.evan_rosier));
        cardss.add(new cards("Draco Malfoy", "Slytherin", 5, R.drawable.draco_malfoy));
        cardss.add(new cards("Dolores Umbridge", "Slytherin", 10, R.drawable.dolores_umbridge));
        cardss.add(new cards("Severus Snape", "Slytherin", 18, R.drawable.severus_snape));
        cardss.add(new cards("Leta Lestrange", "Slytherin", 10, R.drawable.leta_lestrange));

        //Hufflepuff
        cardss.add(new cards("Helga Hufflepuff", "Hufflepuff", 20, R.drawable.helga_hufflepuff));
        cardss.add(new cards("Cedric Diggory", "Hufflepuff", 18, R.drawable.cedric_diggory));
        cardss.add(new cards("Nymphadora Tonks", "Hufflepuff", 14, R.drawable.nymphadora_tonks));
        cardss.add(new cards("Pomona Sprout", "Hufflepuff", 10, R.drawable.sprout));
        cardss.add(new cards("Newt Scamander", "Hufflepuff", 18, R.drawable.newt_scamander));
        cardss.add(new cards("Fat Friar", "Hufflepuff", 12, R.drawable.fat_friar));
        cardss.add(new cards("Hannah Abbott", "Hufflepuff", 10, R.drawable.hannah_abbott));
        cardss.add(new cards("Ernest Macmillan ", "Hufflepuff", 5, R.drawable.ernest_macmillan));
        cardss.add(new cards("Leanne", "Hufflepuff", 10, R.drawable.leanne));
        cardss.add(new cards("Silvanus Kettleburn", "Hufflepuff", 12, R.drawable.silvanus_kettleburn));
        cardss.add(new cards("Ted Lupin", "Hufflepuff", 10, R.drawable.ted_lupin));

        Collections.shuffle(cardss);

        for (int a=0;a<cardss.size();a++){
            if (cardss.get(a).getCard_home().equals("Gryffindor")){
                if (g>=sayi_card){
                    cardss.remove(a);
                    g++;
                }
            }else if (cardss.get(a).getCard_home().equals("Ravenclaw")){
                if (r>=sayi_card2){
                    cardss.remove(a);
                    r++;
                }
            }else if (cardss.get(a).getCard_home().equals("Slytherin")){
                if (s>=sayi_card){
                    cardss.remove(a);
                    s++;
                }
            }else if (cardss.get(a).getCard_home().equals("Hufflepuff")){
                if (h>=sayi_card2){
                    cardss.remove(a);
                    h++;
                }
            }
        }




        /*  FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Cards")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot documend: task.getResult()){
                                ;:
                                :4

                                card_name Ç:;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                card_home = documend.getString("Home");
                                card_point = documend.getString("Point");
                                int card_pointt = Integer.parseInt(card_point);
                                cardss.add(new cards(
                                        card_name,
                                        card_home,
                                        card_pointt,
                                        R.drawable.harry_potter));
                                Log.d("firebase", String.valueOf(task.getResult().getValue()));
                            }
                        }
                        else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                        for(int basla=0;basla<cardss.size();basla++){
                            System.out.println(cardss.get(basla).getCard_home() + "   "
                                    + cardss.get(basla).getCard_point() + "   "
                                    + cardss.get(basla).getCard_name());
                        }
                    }
                });*/

    }
}
