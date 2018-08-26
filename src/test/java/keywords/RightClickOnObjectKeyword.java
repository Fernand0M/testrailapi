package keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickOnObjectKeyword extends SeleniumKeyword {

	public RightClickOnObjectKeyword(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	@Override
	public void PerformAction() {
		try {
			Actions action = new Actions(driver);
			action.contextClick(objKeyword).build().perform();

		} catch (Exception e) {
			throw new CaseFailedException("Error performing action " + e.getMessage());
		}
	}

}
