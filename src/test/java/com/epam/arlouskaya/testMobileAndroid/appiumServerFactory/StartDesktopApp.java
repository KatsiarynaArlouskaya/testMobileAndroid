package com.epam.arlouskaya.testMobileAndroid.appiumServerFactory;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.appium.support.server.arguments.AppiumCommonArgs;
import com.github.genium_framework.server.ServerArguments;

public class StartDesktopApp extends ManageAppiumServer{
	AppiumServer _appiumServer;
	@Override
	protected void getAppiumProperties() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startServer() { 
		ServerArguments serverArguments = new ServerArguments();
        serverArguments.setArgument("--address", "127.0.0.1");
        serverArguments.setArgument("--port", "4723");
        serverArguments.setArgument("--no-reset", true);
        serverArguments.setArgument("--local-timezone", true);
        serverArguments.setArgument(AppiumCommonArgs.LOG_TO_FILE, "\"c:/appiumLogs.txt/\"");
        _appiumServer = new AppiumServer(serverArguments);
        if (!_appiumServer.isServerRunning()){
        	startApp();
        }
        _appiumServer.startServer();	
	}

	private void startApp() {
  	 	CommandLine command = new CommandLine("cmd");
 	 	command.addArgument("/c");
 	 	command.addArgument("\"c:\\Program Files (x86)\\Appium\\appium.exe\"");
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(command, resultHandler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stopServer() {
		_appiumServer.stopServer();	
	}

}
