package com.mytaxi.android_demo.utils;

import com.mytaxi.android_demo.R;

public class DriverSearchUtils {

    private DriverSearchUtils() {}

    public static void searchDriverByKeyword(String keyword) {
        CustomMatchers.enterTextInView(R.id.textSearch, keyword);
    }

    public static void selectDriver(String name) {
        CustomMatchers.selectOptionInAutoSelectViewOptionsList(name);
    }

    public static void clickOnCoordinatesIcon() {
        CustomMatchers.clickOnView(R.id.fab);
    }
}
