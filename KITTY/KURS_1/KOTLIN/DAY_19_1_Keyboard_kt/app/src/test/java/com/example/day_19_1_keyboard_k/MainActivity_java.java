package com.example.day_19_1_keyboard_k;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class MainActivity_java extends AppCompatActivity {
    private static final String TAG = "MyApp";
    private static long back_pressed;
    private EditText myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Интерфейс OnKeyListener у меня НЕ работает!!! OnKey только ВВОД
        myView = findViewById(R.id.myView);
        myView.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                Log.d(TAG,
                        "Это мое сообщение для записи в журнале клавиша в поле MYView KeyCode="
                        +keyCode+ " KeyEvent="+event );
                // TODO Обработайте нажатие клавиши, верните true, если
                // обработка выполнена
                return false;
            }
        });


    }
   /* @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Обработайте нажатие, верните true, если обработка выполнена
        Log.i(TAG, "Это мое сообщение для записи в журнале KeyDown "+  keyCode);
        //super.onKeyDown(keyCode, event);
        return false;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        // Обработайте отпускание клавиши, верните true, если обработка выполнена
        Log.d(TAG, "Это мое сообщение для записи в журнале KeyUP " + keyCode);
         //super.onKeyUp(keyCode, event);
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
    //replaces the default 'Back' button action
    if(keyCode == KeyEvent.KEYCODE_BACK)
    {
        // ваш код
        Log.d(TAG, "Это мое сообщение для записи в журнале onBackPressed=BACK " );
        openQuitDialog();
    }
    return true;
}

    // Это по другому то же самое для кнопки возврата - - противоречит верхнему оно перехватывает клавишу

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        Log.d(TAG, "Это мое сообщение для записи в журнале onBackPressed " );
        openQuitDialog();
    }

    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                MainActivity.this);
        quitDialog.setTitle("Выход: Вы уверены?");

        quitDialog.setPositiveButton("Таки да!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                finish();
            }
        });

        quitDialog.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        });

        quitDialog.show();
    }

    @Override     // отслеживание двойного нажатия
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis())
            //super.onBackPressed();
            openQuitDialog();

        else
            Toast.makeText(getBaseContext(), "Press once again to exit!",
                    Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }
    @Override
    protected void onUserLeaveHint() {
        Toast toast = Toast.makeText(getApplicationContext(), "Нажата кнопка HOME", Toast.LENGTH_SHORT);
        toast.show();
        super.onUserLeaveHint();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            event.startTracking();
            TextView mTextView = findViewById(R.id.textView);
            mTextView.setText("Key Down"); //вывожу текст в текстовом поле
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            TextView mTextView = findViewById(R.id.textView);
            mTextView.setText("Long Press"); //вывожу текст в текстовом поле
            return true;
        }
        return super.onKeyLongPress(keyCode, event);
    }
    */
   @Override
   public boolean onKeyDown(int keyCode, KeyEvent event) {
       switch (keyCode) {
           case KeyEvent.KEYCODE_MENU:
               Toast.makeText(this, "Нажата кнопка Меню", Toast.LENGTH_SHORT)
                       .show();
               return true;
           case KeyEvent.KEYCODE_SEARCH:
               Toast.makeText(this, "Нажата кнопка Поиск", Toast.LENGTH_SHORT)
                       .show();
               return true;
           case KeyEvent.KEYCODE_BACK:
               onBackPressed();
               return true;
           case KeyEvent.KEYCODE_VOLUME_UP:
               event.startTracking();
               return true;
           case KeyEvent.KEYCODE_VOLUME_DOWN:
               Toast.makeText(this, "Нажата кнопка громкости", Toast.LENGTH_SHORT)
                       .show();
               return false;
       }
       return super.onKeyDown(keyCode, event);
       // работае все плохо -- зависит от аппарата
   }

    public void onClick(View view) {
        // прячем клавиатуру. butCalculate - это кнопка  У меня заработала на клавиатуру
        // вызванную полем для заполнения, но не пинудительно
        Button butCalculate = findViewById(R.id.butCalculate);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(butCalculate.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void onClickOn(View view) {
        // принудительно показать клавиатуру работает и принудительно прячет
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

    }

    public void onDialog(View view) {
        DialogFragment dlg;
        dlg = new BlankFragment_java();
        //dlg.show(androidx.fragment.app.DialogFragment.getFragmentManager(), "dlg1");
        dlg.show(getSupportFragmentManager(),"dlg1");
    }

    public void onLang(View view) {
        //Откроем окно настроек клавиатур.


        Intent intent = new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS); // виртуальные клавиатуры
        //Intent intent = new Intent(Settings.ACTION_HARD_KEYBOARD_SETTINGS); // API 24: реальные клавиатуры
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

       //Определение языка клавиатуры : на 5,1,1 светит ZZ надо дописывать еще if
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        InputMethodSubtype ims = imm.getCurrentInputMethodSubtype();
        String localeString = ims.getLocale();
        Locale locale = new Locale(localeString);
        String currentLanguage = locale.getDisplayLanguage();
        EditText languageEditText = (EditText)findViewById(R.id.myView);
        Toast.makeText(getApplicationContext(), currentLanguage, Toast.LENGTH_SHORT).show();
    }
}
