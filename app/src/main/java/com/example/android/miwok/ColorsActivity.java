package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    //Use MediaPlayer API and create an global variable for it
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create an array of words
        final ArrayList<Word> words = new ArrayList<>();

        //Add strings to words ArrayList
        //words.add("one");
        words.add(new Word("Red", "Wetetti", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("Mustard Yellow", "Chiwiite", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        words.add(new Word("Dusty Yellow", "Tipiise", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("Green", "Chokokki", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("Brown", "Takaakki", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("Gray", "Topoppi", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("Black", "Kululli", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("White", "Kelelli", R.drawable.color_white, R.raw.color_white));

        //ListView Adapter
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Get the object at the given position the user clicked on
                Word word = words.get(i);

                //Create and setup the MediaPlayer for the audio resource associated with the current word
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());

                //Start the audio file
                mMediaPlayer.start();
            }
        });


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
