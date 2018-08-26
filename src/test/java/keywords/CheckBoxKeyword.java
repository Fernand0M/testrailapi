package keywords;

import org.openqa.selenium.WebDriver;


public class CheckBoxKeyword extends SeleniumKeyword {

	public CheckBoxKeyword(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	@Override	
	public void PerformAction() {
		boolean shouldSelect;
		if (strInputData.toLowerCase().equals("on")) {
			shouldSelect = true;
		} else {
			shouldSelect = false;
		}

		try {
			if (shouldSelect != objKeyword.isSelected()) {
				objKeyword.click();
			}
		} catch (Exception e) {
			throw new CaseFailedException("Error performing action " + e.getMessage(), e);
		}
	}

}
