package com.epam.arlouskaya.testMobileAndroid;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.arlouskaya.testMobileAndroid.driverFactory.StaticFactory;

import io.appium.java_client.android.AndroidDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
    
{
	private AndroidDriver driver;
	private final String path ="";
	
	@BeforeClass
	public void setUp() throws MalformedURLException{
		driver = StaticFactory.getAndroidDriverFromResourse(path);
	}
	
	@Test
    public void testApp()
    {
        
    }
}
