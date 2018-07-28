package com.orbitz.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Keys;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.sun.glass.events.KeyEvent;

public class FlightHomePage extends WebDriverBaseTestPage<WebDriverTestPage> {
	@FindBy(locator = "link.product.homepage")
	private QAFWebElement selectProduct;

	@FindBy(locator = "link.jorneytype.homepage")
	private QAFWebElement journeyType;

	@FindBy(locator = "input.source.homepage")
	private QAFWebElement sourceCity;

	@FindBy(locator = "input.destination.homepage")
	private QAFWebElement destinationCity;

	@FindBy(locator = "input.calender.homepage")
	private QAFWebElement journeyDate;

	@FindBy(locator = "btn.search.homepage")
	private QAFWebElement searchFlight;
	@FindBy(locator = "btn.cancelcal.homepage")
	private QAFWebElement closeCalender;

	public QAFWebElement getSelectProduct() {
		return selectProduct;
	}

	public QAFWebElement getJourneyType() {
		return journeyType;
	}

	public QAFWebElement getSourceCity() {
		return sourceCity;
	}

	public QAFWebElement getDestinationCity() {
		return destinationCity;
	}

	public QAFWebElement getJourneyDate() {
		return journeyDate;
	}

	public QAFWebElement getSearchFlight() {
		return searchFlight;
	}
	public QAFWebElement getCloseCalender() {
		return closeCalender;
	}
	public void productType() {
		selectProduct.click();
		journeyType.click();
	}
	public void selectOriginCity(String source) throws InterruptedException {
		// sourceCity.click();
		// Thread.sleep(1000);
		sourceCity.sendKeys(source + Keys.ENTER);
	}
	public void selectDestinationCity(String destination) {
		destinationCity.click();
		destinationCity.sendKeys(destination + Keys.ENTER);
	}
	public void selectJourneyDate() {
		journeyDate.click();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/YYYY");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendar.DATE, 5);
		date = calendar.getTime();

		String stringFormat = format.format(date);
		journeyDate.sendKeys(stringFormat);
		closeCalender.click();

	}
	public void bookFlight() {
		searchFlight.click();
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {

	}
	public void launch() {
		driver.get("/");
		//driver.manage().window().maximize();
		Reporter.log("We are on Orbitz Home Page");

	}

}
