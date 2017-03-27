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
public class ShoreFragment extends Fragment {


    public ShoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create an arrayList of words
        final ArrayList<PlaceToVisit> placeToVisit = new ArrayList<PlaceToVisit>();

        placeToVisit.add(new PlaceToVisit(getString(R.string.castelo_do_queijo), getString(R.string.address_castelo_do_queijo), getString(R.string.info_castelo_do_queijo), R.drawable.dom_luis));
        placeToVisit.add(new PlaceToVisit(getString(R.string.porto_city_park), getString(R.string.address_porto_city_park), getString(R.string.info_porto_city_park), R.drawable.dom_luis));
        placeToVisit.add(new PlaceToVisit(getString(R.string.praia_da_luz), getString(R.string.address_praia_da_luz), getString(R.string.info_praia_da_luz), R.drawable.dom_luis));
        placeToVisit.add(new PlaceToVisit(getString(R.string.fortaleza_de_sao_joao), getString(R.string.address_fortaleza_de_sao_joao), getString(R.string.info_fortaleza_de_sao_joao), R.drawable.dom_luis));
        placeToVisit.add(new PlaceToVisit(getString(R.string.farol_de_felgueiras), getString(R.string.address_farol_de_felgueiras), getString(R.string.info_farol_de_felgueiras), R.drawable.dom_luis));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), placeToVisit, R.color.category_shore);

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
