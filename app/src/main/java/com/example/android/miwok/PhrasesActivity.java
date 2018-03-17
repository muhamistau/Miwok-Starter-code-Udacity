package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create an array of words
        ArrayList<Word> words = new ArrayList<>();

        //Add strings to words ArrayList
        //words.add("one");
        words.add(new Word("Where are you going?", "minto wuksus"));
        words.add(new Word("What is your name?", "tinna oyaase'ne"));
        words.add(new Word("My name is....", "oyaaset...."));
        words.add(new Word("How are you feeling?", "michekses?"));
        words.add(new Word("I'm feeling good.", "kuchi achit"));
        words.add(new Word("Are you coming?", "eenes'aa?"));
        words.add(new Word("Yes, I'm coming.", "hee' eenem"));
        words.add(new Word("I'm coming.", "eenem"));
        words.add(new Word("Let's go.", "yoowutis"));
        words.add(new Word("Come here.", "enni'nem"));


        //ListView Adapter
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        /*GridView gridView = (GridView) findViewById(R.id.list);
        gridView.setAdapter(itemsAdapter);*/
        //LinearLayout
        /*
        //Print the values of the elements
        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        //Using While statement
        int index = 0;
        while (index < words.size()) {
            TextView wordView = new TextView(this);
            wordView.setText(words.get(index));
            rootView.addView(wordView);
            index++;
        }

        //Using For statement
        for (int index = 0; index < words.size(); index++) {
            TextView wordView = new TextView(this);
            wordView.setText(words.get(   index));
            rootView.addView(wordView);
        }*/

    }
}
