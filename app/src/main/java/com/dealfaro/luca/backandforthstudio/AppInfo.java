package com.dealfaro.luca.backandforthstudio;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by luca on 18/1/2016.
 */
public class AppInfo {

    private static AppInfo instance = null;
    private static final String COLOR_NAME = "color2";

    protected AppInfo() {
        // Exists only to defeat instantiation.
    }

    // Here are some values we want to keep global.
    public String sharedString;

    public static AppInfo getInstance(Context context) {
        if(instance == null) {
            instance = new AppInfo();
            SharedPreferences settings = context.getSharedPreferences(MainActivity.MYPREFS, 0);
            instance.sharedString = settings.getString(COLOR_NAME, null);
        }
        return instance;
    }

    public void setColor(Context context, String c) {
        instance.sharedString = c;
        SharedPreferences settings = context.getSharedPreferences(MainActivity.MYPREFS, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(COLOR_NAME, c);
        editor.commit();
    }

}
