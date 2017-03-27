package com.example.android.portotourguide;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by soonsoonnow on 2017-03-20.
 */

public class PlaceAdapter extends ArrayAdapter<PlaceToVisit> {

    /** Resource ID for color background */
    private int mColorResourceID;

    public PlaceAdapter(Activity context, ArrayList<PlaceToVisit> word, int colorResourceID) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, word);
        mColorResourceID = colorResourceID;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        PlaceToVisit currentPlaceToVisit = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokWord = (TextView) listItemView.findViewById(R.id.place_address);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokWord.setText(currentPlaceToVisit.getPlaceAddress());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultWord = (TextView) listItemView.findViewById(R.id.place_name);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultWord.setText(currentPlaceToVisit.getPlaceName());

        //mPlayer = MediaPlayer.create(this, R.raw.number_one);

        // Find the ImageView in the list_item.xml layout with the ID image
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentPlaceToVisit.hasImage()) {
            // Get the image resource ID from the current AndroidFlavor object and
            // set the image to iconView
            iconView.setImageResource(currentPlaceToVisit.getImageResourceID());

            // Make sure the view is visible
            iconView.setVisibility(View.VISIBLE);
        } else{
            // Hide view
            iconView.setVisibility(View.GONE);
        }

        //Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID refers to
        int color = ContextCompat.getColor(getContext(), mColorResourceID);
        //Set the background color of the text container view
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
