package com.epsit.dexapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.epsit.plugincore.BaseActivity;
import com.epsit.plugincore.PluginInterface;
import com.epsit.plugincore.PluginManager;

/**
 * 替身activity 用于瞒天过海 壳  加载到第三方插件apk中的activity
 */
public class ProxyActivity extends Activity {
    String TAG = "ProxyActivity";
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //拿到要启动的第三方插件的Activity的名字
        String className = getIntent().getStringExtra("className");
        try{
            Class<?> aClass = PluginManager.getInstance().getDexClassLoader().loadClass(className);
            Object newInstance = aClass.newInstance();

            //需要符合我们的标准才行
            if(newInstance instanceof PluginInterface){
                PluginInterface pluginInterface = (PluginInterface) newInstance;
                //将替身activity的实例或上下文传给第三方的activity
                pluginInterface.attach(this);
                Bundle bundle = new Bundle();//报错了所以注释了而换成了下面的这个
                //调用插件apk中的activity的onCreate方法
                pluginInterface.onCreate(bundle);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void startActivity(Intent intent){
        String className = intent.getStringExtra("className");
        Intent newIntent = new Intent(this, ProxyActivity.class);
        newIntent.putExtra("className", className);
        Log.e(TAG, "ProxyActivity =>startActivity(Intent intent) --马上要启动下自己了->className = "+className);
        super.startActivity(newIntent);
    }
}
