package com.mytaxi.android_demo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.android_demo.utils.DriverProfile;
import com.mytaxi.android_demo.utils.Login;
import com.mytaxi.android_demo.utils.DriverSearch;


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
        DriverSearch.setCurrentActivity(mActivityRule.getActivity());
        Login.logout();
        Login.login("crazydog335","venture");
    }


    @Test
    public void userShouldBeAbleToSearchSelectAndCallDriver() {

        DriverSearch.searchDriver("sa", "Sarah Scott");
        DriverProfile.validateName("Sarah Scott");
        DriverProfile.validateLocation("6834 charles st");
        DriverProfile.validateDate("2002-10-18");
        DriverProfile.clickPhone();

    }
}
