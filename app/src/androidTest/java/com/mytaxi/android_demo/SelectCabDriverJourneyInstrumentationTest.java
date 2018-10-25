package com.mytaxi.android_demo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.android_demo.utils.DriverProfileUtils;
import com.mytaxi.android_demo.utils.LoginUtils;
import com.mytaxi.android_demo.utils.DriverSearchUtils;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class SelectCabDriverJourneyInstrumentationTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule permissionRule = GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION);


    @Before
    public void setup() {
        DriverSearchUtils.setCurrentActivity(mActivityRule.getActivity());
        LoginUtils.logout();
        LoginUtils.login("crazydog335","venture");
    }


    @Test
    public void userShouldBeAbleToSearchSelectAndCallDriver() {

        DriverSearchUtils.searchDriver("sa", "Sarah Scott");
        DriverProfileUtils.validateName("Sarah Scott");
        DriverProfileUtils.validateLocation("6834 charles st");
        DriverProfileUtils.validateDate("2002-10-18");
        DriverProfileUtils.clickPhone();

    }
}
