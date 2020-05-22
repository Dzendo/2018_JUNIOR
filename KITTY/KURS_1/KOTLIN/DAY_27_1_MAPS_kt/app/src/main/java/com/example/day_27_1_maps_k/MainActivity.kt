package com.example.day_27_1_maps_k

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    internal var Lat: Double? = 0.0
    internal var Lng: Double? = 0.0
    internal var Q = ""
    internal var Z = 15
    internal var GEO = "geo:0,0?q=Рябцево"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickMAP_1(view: View) {
        val geoUriString = "geo:0,10?z=2"
        val geoUri = Uri.parse(geoUriString)
        val mapIntent = Intent(Intent.ACTION_VIEW, geoUri)
        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        }

    }

    fun onClickMap_2(view: View) {
        val geoURI = "geo:55.370840,37.834683?z=17"
        val geo = Uri.parse(geoURI)
        val geoIntent = Intent(Intent.ACTION_VIEW, geo)

        if (geoIntent.resolveActivity(packageManager) != null) {
            startActivity(geoIntent)
        }
    }

    fun onClickMap_3(view: View) {
        val lat = 55.370840
        val lng = 37.834683
        val geoUri = String.format("geo:%s,%s?z=15", java.lang.Double.toString(lat), java.lang.Double.toString(lng))
        val geoIntent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))

        if (geoIntent.resolveActivity(packageManager) != null) {
            startActivity(geoIntent)
        }
    }

    fun onClickMap_4(view: View) {
        val geoUriString = "geo:0,0?q=Belgium"
        val geoIntent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUriString))

        if (geoIntent.resolveActivity(packageManager) != null) {
            startActivity(geoIntent)
        }
    }

    // Просмотр улиц (Google StreetView)
    fun onClickMAP(view: View) {
        val geoUriString = "google.streetview:cbll=59.939448,30.328264&cbp=1,99.56,,1,2.0&mz=19"
        val geoUri = Uri.parse(geoUriString)
        val mapIntent = Intent(Intent.ACTION_VIEW, geoUri)

        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        }
        // google.streetview:cbll=lat,lng&cbp=1,yaw,,pitch,zoom&mz=mapZoom
        //lat - широта
        //lng	- долгота
        //yaw	- центр панорамы в градусах по часовой стрелке с севера. Обязательно используйте две запятые.
        //pitch - центр обзора панорамы в градусах от -90 (взор вверх) до 90 (взгляд вниз)
        //zoom - масштаб панорамы. 1.0 = нормальный, 2.0 = приближение в 2 раза, 3.0 = в 4 раза и так далее
        //mapZoom	- масштабирование места карты, связанное с панорамой.
        // Это значение используется при переходе на Карты.

    }

    fun onClickGO(view: View) {
        val mZ: EditText
        val mLat: EditText
        val mLng: EditText
        val mQ: EditText
        mZ = findViewById(R.id.ZOOM)

        Lat = java.lang.Double.valueOf(findViewById<View>(R.id.lat).textAlignment.toDouble())
        Lng = java.lang.Double.valueOf(findViewById<View>(R.id.lng).textAlignment.toDouble())
        Z = Integer.valueOf(mZ.text.toString())
        Q = findViewById<View>(R.id.q).textAlignment.toString()
        //Z= Integer.valueOf(findViewById(R.id.ZOOM).getTextAlignment());
        //Q="Рябцево";
        Log.d("Это я вывожу", "Z= : $Z")

        GEO = "geo:" + java.lang.Double.toString(Lat!!) + "," + java.lang.Double.toString(Lng!!) +
                "?q=" + Q + "&z=" + Z
        GEO = "geo:0,0?q=москва+театр+кошек&z=6"
        val mHelloTextView: TextView
        mHelloTextView = findViewById(R.id.textView)
        mHelloTextView.text = GEO


    }
}