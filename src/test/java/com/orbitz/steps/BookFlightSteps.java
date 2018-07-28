package com.orbitz.steps;

import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.qmetry.qaf.automation.step.NotYetImplementedException;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
/**
 * @author Vikash.Singh
 */

public class BookFlightSteps extends WebDriverBaseTestPage<WebDriverTestPage> {
	@FindBy(locator = "input.calender.homepage")
	private QAFWebElement journeyDate;

	@Override
	protected void openPage(PageLocator locator, Object... args) {
	}
	@QAFTestStep(description = "user navigate to the orbitz homepage")
	public void launch() {
		driver.get("/");
		driver.manage().window().maximize();
		Reporter.log("Orbitz Home Page");
	}

	@QAFTestStep(description = "user navigate to home page select flight product")
	public void productType() {
		click("link.product.homepage");

	}
	@QAFTestStep(description = "user select for oneway journey")
	public void typeOfJourney() {
		click("link.jorneytype.homepage");
	}
	/*@QAFTestStep(description = "user select for source city")
	public void selectOriginCity() {
		sendKeys("Delhi, India (DEL)", "input.source.homepage");
		Reporter.log("source city is selected");
	}
	@QAFTestStep(description = "user select for destination city")
	public void selectDestinationCity() {
		sendKeys("Mumbai, India (BOM)", "input.destination.homepage");
		Reporter.log("Destination city is selected");
	}*/
	@QAFTestStep(description = "user select for journey date")
	public void selectDepartingDate() {
		click("input.calender.homepage");
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/YYYY");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendar.DATE, 5);
		date = calendar.getTime();

		String stringFormat = format.format(date);
		journeyDate.sendKeys(stringFormat);
		click("btn.cancelcal.homepage");
		Reporter.log("Journey date is selected");
	}
	@QAFTestStep(description = "user click on book button")
	public void bookFlight() {
		click("btn.search.homepage");
	}
	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user select for source city as {0}")
	public void userSelectForSourceCity(String str0) {
		sendKeys(str0, "input.source.homepage");
		Reporter.log("source city is selected");
	}
	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user select for destination city as {0}")
	public void userSelectForDestinationCity(String str0) {
		sendKeys(str0, "input.destination.homepage");
		Reporter.log("Destination city is selected");
	}

}
