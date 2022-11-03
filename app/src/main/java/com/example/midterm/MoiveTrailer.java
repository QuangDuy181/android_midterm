package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MoiveTrailer extends AppCompatActivity {

    WebView web;
    String trailerURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moive_trailer);

        web = findViewById(R.id.webview_trailer);
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web.setWebViewClient(new CallBack());
        getData();

    }

    private void getData(){
        if (getIntent().hasExtra("trailerURL")){
            trailerURL = getIntent().getStringExtra("trailerURL");
            web.loadUrl(trailerURL);
        }
        else{
            Toast.makeText(this, "No URL", Toast.LENGTH_SHORT).show();
        }
    }

    private class CallBack extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return false;
        }
    }
}