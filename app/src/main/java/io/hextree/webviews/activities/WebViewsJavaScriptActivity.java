package io.hextree.webviews.activities;

import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.webkit.WebViewAssetLoader;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Base64;

import io.hextree.webviews.LocalContentWebViewClient;
import io.hextree.webviews.R;

public class WebViewsJavaScriptActivity extends AppCompatActivity {

    protected WebView webView = null;

    class JsObject {
        @JavascriptInterface
        public String toString() { return "injectedObject"; }

        @JavascriptInterface
        public String callMe() {
            Toast.makeText(WebViewsJavaScriptActivity.this, "called from WebView", Toast.LENGTH_SHORT).show();
            return "string returned from Java";
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_web_view);

        Button buttonSettings = findViewById(R.id.button_settings);
        buttonSettings.setVisibility(View.GONE);

        Button buttonSources = findViewById(R.id.button_sources);
        buttonSources.setVisibility(View.GONE);

        webView = findViewById(R.id.big_webview);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);

        webView.getSettings().setAllowFileAccess(false);
        webView.getSettings().setAllowFileAccessFromFileURLs(false);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(false);

        webView.addJavascriptInterface(new JsObject(), "injectedObject");

        webView.loadUrl("file:///android_asset/intent.html");
        //webView.loadData("html", "text/html", null);
        findViewById(R.id.logo).setOnClickListener(view -> {
            webView.loadUrl("javascript:document.write(injectedObject.toString())");
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}
