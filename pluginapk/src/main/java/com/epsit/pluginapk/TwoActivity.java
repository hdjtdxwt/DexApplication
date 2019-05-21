package com.epsit.pluginapk;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.epsit.plugincore.BaseActivity;

public class TwoActivity extends BaseActivity implements View.OnClickListener {
    String TAG ="pluginapk-TwoActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        findViewById(R.id.tv).setOnClickListener(this);
    }
    public void onClick(View view){
        Log.e(TAG, "that != null  TwoActivity Toast.makeText");
        if(that==null){
            Toast.makeText(getApplicationContext(), "我被点击了", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(that, "我被点击了", Toast.LENGTH_SHORT).show();
        }

    }

}
