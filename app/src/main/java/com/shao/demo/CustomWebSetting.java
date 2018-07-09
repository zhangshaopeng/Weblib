package com.shao.demo;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.shao.weblib.AbsAgentWebSettings;
import com.shao.weblib.IAgentWebSettings;


/**
 * Description: setting设置
 * Company:
 * Author:Zhangshaopeng
 * Email :1377785991@qq.com
 * Data:2018/7/9
 */
public class CustomWebSetting extends AbsAgentWebSettings {
    @Override
    public IAgentWebSettings toSetting(WebView webView) {
        super.toSetting(webView);
        getWebSettings().setUserAgentString("app " + "android " + getWebSettings().getUserAgentString());
        getWebSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        getWebSettings().setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWebSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        return this;
    }
}
