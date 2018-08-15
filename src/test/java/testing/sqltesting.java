package testing;

import org.testng.annotations.Test;
import pages.LpMockLab;
import pages.MsSql;

public class sqltesting {
    MsSql mssqltesting;
    LpMockLab lpMockLabTesting;


    @Test
    public void msSql(){
        mssqltesting = new MsSql();
        lpMockLabTesting = new LpMockLab();
        //Execute Query
        mssqltesting.mssql("fmorales","Password","987946545");
        //Execute Postman status
        int statusNumber = 0;
        while (statusNumber < 5){
            statusNumber++;
            lpMockLabTesting.labCorpStatusPost(mssqltesting.sqlID,mssqltesting.sqlRegistrationID,statusNumber);
        }

    }
}
