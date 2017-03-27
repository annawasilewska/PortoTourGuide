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
public class CenterFragment extends Fragment {
   // public static final String EXTRA_MESSAGE = "com.example.android.portotourguide.MESSAGE";

    public CenterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create an arrayList of words
        final ArrayList<PlaceToVisit> placeToVisit = new ArrayList<PlaceToVisit>();

        placeToVisit.add(new PlaceToVisit(getString(R.string.monumento_garrett), getString(R.string.address_monumento_garrett), getString(R.string.info_monumento_garrett), R.drawable.dom_luis));
        placeToVisit.add(new PlaceToVisit(getString(R.string.cathedral_porto), getString(R.string.address_cathedral_porto), getString(R.string.info_cathedral_porto), R.drawable.dom_luis));
        placeToVisit.add(new PlaceToVisit(getString(R.string.city_hall), getString(R.string.address_city_hall), getString(R.string.info_city_hall), R.drawable.dom_luis));
        placeToVisit.add(new PlaceToVisit(getString(R.string.stock_exchange_palace), getString(R.string.address_stock_exchange_palace), getString(R.string.info_stock_exchange_palace), R.drawable.dom_luis));
        placeToVisit.add(new PlaceToVisit(getString(R.string.bolhao_market), getString(R.string.address_bolhao_market), getString(R.string.info_bolhao_market), R.drawable.dom_luis));
        placeToVisit.add(new PlaceToVisit(getString(R.string.crystal_palace), getString(R.string.address_crystal_palace), getString(R.string.info_crystal_palace), R.drawable.dom_luis));
        placeToVisit.add(new PlaceToVisit(getString(R.string.sao_bento_station), getString(R.string.address_sao_bento_station), getString(R.string.info_sao_bento_station), R.drawable.dom_luis));
        placeToVisit.add(new PlaceToVisit(getString(R.string.santa_catarina_street), getString(R.string.address_santa_catarina_street), getString(R.string.info_santa_catarina_street), R.drawable.dom_luis));
        placeToVisit.add(new PlaceToVisit(getString(R.string.clerigos_tower), getString(R.string.address_clerigos_tower), getString(R.string.info_clerigos_tower), R.drawable.dom_luis));
        placeToVisit.add(new PlaceToVisit(getString(R.string.dom_luis), getString(R.string.address_dom_luis), getString(R.string.info_dom_luis), R.drawable.dom_luis));
        placeToVisit.add(new PlaceToVisit(getString(R.string.avenida_dos_aliados), getString(R.string.address_avenida_dos_aliados), getString(R.string.info_avenida_dos_aliados), R.drawable.dom_luis));
        placeToVisit.add(new PlaceToVisit(getString(R.string.lello_bookshop), getString(R.string.address_lello_bookshop), getString(R.string.info_lello_bookshop), R.drawable.dom_luis));
        placeToVisit.add(new PlaceToVisit(getString(R.string.house_of_music), getString(R.string.address_house_of_music), getString(R.string.info_house_of_music), R.drawable.dom_luis));
        placeToVisit.add(new PlaceToVisit(getString(R.string.capela_das_almas), getString(R.string.address_capela_das_almas), getString(R.string.info_capela_das_almas), R.drawable.dom_luis));
        placeToVisit.add(new PlaceToVisit(getString(R.string.world_of_discoveries), getString(R.string.address_world_of_discoveries), getString(R.string.info_world_of_discoveries), R.drawable.dom_luis));


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), placeToVisit, R.color.category_center);

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
