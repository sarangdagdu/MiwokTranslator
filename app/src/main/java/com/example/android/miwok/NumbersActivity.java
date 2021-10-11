package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, MediaPlayer.OnCompletionListener {

    ArrayList<Word> englishWordsList;
    MediaPlayer mediaPlayer;
    private AudioManager mAudioManager;

    private final AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    if ((focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) ||
                            (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)) {
                        mediaPlayer.pause();
                        mediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        mediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                       MiwokHelper.releaseMediaPlayer(mediaPlayer);
                    }
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        englishWordsList = new ArrayList<>();
        englishWordsList.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        englishWordsList.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        englishWordsList.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        englishWordsList.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        englishWordsList.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        englishWordsList.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        englishWordsList.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        englishWordsList.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        englishWordsList.add(new Word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
        englishWordsList.add(new Word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(this, englishWordsList, R.color.category_numbers);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        //find appropriate audio to be played for the word.
        Word currentWord = englishWordsList.get(position);
        MiwokHelper.releaseMediaPlayer(mediaPlayer);

        int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            mediaPlayer = MediaPlayer.create(this, currentWord.getmRawResourceId());
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        MiwokHelper.releaseMediaPlayer(mediaPlayer);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
       releaseMediaPlayer();
    }


    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}