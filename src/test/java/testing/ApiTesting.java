package testing;

import org.testng.annotations.Test;

import pages.Api;

public class ApiTesting {
	Api apiTesting;

	@Test
	public void apiTesting() {
		apiTesting = new Api();
		apiTesting.dhsup2021("http://dvm-fmorales1.aws.talentwise.com/integration/sbc/dhs_postback.php?op=billing",
				"ZGhzYmlsbGluZzpMYWJEaXJlY3QyMDE4IQ==t",
				"You are not authorized to send billing data for this platform");
	}

}
