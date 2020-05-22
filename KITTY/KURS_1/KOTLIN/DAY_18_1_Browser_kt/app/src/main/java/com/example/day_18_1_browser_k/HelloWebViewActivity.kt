package com.example.day_18_1_browser_k

import android.content.Intent
import android.net.Uri.*
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.webView

class HelloWebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // включаем поддержку JavaScript
        webView.settings.javaScriptEnabled = true

        // Эта строчка нужна чтобы не открывался стандартный браузер создаем собстенный
        webView.webViewClient = MyWebViewClient()
        // указываем страницу загрузки и первая станица должна зашружаться в окно
        // но иногда сразу запрашивает в браузер (kitty)
        // если перейти по сслылке, то должен запросить браузер и открыться в нем
        // чтобы все время грузить в сое окно объявляем вложенный класс ниже и переопределение
        //webView.loadUrl("http://developer.alexanderklimov.ru/android/");
        //webView.loadUrl("https://developer.android.com/");
        webView.loadUrl("http://java-course.ru/begin/")
        //webView.loadUrl("https://metanit.com/"); // это вызов головной станицы в НАШЕ окно
        // дальше вызовы общаются или с MyWebViewClient из окна или уже с браузером без нас
    }

    // а это необходимо чтобы возвращаться назад по открытым сайтам иначе закроет
    override fun onBackPressed() {
        if (webView.canGoBack())
            webView.goBack()
        else
            super.onBackPressed()
    }

    private inner class MyWebViewClient : WebViewClient() {
        // Чтобы не открывался стандартный браузер достатоно просто объявить этот класс пустой

        // Эта строчка класса нужна только чтобы часть открывать часть нет
        // если не указывать @Override, то ВСЕ обрабатывается в НАШЕЙ странице
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {

            Toast.makeText(applicationContext, "переход! \n$url", Toast.LENGTH_LONG).show()
            //  return false  // если так на входе то все обрабатывается в НАШЕЙ станице

            if (url.contains("alexanderklimov")) {  // alexanderklimov открывать в НАШЕЙ станице
                Toast.makeText(applicationContext, "alexanderklimov! без браузера \n $url", Toast.LENGTH_SHORT).show()
                return false // сообщает что давай обрабатывай ссылку в НАШУ станицу
            }

            if (parse(url).host!!.isEmpty()) {
                // локальные ссылки откроет в приложении, остальные в браузере
                Toast.makeText(applicationContext, "Локальная ссылка -> в НАШЕ окно", Toast.LENGTH_SHORT).show()
                return false // проверить не удалось
            }

            // если не сработали if выше , то:
            // этот блок зовет браузер для открытия страницы
            Toast.makeText(applicationContext, "Зовем браузер", Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_VIEW, parse(url))
            view.context.startActivity(intent)
            return true // и говорит ничего уже грузить в НАШУ страницу не надо

            //  view.loadUrl(url) // эта строка открывает ссылку в этом же окне
            //  return true    // и сообщает что все в порядке - ссылка обработана и ничего вызывать не надо
        }
    }
}

