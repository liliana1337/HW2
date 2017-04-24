package com.dealfaro.luca.backandforthstudio;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by luca on 18/1/2016.
 */
public class AppInfo {

    private static AppInfo instance = null;
    private static final String STRING1 = "s1";
    private static final String STRING2 = "s2";
    private static final String STRING3 = "s3";

    protected AppInfo() {
        // Exists only to defeat instantiation.
    }

    // Here are some values we want to keep global.
    public String sharedString1;
    public String sharedString2;
    public String sharedString3;

    private Context my_context;

    public static AppInfo getInstance(Context context) {
        if(instance == null) {
            instance = new AppInfo();
            instance.my_context = context;
           SharedPreferences settings = context.getSharedPreferences(MainActivity.MYPREFS, 0);
            instance.sharedString1 = settings.getString(STRING1, null);
            instance.sharedString2 = settings.getString(STRING2, null);
            instance.sharedString3 = settings.getString(STRING3, null);
        }
        return instance;
    }

    public void setMyText(String c, int x) {

        SharedPreferences settings = my_context.getSharedPreferences(MainActivity.MYPREFS, 0);
        SharedPreferences.Editor editor = settings.edit();
        switch(x){
            case 1: instance.sharedString1 = c;
                    editor.putString(STRING1, c);
                    break;
            case 2: instance.sharedString2 = c;
                    editor.putString(STRING2, c);
                    break;
            case 3: instance.sharedString3 = c;
                editor.putString(STRING3, c);
                break;
        }

        editor.commit();
    }


}
