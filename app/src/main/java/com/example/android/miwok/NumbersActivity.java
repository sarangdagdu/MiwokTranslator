package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    ArrayList<Word> englishWordsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        englishWordsList = new ArrayList<Word>();

        englishWordsList.add(new Word("one", "lutti"));
        englishWordsList.add(new Word("two", "otiiko"));
        englishWordsList.add(new Word("three", "tolookosu"));
        englishWordsList.add(new Word("four", "oyyisa"));
        englishWordsList.add(new Word("five", "massokka"));
        englishWordsList.add(new Word("six", "temmokka"));
        englishWordsList.add(new Word("seven", "kenekaku"));
        englishWordsList.add(new Word("eight", "kawinta"));
        englishWordsList.add(new Word("nine", "wo’e"));
        englishWordsList.add(new Word("ten", "na’aacha"));

        WordAdapter adapter = new WordAdapter(this,englishWordsList);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        }
    }