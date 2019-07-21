package com.example.learnspanish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_view);
        ArrayList<Word> nums = new ArrayList<>();
        nums.add(new Word("sobrino","nephew" , R.drawable.family_younger_brother));
        nums.add(new Word("sobrina","niece" , R.drawable.family_younger_sister));
        nums.add(new Word("padre" , "father" ,R.drawable.father ));
        nums.add(new Word("madre","mother" , R.drawable.mother));
        nums.add(new Word("hijo","son", R.drawable.son));
        nums.add(new Word("hija","daughter" , R.drawable.daugher));
        nums.add(new Word("abuelo","grandfather" , R.drawable.grandfather));
        nums.add(new Word("abuela","grandmother",R.drawable.grandmother));
        nums.add(new Word("esposo","husband" , R.drawable.husband));
        nums.add(new Word("esposa","wife" , R.drawable.wife));
        nums.add(new Word("padres","parents" , R.drawable.parents));
        nums.add(new Word("hermano" ,"brother", R.drawable.family_older_brother));
        nums.add(new Word("hermana","sister" , R.drawable.family_older_sister));
        nums.add(new Word("primo","cousin (male)",R.drawable.defaultimage));
        nums.add(new Word("prima","cousin (female)",R.drawable.defaultimage));

        nums.add(new Word("nieto","grandson",R.drawable.defaultimage));
        nums.add(new Word("nieta","granddaughter",R.drawable.defaultimage));

        nums.add(new Word("suegro","father-in-law",R.drawable.defaultimage));
        nums.add(new Word("suegra","mother-in-law",R.drawable.defaultimage));
        nums.add(new Word("yerno","son-in-law",R.drawable.defaultimage));
        ListView rootview = findViewById(R.id.rootview);

        WordAdapter numberAdapter = new WordAdapter(this, nums ,R.color.category_family);
        rootview.setAdapter(numberAdapter);

    }


}
