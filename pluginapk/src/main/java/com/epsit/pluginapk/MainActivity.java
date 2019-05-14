package com.epsit.pluginapk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.epsit.plugincore.BaseActivity;

public class MainActivity extends BaseActivity {
    String TAG ="pluginapk-MainActivity";
    Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(that == null){
            Log.e(TAG, "that == null  findViewById(R.id.third_btn)");
            button = findViewById(R.id.third_btn);
        }else{
            Log.e(TAG, "that != null  findViewById(R.id.third_btn)");
            button = that.findViewById(R.id.third_btn);
        }

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                /*if(that==null){
                    Log.e(TAG, "that == null  Toast.makeText");
                    Toast.makeText(getApplicationContext(), "我被点击了", Toast.LENGTH_SHORT).show();
                }else{
                    Log.e(TAG, "that != null  Toast.makeText");
                    Toast.makeText(that, "我被点击了", Toast.LENGTH_SHORT).show();
                }*/
                Intent intent = new Intent(getApplicationContext(), TwoActivity.class);
                startActivity(intent);
            }
        });
    }
}
