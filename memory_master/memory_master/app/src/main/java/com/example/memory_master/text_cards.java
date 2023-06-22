package com.example.memory_master;
import android.content.Context;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class text_cards {
    public void add_text(List<String> cards_list) {
        int c=0;
        for (int a=0;a<Math.sqrt(cards_list.size());a++){
            for (int b=0;b<Math.sqrt(cards_list.size());b++){
                System.out.print("-" + cards_list.get(c));
                c++;
            }
            System.out.println("");

        }


        /*String str = "Bunu dosyaya yazdir";

        File file = new File("Dosya.txt");




        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(str);
        bWriter.close();*/
    }
}
