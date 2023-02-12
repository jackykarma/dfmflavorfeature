package com.jacky.android.app_aab;

import static com.jacky.android.app_aab.MainActivity.FlavorClassLoader.loadResId;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String flavorName = checkFlavor();
        checkDfmRes(flavorName);
        flavorAssetsLoad(flavorName);
        checkMetadataString();
        checkAllowBackup();
    }

    private void checkAllowBackup() {
        try {
            ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo(getPackageName(), 0);
            int allowBackup = applicationInfo.flags & ApplicationInfo.FLAG_ALLOW_BACKUP;
            // 11000011001000 1011111101000110 allowBackup为true
            // 11000011001000 0011111101000110 allowBackup为false
            //                1000000000000000
            Log.d(TAG, "checkAllowBackup:" + Integer.toBinaryString(applicationInfo.flags));
            // 1000000000000000
            Log.d(TAG, "checkAllowBackup:" + Integer.toBinaryString(ApplicationInfo.FLAG_ALLOW_BACKUP));
            Log.d(TAG, "checkAllowBackup: allowBackup:" + (allowBackup > 0));
            // TODO:代码动态设置该属性，应用初始化时设置。manifest中属性替换没有找到合适。
            applicationInfo.flags = applicationInfo.flags | ApplicationInfo.FLAG_ALLOW_BACKUP;
            int allowBackupUpdate = applicationInfo.flags & ApplicationInfo.FLAG_ALLOW_BACKUP;
            Log.d(TAG, "checkAllowBackup: newAllowBackup:" + (allowBackupUpdate > 0));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void checkDfmRes(String pluginName) {
        if (pluginName.isEmpty()) return;
        // TODO:layout测试通过
        int layoutId = loadResId(this, "layout_" + pluginName, "layout", pluginName);
        Log.d(TAG, "checkDfmRes: layoutId:" + layoutId);

        int rawId = loadResId(this, "raw", "raw", pluginName);
        Log.d(TAG, "checkDfmRes: rawId:" + rawId);

        int xmlId = loadResId(this, "widgets", "xml", pluginName);
        Log.d(TAG, "checkDfmRes: xmlId:" + xmlId);

        int stringId = loadResId(this, "app_key", "string", pluginName);
        Log.d(TAG, "checkDfmRes: stringId:" + stringId);
        Log.d(TAG, "checkDfmRes: app_key:" + getString(stringId));
    }

    private void flavorAssetsLoad(String pluginName) {
        AssetManager assetManager = getAssets();
        try {
            InputStream is = assetManager.open("config_" + pluginName + ".xml");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            while (bufferedReader.read() != -1) {
                String line = bufferedReader.readLine();
                Log.d(TAG, "flavorAssetsLoad: line:" + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "flavorAssetsLoad: exception:" + e.getLocalizedMessage());
        }
    }

    private void checkMetadataString() {
        try {
            ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
            String appKey = (String) applicationInfo.metaData.get("app_key");
            Log.d(TAG, "checkMetadataString: appKey:" + appKey);
            Object shortcuts = applicationInfo.metaData.get("android.app.shortcuts");
            Log.d(TAG, "checkMetadataString: shortcuts:" + shortcuts);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String checkFlavor() {
        IFlavorGetter flavorGetter = FlavorClassLoader.loadClass(this, "com.jacky.android.app_aab.featureflavors.FlavorImpl");
        if (flavorGetter != null) {
            Log.d(TAG, "checkFlavor: " + flavorGetter.getFlavor());
            return flavorGetter.getFlavor();
        }
        return null;
    }

    static class FlavorClassLoader {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        public static <T> T loadClass(Context context, String clsName) {
            try {
                Class<?> cls = context.getClassLoader().loadClass(clsName);
                return (T) cls.newInstance();
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static int loadResId(Context context, String resName, String resType, String pluginName) {
            String pkgName = context.getPackageName() + "." + pluginName;
            // TODO:这个理解是错误的
            // pkgName = "com.jacky.android.app_aab.featureflavors.domestic";
            Log.d(TAG, "loadResId: pkgName:" + pkgName);
            return context.getResources().getIdentifier(resName, resType, pkgName);
        }
    }
}