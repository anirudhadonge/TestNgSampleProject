package com.testng.proj.utilities;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class WebDriverClass {

	private WebDriver driver;
	private ExtentTest extentTest;
	
	public WebDriverClass(ExtentTest extent) {
		this.extentTest = extent;
		System.out.println("WebDriver objecte created");
		String browser = System.getProperty("Browser");
		switch (browser.toLowerCase()) {
		case "chrome":
			System.out.println("chrome objected created");
			driver = new ChromeDriverClass().getDriver();

		}
		driver.manage().window().maximize();
	}

	public ExtentTest getExtentTest() {
		return extentTest;
	}

	public WebDriver getDriver() {
		return driver;
	}


	public void quitDriver() {
		System.out.println("Quite the driver");
		driver.quit();
	}

}
