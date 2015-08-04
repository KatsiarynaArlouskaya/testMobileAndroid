package com.epam.arlouskaya.testMobileAndroid.appiumServerFactory;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;

import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.appium.support.server.arguments.AppiumCommonArgs;
import com.github.genium_framework.server.ServerArguments;

public class StartFromNode extends ManageAppiumServer{

	@Override
	protected void getAppiumProperties() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startServer() {
		//not work :(
		CommandLine command = new CommandLine("cmd");
		command = new CommandLine("cmd");
		command.addArgument("/c", false);
	 	command.addArgument("appium", false);
	  	command.addArgument("--address", false);
	 	command.addArgument("127.0.0.1", false);
	 	command.addArgument("--port", false);
	 	command.addArgument("4723", false);
	 	command.addArgument("--log");
	 	command.addArgument("\"c:/appiumLogs.txt/\""); 
	 	DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(command, resultHandler);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public void stopServer() {
		CommandLine command = new CommandLine("cmd");
		command.addArgument("/c");
		command.addArgument("taskkill");
		command.addArgument("/F");
		command.addArgument("/IM");
		command.addArgument("node.exe");
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(command, resultHandler);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
