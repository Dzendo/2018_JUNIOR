package com.example.kit1_05_java_startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final private int CHOOSE_THIEF =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent questionIntent = new Intent(MainActivity.this,ChooseActivity.class);
        startActivityForResult(questionIntent,CHOOSE_THIEF);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // data это обратный INMTENT

        TextView infoTextView = findViewById(R.id.textViewInfo);

        if (requestCode == CHOOSE_THIEF) {
            if (resultCode == RESULT_OK) {
                String thiefname = data.getStringExtra(ChooseActivity.THIEF);
                //String thiefname = data.getStringExtra("1");
                //infoTextView.setText(ChooseActivity.THIEF);

                infoTextView.setText(thiefname);
            }else {
                infoTextView.setText(""); // стираем текст
            }
        }
    }
}
