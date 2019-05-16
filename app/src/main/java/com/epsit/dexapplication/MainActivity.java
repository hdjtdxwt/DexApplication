package com.epsit.dexapplication;

import android.Manifest;
import android.content.Intent;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;

import com.epsit.plugincore.BaseActivity;
import com.epsit.plugincore.PluginManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String TAG = "app->MainActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.loadApk).setOnClickListener(this);
        findViewById(R.id.jumpActivity).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loadApk: //动态权限
                loadApk();
                break;
            case R.id.jumpActivity:
                jumpActivity();
                break;
        }
    }
    public void loadApk(){
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PluginManager.getInstance().setContext(MainActivity.this);
        Log.e(TAG,"有权限后执行loadPath操作-->");
        PluginManager.getInstance().loadPath(Environment.getExternalStorageDirectory().getAbsolutePath()+"/other.apk");

    }
    public void jumpActivity(){
        Intent intent = new Intent(this, ProxyActivity.class);
        intent.putExtra("className",PluginManager.getInstance().getEntryActivityName());
        startActivity(intent);
    }
}
