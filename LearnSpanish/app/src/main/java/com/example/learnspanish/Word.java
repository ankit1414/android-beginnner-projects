package com.example.learnspanish;

public class Word {
    String spanish;
    String english;

    public Word(String spanish_name , String english_name){
        this.spanish = spanish_name;
        this.english = english_name;
    }

    @Override
    public String toString() {
        return (this.spanish + "\n" + this.english);
    }
}
