package com.example.velic.day_06_1_orient;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity_java extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText mNameEditText;
        mNameEditText = findViewById(R.id.editText);
        GridLayout gridLayout = findViewById(R.id.Grid);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mNameEditText.setText("Портретная ориентация");
            gridLayout.setColumnCount(1);
        }
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            mNameEditText.setText("Альбомная ориентация");
            gridLayout.setColumnCount(2);
        }
        else
            mNameEditText.setText("Квадратная ориентация");


    }
   /* @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen Не перехватывает
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }
    private String mOrientation = "";

    private boolean isLandscapeMode(Activity activity)
    {
        int width =
                activity.getWindowManager().getDefaultDisplay().getWidth();
        int height =
                activity.getWindowManager().getDefaultDisplay().getHeight();

        boolean isLandscape = width > height;

        if(isLandscape)
            mOrientation = "Альбомная";
        else
            mOrientation = "Портретная";

        return isLandscape;
    }*/
}
