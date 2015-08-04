package com.epam.arlouskaya.testMobileAndroid.appiumServerFactory;

public abstract class ManageAppiumServer {
	
	abstract protected void getAppiumProperties();	
	abstract public void startServer();
	abstract public void stopServer();
}
