package com.example.kit1_05_java_two_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

//import com.google.android.material.snackbar.Snackbar;
// implementation 'com.android.support:design:28.0.1' вставил в build grsdle
// implementation 'com.google.android.material:material:1.0.0-beta01'


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Всплывающее окно
        //showToast();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast toast = Toast.makeText(getApplicationContext(),
        //        "Прощай, День Рождения", Toast.LENGTH_SHORT);
        //toast.show();
        Toast.makeText(MainActivity.this, "Прощай, День Рождения", Toast.LENGTH_SHORT).show();

    };


    public void OnClick_Send(View view) {
        EditText adressEditText = findViewById(R.id.adress_text);
        EditText letterEditText = findViewById(R.id.letter_text);
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        // в ключ adress пихаем текст из поля адресса
        intent.putExtra("adress",adressEditText.getText().toString());
        // в ключ letter пихаем тест сообщения
        intent.putExtra("letter",letterEditText.getText().toString());
        startActivity(intent);
    }

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }

    public void onClickBirthday(View view) {
        //Intent intent = new Intent(MainActivity.this, BirthdayActivity.class);
        //startActivity(intent);

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.activity_birthday,
                (ViewGroup) findViewById(R.id.BirthdayLayout));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }
    public void showToast() {     // Всплывающее окно
        //создаем и отображаем текстовое уведомление
        Toast toast = Toast.makeText(getApplicationContext(),
                R.string.Birrthday,
                Toast.LENGTH_SHORT);

        toast.setGravity(Gravity.CENTER, 0, 0);

        LinearLayout toastContainer = (LinearLayout) toast.getView();
        ImageView doImageView = new ImageView(getApplicationContext());
        doImageView.setImageResource(R.drawable.aa1020921738);
        toastContainer.addView(doImageView, 0);
        toast.show();

    }

    public void onThread(View view) {
        // Еще одно всплывающее окно
        Snackbar.make(view, "Snackbar Всплывает как г... в проруби", Snackbar.LENGTH_LONG).show();
        // не работает вылетает

        // Thread thread = new Thread(null, doBackgroundThreadProcessing,
        //        "Background");
        // thread.start();
    }

    private Runnable doBackgroundThreadProcessing = new Runnable() {
        public void run() {
            backgroundThreadProcessing();
        }
    };

    private void backgroundThreadProcessing() {
       // Handler handler= Handler.post(doUpdateGUI);

    }

    // Объект Runnable, который вызывает метод из потока GUI
    private Runnable doUpdateGUI = new Runnable() {
        public void run() {
            Context context = getApplicationContext();
            String msg = "To open mobile development!";
            int duration = Toast.LENGTH_SHORT;
            Toast.makeText(context, msg, duration).show();
        }
    };
}
