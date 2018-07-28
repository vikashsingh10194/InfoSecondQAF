package com.orbitz.tests;

import java.awt.AWTException;
import java.util.Map;

import org.testng.annotations.Test;

import com.orbitz.pages.FlightDetailPage;
import com.orbitz.pages.FlightHomePage;
import com.orbitz.pages.FlightSearchPage;
import com.orbitz.utils.FlightData;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class TestPage extends WebDriverTestCase {

	
	@QAFDataProvider (key ="location")
	@Test
	public void bookFlightTest(Map<String, String> flightdatas) throws InterruptedException {
		FlightHomePage flightHomePage = new FlightHomePage();
		flightHomePage.launch();
		flightHomePage.productType();
		//flightHomePage.selectOriginCity("Delhi, India (DEL)");
		//flightHomePage.selectDestinationCity("Mumbai, India (BOM)");
		FlightData flightdata = new FlightData();
		flightdata.selectSourceDestination(flightdatas);
		flightHomePage.selectJourneyDate();
		flightHomePage.bookFlight();
		FlightSearchPage flightSearchpage = new FlightSearchPage();
		flightSearchpage.waitForPageToLoad();
		flightSearchpage.verifySearchPage();
		Thread.sleep(2000);
		flightSearchpage.flightByIndex(0);
		Reporter.log("Given index flight is selected");
		System.out.println("Given index flight is selected");
		FlightDetailPage flightDetailPage = new FlightDetailPage();
		flightDetailPage.verifySelectedFlightDetails();
		

	}
}
