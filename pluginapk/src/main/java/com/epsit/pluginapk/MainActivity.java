package com.epsit.pluginapk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.epsit.plugincore.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    String TAG ="pluginapk-MainActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.third_btn).setOnClickListener(this);
        Log.e(TAG, "that == null  findViewById(R.id.third_btn)");
    }
    @Override
    public void onClick(View v) {
        Log.e(TAG, "that != null  Toast.makeText");
        Toast.makeText(that, "我被点击了", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(that, TwoActivity.class);
        intent.putExtra("className", "com.epsit.pluginapk.TwoActivity");
        startActivity(intent);
    }
}
