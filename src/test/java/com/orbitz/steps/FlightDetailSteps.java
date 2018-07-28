/**
 * 
 */
package com.orbitz.steps;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.orbitz.pages.FlightSearchPage;
import com.orbitz.utils.CommonUtility;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

/**
 * @author Vikash.Singh
 *
 */
public class FlightDetailSteps extends WebDriverBaseTestPage<WebDriverTestPage> {
	@FindBy(locator = "inline.airline.detailpage")
	private QAFWebElement detailPageAirlineName;
	@FindBy(locator = "inline.price.detailpage")
	private QAFWebElement detailPageFlightPrice;

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		
	}
	@QAFTestStep(description="I am verifying the result {0} and {1}")
	public void verifyResult(Object args0,Object args1){
		System.out.println(args0  );
		System.out.println(args1);
	}

	
	@QAFTestStep(description="user verifying selected flight detail")
	public void verifySelectedFlightDetail(){
		if(driver.getWindowHandles().size()>1) {
			CommonUtility.SwitchWindow(driver);
		}
		Validator.verifyThat("price validation of selected flight",FlightSearchPage.flightPrice, Matchers.containsString(detailPageFlightPrice.getText()));
     	Validator.verifyThat("flight name validation of selected flight",FlightSearchPage.flightName, Matchers.containsString(detailPageAirlineName.getText()));
     	Reporter.log("All details is validated");
     	System.out.println("All details is validated");
	}
	/*public void verifySelectedFlightDetails()
	{
		if(driver.getWindowHandles().size()>1) {
			CommonUtility.SwitchWindow(driver);
		}
		Validator.verifyThat("price validation of selected flight",FlightSearchPage.flightPrice, Matchers.containsString(detailPageFlightPrice.getText()));
     	Validator.verifyThat("flight name validation of selected flight",FlightSearchPage.flightName, Matchers.containsString(detailPageAirlineName.getText()));
     	Reporter.log("All details is validated");
     	System.out.println("All details is validated");
	}*/

}
