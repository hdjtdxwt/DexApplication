package com.epsit.plugincore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

public class BaseActivity extends Activity implements PluginInterface {
    public  static  final  String TAG="BaseActivity";
    protected Activity thatActivity;

    /**
     * 注入自己的上下文
     * 如果为空 使用父类
     *
     * @param layoutResID
     */
    @Override
    public void setContentView(int layoutResID) {
        if (thatActivity == null) {
            super.setContentView(layoutResID);
        } else {
            thatActivity.setContentView(layoutResID);
        }
    }

    @Override
    public void setContentView(View view) {
        if (thatActivity == null) {
            super.setContentView(view);
        } else {
            thatActivity.setContentView(view);
        }
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        if (thatActivity == null) {
            super.setContentView(view, params);
        } else {
            thatActivity.setContentView(view, params);
        }
    }

    @Override
    public LayoutInflater getLayoutInflater() {
        if (thatActivity == null) {
            return super.getLayoutInflater();
        } else {
            return thatActivity.getLayoutInflater();
        }
    }

    @Override
    public Window getWindow() {
        if (thatActivity == null) {
            return super.getWindow();
        } else {
            return thatActivity.getWindow();
        }
    }

    @Override
    public View findViewById(int id) {
        if (thatActivity == null) {
            return super.findViewById(id);
        } else {
            return findViewById(id);
        }
    }


    @Override
    public ClassLoader getClassLoader() {
        if (thatActivity == null) {
            return super.getClassLoader();
        } else {
            return getClassLoader();
        }

    }

    @Override
    public WindowManager getWindowManager() {
        if (thatActivity == null) {
            return super.getWindowManager();
        } else {
            return thatActivity.getWindowManager();
        }
    }


    @Override
    public ApplicationInfo getApplicationInfo() {
        if (thatActivity == null) {
            return super.getApplicationInfo();
        } else {
            return thatActivity.getApplicationInfo();
        }
    }

    @Override
    public void attach(Activity pligunActivity) {
        thatActivity = pligunActivity;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void onStart() {
        super.onStart();
    }
    public void onResume() {
        super.onResume();
    }
    public void onRestart() {
        super.onRestart();
    }
    public void onPause() {
        super.onPause();
    }
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void onSaveInstanceState(Bundle outState) { }

    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    public void onBackPressed() {
        if (thatActivity == null) {
            super.onBackPressed();
        } else {
            thatActivity.onBackPressed();
        }
    }

    @Override
    public void finish() {
        if (thatActivity == null) {
            super.finish();
        } else {
            thatActivity.finish();
        }
    }

    /**
     * 注意上下文对象 thatActivity
     * @param intent
     */
    @Override
    public void startActivity(Intent intent) {
        if (thatActivity == null) {
            super.startActivity(intent);
        } else {
            intent.putExtra("className", intent.getComponent().getClassName());
            thatActivity.startActivity(intent);
        }
    }

}
/*public class BaseActivity extends Activity implements PluginInterface {
    //主Apk的引用对象
    protected Activity that;

    @Override
    public void attach(Activity pligunActivity) {
        this.that = pligunActivity;
    }


    @Override
    public void setContentView(View view) {
        if(that == null){
            super.setContentView(view);
        }else{
            that.setContentView(view);
        }
    }

    public void setContentView(int layoutId){
        if(that == null){
            super.setContentView(layoutId);
        }else{
            that.setContentView(layoutId);
        }
    }

    public Context getApplicationContext(){
        if(that == null){
            return super.getApplicationContext();
        }else{
            return that.getApplicationContext();
        }
    }
    public <T extends View> T findViewById(int id){
        if(that == null){
            return super.findViewById(id);
        }else{
            return that.findViewById(id);
        }

    }
    public Intent getIntent(){
        if(that == null){
            return super.getIntent();
        }else{
            return that.getIntent();
        }
    }

    @Override
    public ClassLoader getClassLoader() {
        if(that == null){
            return super.getClassLoader();
        }else{
            return that.getClassLoader();
        }
    }

    @NonNull
    @Override
    public LayoutInflater getLayoutInflater() {
        if(that == null){
            return super.getLayoutInflater();
        }else{
            return that.getLayoutInflater();
        }
    }


    public void startActivity(Intent intent){
        if(that == null){
            super.startActivity(intent);
        }else {
            that.startActivity(intent);
        }
    }

    @Override
    public ApplicationInfo getApplicationInfo() {
        if(that == null){
            return super.getApplicationInfo();
        }
        return that.getApplicationInfo();
    }

    @Override
    public Window getWindow() {
        if(that ==null){
            return super.getWindow();
        }
        return that.getWindow();
    }

    @Override
    public WindowManager getWindowManager() {
        if(that ==null){
            return super.getWindowManager();
        }
        return that.getWindowManager();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestory() {
        //super.onDestory();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}*/
