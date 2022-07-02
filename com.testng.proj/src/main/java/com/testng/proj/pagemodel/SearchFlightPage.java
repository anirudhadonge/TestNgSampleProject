package com.testng.proj.pagemodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;
import com.testng.proj.utilities.ScreenShot;
import com.testng.proj.utilities.WebDriverClass;

public class SearchFlightPage extends BasePageModel{

	@FindBy(css="#travelsafeBanner")
	WebElement travelSafeBanner;
	
	@FindBy(xpath="//h1[contains(text(),'Search flights')]")
	WebElement searchFlightTitle;
	
	@FindBy(xpath="//label[@for=\"RoundTrip\"]//input")
	WebElement roundTripRadio;
	
	@FindBy(xpath="//ani[@class='abde']")
	WebElement dummyelement;
	
	public SearchFlightPage(WebDriverClass webDriver) {
		super(webDriver);
	}

	public String getPageName() {
		return searchFlightTitle.getText();
	}
	
	public void validatePageName(String strName) {
		log(Status.PASS,"The Expected title is "+searchFlightTitle.getText());
		//Assert.assertTrue(searchFlightTitle.getText().equals(strName),"The Page name is "+searchFlightTitle.getText());
	}
	
	public void clickOnDummyElement() {
		wait.until(ExpectedConditions.elementToBeClickable(dummyelement));
		dummyelement.click();
	}
	
	public void clickOnRoundTrip() {
		log(Status.PASS,"Click on Round Trip radio button");
		roundTripRadio.click();
		try {
			log(Status.PASS,"Round Trip Radio button clicked "+ extent.addScreenCaptureFromPath(ScreenShot.capture(driver)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
