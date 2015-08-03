package com.epam.arlouskaya.testMobileAndroid;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import com.epam.arlouskaya.testMobileAndroid.pages.MainPage;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.arlouskaya.testMobileAndroid.driverFactory.StaticFactory;


/**
 * Unit test for simple App.
 */
public class AppTest 
    
{
	private WebDriver driver;
//	private final String pathToDriverProp ="d:\\EPAM\\WorkSpace\\workspace2\\testMobileAndroid";
	
	@BeforeClass
	public void setUp() throws MalformedURLException{
		System.out.println("driver being created...");
		CommandLine command = new CommandLine("cmd");
		command.addArgument("cmd");
		command.addArgument("/c");
		command.addArgument("D:\\Appium\\node.exe\\");
		command.addArgument("D:\\Appium\\node_modules\\appium\\bin\\Appium.js\\");
		command.addArgument("--address");
		command.addArgument("127.0.0.1");
		command.addArgument("--port");
		command.addArgument("4723");
		command.addArgument("--no-reset");
		command.addArgument("--log");
		command.addArgument("C:\\appiumLogs.txt\\");
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(command, resultHandler);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
      //  if (driver != null) driver.quit();
    }
}
