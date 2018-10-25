package com.mytaxi.android_demo.utils;

import android.os.SystemClock;

public class GeneralUtils {

    private GeneralUtils() {}

    public static void waitFor(long timeInMilliSecond) {
        SystemClock.sleep(timeInMilliSecond);
    }
}
