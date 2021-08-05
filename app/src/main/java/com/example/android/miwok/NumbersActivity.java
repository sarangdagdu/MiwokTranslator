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
        englishWordsList = new ArrayList<>();

        englishWordsList.add(new Word("one", "lutti", R.drawable.number_one));
        englishWordsList.add(new Word("two", "otiiko", R.drawable.number_two));
        englishWordsList.add(new Word("three", "tolookosu", R.drawable.number_three));
        englishWordsList.add(new Word("four", "oyyisa", R.drawable.number_four));
        englishWordsList.add(new Word("five", "massokka", R.drawable.number_five));
        englishWordsList.add(new Word("six", "temmokka", R.drawable.number_six));
        englishWordsList.add(new Word("seven", "kenekaku", R.drawable.number_seven));
        englishWordsList.add(new Word("eight", "kawinta", R.drawable.number_eight));
        englishWordsList.add(new Word("nine", "wo’e", R.drawable.number_nine));
        englishWordsList.add(new Word("ten", "na’aacha", R.drawable.number_ten));

        WordAdapter adapter = new WordAdapter(this,englishWordsList, R.color.category_numbers);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        }
    }