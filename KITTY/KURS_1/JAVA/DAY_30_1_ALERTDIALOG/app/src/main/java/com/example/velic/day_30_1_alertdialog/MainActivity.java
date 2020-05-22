package com.example.velic.day_30_1_alertdialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickDialogButton1(View view) {
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        myDialogFragment.show(manager, "dialog");

    }
//альтернативный вариант показа окна через транзакцию
    public void onClickDialogTransac(View view) {
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragment2 myDialogFragment = new MyDialogFragment2();
        FragmentTransaction transaction = manager.beginTransaction();
        myDialogFragment.show(transaction, "dialog");
    }

    public void onClickDialog3(View view) {
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragment3 myDialogFragment = new MyDialogFragment3();
        myDialogFragment.show(manager, "dialog");
    }

    public void onClickList(View view) {
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragment4 myDialogFragment = new MyDialogFragment4();
        myDialogFragment.show(manager, "dialog");
    }

    public void onClick5(View view) {
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragment5 myDialogFragment = new MyDialogFragment5();
        myDialogFragment.show(manager, "dialog");
    }

    public void onClick6(View view) {
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragment6 myDialogFragment = new MyDialogFragment6();
        myDialogFragment.show(manager, "dialog");
    }

    public void onClick7(View view) {
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragment7 myDialogFragment = new MyDialogFragment7();
        myDialogFragment.show(manager, "dialog");
    }

    public void okClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку OK!",
                Toast.LENGTH_LONG).show();
    }

    public void cancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку отмены!",
                Toast.LENGTH_LONG).show();
    }

    public void onClick8(View view) {
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragment8 myDialogFragment = new MyDialogFragment8();
        myDialogFragment.show(manager, "dialog");

    }

    public void onClickYes(View view) {
        Toast.makeText(getApplicationContext(), "Уже купил билет!",
                Toast.LENGTH_LONG).show();
    }

    public void onClickAll(View view) {
        Toast.makeText(getApplicationContext(), "Без денег нечего хотеть!",
                Toast.LENGTH_LONG).show();
    }

    public void onClickNon(View view) {
        Toast.makeText(getApplicationContext(), "Правильно, там одни негры!",
                Toast.LENGTH_LONG).show();

    }
    //алерт диалог не закрывает
}
