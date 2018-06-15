package com.shao.weblib;

import android.webkit.ValueCallback;


public interface JsAccessEntrace extends QuickCallJs {


    void callJs(String js, ValueCallback<String> callback);

    void callJs(String js);


}
