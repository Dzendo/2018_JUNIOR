package com.example.velic.day_05_2x_startactivityforresust;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity_java extends Activity {

    static final private int CHOOSE_THIEF =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_x);
    }

    public void onClick(View view) {
        Intent questionIntent = new Intent(MainActivity_java.this, ChooseActivity_java.class);
        startActivityForResult(questionIntent,CHOOSE_THIEF);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // data это обратный INMTENT

        TextView infoTextView = findViewById(R.id.textViewInfo);

        if (requestCode == CHOOSE_THIEF) {
            if (resultCode == RESULT_OK) {
                String thiefname = data.getStringExtra(ChooseActivity_java.THIEF);
                //String thiefname = data.getStringExtra("1");
                 //infoTextView.setText(ChooseActivity_java.THIEF);

                infoTextView.setText(thiefname);
            }else {
                infoTextView.setText(""); // стираем текст
            }
        }
    }
}
