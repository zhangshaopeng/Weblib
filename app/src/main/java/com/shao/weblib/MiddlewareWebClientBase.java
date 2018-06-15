package com.shao.weblib;

import android.webkit.WebViewClient;


public class MiddlewareWebClientBase extends WebViewClientDelegate {
    private MiddlewareWebClientBase mMiddleWrareWebClientBase;
    private String TAG = this.getClass().getSimpleName();

    MiddlewareWebClientBase(MiddlewareWebClientBase client) {
        super(client);
        this.mMiddleWrareWebClientBase = client;
    }

    protected MiddlewareWebClientBase(WebViewClient client) {
        super(client);
    }

    protected MiddlewareWebClientBase() {
        super(null);
    }

    final MiddlewareWebClientBase next() {
        return this.mMiddleWrareWebClientBase;
    }


    @Override
    final void setDelegate(WebViewClient delegate) {
        super.setDelegate(delegate);

    }

    final MiddlewareWebClientBase enq(MiddlewareWebClientBase middleWrareWebClientBase) {
        setDelegate(middleWrareWebClientBase);
        this.mMiddleWrareWebClientBase = middleWrareWebClientBase;
        return middleWrareWebClientBase;
    }


}
