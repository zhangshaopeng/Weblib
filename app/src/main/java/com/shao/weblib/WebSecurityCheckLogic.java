package com.shao.weblib;

import android.support.v4.util.ArrayMap;
import android.webkit.WebView;



public interface WebSecurityCheckLogic {
    void dealHoneyComb(WebView view);

    void dealJsInterface(ArrayMap<String, Object> objects, WebUtils.SecurityType securityType);

}
