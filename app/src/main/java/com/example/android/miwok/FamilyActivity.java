package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create an array of words
        ArrayList<Word> words = new ArrayList<>();

        //Add strings to words ArrayList
        //words.add("one");
        words.add(new Word("Father", "epe", R.drawable.family_father));
        words.add(new Word("Mother", "eta", R.drawable.family_mother));
        words.add(new Word("Son", "angsi", R.drawable.family_son));
        words.add(new Word("Daughter", "tune", R.drawable.family_daughter));
        words.add(new Word("Older Brother", "taachi", R.drawable.family_older_brother));
        words.add(new Word("Younger Brother", "chalitti", R.drawable.family_younger_brother));
        words.add(new Word("Older Sister", "tete", R.drawable.family_older_sister));
        words.add(new Word("Younger Sister", "kolliti", R.drawable.family_younger_sister));
        words.add(new Word("Grandfather", "paapa", R.drawable.family_grandfather));
        words.add(new Word("Grandmother", "ama", R.drawable.family_grandmother));

        //ListView Adapter
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);

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
