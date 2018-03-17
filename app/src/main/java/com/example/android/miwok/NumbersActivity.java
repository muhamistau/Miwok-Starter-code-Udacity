package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create an array of words
        ArrayList<Word> words = new ArrayList<>();

        //Add strings and image id to words ArrayList
        //words.add("one");
        words.add(new Word("One", "lutti", R.drawable.number_one));
        words.add(new Word("Two", "otiiko", R.drawable.number_two));
        words.add(new Word("Three", "tolookosu", R.drawable.number_three));
        words.add(new Word("Four", "oyyisa", R.drawable.number_four));
        words.add(new Word("Five", "massokka", R.drawable.number_five));
        words.add(new Word("Six", "temmokka", R.drawable.number_six));
        words.add(new Word("Seven", "kenekaku", R.drawable.number_seven));
        words.add(new Word("Eight", "kawinta", R.drawable.number_eight));
        words.add(new Word("Nine", "wo'e", R.drawable.number_nine));
        words.add(new Word("Ten", "na'aacha", R.drawable.number_ten));

        //ListView Adapter
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

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
