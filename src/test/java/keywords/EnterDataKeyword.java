package keywords;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class EnterDataKeyword extends SeleniumKeyword {

	public EnterDataKeyword(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	@Override
	public void PerformAction() {
		try {
			objKeyword.clear();
			objKeyword.sendKeys(strInputData);
			objKeyword.sendKeys(Keys.TAB);
		} catch (Exception e) {
			throw new CaseFailedException("Error performing action " + e.getMessage());
		}
	}

}
