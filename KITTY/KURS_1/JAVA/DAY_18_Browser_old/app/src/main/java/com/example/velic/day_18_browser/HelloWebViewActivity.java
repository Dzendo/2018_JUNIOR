package com.example.velic.day_18_browser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HelloWebViewActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.webView);
        // включаем поддержку JavaScript
        mWebView.getSettings().setJavaScriptEnabled(true);

        // Эта строчка нужна чтобы не открывался стандартный браузер
        mWebView.setWebViewClient(new MyWebViewClient());
        // указываем страницу загрузки
        mWebView.loadUrl("http://developer.alexanderklimov.ru/android");
    }
    // Эта строчка класса нужна чтобы не открывался стандартный браузер
    private class MyWebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            // Этот блок только чтобы открывать часть ссылок из инета а часть локальных
            if(Uri.parse(url).getHost().length() == 0) {
                return false;
            }     // с этим блоком начал вызывать опять Яндекс а было просто окно
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            view.getContext().startActivity(intent);

            // view.loadUrl(url); в принципе этого достаточно для инета без верха
            return true;
        }
    }
    // а это необходимо чтобы возвращаться назад по открытым сайтам иначе закроет
    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
