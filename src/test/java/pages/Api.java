package pages;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Api {

    public void dhsup2021(String strUrl, String strToken, String strResponse) {
        try {
            HttpResponse<String> response = Unirest.post(strUrl)
                    .header("Content-Type", "application/json")
                    .header("Authorization", strToken)
                    .header("Cache-Control", "no-cache")
                    .header("Postman-Token", "b328b085-e6f8-4765-8d20-12f5a75a5420")
                    .body("[{ \"BatchId\": \"A331231231\", \"CustomerId\": \"95\", \"CustomerName\": \"Automationohsqa3\", \"RequestId\": \"9484544\", \"GUID\": \"A331-2312-9031-A643\", \"ApplicantName\": \"FName_010805440 LName_010805440\", \"CocNumber\": \"Test0108055111\", \"SpecimenCollectionDate\": \"11:00.0\", \"CollectionSite\": \"LPS0199\", \"Laboratory\": \"Labcorp\", \"Result\": \"POSITIVE\", \"ProductId\": \"20\", \"CollectFee\": \"1\", \"Charge\": \"2.00\", \"SchedulingFee\": \"3.00\", \"NetworkFee\": \"4.00\", \"CollectionFee\": \"5.00\", \"CollectionFeeAdjusted\": \"6.00\", \"LabFee\": \"7.00\", \"ManualFee\": \"8.00\", \"FinalCharge\": \"9.00\", \"FeeAppliedAfterHours\": \"10.00\", \"FeeAppliedAlcohol\": \"11.00\", \"FeeAppliedBlood\": \"12.00\", \"FeeAppliedDotPhys\": \"13.00\", \"CollectionSiteFeeDotUrine\": \"14.00\", \"CollectionSiteFeeDUrine\": \"15.00\", \"CollectionSiteFeeOnSiteAlc\": \"16.00\", \"CollectionSiteFeeOnSiteDrug\": \"17.00\", \"CollectionSiteFeeOral\": \"18.00\", \"CollectionSiteFeePhysExam\": \"19.00\", \"Internal_Comments\": \"Diluted [DI] - 100154550. TEST OF VIEWING CO []\", \"PlatformId\": \"S1\" } ] \r\n")
                    .asString();
            String resp = response.getBody();
            resp = resp.replaceAll("\"", "");
            System.out.println(resp);

            // Pass Condition
            if (!resp.equals(strResponse)) {
                throw new CaseFailedException("Response is not correctly " + response.getStatus());
            }
        } catch (
                UnirestException e) {
            throw new CaseFailedException("Connection failed");
        }
    }

}
