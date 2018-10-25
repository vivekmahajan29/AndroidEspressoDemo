package com.mytaxi.android_demo.utils;

import com.mytaxi.android_demo.R;

public class DriverProfileUtils {

    private DriverProfileUtils() {}

    public static void validateDriverName(String name) {
        CustomMatchers.validateTextInView(R.id.textViewDriverName, name);
    }

    public static void validateDriverLocation(String location) {
        CustomMatchers.validateTextInView(R.id.textViewDriverLocation, location);
    }

    public static void validateDriverDate(String date) {
        CustomMatchers.validateTextInView(R.id.textViewDriverDate, date);
    }

    public static void clickPhone() {
        CustomMatchers.clickOnView(R.id.fab);
    }
}
