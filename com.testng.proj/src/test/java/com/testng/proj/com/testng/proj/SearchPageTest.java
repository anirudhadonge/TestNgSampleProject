package com.testng.proj.com.testng.proj;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.testng.proj.pagemodel.SearchFlightPage;
import com.testng.proj.utilities.ScreenShot;

public class SearchPageTest extends BaseTest {

	SearchFlightPage searchFlightPage;

	@BeforeMethod
	public void testBeforeMethod() {
		searchFlightPage = new SearchFlightPage(BaseTest.webDriver.get());
	}

	@Test
	public void navigateToSearchPageTest() throws IOException {
		try {
			searchFlightPage.clickOnDummyElement();
			searchFlightPage.validatePageName("New Search");
		} catch (Exception ex) {
			fail(ex.toString());
			log(Status.FAIL, ex.toString() + webDriver.get().getExtentTest()
					.addScreenCaptureFromPath(ScreenShot.capture(webDriver.get().getDriver())));

			Assert.assertTrue(false, ex.toString());
		}
	}
	
	@Test
	public void searchPageTest() {
		searchFlightPage.clickOnRoundTrip();
	}

}
