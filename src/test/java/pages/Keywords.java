package pages;

import keywords.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class Keywords {

    private static final String TYPE_DATA_DICTIONARY = "datadictionary";
    private static final String TYPE_STOREVALUE = "storevalue";
    private static final String TYPE_NORMAL = "normal";
    private static final String TYPE_RANDOM_NUMBER = "random#";
    private static final String TYPE_RANDOM_STRING = "random$";
    public boolean passed = false;
    public boolean blnRegularExpression;
    public String defect;
    public String strPathResults;
    public String strIndex = "1";
    protected WebDriver driver;
    protected String baseUrl;
    String[] arrNam;
    String strBsnComponent;

    public Keywords(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Action: click on button.
     * <p>
     * This method don't return anything.
     *
     * @param strlinktext(id,xpath,name,label of the element)
     * @return perform action on the element.
     */
    protected void clickOnButton(String strLinkText) {
        ClickOnObjectKeyword clickOnButton = new ClickOnObjectKeyword(driver, baseUrl);
        clickOnButton.strInputData = "";
        clickOnButton.strObjectType = "button";
        clickOnButton.strFieldName = FieldReview(strLinkText);
        clickOnButton.strKeywordName = "ClickOnButton";
        clickOnButton.Run();
    }

    /**
     * Action: Click on link.
     * <p>
     * This method won't return anything.
     *
     * @param strlinktext(id,xpath,name,label of the element)
     * @return perform action on the element.
     */

    protected void clickOnLink(String strLinkText) {
        ClickOnObjectKeyword clickOnLink = new ClickOnObjectKeyword(driver, baseUrl);
        clickOnLink.strInputData = "";
        clickOnLink.strFieldName = FieldReview(strLinkText);
        clickOnLink.strKeywordName = "ClickOnLink";
        clickOnLink.strObjectType = "link";
        clickOnLink.strIndex = strIndex;
        clickOnLink.Run();
    }

    /**
     * Action: Double click on element.
     * <p>
     * This method won't return anything.
     *
     * @param strlinktext(id,Xpath,name,label of the element)
     * @return perform action on the element.
     */

    protected void doubleClick(String strLinkText) {
        DoubleClickKeyword doubleClick = new DoubleClickKeyword(driver, baseUrl);
        doubleClick.strInputData = "";
        doubleClick.strFieldName = FieldReview(strLinkText);
        doubleClick.strObjectType = "text";
        doubleClick.boolRegularExpresion = blnRegularExpression;
        doubleClick.strIndex = strIndex;
        doubleClick.strKeywordName = "DoubleClick";
        doubleClick.Run();
    }

    /**
     * Action: Click on Web Element.
     * <p>
     * This method won't return anything.
     *
     * @param strlinktext(id,Xpath,name,label of the element)
     * @return perform action on the element.
     */
    protected void clickOnWebElement(String strLinkText) {
        ClickOnObjectKeyword clickOnElement = new ClickOnObjectKeyword(driver, baseUrl);
        clickOnElement.strInputData = "";
        clickOnElement.strFieldName = FieldReview(strLinkText);
        clickOnElement.strKeywordName = "ClickOnWebElement";
        clickOnElement.strObjectType = "element";
        clickOnElement.strIndex = strIndex;
        clickOnElement.Run();
    }

    /**
     * Action: Click on textbox.
     * <p>
     * This method won't return anything.
     *
     * @param strlinktext(id,Xpath,name,label of the element)
     * @return perform action on the element.
     */
    protected void clickOnTextBox(String strLinkText) {
        ClickOnObjectKeyword ClickOnTextBox = new ClickOnObjectKeyword(driver, baseUrl);
        ClickOnTextBox.strInputData = "";
        ClickOnTextBox.strObjectType = "text";
        ClickOnTextBox.strFieldName = FieldReview(strLinkText);
        ClickOnTextBox.strKeywordName = "ClickOnTextBox";
        ClickOnTextBox.Run();
    }

    /**
     * Action: Click on radio button.
     * <p>
     * This method won't return anything.
     *
     * @param strfieldname(id,Xpath,name,label of the element),strinputdata(true or false)
     * @return perform action on the element.
     */
    protected void clickOnRadioButton(String strFieldName, String strInputData) {
        RadioButtonYesNoKeyword clickOnRadio = new RadioButtonYesNoKeyword(driver, baseUrl);
        clickOnRadio.strInputData = InputReview(strInputData);
        clickOnRadio.strFieldName = FieldReview(strFieldName);
        clickOnRadio.strObjectType = "radio";
        clickOnRadio.boolRegularExpresion = blnRegularExpression;
        clickOnRadio.strIndex = strIndex;
        clickOnRadio.strKeywordName = "ClickOnRadioButton";
        clickOnRadio.Run();
    }

    /**
     * Action: Right click on web element.
     * <p>
     * This method won't return anything.
     *
     * @param strlinktext(id,Xpath,name,label of the element)
     * @return perform action on the element.
     */
    protected void rightClick(String strLinkText) {
        RightClickOnObjectKeyword clickOnButton = new RightClickOnObjectKeyword(driver, baseUrl);
        clickOnButton.strInputData = "";
        clickOnButton.strObjectType = "button";
        clickOnButton.strFieldName = FieldReview(strLinkText);
        clickOnButton.strKeywordName = "ClickOnButton";
        clickOnButton.Run();
    }

    /**
     * Action: Drag and Drop.
     * <p>
     * This method won't return anything.
     *
     * @param value1(id,Xpath,name,label of the element),value2((id,Xpath,name,label of the element)
     * @return perform action on the element.
     */

    protected void dragandDrop(String value1, String value2) {
        DragandDropKeyword DragandDrop = new DragandDropKeyword(driver, baseUrl);
        DragandDrop.strInputData = InputReview(value1);
        DragandDrop.strFieldName = FieldReview(value2);
        DragandDrop.boolRegularExpresion = blnRegularExpression;
        DragandDrop.strIndex = strIndex;
        DragandDrop.strKeywordName = "DragandDrop";
        DragandDrop.Run();
    }

    /**
     * Action: Mouse Hover.
     * <p>
     * This method don't return anything.
     *
     * @param strelement(id,Xpath,name,label of the element)
     * @return mouse hover on the element.
     */

    protected void mouseHover(String strelement) {
        MouseHoverKeyword mouse = new MouseHoverKeyword(driver, baseUrl);
        mouse.strInputData = "";
        mouse.strFieldName = FieldReview(strelement);
        mouse.strKeywordName = "MouseHover";
        mouse.strObjectType = "text";
        mouse.strIndex = strIndex;
        mouse.Run();
    }

    /**
     * Action: Implicit wait.
     *
     * @param time in seconds.
     * @return wait
     */
    protected void implicitWait(int intTimeOut) {
        if (intTimeOut == 0) {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        driver.manage().timeouts().implicitlyWait(intTimeOut, TimeUnit.SECONDS);
    }

    /**
     * Action: Enter data.
     * <p>
     * This method return text in to textbox
     *
     * @param fieldname(id,Xpath,name,label of the element),inputdata
     * @return NA
     */
    protected void enterData(String strFieldName, String strInputData) {
        EnterDataKeyword enterData = new EnterDataKeyword(driver, baseUrl);
        enterData.strInputData = InputReview(strInputData);
        enterData.strFieldName = FieldReview(strFieldName);
        enterData.strObjectType = "text";
        enterData.boolRegularExpresion = blnRegularExpression;
        enterData.strIndex = strIndex;
        enterData.strKeywordName = "EnterData";
        enterData.Run();
    }

    /**
     * Action: Upload Document.
     * <p>
     * This method return text in to uploadfile
     *
     * @param fieldname(id,Xpath,name,label of the element),inputdata
     * @return NA
     */
    protected void uploadFile(String strFieldName, String strInputData) {
        UploadFileKeyword uploadFile = new UploadFileKeyword(driver, baseUrl);
        uploadFile.strInputData = InputReview(strInputData);
        uploadFile.strFieldName = FieldReview(strFieldName);
        uploadFile.strObjectType = "text";
        uploadFile.boolRegularExpresion = blnRegularExpression;
        uploadFile.strIndex = strIndex;
        uploadFile.strKeywordName = "EnterData";
        uploadFile.Run();
    }

    /**
     * Action: Enter data with no Tab.
     * <p>
     * This method return text in to textbox
     *
     * @param fieldname(id,Xpath,name,label of the element),inputdata
     * @return NA
     */
    protected void enterDataEnter(String strFieldName, String strInputData) {
        EnterDataKeywordEnter enterData = new EnterDataKeywordEnter(driver, baseUrl);
        enterData.strInputData = InputReview(strInputData);
        enterData.strFieldName = FieldReview(strFieldName);
        enterData.strObjectType = "text";
        enterData.boolRegularExpresion = blnRegularExpression;
        enterData.strIndex = strIndex;
        enterData.strKeywordName = "EnterData";
        enterData.Run();
    }

    /**
     * Action: Send Data.
     * <p>
     * This method send keys into web page
     *
     * @param inputdata
     * @return NA
     */
    protected void sendData(String strInputData) {
        EnterDataKeyword enterData = new EnterDataKeyword(driver, baseUrl);
        enterData.strInputData = InputReview(strInputData);
        enterData.strObjectType = "text";
        enterData.boolRegularExpresion = blnRegularExpression;
        enterData.strIndex = strIndex;
        enterData.strKeywordName = "EnterData";
        enterData.Run();
    }

    /**
     * Action: Select list box.
     * <p>
     * This method select item form list box.
     *
     * @param fieldname(id,Xpath,name,label of the element),inputdata
     * @return NA.
     */
    protected void selectListBox(String strFieldName, String strInputData) {
        SelectComboBoxKeyword selectList = new SelectComboBoxKeyword(driver, baseUrl);
        selectList.strObjectType = "select";
        selectList.strInputData = InputReview(strInputData);
        selectList.strFieldName = FieldReview(strFieldName);
        selectList.boolRegularExpresion = blnRegularExpression;
        selectList.strObjectType = "text";
        selectList.strIndex = strIndex;
        selectList.strKeywordName = "SelectListBox";
        selectList.Run();
    }

    /**
     * Action: Verify element is present on the web page.
     * <p>
     * This method return true or false.
     *
     * @param by()
     * @return NA
     */
    protected boolean IsElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    /**
     * Action: Wait for element is present.
     * <p>
     * This method returns true or false.
     *
     * @param strElement,seconds
     * @return wait
     */
    protected boolean waitForElementIsPresent(String strElement, int intSeconds) {
        String[] arrTagName;
        String strTagName;
        String strFieldName;
        arrTagName = strElement.split("=");
        //
        blnRegularExpression = false;
        if (strElement.indexOf(".*") > -1) {
            blnRegularExpression = true;
        }
        if (arrTagName.length == 1) {
            strTagName = "id";
            strFieldName = strElement;
        } else if (arrTagName.length == 3) {
            strTagName = arrTagName[0];
            strFieldName = arrTagName[1] + "=" + arrTagName[2];
        } else {
            strTagName = arrTagName[0];
            strFieldName = arrTagName[1];
        }
        WebDriverWait wait = new WebDriverWait(driver, intSeconds);

        if (!blnRegularExpression) {
            try {
                switch (strTagName.toLowerCase()) {
                    case "id":
                        // wait.Until(drv =>
                        // driver.FindElement(By.Id(strFieldName)).Enabled);
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strFieldName)));
                        break;
                    case "name":
                        // wait.Until(drv =>
                        // driver.FindElement(By.Name(strFieldName)).Enabled);
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(strFieldName)));
                        break;
                    case "xpath":
                        // wait.Until(drv =>
                        // driver.FindElement(By.Name(strElement)).Enabled);
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strFieldName)));
                        break;
                    default:
                        break;
                }
            } catch (Exception ex) {
            }
        } else {
            String strXPathExpression;
            strFieldName = strFieldName.replace(".*", "");
            switch (strTagName.toLowerCase()) {
                case "id":
                    strXPathExpression = "//*[contains(@id,'" + strFieldName + "')][1]";
                    break;
                case "name":
                    strXPathExpression = "//*[contains(@name,'" + strFieldName + "')][1]";
                    break;
                case "xpath":
                    strXPathExpression = strTagName;
                    break;
                default:
                    strXPathExpression = strTagName;
                    break;
            }
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strXPathExpression)));
            } catch (Exception ex) {
            }
        }
        return true;
    }

    /**
     * Action: Wait for page to load.
     * <p>
     * This method won't return anything.
     *
     * @param strElement,seconds
     * @return wait
     */

    public boolean waitForPageToLoad() {
        String s = "";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        while (!s.equals("complete")) {
            s = (String) js.executeScript("return document.readyState");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return false;
            }
        }
        return true;
    }

    /**
     * Action: Verify xpath is present into web page.
     * <p>
     * This method don't return anything.
     *
     * @param xpath
     * @return xpath
     */

    protected boolean verifyXpathIsPresent(String xpath) {
        String xPathExpression = xpath;
        WebElement objText;
        if (!IsElementPresent(By.xpath(xPathExpression))) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            this.defect = "Text is not present(1)  " + xpath;
            return false;
        }
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        objText = driver.findElement(By.xpath(xPathExpression));
        if (objText.isDisplayed() && objText.isEnabled()) {
            return true;
        } else {
            this.defect = "Text is not displayed";
            return false;
        }

    }

    /**
     * Action: Verify text is present into web page.
     * <p>
     * This method won't return anything.
     *
     * @param strText
     * @return NA
     */

    protected boolean verifyTextIsPresent(String strText) {
        String xPathExpression = "(//*[contains(text(),'" + strText + "')])[1]";
        WebElement objText;
        if (!IsElementPresent(By.xpath(xPathExpression))) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            this.defect = "Text is not present(1)  " + strText;
            return false;
        }
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        objText = driver.findElement(By.xpath(xPathExpression));
        if (objText.isDisplayed() && objText.isEnabled()) {
            return true;
        } else {
            this.defect = "Text is not displayed";
            return false;
        }

    }

    /**
     * Action: Verify text is present using an index.
     * <p>
     * This method return true or false.
     *
     * @param strText,index
     * @return NA
     */
    protected boolean verifyTextIsPresentIndex(String strText, int Index) {
        String xPathExpression = "(//*[contains(text(),'" + strText + "')])[" + Index + "]";
        WebElement objText;
        if (!IsElementPresent(By.xpath(xPathExpression))) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            this.defect = "Text is not present(1)  " + strText;
            return false;
        }
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        objText = driver.findElement(By.xpath(xPathExpression));
        if (objText.isDisplayed() && objText.isEnabled()) {
            return true;
        } else {
            this.defect = "Text is not displayed";
            return false;
        }

    }

    /**
     * Action: Wait for seconds.
     * <p>
     * This method won't return anything.
     *
     * @param seconds
     * @return NA
     */

    protected void waitFor(int seconds) {
        long millis = TimeUnit.SECONDS.toMillis(seconds);
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new CaseFailedException("Wait of " + seconds + " seconds interrupted.");
        }
    }

    /**
     * Action: Wait for 20 seconds.
     * <p>
     * This method won't return anything.
     *
     * @param seconds
     * @return NA
     */

    protected boolean waitintHigh() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Action: Verify status is present into web page.
     * <p>
     * This method won't return anything.
     *
     * @param strtext
     * @return NA
     */

    protected boolean verifyStatusPresent(String strText) {
        String xPathExpression = strText;
        WebElement objText;
        if (!IsElementPresent(By.xpath(xPathExpression))) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            this.defect = "Text is not present(1)  " + strText;
            return false;
        }
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        objText = driver.findElement(By.xpath(xPathExpression));
        if (objText.isDisplayed() && objText.isEnabled()) {
            return true;
        } else {
            this.defect = "Text is not displayed";
            return false;
        }

    }

    /**
     * Action: Extract xpath from web page.
     * <p>
     * This method return text.
     *
     * @param xpath
     * @return NA
     */
    protected String getTextxpath(String xpath) {
        String xPathExpression = xpath;
        WebElement objText;
        if (!IsElementPresent(By.xpath(xPathExpression))) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            this.defect = "Element is not present(1)  " + xpath;
            return this.defect;
        }
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        objText = driver.findElement(By.xpath(xPathExpression));
        if (objText.isDisplayed()) {
            return objText.getText();
        } else {
            this.defect = "Text is not displayed";
            return this.defect;
        }

    }

    /**
     * Action: Verify Table.
     * <p>
     * This method verify table contents
     *
     * @param strtext
     * @return
     */
    protected void verifyTable(String strTableXpath, String strTableContent) {
        String xPathExpression = strTableXpath;
        WebElement objText;
        if (!IsElementPresent(By.xpath(xPathExpression))) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            this.defect = "Element is not present(1)  " + strTableXpath;

        }
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        objText = driver.findElement(By.xpath(xPathExpression));
        if (objText.isDisplayed() && objText.getText().equals(strTableContent)) {
            System.out.println(objText.getText() + " is displayed correctly");
        } else {
            throw new CaseFailedException("Table is not displayed correctly");
        }

    }

    /**
     * Action: Verify Table.
     * <p>
     * This method verify value contents
     *
     * @param strtext
     * @return
     */
    protected void verifyValue(String strTableXpath, String strTableContent) {
        String xPathExpression = strTableXpath;
        WebElement objText;
        if (!IsElementPresent(By.xpath(xPathExpression))) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            this.defect = "Element is not present(1)  " + strTableXpath;

        }
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        objText = driver.findElement(By.xpath(xPathExpression));
        if (objText.isDisplayed() && objText.getAttribute("value").equals(strTableContent)) {
            System.out.println(objText.getAttribute("value") + " is displayed correctly");
        } else {
            throw new CaseFailedException("Table is not displayed correctly");
        }

    }

    /**
     * Action: Extract text.
     * <p>
     * This method return text.
     *
     * @param strtext
     * @return NA
     */
    protected String extractText(String strText) {
        String xPathExpression = "//*[contains(text(), '" + strText + "')]";
        WebElement objText;
        if (!IsElementPresent(By.xpath(xPathExpression))) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            this.defect = "Text is not present(1)  " + strText;
            return this.defect;
        }
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        objText = driver.findElement(By.xpath(xPathExpression));
        if (objText.isDisplayed()) {
            return objText.getText();
        } else {
            this.defect = "Text is not displayed";
            return this.defect;
        }

    }

    /**
     * Action: Extract value using xpath.
     * <p>
     * This method don't return anything.
     *
     * @param xpath
     * @return NA
     */
    protected String getValueXpath(String xpath) {
        String xPathExpression = xpath;
        WebElement objText;
        if (!IsElementPresent(By.xpath(xPathExpression))) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            this.defect = "Text is not present(1)  " + xpath;
            return this.defect;
        }
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        objText = driver.findElement(By.xpath(xPathExpression));
        if (objText.isDisplayed()) {
            return objText.getAttribute("value");
        } else {
            this.defect = "Text is not displayed";
            return this.defect;
        }

    }

    /**
     * Action: Extract text following.
     * <p>
     * This method return text.
     *
     * @param strtext
     * @return NA
     */

    protected String extractTextFollowing(String strText) {
        String xPathExpression = "(//*[normalize-space(text())= '" + strText + "'])[1]/following::*[text()][1]";
        WebElement objText;
        if (!IsElementPresent(By.xpath(xPathExpression))) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            this.defect = "Text is not present(1)  " + strText;
            return this.defect;
        }
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        objText = driver.findElement(By.xpath(xPathExpression));
        if (objText.isDisplayed()) {
            return objText.getText();
        } else {
            this.defect = "Text is not displayed";
            return this.defect;
        }

    }

    /**
     * Action: Extract text from input.
     * <p>
     * This method return text.
     *
     * @param strtext
     * @return NA
     */
    protected String extractTextInput(String strText) {
        String xPathExpression = "(//*[normalize-space(text())= '" + strText + "'])[1]/following::input[2]";
        WebElement objText;
        if (!IsElementPresent(By.xpath(xPathExpression))) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            this.defect = "Text is not present(1)  " + strText;
            return this.defect;
        }
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        objText = driver.findElement(By.xpath(xPathExpression));

        if (objText.isDisplayed()) {
            // return objText.getText();
            return objText.getAttribute("value");
        } else {
            this.defect = "Text is not displayed";
            return this.defect;
        }

    }

    /**
     * Action: Is alert present switch to alert.
     * <p>
     * This method won't return anything.
     *
     * @param
     * @return NA
     */

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException ex) {
            return false;
        }
    }

    /**
     * Action: Is alert present switch to alert and next.
     * <p>
     * This method won't return anything.
     *
     * @param NA
     * @return NA
     */
    protected String closeAlertAndGetItsText(boolean acceptNextAlert) {
        if (!isAlertPresent()) {
            return "";
        }
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    /**
     * Action: Switch to frame.
     * <p>
     * This method won't return anything.
     *
     * @param strframename
     * @return NA
     */
    protected boolean switchFrame(String strFrameName) {
        try {
            if (strFrameName.toLowerCase().equals("default")) {
                driver.switchTo().defaultContent();
            } else {
                driver.switchTo().frame(strFrameName);
            }
        } catch (Exception ex) {
            this.defect = ex.getMessage();
        }

        return true;
    }

    /**
     * Action: Switch to window.
     * <p>
     * This method won't return anything.
     *
     * @param strWindowTitle
     * @return NA
     */

    protected boolean switchWindows(String strWindowTitle) {
        driver.switchTo().defaultContent();
        String currentWindow = driver.getWindowHandle();
        List<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
        for (String w : availableWindows) {
            if (w != currentWindow) {
                driver.switchTo().window(w);
                if (driver.getTitle().equals(strWindowTitle)) {
                    try {
                        String strTitle = driver.getTitle();
                        System.out.println(strTitle);
                    } catch (Exception ex) {
                        driver.switchTo().window(w).close();
                        this.defect = ex.getMessage().toString();
                        return false;
                    }
                    return true;
                } else {
                    driver.switchTo().window(currentWindow);
                }

            }
        }
        return false;
    }

    /**
     * Action: Add &prefill=1 into url
     * <p>
     * This method won't return anything.
     *
     * @param NA
     * @return NA
     */
    protected void prefillLaunch() {
        String currentURL;
        currentURL = driver.getCurrentUrl();
        driver.get(currentURL + "&prefill=1");
    }

    /**
     * Action: Function9
     * <p>
     * This method won't return anything.
     *
     * @param NA
     * @return NA
     */
    protected void function9(String strdvmName, String strRequestID) {
        String currentURL;
        currentURL = driver.getCurrentUrl();
        driver.get("https://admin.dvm-" + strdvmName + ".aws.talentwise.com/admin/report-enterprise.php?Fctn=9&ReqID="
                + strRequestID);
        waitForPageToLoad();
        driver.get(currentURL);
    }


    /**
     * Action: Switch to Tab.
     * <p>
     * This method won't return anything.
     *
     * @param strTabTitle
     * @return NA
     */
    protected boolean switchTab(String strTabTitle) {
        driver.switchTo().defaultContent();
        String currentWindow = driver.getWindowHandle();
        List<String> availabletabs = new ArrayList<String>(driver.getWindowHandles());
        for (String w : availabletabs) {
            if (w != currentWindow) {
                driver.switchTo().window(w);
                if (driver.getTitle().equals(strTabTitle)) {
                    try {
                        String strTitle = driver.getTitle();
                        System.out.println(strTitle);
                    } catch (Exception ex) {
                        driver.switchTo().window(w).close();
                        this.defect = ex.getMessage().toString();
                        return false;
                    }
                    return true;
                } else {
                    driver.switchTo().window(currentWindow);
                }

            }
        }
        return false;
    }

    /**
     * Action: Select checkbox.
     * <p>
     * This method won't return anything.
     *
     * @param strname
     * @return NA
     */

    protected boolean selectCheckBox(String strName) {
        WebElement chkLink;
        try {
            chkLink = driver
                    .findElement(By.xpath("(//*[text()='" + strName + "'])[1]/preceding::input[@type='checkbox'][1]"));
            chkLink.click();
        } catch (Exception ex) {
            System.out.println("Error on CheckBox " + this.defect);
            this.defect = ex.getMessage();
            return false;
        }
        return true;
    }

    /**
     * Action: Wait.
     * <p>
     * This method won't return anything.
     *
     * @param timeout
     * @return NA
     */

    boolean wait(int intTimeOut) throws InterruptedException {
        int iTimeOut;
        if (intTimeOut < 999) {
            iTimeOut = intTimeOut * 1000;
        } else {
            iTimeOut = intTimeOut;
        }
        Thread.sleep(iTimeOut);
        return true;
    }

    /**
     * Action: verify select option.
     * <p>
     * This method don't return anything.
     *
     * @param strfield,strinputdata
     * @return NA
     */

    protected void verifySelectOptions(String strField, String strInputData) {
        VerifySelectOptions verifyOptions = new VerifySelectOptions(driver, baseUrl);
        verifyOptions.strInputData = strInputData;
        verifyOptions.strFieldName = strField;
        verifyOptions.strObjectType = "selectlist";
        verifyOptions.Run();
    }

    /**
     * Action: Click on checkbox.
     * <p>
     * This method won't return anything.
     *
     * @param strfield,strinputdata
     * @return NA
     */

    protected void clickOnCheckBox(String strFieldName, String strInputData) {
        CheckBoxKeyword checkBox = new CheckBoxKeyword(driver, baseUrl);
        checkBox.strInputData = InputReview(strInputData);
        checkBox.strFieldName = FieldReview(strFieldName);
        checkBox.strObjectType = "button";
        checkBox.Run();
    }

    /**
     * Action: Field review.
     * <p>
     * This method won't return anything.
     *
     * @param strfieldname
     * @return NA
     */
    protected String FieldReview(String strFieldName) {

        // Regular Expression
        String finalFieldName;
        if (strFieldName.indexOf(".*", 0) != -1) {
            // .*_Street
            finalFieldName = strFieldName.replace(".*", "");
            blnRegularExpression = true;
        } else {
            blnRegularExpression = false;
            finalFieldName = strFieldName;
        }

        // Index
        String idx;
        int posSharp;
        if (finalFieldName.indexOf("#") != -1) {
            posSharp = finalFieldName.indexOf("#");
            idx = finalFieldName.substring(posSharp + 1);
            finalFieldName = finalFieldName.substring(0, posSharp);
        } else {
            idx = "1";
        }
        strIndex = idx;
        //
        return finalFieldName;
    }

    /**
     * Action: Input review.
     * <p>
     * This method don't return anything.
     *
     * @param strInput
     * @return NA
     */
    protected String InputReview(String strInput) {

        String strInputType;
        String[] arrInputData;
        strInputType = TYPE_NORMAL;

        // Get values for validate type String
        int intInitalPart = 0;
        int intEndPart = 0;
        int posSignal;

        // data dictionary - paramter file
        intInitalPart = strInput.indexOf("dt_");
        if (intInitalPart == 1) {
            strInputType = TYPE_DATA_DICTIONARY;
        }
        // store value
        intInitalPart = strInput.indexOf("${");
        intEndPart = strInput.indexOf("}");
        if (intInitalPart > 0 && intEndPart > 0) {
            posSignal = strInput.indexOf("${");
            arrInputData = new String[2];
            strInputType = TYPE_STOREVALUE;
        }
        String[] arrRandom;
        int intSizeRandom;
        intInitalPart = strInput.indexOf(TYPE_RANDOM_STRING + ";");
        if (intInitalPart == 0) {
            arrRandom = strInput.split(";");
            if (arrRandom.length == 0) {
                intSizeRandom = 1;
            } else {
                intSizeRandom = Integer.parseInt(arrRandom[1]);
            }
            strInputType = TYPE_RANDOM_STRING;
        }
        intInitalPart = strInput.indexOf(TYPE_RANDOM_NUMBER + ";");
        if (intInitalPart == 0) {
            arrRandom = strInput.split(";");
            if (arrRandom.length == 0) {
                intSizeRandom = 1;
            } else {
                intSizeRandom = Integer.parseInt(arrRandom[1]);
            }
            strInputType = TYPE_RANDOM_NUMBER;
        }
        switch (strInputType.toLowerCase()) {
            case TYPE_DATA_DICTIONARY:
                return strInput; // pending
            case TYPE_RANDOM_STRING:
                // return RandomString(3); // pending
            case TYPE_RANDOM_NUMBER:
                // return RandomNumeric(9); // pending
            case TYPE_NORMAL:
                return strInput;
            case TYPE_STOREVALUE:
                return strInput; // pending
            default:
                return "";
        }

    }

    /**
     * Action: Random string.
     * <p>
     * This method return random string.
     *
     * @param NA
     * @return NA
     */
    String RandomString(int size) {
        String buffer = RandomStringUtils.randomAlphabetic(size);
        return new String(buffer);
    }

    /**
     * Action: Random number.
     * <p>
     * This method return random number.
     *
     * @param NA
     * @return NA
     */
    String RandomNumeric(int size) {
        String buffer = RandomStringUtils.randomNumeric(size);
        return new String(buffer);

    }

    /**
     * Action: LoginAlert.
     * <p>
     * This method return random number.
     *
     * @param Username,Password
     * @return NA
     */

}
