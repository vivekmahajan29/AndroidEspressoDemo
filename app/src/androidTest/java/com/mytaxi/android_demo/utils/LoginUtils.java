package com.mytaxi.android_demo.utils;

import android.util.Log;

import com.mytaxi.android_demo.R;

import static com.mytaxi.android_demo.utils.Constants.LOG_TAG;


public class LoginUtils {

    private LoginUtils() {}

    public static final long TIME_IN_MILLI_SECONDS = 5000;

    public static void login(String username, String password) {
        CustomMatchers.enterTextInView(R.id.edt_username, username);
        CustomMatchers.enterTextInView(R.id.edt_password, password);
        CustomMatchers.clickOnView(R.id.btn_login);
        GeneralUtils.waitFor(TIME_IN_MILLI_SECONDS);
    }

    public static void validateUserName(String username) {
        CustomMatchers.validateTextInView(R.id.nav_username, username);
    }

    public static void logoutIfAlreadyLoggedIn() {
        try {
            openNavigationBar();
            clickLogout();
        } catch (Exception ex) { Log.w(LOG_TAG, "Already logged out!"); }
    }

    public static void clickLogout() {
        CustomMatchers.clickOnView("Logout");
    }

    public static void openNavigationBar() {
        CustomMatchers.clickOnTopLeftActionBar(R.id.drawer_layout);
    }
}
