package com.example.day_18_2_browser_default_k

import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val url = intent.data
        webView.webViewClient = Callback()
        webView.loadUrl(url!!.toString())
    }

    private inner class Callback : WebViewClient() {
        override fun shouldOverrideUrlLoading(view : WebView ,request : WebResourceRequest): Boolean {
            return false
        }
    }
}
