package com.example.lhx.recovery;

public class showpriceview {
    private String pictureUrl;
    private String text;
    private double price;

    public String getPictureUrl() {
        return pictureUrl;
    }
    public String getText(){
        return text;
    }

    public double getPrice() {
        return price;
    }

    public showpriceview(String pictureUrl, String text,double price){
        this.pictureUrl = pictureUrl;
        this.text = text;
        this.price = price;
    }
}
