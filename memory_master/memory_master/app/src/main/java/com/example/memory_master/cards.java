package com.example.memory_master;

public class cards {


    private String card_name;
    private String card_home;
    private int card_point;
    private int card_picture;

    public cards(String card_name,String card_home,int card_point, int card_picture){
        this.card_name=card_name;
        this.card_home=card_home;
        this.card_point=card_point;
        this.card_picture=card_picture;
    }

    public String getCard_name() {
        return card_name;
    }

    public String getCard_home() {
        return card_home;
    }

    public int getCard_point() {
        return card_point;
    }

    public int getCard_picture() {
        return card_picture;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public void setCard_home(String card_home) {
        this.card_home = card_home;
    }

    public void setCard_point(int card_point) {
        this.card_point = card_point;
    }

    public void setCard_picture(int card_picture) {
        this.card_picture = card_picture;
    }
}
