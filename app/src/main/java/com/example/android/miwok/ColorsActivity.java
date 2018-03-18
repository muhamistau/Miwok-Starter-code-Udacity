package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RemoteController;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    //Use MediaPlayer API and create an global variable for it
    private MediaPlayer mMediaPlayer;

    //handles audio focus when playing a sound file
    private AudioManager mAudiomanager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = (new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                //Pause
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                //Resume
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                //Stop and release resource
                releaseMediaPlayer();
            }
        }
    });

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create and setup the AudioManager to request audio focus
        mAudiomanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

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

                //Release the media player if it currently exists because we are about to play a different song
                releaseMediaPlayer();

                //request adudio focus
                int result = mAudiomanager.requestAudioFocus(mOnAudioFocusChangeListener,
                        //Use the music stream
                        AudioManager.STREAM_MUSIC,
                        //Request permanent focus
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    //Create and setup the MediaPlayer for the audio resource associated with the current word
                    mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());

                    //Start the audio file
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
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

    @Override
    protected void onStop() {
        super.onStop();
        //When the activity is stopped, release the media player resources because we won't need it anymore
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        //If the media player is not null, then it may be currenly palying sound
        if (mMediaPlayer != null) {
            //Regardles of the current state of the media player, release its resources because we no longer need it.
            mMediaPlayer.release();

            //Set media player back to null. For our code, we've decided that setting the media player to null is an easy way
            //to tell that the media player is not configured to play an audio file at the moment.
            mMediaPlayer = null;
            mAudiomanager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
