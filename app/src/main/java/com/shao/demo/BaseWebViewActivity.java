package com.shao.demo;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.shao.weblib.R;
import com.shao.weblib.WebUtils;

/**
 * Description:可做BaseWebView
 * Company:
 * Author:Zhangshaopeng
 * Email :1377785991@qq.com
 * Data:2018/7/9
 */
public class BaseWebViewActivity extends AppCompatActivity {

    private WebUtils webUtils;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_main);
        LinearLayout mLinearLayout = findViewById(R.id.ll);

/**
 *      传入Activity
 *      传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams
 *      useDefaultIndicator()// 使用默认进度条
 *      使用默认进度条颜色
 *      .setReceivedTitleCallback(mCallback) //设置 Web 页面的 title 回调
 */
        webUtils = WebUtils.with(this)
                .setAgentWebParent(mLinearLayout, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .setAgentWebWebSettings(new CustomWebSetting())
                .setWebChromeClient(mWebChromeClient)
                .setWebViewClient(mWebViewClient)
                .setSecurityType(WebUtils.SecurityType.STRICT_CHECK)
                //  .setMainFrameErrorView()//错误页面设置
                .additionalHttpHeader("token", "this is my token , please not forget")
                .creatWeb()
                .ready()
                .go("http://www.jd.com");
        webView = webUtils.getWebCreator().getWebView();
        webUtils.getJsInterfaceHolder().addJavaObject("JSInterface", new JSInterface(this));//JS交互

    }

    private WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            //do you  work
        }
    };
    private WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            //do you work
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (webUtils.handleKeyEvent(keyCode, event)) {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                    webView.goBack();
                }
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        webUtils.getWebLifeCycle().onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        webUtils.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        webUtils.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }

    // js交互
    public void add() {
    }
}
