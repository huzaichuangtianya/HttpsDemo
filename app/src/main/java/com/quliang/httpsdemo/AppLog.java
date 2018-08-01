package com.quliang.httpsdemo;

import android.util.Log;

/**
 * @author quliang
 * @version 2015-8-20 上午11:28:11
 *          desc
 */
public class AppLog {
    private static String  LOG           = "Http";
    private static boolean switchSetting = true;

    // private static boolean switchSetting = false;

    public static void D(String s) {
        if (switchSetting)
            Log.i(LOG, s);
    }
}
