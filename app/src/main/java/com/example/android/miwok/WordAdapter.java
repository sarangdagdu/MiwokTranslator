package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.android.miwok.R;
import com.example.android.miwok.Word;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mcolorResourceId;
    /**
     * Parameterized Constructor
     *
     * @param context context
     * @param objects ArrayList of Words
     */
    public WordAdapter(Activity context, ArrayList<Word> objects, int colorResourceId) {
        super(context, 0, objects);
        mcolorResourceId = colorResourceId;
    }

    /**
     * Need this to create a view of custom requirement. Here custom requirement means
     * having 2 TextViews.
     *
     * @param position    position of the view
     * @param convertView the single view
     * @param parent      ViewGroup
     * @return listItem
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //Get the words that needs to be populated
        Word currentWord = getItem(position);

        //Set the default text view to default word
        TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getmDefaultTranslation());

        //Set the miwok text view to miwok word
        TextView miwokTextView = listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getmMiwokTranslation());

        //Set the Image resource id
        ImageView imageView = listItemView.findViewById(R.id.image_section);
        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getmImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.list_item);
        int color = ContextCompat.getColor(getContext(), mcolorResourceId);
        textContainer.setBackgroundColor(color);

        /* Return the created / recycled view */
        return listItemView;
    }

}
