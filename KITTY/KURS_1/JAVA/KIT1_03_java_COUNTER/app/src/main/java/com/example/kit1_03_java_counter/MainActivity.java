package com.example.kit1_03_java_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mKitsCounterButton;
    private Button mDolphinsCounterButton;
    private TextView helloTextView;
    public int mCountKits = 0;
    public int mCountDolphins = 0;

    private static final String KEY_COUNT_Dolphins = "COUNT_DOLPHINS";
    private static final String KEY_COUNT_Kits = "COUNT_KITS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helloTextView = findViewById(R.id.textView);
        mKitsCounterButton = findViewById(R.id.button_Counter_Kits);
        mDolphinsCounterButton = findViewById(R.id.button_Сounter_Dolphins);
        /*mKitsCounterButton.setOnClickListener(new View.OnClickListener() {
                                                   @Override
                                                   public void onClick(View view) {
          helloTextView.setText("Я насчитал " + ++mCount + " Китов");
                                                   }
                                               });
         */
        mKitsCounterButton.setOnClickListener(v ->
                helloTextView.setText("Я насчитал " + ++mCountKits + " Китов"));
        mDolphinsCounterButton.setOnClickListener(v ->
                helloTextView.setText("Я насчитал " + ++mCountDolphins + " Дельфинов"));
        if (savedInstanceState != null) {
            mCountKits = savedInstanceState.getInt(KEY_COUNT_Kits, 0);
            mCountDolphins = savedInstanceState.getInt(KEY_COUNT_Dolphins, 1);
            // helloTextView.setText("Я насчитал " + mCountDolphins + " Дельфинов");
            //helloTextView.setText("Я насчитал " + mCountKits + " Китов");
        }
    }
    public void onClick(View view) {

        helloTextView.setText("Hello AFALINA! ");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT_Dolphins, mCountDolphins);
        outState.putInt(KEY_COUNT_Kits, mCountKits);

    }
}
