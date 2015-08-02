package com.epam.arlouskaya.testMobileAndroid;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

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
	private final String pathToDriverProp ="d:\\EPAM\\WorkSpace\\workspace2\\testMobileAndroid";
	
	@BeforeClass
	public void setUp() throws MalformedURLException{
		CommandLine command = new CommandLine("cmd");
		command.addArgument("/c");
		command.addArgument("C://Program Files (x86)//Appium//node.exe");
		command.addArgument("C://Program Files (x86)//Appium//node_modules//appium//bin//appium.js");
		command.addArgument("--address");
		command.addArgument("0.0.0.0");
		command.addArgument("--port");
		command.addArgument("4724");
		command.addArgument("--no-reset");
		command.addArgument("--log");
		command.addArgument("C://Users//...//log//appiumLogs.txt");
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(command, resultHandler);
		} catch (ExecuteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = StaticFactory.getAndroidDriverFromResourse(pathToDriverProp);
	}
	
	@Test
    public void testApp()
    {
        driver.findElement(By.xpath("//android.widget.TextView[@text='Accessibility']")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Accessibility']")).click();
    }
	
	@AfterClass
    public void tearDown() throws Exception {
        if (driver != null) driver.quit();
    }
}
