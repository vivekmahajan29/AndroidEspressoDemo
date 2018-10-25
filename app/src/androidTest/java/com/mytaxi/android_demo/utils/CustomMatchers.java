package com.mytaxi.android_demo.utils;

import android.app.Activity;
import android.support.test.espresso.contrib.DrawerActions;
import android.view.Gravity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

public class CustomMatchers {

    private static Activity currentActivity = null;

    public static void enterTextInView(int id, String text) {
        onView(withId(id))
                .perform(typeText(text));
    }

    public static void clickOnView(int id) {
        onView(withId(id))
                .perform(click());
    }

    public static void validateTextInView(int id, String text) {
        onView(withId(id))
                .check(matches(withText(text)));
    }

    public static void clickOnView(String text) {
        onView(withText(text))
                .perform(click());
    }

    public static void clickOnTopLeftActionBar(int id) {
        onView(withId(id))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open());
    }

    public static void setCurrentActivity(Activity activity) {
        currentActivity = activity;
    }

    public static void selectOptionInAutoSelectViewOptionsList(String name) {
        onView(withText(name))
                .inRoot(withDecorView(not(is(currentActivity.getWindow().getDecorView()))))
                .check(matches(isDisplayed()))
                .perform(click());
    }
}
