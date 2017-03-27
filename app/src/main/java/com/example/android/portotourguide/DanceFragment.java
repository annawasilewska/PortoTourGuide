package com.example.android.portotourguide;


import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DanceFragment extends Fragment {


    public DanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create an arrayList of words
        final ArrayList<PlaceToVisit> placeToVisit = new ArrayList<PlaceToVisit>();

        placeToVisit.add(new PlaceToVisit(getString(R.string.club_musica_80), getString(R.string.address_club_musica), getString(R.string.info_club_musica_80)));
        placeToVisit.add(new PlaceToVisit(getString(R.string.twiggy_events_pub), getString(R.string.address_twiggy_events_pub), getString(R.string.info_twiggy_events_pub)));
        placeToVisit.add(new PlaceToVisit(getString(R.string.cave_45), getString(R.string.address_cave_45), getString(R.string.info_cave_45)));
        placeToVisit.add(new PlaceToVisit(getString(R.string.boulevard), getString(R.string.address_boulevard), getString(R.string.info_boulevard)));
        placeToVisit.add(new PlaceToVisit(getString(R.string.oporto_dancehall), getString(R.string.address_oporto_dancehall), getString(R.string.info_oporto_dancehall)));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), placeToVisit, R.color.category_dance);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), InformationPage.class);
                String messageOut = placeToVisit.get(position).getAdditionalInformation();
                intent.putExtra("message", messageOut);
                startActivity(intent);
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}

