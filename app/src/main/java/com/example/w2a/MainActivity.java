package com.example.w2a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView wbV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wbV = findViewById(R.id.webV);
        WebSettings webSet = wbV.getSettings();
        webSet.setJavaScriptEnabled(true);
        //wbV.loadUrl("http://www.cultivares.com.mx/");
        wbV.loadUrl("http://ead02.maz.uasnet.mx/");
       // wbV.loadUrl("https://www.liverpool.com.mx");
        wbV.getSettings().setAppCacheEnabled(true);
        wbV.getSettings().setAppCachePath("/data/data" + getPackageName() + "/cache");
        wbV.getSettings().setSaveFormData(true);
        wbV.getSettings().setDatabaseEnabled(true);
        wbV.getSettings().setDomStorageEnabled(true);
        wbV.setWebViewClient( new WebViewClient());
        CookieManager.getInstance().acceptCookie();
    }

    @Override
    public void onBackPressed () {
        if (wbV.canGoBack()) {
            wbV.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
