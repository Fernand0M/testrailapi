package testing;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LpMockLab;
import pages.MsSql;
import pages.webAdmin;

public class sqltesting {
    MsSql mssqltesting;
    LpMockLab lpMockLabTesting;
    WebDriver driver;


    // @BeforeTest
    // public void setup() {
    //     System.setProperty("webdriver.chrome.driver", ("C:\\Drivers\\chromedriver.exe"));
    //    driver = new ChromeDriver();
    //     driver.get("https://fmorales:k5rHD5RD@qawebadmin3.sterlingdirect.com/webadmin-ohs/");
    // }


    @Test
    public void msSql() {
        mssqltesting = new MsSql();
        lpMockLabTesting = new LpMockLab();
        webAdmin webadminpage = new webAdmin(driver);
        String specimendId = "FMVL1116"; //TODO: Change on each exercise
        String referenceId = "987947204"; //TODO: Change on each exercise
        char overallResult = 'P';

        //Execute Query
        mssqltesting.mssql("fmorales", "k5rHD5RD", referenceId); //TODO:get panel id
        //Execute Postman status
        int statusNumber = 0;
        while (statusNumber < 11) {
            statusNumber++;
            if (statusNumber != 6) {
                System.out.println("Status executed: "+ statusNumber);
                lpMockLabTesting.labCorpStatusPost(mssqltesting.sqlID, mssqltesting.sqlRegistrationID, statusNumber, specimendId);
            }
        }
        //Execute labCorpCocPost
        lpMockLabTesting.labCorpCocPost(mssqltesting.sqlID, mssqltesting.sqlRegistrationID, specimendId);
        //Execute labCorpResultPost
        lpMockLabTesting.labCorpResultPost(mssqltesting.sqlID, mssqltesting.sqlRegistrationID, specimendId, overallResult);
        //Execute GetToken
        lpMockLabTesting.intLpGetToken();
        //Execute provisionLPTicket
        lpMockLabTesting.provisionLPTicket(mssqltesting.ticketID, lpMockLabTesting.accessToken);
        //Execute labResultPostback
        lpMockLabTesting.ldResultPostBack(lpMockLabTesting.bodyRequest);

    }
}
