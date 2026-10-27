package com.spckcreator.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        webView = new WebView(this);
        setContentView(webView);

        WebSettings s = webView.getSettings();
        s.setJavaScriptEnabled(true);          // само приложение и AI-функции
        s.setDomStorageEnabled(true);          // localStorage (проекты, ключ, чат)
        s.setAllowFileAccess(true);            // файл лежит в assets
        s.setMediaPlaybackRequiresUserGesture(false);

        // Ссылки и переходы остаются внутри приложения
        webView.setWebViewClient(new WebViewClient());

        // Логи console.* превью-приложения видны в logcat
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onConsoleMessage(ConsoleMessage msg) {
                android.util.Log.d("SpckApp", msg.message() + " (" + msg.lineNumber() + ")");
                return true;
            }
        });

        webView.loadUrl("file:///android_asset/www/index.html");
    }

    @Override
    public void onBackPressed() {
        // Сначала история назад внутри WebView, потом выход
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
