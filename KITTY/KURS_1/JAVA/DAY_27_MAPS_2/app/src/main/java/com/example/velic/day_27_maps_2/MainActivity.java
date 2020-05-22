package com.example.velic.day_27_maps_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Double Lat=0.0,Lng=0.0;
    String Q="";
    int Z=15;
    String GEO="geo:0,0?q=Рябцево";;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickMAP_1(View view) {
        String geoUriString = "geo:0,10?z=2";
        Uri geoUri = Uri.parse(geoUriString);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, geoUri);
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }

    }

    public void onClickMap_2(View view) {
        String geoURI = "geo:55.370840,37.834683?z=17";
        Uri geo = Uri.parse(geoURI);
        Intent geoIntent = new Intent(Intent.ACTION_VIEW, geo);

        if (geoIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(geoIntent);
        }
    }

    public void onClickMap_3(View view) {
        Double lat=55.370840, lng=37.834683;
        String geoUri = String.format("geo:%s,%s?z=15", Double.toString(lat), Double.toString(lng));
        Intent geoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));

        if (geoIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(geoIntent);
        }
    }

    public void onClickMap_4(View view) {
        String geoUriString = "geo:0,0?q=Belgium";
        Intent geoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUriString));

        if (geoIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(geoIntent);
        }
    }

    public void onClickMAP(View view) {
        //geo="geo:"+Double.toString(lat)+","+Double.toString(lng)+
        //        "?q="+q+"&z="+z;
        //GEO="geo:0,0?q=Рябцево";
        Intent geoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(GEO));

        if (geoIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(geoIntent);
        }


    }

    public void onClickGO(View view) {
        EditText mZ,mLat,mLng,mQ;
        mZ=findViewById(R.id.ZOOM);

        Lat= Double.valueOf(findViewById(R.id.lat).getTextAlignment());
        Lng= Double.valueOf(findViewById(R.id.lng).getTextAlignment());
          Z= Integer.valueOf(String.valueOf(mZ.getText()));
          Q= String.valueOf(findViewById(R.id.q).getTextAlignment());
        //Z= Integer.valueOf(findViewById(R.id.ZOOM).getTextAlignment());
        //Q="Рябцево";
        Log.d("Это я вывожу", "Z= : "+Z);

        GEO="geo:"+Double.toString(Lat)+","+Double.toString(Lng)+
                "?q="+Q+"&z="+Z;
        GEO="geo:0,0?q=москва+театр+кошек&z=6";
        TextView mHelloTextView;
        mHelloTextView = findViewById(R.id.textView);
        mHelloTextView.setText(GEO);


    }
}