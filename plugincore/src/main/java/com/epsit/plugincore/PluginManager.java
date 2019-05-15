package com.epsit.plugincore;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * 插件Apk,需要加载类，加载第三方插件apk的资源
 */

public class PluginManager {

    //单例
    private static PluginManager pluginManager = new PluginManager();

    //插件Apk的资源对象
    private Resources resources;
    //插件apk中的包信息类
    private PackageInfo packageInfo;
    //类加载器，加载dex文件或者dex相关的文件（Apk,或library）；
    private DexClassLoader dexClassLoader;//ClassLoader的子类
    //上下文
    private Context context;
    private String entryActivityName;
    private PluginManager(){

    }

    public static PluginManager getInstance(){
        return pluginManager;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public DexClassLoader getDexClassLoader() {
        return dexClassLoader;
    }

    /**
     * 加载第三方的插件apk
     * @param path 第三方插件的路径
     */
    public void loadPath(String path)  {
        //获取当前应用的内部的私有存储路径(第一个参数是固定的)
        File dexOutFile = context.getDir("dex",Context.MODE_PRIVATE);
        //初始化类型加载器
        dexClassLoader = new DexClassLoader(path, dexOutFile.getAbsolutePath(),
                null, context.getClassLoader());

        //获取包管理器（区分不同应用的）
        PackageManager packageManager = context.getPackageManager();

        //通过包管理器获取插件dex中的包信息
        packageInfo = packageManager.getPackageArchiveInfo(path, PackageManager.GET_ACTIVITIES);
        //activity集合跟App-B的Manifest中注册的activity有关 顺序也有关
        entryActivityName = packageInfo.activities[1].name;
        for (int i=0;i<packageInfo.activities.length;i++){
            Log.e("PluginManager", packageInfo.activities[i].name);
        }
        //AssetManager, DisplayMinifiest,
       // resources = new Resources()
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssetPath = AssetManager.class.getMethod("addAssetPath", String.class);
            addAssetPath.invoke(assetManager, path);
            resources = new Resources(assetManager, context.getResources().getDisplayMetrics(),
                    context.getResources().getConfiguration()); //得到的就是第三方的插件的Resources
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public Resources getPluginResources() {
        return resources;
    }

    public String getEntryActivityName() {
        return entryActivityName;
    }
}
