package keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectComboBoxKeyword extends SeleniumKeyword {

	public SelectComboBoxKeyword(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public void PerformAction() {
		try {
			Select selectElement = new Select(objKeyword);
			selectElement.selectByVisibleText(strInputData);
		} catch (Exception e) {
			throw new CaseFailedException("Error performing action " + e.getMessage());
		}
	}

}
