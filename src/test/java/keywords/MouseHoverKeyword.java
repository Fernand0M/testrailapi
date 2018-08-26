package keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class MouseHoverKeyword extends SeleniumKeyword {

	public MouseHoverKeyword(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	@Override
	public void PerformAction() {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(objKeyword).build().perform();
			action.click();

		} catch (Exception e) {
			throw new CaseFailedException("Error performing action " + e.getMessage());
		}
	}
	
}
