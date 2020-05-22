package com.example.kit1_04_java_colors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
                mInfoTextView.setText(getText(R.string.green) + "  Listener ");
                mConstraintLayout.setBackgroundColor(getResources().getColor(R.color.greenColor));
            }
        });
        // Только для JAVA 8 :
        yellowButton.setOnClickListener(v -> {
            mInfoTextView.setText(getText(R.string.yellow) + " Lamba ");
            mConstraintLayout.setBackgroundColor(getResources().getColor(R.color.yellowColor));
        });


    }

    public void onRedButtonClick(View view) {
        mInfoTextView.setText(getText(R.string.red) + " CLICK ");
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
