/**
 * 
 */
package com.orbitz.utils;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;

/**
 * @author Vikash.Singh
 */
public class CommonUtility {
	
	public static void SwitchWindow(QAFWebDriver driver) {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
	}

}
