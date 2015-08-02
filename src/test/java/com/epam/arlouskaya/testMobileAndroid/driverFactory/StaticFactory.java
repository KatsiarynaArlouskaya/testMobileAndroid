package com.epam.arlouskaya.testMobileAndroid.driverFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class StaticFactory {
	public static AndroidDriver getAndroidDriverFromResourse(String path) throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		File file = new File(path);
		URL[] urls = {file.toURI().toURL()};
		ClassLoader loader = new URLClassLoader(urls);
		ResourceBundle bundle = ResourceBundle.getBundle("driver", Locale.getDefault(), loader);
		//ResourceBundle bundle = ResourceBundle.getBundle("driver");
		Set<String> keys = bundle.keySet();
		for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			capabilities.setCapability(key, bundle.getString(key));
		}
        URL serverAddress = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver (serverAddress, capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
}
