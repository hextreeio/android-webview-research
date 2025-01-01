package io.hextree.webviews.activities;

import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

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

public class WebViewsTestActivity extends AppCompatActivity {

    protected String currentUrl = null; // Default URL
    
    protected WebView webView = null;
    private String testCase = null;

    protected String getTestCase() {
        return testCase;
    }

    // settings toggle
    protected CheckBox checkWebContentsDebuggingEnabled,
            checkAllowContentAccess,
            checkJavaScriptEnabled, checkAllowFileAccessFromFileURLs,
            checkAllowFileAccess, checkAllowUniversalAccessFromFileURLs;
    protected Button buttonSettings, buttonSources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_web_view);

        testCase = getIntent().getStringExtra("TEST_CASE");
        currentUrl = "file:///android_asset/"+getTestCase();
        Log.i("WebViews", "WebViewsTestActivity: "+currentUrl);

        final WebViewAssetLoader assetLoader = new WebViewAssetLoader.Builder()
                .setDomain("example.com") // Replace this with your website's domain.
                .addPathHandler("/assets/", new WebViewAssetLoader.AssetsPathHandler(this))
                .build();

        buttonSettings = findViewById(R.id.button_settings);
        buttonSettings.setVisibility(View.VISIBLE);
        buttonSettings.setOnClickListener(view -> showSettingsOverlay());

        buttonSources = findViewById(R.id.button_sources);
        buttonSources.setVisibility(View.VISIBLE);
        buttonSources.setOnClickListener(view -> showSourcesOverlay());

        webView = findViewById(R.id.big_webview);

        WebViewClient c = new LocalContentWebViewClient(assetLoader);
        webView.setWebViewClient(c);
        //webView.setWebViewClient(new WebViewClient());

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);

        webView.getSettings().setAllowFileAccess(getIntent().getBooleanExtra("FILE_ACCESS", false));
        webView.getSettings().setAllowFileAccessFromFileURLs(getIntent().getBooleanExtra("FILE_URI_ACCESS", false));
        webView.getSettings().setAllowUniversalAccessFromFileURLs(getIntent().getBooleanExtra("FILE_UNIVERSAL_ACCESS", false));

        loadNewURL(currentUrl);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void loadNewURL(String url) {
        currentUrl = url;
        webView.loadUrl(url);
    }

    private void settingsChanged() {
        WebSettings settings = webView.getSettings();

        settings.setAllowContentAccess(checkAllowContentAccess.isChecked());
        WebView.setWebContentsDebuggingEnabled(checkWebContentsDebuggingEnabled.isChecked());
        settings.setJavaScriptEnabled(checkJavaScriptEnabled.isChecked());
        settings.setAllowFileAccess(checkAllowFileAccess.isChecked());
        settings.setAllowFileAccessFromFileURLs(checkAllowFileAccessFromFileURLs.isChecked());
        settings.setAllowUniversalAccessFromFileURLs(checkAllowUniversalAccessFromFileURLs.isChecked());

        // Reload the current URL with the new settingsq
        loadNewURL(currentUrl);
    }

    private void showSettingsOverlay() {
        View view = getLayoutInflater().inflate(R.layout.settings_overlay, null);
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.setContentView(view);

        // Initialize checkboxes
        checkAllowContentAccess = view.findViewById(R.id.check_setAllowContentAccess);
        checkJavaScriptEnabled = view.findViewById(R.id.check_setJavaScriptEnabled);
        checkAllowFileAccessFromFileURLs = view.findViewById(R.id.check_setAllowFileAccessFromFileURLs);
        checkAllowFileAccess = view.findViewById(R.id.check_setAllowFileAccess);
        checkAllowUniversalAccessFromFileURLs = view.findViewById(R.id.check_setAllowUniversalAccessFromFileURLs);
        if(checkWebContentsDebuggingEnabled == null) {
            checkWebContentsDebuggingEnabled = view.findViewById(R.id.check_setWebContentsDebuggingEnabled);
            checkWebContentsDebuggingEnabled.setChecked((getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0 );
        } else {
            checkWebContentsDebuggingEnabled = view.findViewById(R.id.check_setWebContentsDebuggingEnabled);
        }

        WebSettings settings = webView.getSettings();
        checkAllowContentAccess.setChecked(settings.getAllowContentAccess());
        checkJavaScriptEnabled.setChecked(settings.getJavaScriptEnabled());
        checkAllowFileAccessFromFileURLs.setChecked(settings.getAllowFileAccessFromFileURLs());
        checkAllowFileAccess.setChecked(settings.getAllowFileAccess());
        // cannot get the web contents debugging state
        //checkWebContentsDebuggingEnabled.setChecked(WebView.setWebContentsDebuggingEnabled());
        checkAllowUniversalAccessFromFileURLs.setChecked(settings.getAllowUniversalAccessFromFileURLs());

        Button buttonClose = view.findViewById(R.id.button_close_settings);
        buttonClose.setOnClickListener(v -> dialog.dismiss());

        // Set listeners for checkboxes
        CompoundButton.OnCheckedChangeListener listener = (buttonView, isChecked) -> settingsChanged();
        checkAllowContentAccess.setOnCheckedChangeListener(listener);
        checkJavaScriptEnabled.setOnCheckedChangeListener(listener);
        checkAllowFileAccessFromFileURLs.setOnCheckedChangeListener(listener);
        checkAllowFileAccess.setOnCheckedChangeListener(listener);
        checkAllowUniversalAccessFromFileURLs.setOnCheckedChangeListener(listener);
        checkWebContentsDebuggingEnabled.setOnCheckedChangeListener(listener);

        dialog.show();
    }

    private void showSourcesOverlay() {
        View view = getLayoutInflater().inflate(R.layout.sources_overlay, null);
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.setContentView(view);

        // Initialize your buttons inside the overlay
        String webview_btn1 = "https://oak.hackstree.io/android/webview/"+getTestCase();
        ((Button) view.findViewById(R.id.webview_btn1)).setText(webview_btn1);
        ((Button) view.findViewById(R.id.webview_btn1)).setOnClickListener(v -> loadNewURL(webview_btn1));

        String webview_btn2 = "file:///android_asset/"+getTestCase();
        ((Button) view.findViewById(R.id.webview_btn2)).setText(webview_btn2);
        ((Button) view.findViewById(R.id.webview_btn2)).setOnClickListener(v -> loadNewURL(webview_btn2));

        InputStream inputStream = null;
        try {
            inputStream = getAssets().open(getTestCase());
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line+"\n");
            }
            reader.close();

            String webview_btn3 = "data:text/html;base64,"+ Base64.getEncoder().encodeToString(builder.toString().getBytes());
            ((Button) view.findViewById(R.id.webview_btn3)).setText(webview_btn3);
            ((Button) view.findViewById(R.id.webview_btn3)).setOnClickListener(v -> {
                loadNewURL(webview_btn3);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        String webview_btn4 = FileProvider.getUriForFile(getApplicationContext(), "io.hextree.webprovider", new File(getFilesDir(), getTestCase())).toString();
        //String webview_btn4 = "content://io.hextree.webview/internal/origins.html";
        ((Button) view.findViewById(R.id.webview_btn4)).setText(webview_btn4);
        ((Button) view.findViewById(R.id.webview_btn4)).setOnClickListener(v -> {
            loadNewURL(webview_btn4);
        });

        String webview_btn5 = "file:///data/data/"+getApplication().getPackageName()+"/files/"+getTestCase();
        ((Button) view.findViewById(R.id.webview_btn5)).setText(webview_btn5);
        ((Button) view.findViewById(R.id.webview_btn5)).setOnClickListener(v -> {
            loadNewURL(webview_btn5);
        });

        String webview_btn6 = "file://"+getApplicationInfo().nativeLibraryDir+"/"+getTestCase();
        ((Button) view.findViewById(R.id.webview_btn6)).setText(webview_btn6);
        ((Button) view.findViewById(R.id.webview_btn6)).setOnClickListener(v -> {
            loadNewURL(webview_btn6);
        });

        dialog.show();
    }
}
