package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create an array of words
        ArrayList<Word> words = new ArrayList<Word>();

        //Add strings to words ArrayList
        //words.add("one");
        words.add(new Word("Red", "Wetetti"));
        words.add(new Word("Mustard Yellow", "Chiwiite"));
        words.add(new Word("Dusty Yellow", "Tipiise"));
        words.add(new Word("Green", "Chokokki"));
        words.add(new Word("Brown", "Takaakki"));
        words.add(new Word("Gray", "Topoppi"));
        words.add(new Word("Black", "Kululli"));
        words.add(new Word("White", "Kelelli"));

        //ListView Adapter
        WordAdapter adapter = new WordAdapter(this, words);

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
