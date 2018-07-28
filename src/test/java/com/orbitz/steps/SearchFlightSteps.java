/**
 * 
 */
package com.orbitz.steps;

import org.hamcrest.Matchers;
import static com.qmetry.qaf.automation.step.CommonStep.*;

import java.util.List;

import com.orbitz.component.SearchList;
import com.qmetry.qaf.automation.step.NotYetImplementedException;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Validator;

/**
 * @author Vikash.Singh
 */
public class SearchFlightSteps extends WebDriverBaseTestPage<WebDriverTestPage> {
	public static String flightName;
	public static String flightPrice;

	@FindBy(locator = "link.flightlist.searchpage")
	private List<SearchList> flightlist;

	@Override
	protected void openPage(PageLocator locator, Object... args) {
	}
	@QAFTestStep(description = "user verify for search page")
	public void verifySearchPage() {
		Validator.verifyThat("Search page validation", driver.getTitle(),
				Matchers.containsString("DEL to BOM Flights | Orbitz"));
	}
	

	@QAFTestStep(description="user will select flight by Index {0}")
	public void selectFlightByIndex(int index){
		SearchList searchList = flightlist.get(index);
		flightName = searchList.getFlightName().getText();
		flightPrice = searchList.getFlightPrice().getText();
		searchList.getBookFlight().click();
		//System.out.println("flight selected on index  " + index);
	}


	@QAFTestStep(description = "User wait for present of oneway radio button")
	public void waitForPageload() {
		waitForPresent("btn.oneway.searchpage");
	}

}
