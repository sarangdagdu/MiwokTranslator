/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewNumbers;
    TextView textViewColors;
    TextView textViewPhrases;
    TextView textViewFamilyMembers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        textViewNumbers = findViewById(R.id.numbers);
        textViewNumbers.setOnClickListener(this);
        textViewPhrases = findViewById(R.id.phrases);
        textViewPhrases.setOnClickListener(this);
        textViewColors = findViewById(R.id.colors);
        textViewColors.setOnClickListener(this);
        textViewFamilyMembers = findViewById(R.id.family);
        textViewFamilyMembers.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.numbers){
            tapNumbersTextView();
        }
        else if(v.getId() == R.id.colors){
            tapColorsTextView();
        }
        else if(v.getId() == R.id.phrases){
            tapPhrasesTextView();
        }
        else if(v.getId() == R.id.family){
            tapFamilyMembersTextView();
        }
    }

    private void tapFamilyMembersTextView() {
        Intent intent = new Intent(getApplicationContext(), FamilyActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Opened Family Members Activity",Toast.LENGTH_LONG).show();

    }

    private void tapPhrasesTextView() {
        Intent intent = new Intent(getApplicationContext(), PhrasesActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Opened Phrases Activity",Toast.LENGTH_LONG).show();

    }

    private void tapColorsTextView() {
        Intent intent = new Intent(getApplicationContext(), ColorsActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Opened Colors Activity",Toast.LENGTH_LONG).show();

    }

    private void tapNumbersTextView() {
        Intent intent = new Intent(getApplicationContext(), NumbersActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Opened Numbers Activity",Toast.LENGTH_LONG).show();
    }
}
