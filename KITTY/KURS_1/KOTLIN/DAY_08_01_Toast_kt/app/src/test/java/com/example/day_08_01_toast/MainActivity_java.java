package com.example.day_08_01_toast;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.dolv.day_8_show_toast.R.string.*;

public class MainActivity_java extends AppCompatActivity {

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


    public void onClick2(View view) {
        mainProcessing();
    }

    // Использование уведомлений Toast в рабочих потоках
    private void mainProcessing() {
        Thread thread = new Thread(null, doBackgroundThreadProcessing,
                "Background");

        thread.start();
    }

    private Runnable doBackgroundThreadProcessing = new Runnable() {
        public void run() {
            backgroundThreadProcessing();
        }
    };

    private void backgroundThreadProcessing() {
        Handler handler = new Handler(Looper.getMainLooper());  // DO
        //return;
        handler.post(doUpdateGUI);
        //new Handler(Looper.getMainLooper()).post(doUpdateGUI);
    }

    // Объект Runnable, который вызывает метод из потока GUI
    private Runnable doUpdateGUI = new Runnable() {
        public void run() {
            Context context = getApplicationContext();
            String msg = "Открыли мобильную разработку! из потока";
            int duration = Toast.LENGTH_LONG;
            Toast.makeText(context, msg, duration).show();
        }
    };
}
