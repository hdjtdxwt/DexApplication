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
        Log.e(TAG, "that == null  findViewById(R.id.third_btn)");
    }
    @Override
    public void onClick(View v) {
        if(thatActivity==null){
            Log.e(TAG, "that == null  Toast.makeText");
            Toast.makeText(getApplicationContext(), "我被点击了", Toast.LENGTH_SHORT).show();
        }else{
            Log.e(TAG, "that != null  Toast.makeText");
            Toast.makeText(thatActivity, "我被点击了", Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent(getApplicationContext(), TwoActivity.class);
        startActivity(intent);
    }
}
