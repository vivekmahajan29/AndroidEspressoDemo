package com.mytaxi.android_demo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.android_demo.utils.CustomMatchers;
import com.mytaxi.android_demo.utils.DriverProfileUtils;
import com.mytaxi.android_demo.utils.LoginUtils;
import com.mytaxi.android_demo.utils.DriverSearchUtils;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.mytaxi.android_demo.utils.Constants.PASSWORD;
import static com.mytaxi.android_demo.utils.Constants.USERNAME;


@RunWith(AndroidJUnit4.class)
public class SelectCabDriverJourneyInstrumentationTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule permissionRule = GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION);


    @Before
    public void setup() {

        CustomMatchers.setCurrentActivity(mActivityRule.getActivity());
        LoginUtils.logoutIfAlreadyLoggedIn();
        LoginUtils.login(USERNAME, PASSWORD);
        LoginUtils.openNavigationBar();
        LoginUtils.validateUserName(USERNAME);
        DriverSearchUtils.clickOnCoordinatesIcon();
    }


    @Test
    public void userShouldBeAbleToSearchSelectAndCallDriver() {

        DriverSearchUtils.searchDriverByKeyword("sa");
        DriverSearchUtils.selectDriver("Sarah Scott");

        DriverProfileUtils.validateDriverName("Sarah Scott");
        DriverProfileUtils.validateDriverLocation("6834 charles st");
        DriverProfileUtils.validateDriverDate("2002-10-18");

        DriverProfileUtils.clickPhone();

    }
}
