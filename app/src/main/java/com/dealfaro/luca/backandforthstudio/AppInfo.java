package com.dealfaro.luca.backandforthstudio;

import android.content.Context;

/**
 * Created by luca on 18/1/2016.
 */
public class AppInfo {

    private static AppInfo instance = null;

    protected AppInfo() {
        // Exists only to defeat instantiation.
    }

    // Here are some values we want to keep global.
    public String sharedString;

    public static AppInfo getInstance(Context context) {
        if(instance == null) {
            instance = new AppInfo();
            instance.sharedString = "";
        }
        return instance;
    }

}
