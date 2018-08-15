package testing;

import org.testng.annotations.Test;
import pages.LpMockLab;

public class ApiTesting {
    LpMockLab lpMockLabTesting;

    @Test
    public void apiTesting() {
        lpMockLabTesting = new LpMockLab();
        //lpMockLabTesting.example("http://dvm-fmorales1.aws.talentwise.com/integration/sbc/dhs_postback.php?op=billing",
        //        "ZGhzYmlsbGluZzpMYWJEaXJlY3QyMDE4IQ==t",
        //        "You are not authorized to send billing data for this platform");
        lpMockLabTesting.labCorpResultPost();
    }

}
