/**
 * 
 */
package com.orbitz.utils;

import org.openqa.selenium.Capabilities;

import com.qmetry.qaf.automation.core.QAFListenerAdapter;
import com.qmetry.qaf.automation.ui.webdriver.CommandTracker;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriverCommandListener;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElementCommandAdapter;
import com.qmetry.qaf.automation.util.Reporter;

/**
 * @author Vikash.Singh
 *
 */
public class WebDriverListener implements QAFWebDriverCommandListener {

	@Override
	public void beforeCommand(QAFExtendedWebDriver driver,
			CommandTracker commandHandler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCommand(QAFExtendedWebDriver driver, CommandTracker commandHandler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFailure(QAFExtendedWebDriver driver, CommandTracker commandHandler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeInitialize(Capabilities desiredCapabilities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInitialize(QAFExtendedWebDriver driver) {
		driver.manage().window().maximize();
		Reporter.log("window is maximized");
		System.out.println("window is maximized");
		
	}

	@Override
	public void onInitializationFailure(Capabilities desiredCapabilities, Throwable t) {
		// TODO Auto-generated method stub
		
	}

}
