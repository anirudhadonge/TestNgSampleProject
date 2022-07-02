package com.testng.proj.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverClass {
	WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public ChromeDriverClass() {
		String chromeDriverPath = System.getProperty("user.dir") + "\\Executables\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
	}

}
