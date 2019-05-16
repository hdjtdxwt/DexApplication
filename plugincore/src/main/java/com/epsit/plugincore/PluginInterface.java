package com.epsit.plugincore;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

/**
 * 所有外置apk中的app页面必须要实现这个接口，这个类是规范所有外置apk的activity的标准
 */
public interface PluginInterface {
    /**
     * 注入上下文
     * @param pligunActivity
     */
    void attach(Activity pligunActivity);
    void printAttachActivityInfo();
    void onCreate(Bundle savedInstanceState);
    void onStart();
    void onResume();
    void onPause();
    void onStop();
    void onDestroy();
    void onSaveInstanceState(Bundle outState);
    boolean onTouchEvent(MotionEvent event);
    void onBackPressed();

}

