package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

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

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, englishWordsList);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        }
    }