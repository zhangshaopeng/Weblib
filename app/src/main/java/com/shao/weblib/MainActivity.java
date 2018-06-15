package com.shao.weblib;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private WebUtils webUtils;

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
                //传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams
                .setAgentWebParent(mLinearLayout, new LinearLayout.LayoutParams(-1, -1))
                // 使用默认进度条
//                .useDefaultIndicator()
                // 使用默认进度条颜色
//                .defaultProgressBarColor()
                // 使用指定进度条颜色
//                .useDefaultIndicator(getResources().getColor(R.color.colorAccent))
                .useDefaultIndicator(getResources().getColor(R.color.colorAccent), 5)
//               .setReceivedTitleCallback(mCallback) //设置 Web 页面的 title 回调
                .creatWeb()
                .ready()
                .go("http://www.jd.com");


    }
}
