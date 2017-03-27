package com.example.android.portotourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InformationPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_page);
        TextView textView = (TextView) findViewById(R.id.information_box);

        // Get the Intent that started this activity and extract the string
        final Intent intent = getIntent();
        String messageIn = intent.getExtras().getString("message");

        textView.setText(Html.fromHtml(messageIn));

        Button showOnMap = (Button) findViewById(R.id.showOnMap);
        showOnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creates an Intent that will load a map of San Francisco
                String placeName = intent.getExtras().getString("placeName");
                placeName.replace(" ", "+");
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + placeName + ",+Porto,+Portugal");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });
    }
}
