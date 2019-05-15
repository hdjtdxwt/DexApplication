package com.epsit.plugincore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class BaseActivity extends Activity implements PluginInterface {
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
        if(that ==null){
            super.onCreate(savedInstanceState);
        }else{
            //that.onCreate(savedInstanceState);
            Log.e("BaseActivity","onCreate(Bundle savedInstanceState) that对象不是空");
        }

    }
}
