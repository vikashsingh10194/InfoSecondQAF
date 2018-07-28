/**
 * 
 */
package com.orbitz.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;

import java.util.List;

import org.hamcrest.Matchers;

import com.orbitz.component.SearchList;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

/**
 * @author Vikash.Singh
 */
public class FlightSearchPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	public static String flightName;
	public static String flightPrice;

	@FindBy(locator = "link.flightlist.searchpage")
	private List<SearchList> flightlist;
	@FindBy(locator = "btn.oneway.searchpage")
	private QAFWebElement oneWayRadioButton;

	@Override
	protected void openPage(PageLocator locator, Object... args) {

	}
	@Override
	public void waitForPageToLoad() {
		oneWayRadioButton.waitForPresent();
	}

	public void flightByIndex(int index) {
		SearchList searchList = flightlist.get(index);
		flightName = searchList.getFlightName().getText();
		flightPrice = searchList.getFlightPrice().getText();
		searchList.getBookFlight().click();
		System.out.println("flight selected on index  " + index);

	}
	public void verifySearchPage() {
		Validator.verifyThat("Search page validation", driver.getTitle(),Matchers.containsString("DEL to BOM Flights | Orbitz"));
			}
}
