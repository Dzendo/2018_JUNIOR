package com.example.kit1_10_java_menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView infoTextView = (TextView) findViewById(R.id.textView);
        switch (id) {
            case R.id.action_cat1:
                infoTextView.setText("Вы выбрали кота!");
                return true;
            case R.id.action_cat2:
                infoTextView.setText("Вы выбрали кошку!");
                return true;
            case R.id.action_cat3:
                infoTextView.setText("Вы выбрали котёнка!");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        }

    public void onSettingsMenuClick(MenuItem item) {
        TextView infoTextView = (TextView) findViewById(R.id.textView);
        infoTextView.setText("Вы выбрали пункт Settings, лучше бы выбрали кота");
    }
}
