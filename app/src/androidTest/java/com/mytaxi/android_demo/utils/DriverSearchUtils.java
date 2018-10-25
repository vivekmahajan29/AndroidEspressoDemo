package com.mytaxi.android_demo.utils;

import android.app.Activity;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;

import com.mytaxi.android_demo.R;

import java.util.Collection;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

public class DriverSearchUtils {

    private static Activity currentActivity = null;

    public static void setCurrentActivity(Activity activity) {
        currentActivity = activity;
    }
    public static void searchDriver(String keyword, String name) {

        onView(withId(R.id.textSearch))
                .perform(typeText(keyword));

        onView(withText(name))
                .inRoot(withDecorView(not(is(currentActivity.getWindow().getDecorView()))))
                .check(matches(isDisplayed()))
                .perform(click());

    }
}
