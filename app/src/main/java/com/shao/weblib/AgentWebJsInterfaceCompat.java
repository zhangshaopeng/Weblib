package com.shao.weblib;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.webkit.JavascriptInterface;

import java.lang.ref.WeakReference;


public class AgentWebJsInterfaceCompat {

	private WeakReference<WebUtils> mReference = null;
	private WeakReference<Activity> mActivityWeakReference = null;
	private String TAG = this.getClass().getSimpleName();

	AgentWebJsInterfaceCompat(WebUtils agentWeb, Activity activity) {
		mReference = new WeakReference<WebUtils>(agentWeb);
		mActivityWeakReference = new WeakReference<Activity>(activity);
	}


	@JavascriptInterface
	public void uploadFile() {
		uploadFile("*/*");
	}

	@JavascriptInterface
	public void uploadFile(String acceptType) {
		LogUtils.i(TAG, acceptType + "  " + mActivityWeakReference.get() + "  " + mReference.get());
		if (mActivityWeakReference.get() != null && mReference.get() != null) {

			AgentWebUtils.showFileChooserCompat(mActivityWeakReference.get(),
					mReference.get().getWebCreator().getWebView(),
					null,
					null,
					mReference.get().getPermissionInterceptor(),
					null,
					acceptType,
					new Handler.Callback() {
						@Override
						public boolean handleMessage(Message msg) {
							if (mReference.get() != null) {
								mReference.get().getJsAccessEntrace()
										.quickCallJs("uploadFileResult",
												msg.obj instanceof String ? (String) msg.obj : null);
							}
							return true;
						}
					}
			);


		}
	}

}
