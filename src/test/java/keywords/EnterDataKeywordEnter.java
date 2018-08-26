package keywords;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class EnterDataKeywordEnter extends SeleniumKeyword {

	public EnterDataKeywordEnter(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	@Override
	public void PerformAction() {
		try {
			objKeyword.clear();
			objKeyword.sendKeys(strInputData);
			objKeyword.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			throw new CaseFailedException("Error performing action " + e.getMessage());
		}
	}

}
