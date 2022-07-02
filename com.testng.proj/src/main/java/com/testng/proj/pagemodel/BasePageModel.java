package com.testng.proj.pagemodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.testng.proj.utilities.WebDriverClass;

public class BasePageModel {
	ExtentTest extent;
	WebDriver driver;
	WebDriverWait wait;

	public BasePageModel(WebDriverClass webDriver) {
		extent = webDriver.getExtentTest();
		driver = webDriver.getDriver();
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}

	public void info(String message) {
		extent.info(message);
	}

	public void log(Status status, String message) {
		extent.log(status, message);
	}

	public void error(String message) {
		extent.error(message);
	}

}
