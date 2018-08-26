package keywords;

import org.openqa.selenium.WebDriver;

public class UploadFileKeyword extends SeleniumKeyword {

	public UploadFileKeyword(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	@Override
	public void PerformAction() {
		try {
			objKeyword.clear();
			objKeyword.sendKeys(strInputData);
		} catch (Exception e) {
			throw new CaseFailedException("Error performing action " + e.getMessage());
		}
	}

}
