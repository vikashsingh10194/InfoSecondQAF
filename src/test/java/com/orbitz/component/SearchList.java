package com.orbitz.component;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

/**
 * @author Vikash.Singh
 */
public class SearchList extends QAFWebComponent {

	public SearchList(String locator) {
		super(locator);
	}
	@FindBy(locator = "text.flightname.searchpage")
	private QAFWebElement flightName;
	@FindBy(locator = "btn.bookflight.searchpage")
	private QAFWebElement bookFlight;

	@FindBy(locator = "inline.price.searchpage")
	private QAFWebElement flightPrice;
	public QAFWebElement getFlightName() {
		return flightName;
	}
	public QAFWebElement getFlightPrice() {
		return flightPrice;
	}
	public QAFWebElement getBookFlight() {
		return bookFlight;
	}

}
