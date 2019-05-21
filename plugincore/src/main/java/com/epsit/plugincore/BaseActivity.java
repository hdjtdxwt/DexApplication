package com.epsit.plugincore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

public class BaseActivity extends AppCompatActivity implements PluginInterface {
    //主Apk的引用对象
    protected Activity that;
    String TAG ="BaseActivity";
    @Override
    public void attach(Activity pligunActivity) {
        this.that = pligunActivity;
    }

    @Override
    public void printAttachActivityInfo() {
        if(this.that!=null){
            Log.e("printAttachActivity","that="+that.getClass().getName());
        }else{
            Log.e("printAttachActivity","that is null" );
        }
    }

    @Override
    public void setContentView(View view) {
        if(that==null){
            super.setContentView(view);
        }else{
            that.setContentView(view);
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        if(that==null){
            Log.e(TAG,"setContentView  that is null");
            super.setContentView(layoutResID);
        }else {
            Log.e(TAG,"setContentView  that is not null");
            that.setContentView(layoutResID);
        }
    }

    @Override
    public <T extends View> T findViewById(int id) {
        if(that==null){
            return super.findViewById(id);
        }else{
            return that.findViewById(id);
        }

    }

    @Override
    public Intent getIntent() {
        if(that==null){
            return null;
        }
        return that.getIntent();
    }
    @Override
    public ClassLoader getClassLoader() {
        if(that==null){
            return super.getClassLoader();
        }
        return that.getClassLoader();
    }

    @NonNull
    @Override
    public LayoutInflater getLayoutInflater() {
        if(that==null){
            return super.getLayoutInflater();
        }
        return that.getLayoutInflater();
    }

    public void startActivity(Intent intent){
        if(that == null){
            super.startActivity(intent);
        }else{
            that.startActivity(intent);
        }

    }

    @Override
    public ApplicationInfo getApplicationInfo() {
        if(that==null){
            return super.getApplicationInfo();
        }else {
            return that.getApplicationInfo();
        }
    }

    @Override
    public Window getWindow() {
        if(that==null){
            return super.getWindow();
        }else {
            return that.getWindow();
        }
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
        if(that==null){
            super.onStart();
        }
    }

    @Override
    public void onResume() {
        if(that==null){
            super.onResume();
        }
    }

    @Override
    public void onPause() {
        if(that==null){
            super.onPause();
        }
    }

    @Override
    public void onStop() {
        if(that==null){
            super.onStop();
        }
    }

    @Override
    public void onDestroy() {
        if(that==null){
            super.onDestroy();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if(that==null){
            super.onSaveInstanceState(outState);
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        if(that ==null){
            Log.e(TAG,"onCreate(Bundle savedInstanceState)");
            super.onCreate(savedInstanceState);
        }else{
            //that.onCreate(savedInstanceState);//私有的方法
            Log.e("BaseActivity","onCreate(Bundle savedInstanceState) that对象不是空");
        }

    }
}
