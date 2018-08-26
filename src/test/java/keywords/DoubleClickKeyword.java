package keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickKeyword extends SeleniumKeyword {

	public DoubleClickKeyword(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	@Override
	public void PerformAction() {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(objKeyword).doubleClick().build().perform();
		} catch (Exception e) {
			throw new CaseFailedException("Error performing action " + e.getMessage());
		}
	}

}
