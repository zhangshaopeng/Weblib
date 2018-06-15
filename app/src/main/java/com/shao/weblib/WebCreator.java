package com.shao.weblib;

import android.webkit.WebView;
import android.widget.FrameLayout;

public interface WebCreator extends IWebIndicator {
    WebCreator create();

    WebView getWebView();

    FrameLayout getWebParentLayout();
}
