package com.example.velic.day_04_1_svetofor;

import android.app.Activity;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity_java extends Activity {
private ConstraintLayout mConstraintLayout;
private TextView mInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     mConstraintLayout = findViewById(R.id.constraintLayout);
     mInfoTextView =findViewById(R.id.textView);

        Button yellowButton = (Button) findViewById(R.id.buttonYellow);
        Button greenButton = (Button) findViewById(R.id.buttonGreen);
         greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInfoTextView.setText(R.string.green + "  Listener_J ");
                mConstraintLayout.setBackgroundColor(getResources().getColor(R.color.greenColor));
            }
        });
        // Только для JAVA 8 :
        yellowButton.setOnClickListener(v -> {
                mInfoTextView.setText(R.string.yellow + " Lamba_J ");
                mConstraintLayout.setBackgroundColor(getResources().getColor(R.color.yellowColor));
            });


    }

    public void onRedButtonClick(View view) {
        mInfoTextView.setText(getText(R.string.red) + " CLICK_J ");
        mConstraintLayout.setBackgroundColor(getResources().getColor(R.color.redColor));
    }

    public void onYellowButtonClick(View view) {
        // mInfoTextView.setText(R.string.yellow + " CLICK ");
        // mConstraintLayout.setBackgroundColor(getResources().getColor(R.color.yellowColor));
    }

    public void onGreenButtonClick(View view) {
       // mInfoTextView.setText(R.string.green + " CLICK ");
       // mConstraintLayout.setBackgroundColor(getResources().getColor(R.color.greenColor));
    }

}
