package com.example.kit1_08_java_show_toast;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view) {
       // Toast toast = Toast.makeText(getApplicationContext(),
       //         "Пора вставать! Утро!",
            //    Toast.LENGTH_SHORT);
        //toast.setGravity(Gravity.CENTER,0,0);
        //toast.show();

        //int duration = Toast.LENGTH_LONG;
        //Toast toast2;
       // toast2 = Toast.makeText(getApplicationContext(),
        //        R.string.show_toast,
        //        duration);
        //toast2.setGravity(Gravity.TOP, 0, 0);
        //toast2.show();

        Toast toast3 = Toast.makeText(getApplicationContext(),
                R.string.show_toast, Toast.LENGTH_LONG);
        toast3.setGravity(Gravity.CENTER, 0, 0);
        LinearLayout toastContainer = (LinearLayout) toast3.getView();
        ImageView catImageView = new ImageView(getApplicationContext());
        catImageView.setImageResource(R.drawable.soley);
        toastContainer.addView(catImageView, 0);
        toast3.show();
    }
}
