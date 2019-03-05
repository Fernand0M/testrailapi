package testing;

import org.testng.annotations.Test;
import pages.LpMockLab;
import pages.MsSql;

public class Quest {

    // ------- Variables -------------------------------------
    String userDB = ""; //TODO: Change with your credentials
    String passDB = "!"; //TODO: Change with your credentials
    String specimendId = "FERNANDOV55"; //TODO: Change on each exercise
    String referenceId = "988161433"; //TODO: Change on each exercise
    char overallResult = 'P';

    MsSql mssqltesting;
    LpMockLab lpMockLabTesting;

    @Test
    public void DatabaseSearch() {
        mssqltesting = new MsSql();
        //Execute Query
        mssqltesting.mssql(userDB, passDB, referenceId);
    }


    @Test
    public void questStep1() {
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
        lpMockLabTesting.QuestStatusPost(mssqltesting.sqlRegistrationID, "OK");
        lpMockLabTesting.QuestCocPost(mssqltesting.sqlRegistrationID, specimendId);
        lpMockLabTesting.QuestResultPost(specimendId);
    }


    @Test
    public void questStep2() {
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
