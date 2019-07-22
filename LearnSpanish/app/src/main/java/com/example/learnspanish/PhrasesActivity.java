package com.example.learnspanish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_view);
        ArrayList<Word> nums = new ArrayList<>();
        nums.add(new Word("buenos días" , "good morning" ));
        nums.add(new Word("buenas tardes","good afternoon"));
        nums.add(new Word(
                "buenas noches","good evening"));
        nums.add(new Word("hola","hello"));
        nums.add(new Word(
                "Como siempre","As always"));
        nums.add(new Word(
                "Mal","Bad"));
        nums.add(new Word("Todo bien","All good"));
        nums.add(new Word("Nada" ,"Nothing"));
        nums.add(new Word("¿Cómo te va?","How’s it going?"));
        nums.add(new Word(
                "¿Cómo has ido?","How’ve you been?"));
        nums.add(new Word(
                "¿Qué pasa?","What’s happening?"));
        nums.add(new Word(
                "¿Qué haces?","What are you doing?"));
        nums.add(new Word("Lo siento","I’m sorry"));
        nums.add(new Word("Te amo","I love you"));
        nums.add(new Word("Necesito ayuda","I need help"));
        nums.add(new Word("chao","goodbye"));
        nums.add(new Word("hasta luego","later"));
        nums.add(new Word(
                "hasta pronto","see you soon"));
        nums.add(new Word("¡Buena suerte!","Good luck!"));
        nums.add(new Word(
                "¡Diviértete!","Have fun!"));

        nums.add(new Word(
                "¡Con mucho amor!","Lots of love!"));
        ListView rootview = findViewById(R.id.rootview);
        WordAdapter numberAdapter = new WordAdapter(this, nums , R.color.category_phrases);
        rootview.setAdapter(numberAdapter);

    }

}
