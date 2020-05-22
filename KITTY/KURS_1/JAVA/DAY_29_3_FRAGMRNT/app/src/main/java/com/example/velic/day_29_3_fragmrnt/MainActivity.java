package com.example.velic.day_29_3_fragmrnt;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements Fragment1.OnSelectedButtonListener{
   /* private TextView mHelloTextView;
    private ImageView mNameImageView; */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("DAY_29_3_00", "MAIN подключаем Fragment : ");
        setContentView(R.layout.activity_main);
        Log.d("DAY_29_3_0", "MAIN подключаем Fragment : ");
       /* mHelloTextView = findViewById(R.id.textView);
        mNameImageView = findViewById(R.id.imageView);  */
    }

   /* public void OnClick1(View view) {

        String simpleString  =  getString (R.string.Button1);
        mHelloTextView.setText(simpleString);
        Drawable simpleView = getDrawable(R.drawable.chicken);
        mNameImageView.setImageDrawable(simpleView);

    }

    public void OnClick2(View view) {
        mHelloTextView.setText(getString (R.string.Button2));
        mNameImageView.setImageDrawable(getDrawable(R.drawable.dog));
    }

    public void OnClick3(View view) {
        String simpleString  =  getString (R.string.Button3);
        mHelloTextView.setText(simpleString);
        Drawable simpleView = getDrawable(R.drawable.duck);
        mNameImageView.setImageDrawable(simpleView);
    }*/

    @Override
    public void onButtonSelected(int buttonIndex) {
        Log.d("DAY_29_3_5", "MAIN подключаем FragmentManager : "+buttonIndex);
        // подключаем FragmentManager
        FragmentManager fragmentManager = getFragmentManager();
        Log.d("DAY_29_3_6", "MAIN Получаем ссылку на второй фрагмент по ID : "+buttonIndex);
        // Получаем ссылку на второй фрагмент по ID
        Fragment2 fragment2 = (Fragment2) fragmentManager
                .findFragmentById(R.id.fragment2);
        Log.d("DAY_29_3_7", "MAIN Нажата Кнопка : "+buttonIndex);
// если фрагмента не существует или он невидим
        if (fragment2 == null || !fragment2.isVisible()) {
            Log.d("DAY_29_3_8", "MAIN если фрагмента не существует или он невидим : "+buttonIndex);
            // запускаем активность
            Intent intent = new Intent(this, SecondActivity.class);

            intent.putExtra("buttonIndex", buttonIndex);
            Log.d("DAY_29_3_9", "MAIN запускаем активность : "+buttonIndex);
            startActivity(intent);
        } else {
            // Выводим нужную информацию
            Log.d("DAY_29_3_10", "MAIN Выводим нужную информацию : "+buttonIndex);
                fragment2.setDescription(buttonIndex);
        }
    }
}
