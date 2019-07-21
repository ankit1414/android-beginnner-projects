package com.example.learnspanish;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private  int mcolorid;
    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        View listofobjects = convertView;
        if(listofobjects == null){
            listofobjects = LayoutInflater.from((getContext())).inflate(R.layout.list_item , parent , false);
            //listofobjects = LayoutInflater.from(getContext()).inflate(R.id.listOfItem, parent ,false);
        }
        Word currentword = getItem(position);
        TextView spanish = listofobjects.findViewById(R.id.spanish_word);
        spanish.setText(currentword.getSpanish());
        TextView english = listofobjects.findViewById(R.id.english_word);
        english.setText(currentword.getEnglish());
        if(currentword.getHasimage() == 1) {
            ImageView image = listofobjects.findViewById(R.id.image_id);
            image.setImageResource(currentword.getImageresource());
            image.setVisibility(View.VISIBLE);
        }
        else{
            ImageView image = listofobjects.findViewById(R.id.image_id);
            image.setVisibility(View.GONE);
        }
        View view = listofobjects.findViewById(R.id.textContainerView);
        view.setBackgroundColor(this.mcolorid);

        return listofobjects;

    }

    public WordAdapter(Context context, ArrayList<Word> objects , int colorid) {
        super(context, 0, objects);
        this.mcolorid = colorid;
    }

}
