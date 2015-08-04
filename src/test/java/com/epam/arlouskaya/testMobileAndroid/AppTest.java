package com.epam.arlouskaya.testMobileAndroid;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import com.epam.arlouskaya.testMobileAndroid.pages.MainPage;
import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.appium.support.server.arguments.AppiumCommonArgs;
import com.github.genium_framework.server.ServerArguments;

import io.appium.java_client.android.AndroidDriver;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.arlouskaya.testMobileAndroid.appiumServerFactory.ManageAppiumServer;
import com.epam.arlouskaya.testMobileAndroid.appiumServerFactory.StartDesktopApp;
import com.epam.arlouskaya.testMobileAndroid.driverFactory.StaticFactory;


/**
 * Unit test for simple App.
 */
public class AppTest 
    
{
	private WebDriver driver;
//	private final String pathToDriverProp ="d:\\EPAM\\WorkSpace\\workspace2\\testMobileAndroid";
	ManageAppiumServer manageAppium;
	@BeforeClass
	public void setUp() throws MalformedURLException{
		manageAppium = new StartDesktopApp();
		manageAppium.startServer();
		File classpathRoot = new File(System.getProperty("user.dir"));
		String pathToDriverProp = classpathRoot.getAbsolutePath();
		driver = StaticFactory.getAndroidDriverFromResourse(pathToDriverProp);
	}
	
	@Test
    public void testApp()
    {
		MainPage mainPage = new MainPage((AndroidDriver) driver);
		mainPage.clickAccessibility();
		mainPage.clickAnimation();
		mainPage.clickApp();
		mainPage.clickContent();
    }
	
	@AfterClass
    public void tearDown() throws Exception {
      if (driver != null) driver.quit();
      manageAppium.stopServer();
    }
}
