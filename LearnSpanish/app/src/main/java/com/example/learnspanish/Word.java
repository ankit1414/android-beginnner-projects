package com.example.learnspanish;

public class Word {
    private String spanish;
    private String english;
    private  int imageresource;
    private  int hasimage = -1;

    public Word(String spanish_name , String english_name, int imageresource){
        this.spanish = spanish_name;
        this.english = english_name;
        this.imageresource = imageresource;
        this.hasimage = 1;
    }
    public Word(String spanish_name , String english_name ){
        this.spanish = spanish_name;
        this.english = english_name;
//        this.hasimage = -1;
    }

    public String getSpanish() {
        return spanish;
    }

    public String getEnglish() {
        return english;
    }

    public int getImageresource() {
        return imageresource;
    }

    public  int getHasimage() {
        return hasimage;
    }
}
