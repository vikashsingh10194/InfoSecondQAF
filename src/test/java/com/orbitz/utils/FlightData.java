/**
 * 
 */
package com.orbitz.utils;

import java.util.Map;

import com.orbitz.pages.FlightHomePage;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.TestPage;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.util.Reporter;

/**
 * @author Vikash.Singh
 *
 */
public class FlightData extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	FlightHomePage homePage= new FlightHomePage();
	//String path="resources/data.csv";
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		
	}
	/*@QAFDataProvider(key= "resources/data.csv")
	public void selectSourceDestination(Map<String,String> flightdatas) {
		String sourceCity= flightdatas.get(([0][0]).toString());
		homePage.getSourceCity().sendKeys(sourceCity);
		Reporter.log("Source is selected as  "+sourceCity);
		String destinationCity = flightdatas.get("Destination");
		homePage.getDestinationCity().sendKeys(destinationCity);
		Reporter.log("Destination is selected as  "+destinationCity);
		
	}*/
	
	@QAFDataProvider (key ="location")
	public void selectSourceDestination(Map<String,String> data) {
		String source= data.get("source");
		homePage.getSourceCity().sendKeys(source);
		Reporter.log("Source is selected as  "+source);
		String destination = data.get("destination");
		homePage.getDestinationCity().sendKeys(destination);
		Reporter.log("Destination is selected as  "+destination);
		
	}

}
