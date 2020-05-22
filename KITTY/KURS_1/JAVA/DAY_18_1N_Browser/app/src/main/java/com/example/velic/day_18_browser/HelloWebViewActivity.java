package com.example.velic.day_18_browser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class HelloWebViewActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.webView);
        // включаем поддержку JavaScript
        mWebView.getSettings().setJavaScriptEnabled(true);

        // Эта строчка нужна чтобы не открывался стандартный браузер создаем собстенный
        mWebView.setWebViewClient(new MyWebViewClient());
        // указываем страницу загрузки и первая станица должна зашружаться в окно
        // но иногда сразу запрашивает в браузер (kitty)
        // если перейти по сслылке, то должен запросить браузер и открыться в нем
        // чтобы все время грузить в сое окно объявляем вложенный класс ниже и переопределение
        //mWebView.loadUrl("http://developer.alexanderklimov.ru/android/");
        //mWebView.loadUrl("https://developer.android.com/");
        mWebView.loadUrl("https://navalny.com/");
        //mWebView.loadUrl("http://brazuka.ru/");
        //mWebView.loadUrl("http://java-course.ru/begin/");
        //mWebView.loadUrl("https://metanit.com/"); // это вызов головной станицы в НАШЕ окно
        // дальше вызовы общаются или с MyWebViewClient из окна или уже с браузером без нас
    }

    @Override
    // а это необходимо чтобы возвращаться назад по открытым сайтам иначе закроет
    public void onBackPressed() {
        if (mWebView.canGoBack()) mWebView.goBack();
        else super.onBackPressed();
    }

    private class MyWebViewClient extends WebViewClient {
        // Чтобы не открывался стандартный браузер достатоно просто объявить этот класс пустой

            // Эта строчка класса нужна только чтобы часть открывать часть нет
            @Override // если не указывать @Override, то ВСЕ обрабатывается в НАШЕЙ странице
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                Toast.makeText(getApplicationContext(), "переход! \n"+url, Toast.LENGTH_LONG).show();
                  //  return false; если так на входе то все обрабатывается в НАШЕЙ станице

                if (url.contains("alexanderklimov")) {  // alexanderklimov открывать в НАШЕЙ станице
                    Toast.makeText(getApplicationContext(), "alexanderklimov! без браузера \n "+url, Toast.LENGTH_SHORT).show();
                    return false; // сообщает что давай обрабатывай ссылку в НАШУ станицу
               }

                if(Uri.parse(url).getHost().length() == 0) {
                    // локальные ссылки откроет в приложении, остальные в браузере
                    Toast.makeText(getApplicationContext(), "Локальная ссылка -> в НАШЕ окно", Toast.LENGTH_SHORT).show();
                    return false; // проверить не удалось
                }

                // если не сработали if выше , то:
                // этот блок зовет браузер для открытия страницы
                Toast.makeText(getApplicationContext(), "Зовем браузер", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                view.getContext().startActivity(intent);
                return true; // и говорит ничего уже грузить в НАШУ страницу не надо

             //  view.loadUrl(url); // эта строка открывает ссылку в этом же окне
             //  return true;    // и сообщает что все в порядке - ссылка обработана и ничего вызывать не надо
            }
    }
}

