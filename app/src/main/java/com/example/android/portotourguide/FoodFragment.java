package com.example.android.portotourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create an arrayList of words
        final ArrayList<PlaceToVisit> placeToVisit = new ArrayList<PlaceToVisit>();

        placeToVisit.add(new PlaceToVisit(getString(R.string.sandeira_do_porto), getString(R.string.address_sandeira_do_porto), getString(R.string.info_sandeira_do_porto)));
        placeToVisit.add(new PlaceToVisit(getString(R.string.nata_lisboa_catarina), getString(R.string.address_nata_lisboa_catarina), getString(R.string.info_nata_lisboa_catarina)));
        placeToVisit.add(new PlaceToVisit(getString(R.string.nata_lisboa_flores), getString(R.string.address_nata_lisboa_flores), getString(R.string.info_nata_lisboa_flores)));
        placeToVisit.add(new PlaceToVisit(getString(R.string.la_copa), getString(R.string.address_la_copa), getString(R.string.info_la_copa)));
        placeToVisit.add(new PlaceToVisit(getString(R.string.miss_pavlova), getString(R.string.address_miss_pavlova), getString(R.string.info_miss_pavlova)));
        placeToVisit.add(new PlaceToVisit(getString(R.string.praia_da_luz_cafe), getString(R.string.address_praia_da_luz_cafe), getString(R.string.info_praia_da_luz_cafe)));
        placeToVisit.add(new PlaceToVisit(getString(R.string.tentacoes_no_prato), getString(R.string.address_tentacoes_no_prato), getString(R.string.info_tentacoes_no_prato)));
        placeToVisit.add(new PlaceToVisit(getString(R.string.chocolataria_das_flores), getString(R.string.address_chocolataria_das_flores), getString(R.string.info_chocolataria_das_flores)));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), placeToVisit, R.color.category_food);

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
                String placeName = placeToVisit.get(position).getPlaceName();
                intent.putExtra("placeName", placeName);
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

