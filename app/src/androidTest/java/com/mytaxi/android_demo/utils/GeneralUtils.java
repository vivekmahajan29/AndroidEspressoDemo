package com.mytaxi.android_demo.utils;

import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;

import com.bumptech.glide.load.model.ResourceLoader;
import com.mytaxi.android_demo.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class GeneralUtils {

    public static final String CONFIG_PROPERTIES = "Config.properties";
    public static Properties config;

    public static void waitFor(long timeInMilliSecond) {
        SystemClock.sleep(timeInMilliSecond);
    }

    private static void loadConfig() throws IOException {
        InputStream inputStream = InstrumentationRegistry.getInstrumentation()
                .getContext()
                .getResources()
                .getAssets()
                .open(CONFIG_PROPERTIES);

        if (inputStream != null) {
            config = new Properties();
            config.load(inputStream);
        }
        else
            throw new FileNotFoundException("Config file: " + CONFIG_PROPERTIES + " not found");
    }

    public static Properties getConfig() throws IOException {
        if (config == null)
            loadConfig();
        return config;
    }
}
