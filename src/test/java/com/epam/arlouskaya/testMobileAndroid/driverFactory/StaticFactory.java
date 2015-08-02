package com.epam.arlouskaya.testMobileAndroid.driverFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class StaticFactory {
	public static AndroidDriver getAndroidDriverFromResourse(String path) throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.1.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformVersion", "4.3");
        String userDir = System.getProperty("user.dir");

        URL serverAddress;
        String localApp = "api.apk";
        String appPath = Paths.get(userDir, localApp).toAbsolutePath().toString();
        capabilities.setCapability("app", appPath);
        serverAddress = new URL("http://127.0.0.1:4723/wd/hub");
		return new AndroidDriver (serverAddress, capabilities);
	}
}
