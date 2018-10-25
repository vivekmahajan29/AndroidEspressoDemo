package com.mytaxi.android_demo.utils;

import com.mytaxi.android_demo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class DriverProfileUtils {

    public static void validateName(String name) {
        onView(withId(R.id.textViewDriverName))
                .check(matches(withText(name)));
    }

    public static void validateLocation(String location) {
        onView(withId(R.id.textViewDriverLocation))
                .check(matches(withText(location)));
    }

    public static void validateDate(String date) {
        onView(withId(R.id.textViewDriverDate))
                .check(matches(withText(date)));
    }

    public static void clickPhone() {
        onView(withId(R.id.fab))
                .perform(click());
    }
}
