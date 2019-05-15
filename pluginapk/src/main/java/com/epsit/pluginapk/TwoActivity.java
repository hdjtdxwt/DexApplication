package com.epsit.pluginapk;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.epsit.plugincore.BaseActivity;

public class TwoActivity extends BaseActivity {
    String TAG ="pluginapk-TwoActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        /*if(thatActivity == null){
            Log.e(TAG, "that == null  findViewById(R.id.third_btn)");
            tv = findViewById(R.id.tv);
        }else{
            Log.e(TAG, "that != null  findViewById(R.id.third_btn)");
            tv = thatActivity.findViewById(R.id.tv);
        }

        tv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(thatActivity==null){
                    Log.e(TAG, "that == null  TwoActivity Toast.makeText");
                    Toast.makeText(getApplicationContext(), "我被点击了", Toast.LENGTH_SHORT).show();
                }else{
                    Log.e(TAG, "that != null  TwoActivity Toast.makeText");
                    Toast.makeText(thatActivity, "我被点击了", Toast.LENGTH_SHORT).show();
                }

            }
        });*/
    }
    public void onClick(View view){
        if(thatActivity==null){
            Log.e(TAG, "that == null  TwoActivity Toast.makeText");
            Toast.makeText(getApplicationContext(), "我被点击了", Toast.LENGTH_SHORT).show();
        }else{
            Log.e(TAG, "that != null  TwoActivity Toast.makeText");
            Toast.makeText(thatActivity, "我被点击了", Toast.LENGTH_SHORT).show();
        }
    }
}
