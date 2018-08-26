package keywords;

import org.openqa.selenium.WebDriver;


public class RadioButtonYesNoKeyword extends SeleniumKeyword {

	public RadioButtonYesNoKeyword(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	@Override
	public void PerformAction() {
		try {
			objKeyword.click();
		} catch (Exception e) {
			throw new CaseFailedException("Error performing action " + e.getMessage());
		}
	}

}
