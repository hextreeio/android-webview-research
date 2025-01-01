package io.hextree.webviews;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

import androidx.annotation.RequiresApi;
import androidx.webkit.WebViewAssetLoader;
import androidx.webkit.WebViewClientCompat;

public class LocalContentWebViewClient extends WebViewClientCompat {

    private final WebViewAssetLoader mAssetLoader;

    public LocalContentWebViewClient(WebViewAssetLoader assetLoader) {
        mAssetLoader = assetLoader;
    }

    @Override
    @RequiresApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView view,
                                                      WebResourceRequest request) {
        return mAssetLoader.shouldInterceptRequest(request.getUrl());
    }

    @Override
    @SuppressWarnings("deprecation") // To support API < 21.
    public WebResourceResponse shouldInterceptRequest(WebView view,
                                                      String url) {
        return mAssetLoader.shouldInterceptRequest(Uri.parse(url));
    }
}
