package com.example.memory_master;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

public class difficulty_selection_online extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    String seviye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_activity);

        radioGroup = findViewById(R.id.radioGroup);

        Button buttonApply = findViewById(R.id.button);
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                seviye = (String) radioButton.getText();
                System.out.println("    umut          "+seviye);

                if (seviye.equals("KOLAY")){
                    startActivity(new Intent(difficulty_selection_online.this,screen_2x2_online.class));
                }
                if (seviye.equals("ORTA")){
                    startActivity(new Intent(difficulty_selection_online.this,screen_4x4_online.class));
                }
                if (seviye.equals("ZOR")){
                    startActivity(new Intent(difficulty_selection_online.this,screen_6x6_online.class));
                }
            }
        });


    }
    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        //Toast.makeText(this, "Seçiminiz:  " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }

}
