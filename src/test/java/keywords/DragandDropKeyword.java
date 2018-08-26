package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragandDropKeyword extends SeleniumKeyword {

	public DragandDropKeyword(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	String[] arrInputData1 = strInputData.split(":");
	String strTagName1 = arrInputData1[0];
	String objName = arrInputData1[1];
	WebElement objKeyword2;

	@Override
	public void PerformAction() {
		try {
			switch (strTagName1.toLowerCase()) {
			case "xpath":
				objKeyword2 = driver.findElement(By.xpath(objName));
				break;
			case "id":
				objKeyword2 = driver.findElement(By.id(objName));
				break;
			case "name":
				objKeyword2 = driver.findElement(By.name(objName));
				break;
			default: {
				throw new CaseFailedException("Error creating object (1) - " + objName + " - " + strObjectType);
			}
			}

			Actions builder = new Actions(driver);
			builder.clickAndHold(objKeyword).moveToElement(objKeyword2).release(objKeyword2).perform();
		} catch (Exception e) {
			throw new CaseFailedException("Error performing action " + e.getMessage());
		}
	}

}
