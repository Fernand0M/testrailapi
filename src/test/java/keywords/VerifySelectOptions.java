package keywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifySelectOptions extends SeleniumKeyword {

	public VerifySelectOptions(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	String strXPathExpression;

	@Override
	public void PerformAction() {
		try {
			String[] arrOptions;
			arrOptions = strInputData.split(";");
			List<WebElement> listOptionType;
			listOptionType = driver.findElements(By.xpath(strXPathExpression));
			String strCurrentText;
			int intIndex = 0;
			boolean blnOk = true;
			System.out.println("=====[ Select Options from :" + strFieldName + " ]============");

			for (WebElement item : listOptionType) {
				strCurrentText = item.getText();
				if (!strCurrentText.equals(arrOptions[intIndex])) {
					blnOk = false;
					break;
				}
				System.out.println("Options [" + intIndex + "]:={" + item.getText() + "}");
				intIndex++;
			}
			if (!blnOk) {
				throw new CaseFailedException("Select List with wrong values");
			}
		} catch (Exception ex) {
			throw new CaseFailedException(ex.getMessage(), ex);
		}
	}

	@Override
	public void FindObject() {
		strXPathExpression = "(//*[normalize-space(text())='" + strFieldName + "']/following::select[1])[1]/option";

		if (!IsElementPresent(By.xpath(strXPathExpression))) {
			throw new CaseFailedException("Element not found");
		}
		try {
			objKeyword = driver.findElement(By.xpath(strXPathExpression));
		} catch (Exception ex) {
			throw new CaseFailedException(ex.getMessage(), ex);
		}
	}

}
