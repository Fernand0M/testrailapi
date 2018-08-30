package testing;

import org.testng.annotations.Test;
import pages.LpMockLab;
import pages.MsSql;

import java.util.concurrent.TimeUnit;

public class LPInternalTool {

    // ------- Variables -------------------------------------
    String userDB = ""; //TODO: Change with your credentials
    String passDB = ""; //TODO: Change with your credentials
    String specimendId = "RandomString"; //TODO: Change on each exercise
    String referenceId = "987953696"; //TODO: Change on each exercise
    char overallResult = 'P';

    MsSql mssqltesting;
    LpMockLab lpMockLabTesting;

    @Test
    public void labCorpLP() {
        mssqltesting = new MsSql();
        lpMockLabTesting = new LpMockLab();

        //Execute Query
        mssqltesting.mssql(userDB, passDB, referenceId);
        //Execute GetToken
        lpMockLabTesting.intLpGetToken();
        //Execute provisionLPTicket
        lpMockLabTesting.provisionLPTicket(mssqltesting.ticketID, lpMockLabTesting.accessToken);
        //Execute labResultPostback
        lpMockLabTesting.ldResultPostBack(lpMockLabTesting.bodyRequest);
        //Execute Postman status
        int statusNumber = 0;
        while (statusNumber < 11) {
            statusNumber++;
            if (statusNumber != 6) {
                System.out.println("Status executed: " + statusNumber);
                lpMockLabTesting.labCorpStatusPost(mssqltesting.sqlID, mssqltesting.sqlRegistrationID, statusNumber, specimendId);
            }
        }
        //Execute labCorpCocPost
        lpMockLabTesting.labCorpCocPost(mssqltesting.sqlID, mssqltesting.sqlRegistrationID, specimendId);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
        }
        //Execute labCorpResultPost
        lpMockLabTesting.labCorpResultPost(mssqltesting.sqlID, mssqltesting.sqlRegistrationID, specimendId, overallResult);
    }

    @Test
    public void labCorpLP2() {
        mssqltesting = new MsSql();
        lpMockLabTesting = new LpMockLab();

        //Execute Query
        mssqltesting.mssql(userDB, passDB, referenceId);
        //Execute GetToken
        lpMockLabTesting.intLpGetToken();
        //Execute provisionLPTicket
        lpMockLabTesting.provisionLPTicket(mssqltesting.ticketID, lpMockLabTesting.accessToken);
        //Execute labResultPostback
        lpMockLabTesting.ldResultPostBack(lpMockLabTesting.bodyRequest);
    }

}
