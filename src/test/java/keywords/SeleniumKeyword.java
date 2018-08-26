package keywords;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.CaseFailedException;

public class SeleniumKeyword {

	protected WebDriver driver;
	protected String baseUrl;
	public WebElement objKeyword;
	public String strKeywordName;
	public String strFieldName;
	public String strInputData;
	public String strIndex;
	public String strObjectType = "";
	public String strTagName = "";
	public String strXpathExpression = "";
	public boolean boolRegularExpresion;
	int intTimeOut = 15;
	

	public SeleniumKeyword(WebDriver driver, String baseUrl) {
		this.baseUrl = baseUrl;
		this.driver = driver;
	}

	public void Run() {
		Init();
		FindObject();
		FailCondition();
		PerformAction();
		PassCondition();

		System.out.println(MessageFormat.format("Action executed : Field Name : {0}  Input Data:  {1} Type :{2}",
				strFieldName, strInputData, strObjectType));
	}

	protected void Init() {
		if (strObjectType.equals("") || strObjectType.equals(null)) {
			throw new CaseFailedException("Object type is not defined yet ");
		}
	}

	protected void PerformAction() {
		try {
			objKeyword.clear();
			objKeyword.sendKeys(strInputData);
			//logger.info("Executed Action on :Field Name :" + strFieldName + " Input Data:" + strInputData);
		} catch (Exception e) {
			throw new CaseFailedException("Error performing action " + e.getMessage());
		}
	}

	protected void PassCondition() {

	}

	protected void FailCondition() {

		if (!objKeyword.isDisplayed()) {
			throw new CaseFailedException("Error on Object" + strFieldName + "Error : Element is not displayed.");
		}
		if (!objKeyword.isEnabled()) {
			throw new CaseFailedException("Error on Object" + strFieldName + "Error : Element not enabled.");
		}
	}

	/*---------------------------------------------------------------------
	 * FindObject();
	 ---------------------------------------------------------------------*/
	protected void FindObject() {
		extractXPathExpressionForType();
		if (strFieldName.contains("//")) {
			strXpathExpression = strFieldName;
		}

		try {
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		} catch (Exception ex) {
			throw new CaseFailedException(ex.getMessage(), ex);
		}

		if (!boolRegularExpresion) {
			if (IsElementPresent(By.xpath(strFieldName))) {
				strTagName = "xpath";
			}
			if (IsElementPresent(By.id(strFieldName))) {
				strTagName = "id";
			} else if (IsElementPresent(By.name(strFieldName))) {
				strTagName = "name";
			} else {
				if (IsElementPresent(By.xpath(strXpathExpression))) {
					strTagName = "xpath";
				} else {
					strTagName = "";
				}
			}
		} else {
			if (IsElementPresent(By.xpath("//*[contains(@id,'" + strFieldName + "')]"))) {
				strXpathExpression = "//*[contains(@id,'" + strFieldName + "')]";
				strTagName = "xpath";
			} else if (IsElementPresent(By.xpath("//*[contains(@name,'" + strFieldName + "')]"))) {
				strXpathExpression = "//*[contains(@name,'" + strFieldName + "')]";
				strTagName = "xpath";
			} else {
				if (IsElementPresent(By.xpath(strXpathExpression))) {
					strTagName = "xpath";
				} else {
					strTagName = "";
				}
			}
		}
		CreateObject();
	}

	private void extractXPathExpressionForType() {
		switch (strObjectType.toLowerCase()) {
		case "text":
			strXpathExpression = "(//*[normalize-space(text())='" + strFieldName + "']/following::input[1])[" + strIndex
					+ "]";
			break;
		case "select":
			strXpathExpression = "(//*[normalize-space(text())='" + strFieldName + "']/following::select[1])["
					+ strIndex + "]";
			break;
		case "image":
			strXpathExpression = "(//*[normalize-space(text())='" + strFieldName + "']/following::img[1])[" + strIndex
					+ "]";
			break;
		case "button":
			strXpathExpression = "(//*[normalize-space(text())='" + strFieldName
					+ "']/following::input[@type='button' or @type ='submit'][1])[" + strIndex + "]";
			break;
		case "link":	
			strXpathExpression = "(//a[normalize-space(text())='" + strFieldName + "'])[" + strIndex + "]";
			break;
		case "radio": {
			if (strInputData.toLowerCase().equals("yes")) {
				strXpathExpression = "(//*[normalize-space(text())=\"" + strFieldName
						+ "\"]/following::input[@type='radio' and (@value=\"Yes\" or @value=\"true\") ])[" + strIndex
						+ "]";
			} else if (strInputData.toLowerCase().equals("no")) {
				strXpathExpression = "(//*[normalize-space(text())=\"" + strFieldName
						+ "\"]/following::input[@type='radio' and (@value=\"No\" or @value=\"false\") ])[" + strIndex
						+ "]";
			} else {
				strXpathExpression = "(//*[normalize-space(text())=\"" + strFieldName
						+ "\"]/following::input[@type='radio' and @value = '" + strInputData + "'])[" + strIndex + "]";
			}
		}
			break;
		default:
			throw new CaseFailedException(
					MessageFormat.format("Cannot find object of unknown type {0}", strObjectType));
		}
	}

	private void CreateObject() {
		try {
			switch (strTagName.toLowerCase()) {
			case "xpath":
				objKeyword = driver.findElement(By.xpath(strXpathExpression));
				break;
			case "id":
				objKeyword = driver.findElement(By.id(strFieldName));
				break;
			case "name":
				objKeyword = driver.findElement(By.name(strFieldName));
				break;
			default: {
				throw new CaseFailedException("Error creating object (1) - " + strFieldName + " - " + strObjectType);
			}
			}
		} catch (Exception e) {
			throw new CaseFailedException("Error creating object (2) " + e.getMessage());
		}
	}

	protected boolean IsElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

}
