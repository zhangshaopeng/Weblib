package com.shao.demo;

import android.webkit.JavascriptInterface;

/**
 * Description:js 交互类
 * Company:
 * Author:Zhangshaopeng
 * Email :1377785991@qq.com
 * Data:2018/7/9
 */
public class JSInterface {
    private BaseWebViewActivity activity;

    public JSInterface(BaseWebViewActivity activity) {
        this.activity = activity;
    }

    @JavascriptInterface
    public void jsAdd() {
        // TODO: js交互方法
        activity.add();
    }
}
