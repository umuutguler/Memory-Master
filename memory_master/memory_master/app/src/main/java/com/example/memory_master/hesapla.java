package com.example.memory_master;

public class hesapla {

    public int skor;
    int house_point1;
    int house_point2;

    public void match(int puan, int sure, String house){
        evkatsayi(house,"");
        skor = (2*puan*house_point1)*(sure/10);
    }

    public void not_match(int puan1, int puan2, int sure, String house1, String house2){
        evkatsayi(house1,house2);
        if (house1 == house2){
            skor = ((puan1+puan2)/house_point1)*(sure/10);
        }else {
            skor = (((puan1+puan2)*house_point1*house_point2)/2)*(sure/10);
        }

    }

    private void evkatsayi(String house1, String house2){
        if (house1 == "Gryffindor" || house1 == "Slytherin"){
            house_point1 = 2;
        }else if (house1 == "Hufflepuff" || house1 == "Ravenclaw"){
            house_point1 = 1;
        }
        if (house2 == "Gryffindor" || house2 == "Slytherin"){
            house_point2 = 2;
        }else if (house2 == "Hufflepuff" || house2 == "Ravenclaw"){
            house_point2 = 1;
        }
    }

}
