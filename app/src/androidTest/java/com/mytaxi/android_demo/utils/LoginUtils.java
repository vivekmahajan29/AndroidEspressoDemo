package com.mytaxi.android_demo.utils;

import android.nfc.Tag;
import android.os.SystemClock;
import android.support.test.espresso.contrib.DrawerActions;
import android.util.Log;
import android.view.Gravity;

import com.mytaxi.android_demo.R;

import java.io.IOException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.mytaxi.android_demo.misc.Constants.LOG_TAG;

public class LoginUtils {

    public static final long TIME_IN_MILLI_SECONDS = 5000;

    public static void login(String username, String password) {

        onView(withId(R.id.edt_username))
                .perform(typeText(username));

        onView(withId(R.id.edt_password))
                .perform(typeText(password));

        onView(withId(R.id.btn_login))
                .perform(click());

        GeneralUtils.waitFor(TIME_IN_MILLI_SECONDS);
    }

    public static void logout() {

        try {
            onView(withId(R.id.drawer_layout))
                    .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                    .perform(DrawerActions.open());

            onView(withText("Logout"))
                    .check(matches(isDisplayed()))
                    .perform(click());


        } catch (Exception ex) { Log.w(LOG_TAG, "Already logged out !"); }
    }
}
