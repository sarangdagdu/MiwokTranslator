package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    ArrayList<String> englishWordsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        englishWordsList = new ArrayList<String>();
        
        englishWordsList.add("one");
        englishWordsList.add("two");
        englishWordsList.add("three");
        englishWordsList.add("four");
        englishWordsList.add("five");
        englishWordsList.add("six");
        englishWordsList.add("seven");
        englishWordsList.add("eight");
        englishWordsList.add("nine");
        englishWordsList.add("ten");

        for (int i = 0; i < englishWordsList.size(); i++) {
            Log.v("NumbersActivity", "Word at index " + i + ": " + englishWordsList.get(i));
        }
    }
}