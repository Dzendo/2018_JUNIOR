package com.example.dolv.day_8_showtoastme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void onClick(View view) {
        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(R.layout.custom_layout,
                (ViewGroup) findViewById(R.id.toast_layout));


        Toast toast = new Toast(getApplicationContext());

        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();


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
