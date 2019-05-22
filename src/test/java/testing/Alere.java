package testing;

import org.testng.annotations.Test;
import pages.LpMockLab;
import pages.MsSql;

import java.util.concurrent.TimeUnit;

public class Alere {

    // ------- Variables -------------------------------------
    String userDB = "fmorales"; //TODO: Change with your credentials
    String passDB = "Softtek04!"; //TODO: Change with your credentials
    String specimendId = "FERNANDOV44"; //TODO: Change on each exercise
    String referenceId = "988161434"; //TODO: Change on each exercise
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
    public void Database() {
        mssqltesting = new MsSql();
        //Execute Query
        mssqltesting.devdb("readWrite", "RW5b147");
    }


    @Test
    public void alereStep1() {
        mssqltesting = new MsSql();
        lpMockLabTesting = new LpMockLab();

        //Execute Query
        mssqltesting.mssql(userDB, passDB, referenceId);
        //Execute GetToken
         lpMockLabTesting.intLpGetToken();
        //Execute provisionLPTicket
        lpMockLabTesting.provisionLPTicket(mssqltesting.ticketID, lpMockLabTesting.accessToken);

    }
}

