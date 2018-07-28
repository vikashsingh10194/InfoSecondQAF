package com.orbitz.pages;

import org.hamcrest.Matchers;

import com.orbitz.utils.CommonUtility;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class FlightDetailPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "inline.airline.detailpage")
	private QAFWebElement detailPageAirlineName;
	@FindBy(locator = "inline.price.detailpage")
	private QAFWebElement detailPageFlightPrice;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}
	public QAFWebElement getInlineAirlineDetailpage() {
		return detailPageAirlineName;
	}
	public QAFWebElement getInlinePriceDetailpage() {
		return detailPageFlightPrice;
	}
	
	public void verifySelectedFlightDetails()
	{
		if(driver.getWindowHandles().size()>1) {
			CommonUtility.SwitchWindow(driver);
		}
		Validator.verifyThat("price validation of selected flight",FlightSearchPage.flightPrice, Matchers.containsString(detailPageFlightPrice.getText()));
     	Validator.verifyThat("flight name validation of selected flight",FlightSearchPage.flightName, Matchers.containsString(detailPageAirlineName.getText()));
     	System.out.println("All details is validated");
	}

}
