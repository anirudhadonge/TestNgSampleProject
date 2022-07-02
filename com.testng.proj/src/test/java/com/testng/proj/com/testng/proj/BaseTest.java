package com.testng.proj.com.testng.proj;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.Status;
import com.testng.proj.utilities.Environment;
import com.testng.proj.utilities.ExtentReportClass;
import com.testng.proj.utilities.WebDriverClass;

public class BaseTest {
	WebDriverClass webDriverClass;
	public static ThreadLocal<WebDriverClass> webDriver = new ThreadLocal<WebDriverClass>();
	Environment environment;

	@BeforeMethod
	public void beforeMethod(Method method) {
		System.out.println("BaseTest Before method invoked");
		webDriver.set(new WebDriverClass(ExtentReportClass.getExtentReporter().createTest(method.getName())));
		info("driver :" + webDriver.get());
		environment = new Environment();
		log(Status.PASS,"Navigating to Url :"+environment.getUrl());
		webDriver.get().getDriver().navigate().to(environment.getUrl());
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		webDriver.get().getExtentTest().info("BaseTest After method invoked");
		webDriver.get().getExtentTest().info("Close the driver " + webDriver.get().getDriver());
		webDriver.get().getDriver().quit();
		webDriver.get().getExtentTest().info("Driver closed");
		ExtentReportClass.getExtentReporter().flush();
	}
	
	public void info(String message) {
		webDriver.get().getExtentTest().info(message);
	}

	public void log(Status status, String message) {
		webDriver.get().getExtentTest().log(status, message);
	}

	public void error(String message) {
		webDriver.get().getExtentTest().error(message);
	}
	
	public void fail(String message) {
		webDriver.get().getExtentTest().fail(message);
	}
}
