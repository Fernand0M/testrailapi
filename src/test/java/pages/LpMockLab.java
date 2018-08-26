package pages;

import Utils.PropertiesReader;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class LpMockLab {
    public String accessToken;
    public String bodyRequest;
    public String state;
    PropertiesReader propreader = new PropertiesReader();
    String environment = System.getProperty("hostname");

    public void example(String strUrl, String strToken, String strResponse) {
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

    // Lab corp
    public void labCorpResultPost(String sqlID, String regID, String specimendId, char overallResult) {
        try {
            HttpResponse<String> response = Unirest.post("http://qatlsvc03:8080/vif-receiver/results/lab/labcorp")
                    .header("Content-Type", "application/xml")
                    .header("Cache-Control", "no-cache")
                    .header("Postman-Token", "201e0528-ace2-40b2-9775-571ece60cc14")
                    .body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n<soapenv:Header/>\r\n<soapenv:Body>\r\n<result xmlns=\"http://cws.ots.labcorp.com\">\r\n<userId>labcorp</userId>\r\n<password>p@55w0rd</password>\r\n<result>\r\n<accessionNumber>0572854881</accessionNumber>\r\n<accountLocationCode>100041</accountLocationCode>\r\n<accountLocationName>AERO CONTROL</accountLocationName>\r\n<accountLocationPhone>2537353350</accountLocationPhone>\r\n<accountName>HEALTHFORCE PARTNERS CORPORATE</accountName>\r\n<accountNumber>100041</accountNumber>\r\n<certifyingScientist/>\r\n    <clientRegistrationId>" + sqlID + "</clientRegistrationId>\r\n  <collectionSiteAddress1>17420 NW FWY.</collectionSiteAddress1>\r\n   <collectionSiteAddress2/>\r\n  <collectionSiteAddress3>63-1232342</collectionSiteAddress3>\r\n  <collectionSiteCity>HOUSTON</collectionSiteCity>\r\n   <collectionSiteId>S05551118</collectionSiteId>\r\n   <collectionSiteName>US HEALTHWORKS-TX</collectionSiteName>\r\n <collectionSiteState>TX</collectionSiteState>\r\n <collectionSiteZip>77040</collectionSiteZip>\r\n <collectorCOCcomments>\r\n  <abbreviation/>\r\n  <commentText>100154550.  TEST OF VIEWING CO</commentText>\r\n  <commentType>DI</commentType>\r\n </collectorCOCcomments>\r\n <collectorName>Harit</collectorName>\r\n<collectorPhone>7134460144</collectorPhone>\r\n<dateTimeSpecimenCollection>2014-11-19T18:11:00.000-00:00</dateTimeSpecimenCollection>\r\n <dateTimeSpecimenReceivedAtLab>2014-11-19T18:11:00.000-00:00</dateTimeSpecimenReceivedAtLab>\r\n <dateTimeSpecimenReportedFromLab>2014-11-14T19:11:00.000-00:00</dateTimeSpecimenReportedFromLab>\r\n <donorId/>\r\n <donorNameFirst>testFn</donorNameFirst>\r\n <donorNameLast>testLn</donorNameLast>\r\n  <donorPhone>3323431234</donorPhone>\r\n  <donorReasonForTest>RA</donorReasonForTest>\r\n <donorSSN>123412341</donorSSN>\r\n <dotRegulatedAccount>0</dotRegulatedAccount>\r\n  <dotSpecimenResult>  </dotSpecimenResult>\r\n <employerNameFromCCF/>\r\n  <labcorpRegistrationNumber>" + regID + "</labcorpRegistrationNumber>\r\n <mroNameFromCCF/>\r\n <originalLabCorpAccessionNumber/>\r\n  <overallSpecimenResult>" + overallResult + "</overallSpecimenResult>\r\n  <panelId>3872030031</panelId>\r\n <poctProductId>  </poctProductId>\r\n<priorAccount/>\r\n  <specimenId>" + specimendId + "</specimenId>\r\n  <splitSpecimenReceived>0</splitSpecimenReceived>\r\n <temperature/>\r\n  <temperatureInRange>1</temperatureInRange>\r\n  <testResults>\r\n  <confirmCutoff>\r\n </confirmCutoff>\r\n  <resultQualitative>N</resultQualitative>\r\n<resultQuantitative>\r\n</resultQuantitative>\r\n <screeningCutoff>\r\n  </screeningCutoff>\r\n  <drugId>001100</drugId>\r\n  <units>ug/mL</units>\r\n  <referenceInterval>200</referenceInterval>\r\n  </testResults>\r\n <testResults>\r\n  <confirmCutoff>000020</confirmCutoff>\r\n  <resultQualitative>N</resultQualitative>\r\n  <resultQuantitative/>\r\n  <screeningCutoff>20</screeningCutoff>\r\n <drugId>003000</drugId>\r\n  <units>mg/dL</units>\r\n <referenceInterval xsi:nil=\"true\"/>\r\n </testResults>\r\n   <testResults>\r\n  <confirmCutoff>000300</confirmCutoff>\r\n  <resultQualitative>N</resultQualitative>\r\n   <resultQuantitative/>\r\n   <screeningCutoff>300</screeningCutoff>\r\n  <drugId>004000</drugId>\r\n <units>ng/mL</units>\r\n  <referenceInterval xsi:nil=\"true\"/>\r\n </testResults>\r\n <testResults>\r\n<confirmCutoff>000100</confirmCutoff>\r\n <resultQualitative>N</resultQualitative>\r\n  <resultQuantitative/>\r\n  <screeningCutoff>300</screeningCutoff>\r\n <drugId>007000</drugId>\r\n <units>ng/mL</units>\r\n<referenceInterval xsi:nil=\"true\"/>\r\n</testResults>\r\n<testResults>\r\n <confirmCutoff>000015</confirmCutoff>\r\n<resultQualitative>N</resultQualitative>\r\n<resultQuantitative/>\r\n<screeningCutoff>50</screeningCutoff>\r\n <drugId>006000</drugId>\r\n<units>ng/mL</units>\r\n<referenceInterval xsi:nil=\"true\"/>\r\n</testResults>\r\n<testResults>\r\n<confirmCutoff>000015</confirmCutoff>\r\n<resultQualitative>N</resultQualitative>\r\n<resultQuantitative/>\r\n<screeningCutoff>50</screeningCutoff>\r\n<drugId>002000</drugId>\r\n<units>ng/mL</units>\r\n<referenceInterval xsi:nil=\"true\"/>\r\n</testResults>\r\n<testResults>\r\n<confirmCutoff>000015</confirmCutoff>\r\n<resultQualitative>N</resultQualitative>\r\n<resultQuantitative/>\r\n<screeningCutoff>50</screeningCutoff>\r\n<drugId>008000</drugId>\r\n<units>ng/mL</units>\r\n<referenceInterval xsi:nil=\"true\"/>\r\n</testResults>\r\n<transmissionType>01</transmissionType>\r\n<pscCollectionSite>0</pscCollectionSite>\r\n<testingLabId>RTP</testingLabId>\r\n<donorNameMiddleInitial/>\r\n</result>\r\n</result>\r\n</soapenv:Body>\r\n</soapenv:Envelope>\r\n")
                    .asString();
            String resp = response.getBody();
            resp = resp.replaceAll("\"", "");
            System.out.println("Labcorp Result Post Executed log :");
            System.out.println(resp);
        } catch (
                UnirestException e) {
            throw new CaseFailedException("Connection failed");
        }
    }

    public void labCorpStatusPost(String sqlID, String regID, int statusNumber, String specimendId) {
        try {
            HttpResponse<String> response = Unirest.post("http://qatlsvc03:8080/vif-receiver/results/status/labcorp")
                    .header("Content-Type", "application/xml")
                    .header("Cache-Control", "no-cache")
                    .header("Postman-Token", "9ffedc59-6c4b-45e1-ba98-0cb1589c2048")
                    .body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n\t<soapenv:Header/>\r\n\t<soapenv:Body>\r\n\t\t<status xmlns=\"http://cws.ots.labcorp.com\">\r\n\t\t\t<userId>labcorp</userId>\r\n\t\t\t<password>p@55w0rd</password>\r\n\t\t\t<accountNumber>100041</accountNumber>\r\n\t\t\t<accountLocationCode>100041</accountLocationCode>\r\n\t\t\t<clientRegistrationId>" + sqlID + "</clientRegistrationId>\r\n\t\t\t<labcorpRegistrationNumber>" + regID + "</labcorpRegistrationNumber>\r\n\t\t\t<specimenId>" + specimendId + "</specimenId>\r\n\t\t\t<status>" + statusNumber + "</status>\r\n\t\t</status>\r\n\t</soapenv:Body>\r\n</soapenv:Envelope>")
                    .asString();
            String resp = response.getBody();
            resp = resp.replaceAll("\"", "");
            System.out.println(resp);
        } catch (
                UnirestException e) {
            throw new CaseFailedException("Connection failed");
        }
    }

    public void labCorpCocPost(String sqlID, String regID, String specimendId) {
        String cocBody = (propreader.getProperty("labcorpCocBody"));
        try {
            HttpResponse<String> response = Unirest.post("http://qatlsvc03:8080/vif-receiver/results/coc/labcorp")
                    .header("Content-Type", "application/xml")
                    .header("Cache-Control", "no-cache")
                    .header("Postman-Token", "09de4085-23cf-4b21-ab7d-c1c4517158bf")
                    .body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n\t<soapenv:Header/>\r\n\t<soapenv:Body>\r\n\t\t<coc xmlns=\"http://cws.ots.labcorp.com\">\r\n\t\t\t<userId>labcorp</userId>\r\n\t\t\t<password>p@55w0rd</password>\r\n\t\t\t<accountNumber>100041</accountNumber>\r\n\t\t\t<accountLocationCode>100041</accountLocationCode>\r\n\t\t\t<clientRegistrationId>" + sqlID + "</clientRegistrationId>\r\n\t\t\t<labcorpRegistrationNumber>" + regID + "</labcorpRegistrationNumber>\r\n\t\t\t<specimenId>" + specimendId + "</specimenId>\r\n\t\t\t" + cocBody)
                    .asString();

            String resp = response.getBody();
            resp = resp.replaceAll("\"", "");
            System.out.println("Labcorp coc Executed log :");
            System.out.println(resp);
        } catch (
                UnirestException e) {
            throw new CaseFailedException("Connection failed");
        }
    }

    // Escreen
    public void EscreenStatusPost(String sqlID, String regID, int statusNumber, String specimendId) {
        try {
            HttpResponse<String> response = Unirest.post("http://qatlsvc03:8080/vif-receiver/results/status/alere-escreen")
                    .header("Content-Type", "application/xml")
                    .header("Cache-Control", "no-cache")
                    .header("Postman-Token", "0573e182-c083-4050-b034-745901c272ba")
                    .body("<eScreenData TransmissionID=\"53a21177-fa69-4db3-beb5-3e279d7f421d\">\r\n\t<RecordCount>1</RecordCount>\r\n\t<Version>1.0</Version>\r\n\t<DateReported>1/25/2017</DateReported>\r\n\t<TimeReported>4:45:35 PM</TimeReported>\r\n\t<SpecimenStatus Status=\"" + statusNumber + "\">\r\n\t\t<eScreenID>204650730</eScreenID>\r\n\t\t<ConfirmationNumber>" + regID + "</ConfirmationNumber>\r\n\t\t<eScreenClientAccount>999999</eScreenClientAccount>\r\n\t\t<eScreenClientSubAccount>63</eScreenClientSubAccount>\r\n\t\t<LabName>ALERE</LabName>\r\n\t\t<LabAccount>ESCH01</LabAccount>\r\n\t\t<ClientName>Lithia Motors</ClientName>\r\n\t\t<InternalClientID>1</InternalClientID>\r\n\t\t<ElectronicClientID>6308</ElectronicClientID>\r\n\t\t<LocationInfo>Providence Occupational Health-Northwest</LocationInfo>\r\n\t\t<CollectionSite>13792</CollectionSite>\r\n\t\t<AccessionNum/>\r\n\t\t<SpecimenType>U</SpecimenType>\r\n\t\t<DonorName>FName_160107284, LName_160107284</DonorName>\r\n\t\t<SSN>123412341</SSN>\r\n\t\t<OtherID/>\r\n\t\t<OtherIDType/>\r\n\t\t<ExternalDonorID>" + sqlID + "</ExternalDonorID>\r\n\t\t<DOB>4/26/1990</DOB>\r\n\t\t<HomePhone/>\r\n\t\t<HomePhoneExt/>\r\n\t\t<WorkPhone>925-961-2659</WorkPhone>\r\n\t\t<WorkPhoneExt/>\r\n\t\t<ChainOfCustody>TEST394884</ChainOfCustody>\r\n\t\t<CollectionDate>1/25/2017</CollectionDate>\r\n\t\t<CollectionTime>4:45:26 PM</CollectionTime>\r\n\t\t<LabReceivedDate>1/25/2017</LabReceivedDate>\r\n\t\t<LabReceivedTime>4:45:26 PM</LabReceivedTime>\r\n\t\t<LabReportDate>1/25/2017</LabReportDate>\r\n\t\t<LabReportTime>4:45:26 PM</LabReportTime>\r\n\t\t<VerificationDate/>\r\n\t\t<VerificationTime/>\r\n\t\t<ReasonForTest>PE</ReasonForTest>\r\n\t\t<SpecimenCollector>Petry, Mytoka</SpecimenCollector>\r\n\t\t<PrintedComments/>\r\n\t\t<Regulation>N</Regulation>\r\n\t\t<RegulationType/>\r\n\t</SpecimenStatus>\r\n</eScreenData>")
                    .asString();
            String resp = response.getBody();
            resp = resp.replaceAll("\"", "");
            System.out.println(resp);
        } catch (
                UnirestException e) {
            throw new CaseFailedException("Connection failed");
        }
    }

    public void EscreenResultPost() {
        try {
            HttpResponse<String> response = Unirest.post("http://qatlsvc03:8080/vif-receiver/results/lab/alere-escreen")
                    .header("Content-Type", "application/xml")
                    .header("Cache-Control", "no-cache")
                    .header("Postman-Token", "e0710f9e-d23a-462a-ad61-a6479bc8bf0c")
                    .body("<?xml version=\"1.0\"?>\r\n<eScreenData TransmissionID=\"53a21177-fa69-4db3-beb5-3e279d7f421d\">\r\n  <Version>1.0</Version>\r\n  <DateReported>6/22/2016</DateReported>\r\n  <TimeReported>09:57:46.4294194</TimeReported>\r\n  <SpecimenResult Disposition=\"2\">\r\n    <eScreenID>204650730</eScreenID>\r\n    <ConfirmationNumber>12345</ConfirmationNumber>\r\n    <LabLocationCode/>\r\n    <Dilute>0</Dilute>\r\n    <eScreenClientAccount>999999</eScreenClientAccount>\r\n    <eScreenClientSubAccount>63</eScreenClientSubAccount>\r\n    <CostCenter/>\r\n    <LabName>ALERE</LabName>\r\n    <LabAccount>ESCH01</LabAccount>\r\n    <ClientName>automationqa</ClientName>\r\n    <InternalClientID>99</InternalClientID>\r\n    <ElectronicClientID>4913</ElectronicClientID>\r\n    <LocationInfo>69316 CENTERS FOR FAMILY HEALTH - SAVIERS 2921 SAVIERS RD  OXNARD CA 93033 - DC</LocationInfo>\r\n    <CollectionSite>25734</CollectionSite>\r\n    <CollectionSiteInNetwork>1</CollectionSiteInNetwork>\r\n    <ECupCollection>1</ECupCollection>\r\n    <CollectionSitePhoneNumber>805-487-5585</CollectionSitePhoneNumber>\r\n    <AccessionNum>12641297</AccessionNum>\r\n    <DonorName>Escreen, Poke</DonorName>\r\n    <SSN>988676883</SSN>\r\n    <OtherID>CDL F2416790</OtherID>\r\n    <OtherIDType>D</OtherIDType>\r\n    <ExternalDonorID/>\r\n    <DOB>8/22/1993</DOB>\r\n    <HomePhone/>\r\n    <HomePhoneExt/>\r\n    <WorkPhone>805-216-8489</WorkPhone>\r\n    <WorkPhoneExt/>\r\n    <ChainOfCustody>TEST1999</ChainOfCustody>\r\n    <CollectionDate>6/14/2016</CollectionDate>\r\n    <CollectionTime>1:55:00 PM</CollectionTime>\r\n    <LabReceivedDate>6/16/2016</LabReceivedDate>\r\n    <LabReceivedTime>8:00:00 AM</LabReceivedTime>\r\n    <LabReportDate>6/20/2016</LabReportDate>\r\n    <LabReportTime>12:10:00 AM</LabReportTime>\r\n    <VerificationDate>6/21/2016</VerificationDate>\r\n    <VerificationTime>1:19:18 PM</VerificationTime>\r\n    <ReasonForTest>PE</ReasonForTest>\r\n    <SpecimenCollector>Miller, Josie</SpecimenCollector>\r\n    <PrintedComments/>\r\n    <Regulation>N</Regulation>\r\n    <RegulationType></RegulationType>\r\n\t\t<!--\r\n\t\tRSPA\r\n\t\tFAA\r\n\t\tFRA\r\n\t\tFTA\r\n\t\tFHWA\r\n\t\tUSCG\r\n\t\tFMCSA\r\n\t\t-->\t\t\r\n    <COCConfirmationDate>08/08/2016</COCConfirmationDate>\r\n    <COCConfirmationOperator/>\r\n    <MRO>\r\n      <Name>Dr. Stephen Kracht</Name>\r\n      <Address>7500 W. 110th St, Ste 400A</Address>\r\n      <City>Overland Park</City>\r\n      <State>KS</State>\r\n      <Zip>66225</Zip>\r\n      <Phone>888-382-2281</Phone>\r\n    </MRO>\r\n\t<Analyte Disposition='N'>\r\n\t\t<PanelID>1005</PanelID>\r\n\t\t<AnalyteID>100</AnalyteID>\r\n\t\t<AnalyteName>Marijuana</AnalyteName>\r\n\t\t<SpecimenType>H</SpecimenType>\r\n\t\t<ScreeningCutoffValue>50</ScreeningCutoffValue>\r\n\t\t<ScreeningCutoffUnit>ng/ml</ScreeningCutoffUnit>\r\n\t\t<ConfirmationCutoffValue/>\r\n\t\t<ConfirmationCutoffUnit/>\r\n\t\t<Quantity>\r\n\t\t</Quantity>\r\n\t</Analyte>\r\n\t<Analyte Disposition='N'>\r\n\t\t<PanelID>1005</PanelID>\r\n\t\t<AnalyteID>200</AnalyteID>\r\n\t\t<AnalyteName>Cocaine</AnalyteName>\r\n\t\t<SpecimenType>H</SpecimenType>\r\n\t\t<ScreeningCutoffValue>300</ScreeningCutoffValue>\r\n\t\t<ScreeningCutoffUnit>ng/ml</ScreeningCutoffUnit>\r\n\t\t<ConfirmationCutoffValue/>\r\n\t\t<ConfirmationCutoffUnit/>\r\n\t\t<Quantity>\r\n\t\t</Quantity>\r\n\t</Analyte>\r\n\t<Analyte Disposition='N'>\r\n\t\t<PanelID>1005</PanelID>\r\n\t\t<AnalyteID>300</AnalyteID>\r\n\t\t<AnalyteName>Amphetamines</AnalyteName>\r\n\t\t<SpecimenType>H</SpecimenType>\r\n\t\t<ScreeningCutoffValue>1000</ScreeningCutoffValue>\r\n\t\t<ScreeningCutoffUnit>ng/ml</ScreeningCutoffUnit>\r\n\t\t<ConfirmationCutoffValue/>\r\n\t\t<ConfirmationCutoffUnit/>\r\n\t\t<Quantity>\r\n\t\t</Quantity>\r\n\t</Analyte>\r\n\t<Analyte Disposition='N'>\r\n\t\t<PanelID>1005</PanelID>\r\n\t\t<AnalyteID>400</AnalyteID>\r\n\t\t<AnalyteName>Opiates</AnalyteName>\r\n\t\t<SpecimenType>H</SpecimenType>\r\n\t\t<ScreeningCutoffValue>2000</ScreeningCutoffValue>\r\n\t\t<ScreeningCutoffUnit>ng/ml</ScreeningCutoffUnit>\r\n\t\t<ConfirmationCutoffValue/>\r\n\t\t<ConfirmationCutoffUnit/>\r\n\t\t<Quantity>\r\n\t\t</Quantity>\r\n\t</Analyte>\r\n\t<Analyte Disposition='N'>\r\n\t\t<PanelID>1005</PanelID>\r\n\t\t<AnalyteID>500</AnalyteID>\r\n\t\t<AnalyteName>PCP</AnalyteName>\r\n\t\t<SpecimenType>H</SpecimenType>\r\n\t\t<ScreeningCutoffValue>25</ScreeningCutoffValue>\r\n\t\t<ScreeningCutoffUnit>ng/ml</ScreeningCutoffUnit>\r\n\t\t<ConfirmationCutoffValue/>\r\n\t\t<ConfirmationCutoffUnit/>\r\n\t\t<Quantity>\r\n\t\t</Quantity>\r\n\t</Analyte>\r\n\r\n  </SpecimenResult>\r\n  <RecordCount>1</RecordCount>\r\n</eScreenData>\r\n")
                    .asString();
            String resp = response.getBody();
            resp = resp.replaceAll("\"", "");
            System.out.println(resp);
        } catch (
                UnirestException e) {
            throw new CaseFailedException("Connection failed");
        }
    }

    // Quest
    public void QuestStatusPost() {
        try {
            HttpResponse<String> response = Unirest.post("http://qatlsvc03:8080/vif-receiver/results/status/quest")
                    .header("Content-Type", "application/xml")
                    .header("Cache-Control", "no-cache")
                    .header("Postman-Token", "ef485f3d-298e-4311-996d-aa77f7c3ba08")
                    .body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:qcs=\"https://qcs-uat.questdiagnostics.com\">\r\n\t<soapenv:Header/>\r\n\t<soapenv:Body>\r\n\t\t<qcs:ReceiveCollectionStatus>\r\n\t\t\t<userName>quest-VIF-QA</userName>\r\n\t\t\t<password>p@55w0rd</password>\r\n\t\t\t<collectionstatusXML>\r\n\t\t\t\t<![CDATA[<Status>\t<SendingFacility>Sterling</SendingFacility>\t<ReferenceTestID>452318</ReferenceTestID>\t<CollectionStatus>ONSITE</CollectionStatus>\t<CollectorComments></CollectorComments></Status>]]>\r\n\t\t\t</collectionstatusXML>\r\n\t\t</qcs:ReceiveCollectionStatus>\r\n\t</soapenv:Body>\r\n</soapenv:Envelope>")
                    .asString();
            String resp = response.getBody();
            resp = resp.replaceAll("\"", "");
            System.out.println(resp);
        } catch (
                UnirestException e) {
            throw new CaseFailedException("Connection failed");
        }
    }

    public void QuestCocPost() {
        try {
            HttpResponse<String> response = Unirest.post("http://qatlsvc03:8080/vif-receiver/results/coc/quest")
                    .header("Content-Type", "application/xml")
                    .header("Cache-Control", "no-cache")
                    .header("Postman-Token", "e88209c4-3c3a-41a2-a38e-16878b3e9b6e")
                    .body(propreader.getProperty("QuestCocBody"))
                    .asString();
            String resp = response.getBody();
            resp = resp.replaceAll("\"", "");
            System.out.println(resp);
        } catch (
                UnirestException e) {
            throw new CaseFailedException("Connection failed");
        }
    }

    public void QuestResultPost() {
        try {
            HttpResponse<String> response = Unirest.post("http://qatlsvc03:8080/vif-receiver/results/lab/quest")
                    .header("Content-Type", "application/xml")
                    .header("Cache-Control", "no-cache")
                    .header("Postman-Token", "c4385067-2533-490d-bf96-52659210fb7c")
                    .body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:qcs=\"https://qcs-uat.questdiagnostics.com\">\r\n<soapenv:Header/>\r\n<soapenv:Body>\r\n<qcs:ReceiveLabTestResult>\r\n<userName>quest-VIF-QA</userName>\r\n<password>p@55w0rd</password>\r\n<LabTestResultXml> \r\n<Donor>\r\n<ResultState>0</ResultState>\r\n<OrderClient>\r\n<ClientNumber>41107405</ClientNumber>\r\n<ClientName>YMCA OF GREATER HOUSTON</ClientName>\r\n<ClientAttn>HR MANAGER</ClientAttn>\r\n<ClientAccountDescription>SAP</ClientAccountDescription>\r\n<Address>\r\n<StreetAddress>2600 N LOOP WEST STE 300, </StreetAddress>\r\n<City>HOUSTON</City>\r\n<State>TX</State>\r\n<Zip>77092</Zip>\r\n<Phone>713-758-9167</Phone>\r\n<Fax/>\r\n</Address>\r\n</OrderClient>\r\n<Specimen>\r\n<RequisitionNumber>875880226</RequisitionNumber>\r\n<UniqueRequisitionID>4537208273746CKS</UniqueRequisitionID>\r\n<LabAccessionNumber>273746C</LabAccessionNumber>\r\n<DonorPrimaryID>767676761</DonorPrimaryID>\r\n<DonorSecondaryID>WFD, Ivan</DonorSecondaryID>\r\n<ReasonForTest>PRE-EMPLOYMENT</ReasonForTest>\r\n<DonorVerificationFlag>1</DonorVerificationFlag>\r\n<SpecimenCollectionDate>20160602</SpecimenCollectionDate>\r\n<SpecimenCollectionTime>1126</SpecimenCollectionTime>\r\n<SpecimenReceivedDate>20160603</SpecimenReceivedDate>\r\n<SpecimenReceivedTime>0501</SpecimenReceivedTime>\r\n</Specimen>\r\n<ClientSiteLocation>\r\n<ClientSiteLocationID/>\r\n<Address>\r\n<Name/>\r\n<StreetAddress/>\r\n<StreetAddress2/>\r\n<StreetAddress3/>\r\n</Address>\r\n</ClientSiteLocation>\r\n<Reporting>\r\n<ReportDate>20160604</ReportDate>\r\n<ReportTime>1011</ReportTime>\r\n<ResultsIndicator>YNNNNNN</ResultsIndicator>\r\n<ReportVerificationTimestamp>201606041002</ReportVerificationTimestamp>\r\n<SpecimenID>TEST11000</SpecimenID>\r\n<ReportComments>Testing purpose           <ReportComment/>\r\n<ReportComment/>\r\n</ReportComments>\r\n</Reporting>\r\n<MROClient>\r\n<ClientNumber>41107405</ClientNumber>\r\n<ClientName>DR RICHARD WORONOFF</ClientName>\r\n<ClientAttn>STERLING MED REVIEW XML</ClientAttn>\r\n<Address>\r\n<StreetAddress>6111 OAK TREE BLVD, </StreetAddress>\r\n<City>INDEPENDENCE</City>\r\n<State>OH</State>\r\n<Zip>44131</Zip>\r\n<Phone>800-853-3228</Phone>\r\n<Fax>646-829-3501</Fax>\r\n</Address>\r\n</MROClient>\r\n<QuestLab>\r\n<QuestLabID>KS</QuestLabID>\r\n<QuestLabName>Quest Diagnostics-Lenexa</QuestLabName>\r\n<CertifiedScientist>KSEB06</CertifiedScientist>\r\n<Address>\r\n<StreetAddress>10101 Renner Blvd</StreetAddress>\r\n<City>Lenexa</City>\r\n<State>KS</State>\r\n<Zip>66219</Zip>\r\n</Address>\r\n</QuestLab>\r\n<CollectionSite>\r\n<CollectionSiteID>SGL</CollectionSiteID>\r\n<Address>\r\n<Name>Quest Diagnostics-Sugarland PSC</Name>\r\n<StreetAddress>15259 Southwest Freeway</StreetAddress>\r\n<StreetAddress2/>\r\n<City>Sugar Land</City>\r\n<State>TX</State>\r\n<Zip>77478</Zip>\r\n<Phone>281-494-4553</Phone>\r\n<Fax>281-494-4563</Fax>\r\n</Address>\r\n</CollectionSite>\r\n<Results>\r\n<Result>\r\n<UnitCodeMne>5867090015</UnitCodeMne>\r\n<UnitCodeNumber>717847</UnitCodeNumber>\r\n<UnitCodeReportName1>SUBSTANCE ABUSE PANEL 5-</UnitCodeReportName1>\r\n<UnitCodeReportName2>50, OP2000</UnitCodeReportName2>\r\n<UnitCodeReqShortBillName>SAP 5-50/2000</UnitCodeReqShortBillName>\r\n<UnitCodeRefex/>\r\n<UnitCodeQBSBillCode>0006405</UnitCodeQBSBillCode>\r\n<ProfileCodeMne/>\r\n<TestCodeMne>AMP</TestCodeMne>\r\n<TestCodeName>AMPHETAMINES (1000 ng/mL SCREEN)</TestCodeName>\r\n<TestCodeNumber>72431</TestCodeNumber>\r\n<TestCodeType>S</TestCodeType>\r\n<ResultStatus>D</ResultStatus>\r\n<ClinicalStatus>K</ClinicalStatus>\r\n<ResultValue></ResultValue>\r\n<UnitsOfMeasure/>\r\n<ReferenceRangeLow/>\r\n<ReferenceRangeHigh/>\r\n<ReferenceRange1></ReferenceRange1>\r\n<ReferenceRange2/>\r\n<SpecimenType>R</SpecimenType>\r\n<OrderableType>SAP</OrderableType>\r\n<ScreeningCutoff>1000</ScreeningCutoff>\r\n<ConfirmationCutoff>500</ConfirmationCutoff>\r\n<GCMSLevel/>\r\n<ClassTestCodeMne/>\r\n<ClassTestCodeCutoff/>\r\n<AlphaInformation>\r\n<ResultType>A</ResultType>\r\n<AlphaResult>NEGATIVE</AlphaResult>\r\n<MessageCode/>\r\n<MessageCategory/>\r\n</AlphaInformation>\r\n</Result>\r\n<Result>\r\n<UnitCodeMne>5867090015</UnitCodeMne>\r\n<UnitCodeNumber>717847</UnitCodeNumber>\r\n<UnitCodeReportName1>SUBSTANCE ABUSE PANEL 5-</UnitCodeReportName1>\r\n<UnitCodeReportName2>50, OP2000</UnitCodeReportName2>\r\n<UnitCodeReqShortBillName>SAP 5-50/2000</UnitCodeReqShortBillName>\r\n<UnitCodeRefex/>\r\n<UnitCodeQBSBillCode>0006405</UnitCodeQBSBillCode>\r\n<ProfileCodeMne/>\r\n<TestCodeMne>COC</TestCodeMne>\r\n<TestCodeName>COCAINE METABOLITES </TestCodeName>\r\n<TestCodeNumber>72432</TestCodeNumber>\r\n<TestCodeType>S</TestCodeType>\r\n<ResultStatus>D</ResultStatus>\r\n<ClinicalStatus>K</ClinicalStatus>\r\n<ResultValue/>\r\n<UnitsOfMeasure/>\r\n<ReferenceRangeLow/>\r\n<ReferenceRangeHigh/>\r\n<ReferenceRange1/>\r\n<ReferenceRange2/>\r\n<SpecimenType>R</SpecimenType>\r\n<OrderableType>SAP</OrderableType>\r\n<ScreeningCutoff>300</ScreeningCutoff>\r\n<ConfirmationCutoff>150</ConfirmationCutoff>\r\n<GCMSLevel/>\r\n<ClassTestCodeMne/>\r\n<ClassTestCodeCutoff/>\r\n<AlphaInformation>\r\n<ResultType>A</ResultType>\r\n<AlphaResult>NEGATIVE</AlphaResult>\r\n<MessageCode/>\r\n<MessageCategory/>\r\n</AlphaInformation>\r\n</Result>\r\n<Result>\r\n<UnitCodeMne>5867090015</UnitCodeMne>\r\n<UnitCodeNumber>717847</UnitCodeNumber>\r\n<UnitCodeReportName1>SUBSTANCE ABUSE PANEL 5-</UnitCodeReportName1>\r\n<UnitCodeReportName2>50, THCOZ</UnitCodeReportName2>\r\n<UnitCodeReqShortBillName>SAP 5-50/2000</UnitCodeReqShortBillName>\r\n<UnitCodeRefex/>\r\n<UnitCodeQBSBillCode>0006405</UnitCodeQBSBillCode>\r\n<ProfileCodeMne/>\r\n<TestCodeMne>THCOZ</TestCodeMne>\r\n<TestCodeName>MARIJUANA METABOLITES, (50 ng/mL SCREEN)</TestCodeName>\r\n<TestCodeNumber>72452</TestCodeNumber>\r\n<TestCodeType>S</TestCodeType>\r\n<ResultStatus>D</ResultStatus>\r\n<ClinicalStatus>K</ClinicalStatus>\r\n<ResultValue/>\r\n<UnitsOfMeasure/>\r\n<ReferenceRangeLow/>\r\n<ReferenceRangeHigh/>\r\n<ReferenceRange1/>\r\n<ReferenceRange2/>\r\n<SpecimenType>R</SpecimenType>\r\n<OrderableType>SAP</OrderableType>\r\n<ScreeningCutoff>50</ScreeningCutoff>\r\n<ConfirmationCutoff>15</ConfirmationCutoff>\r\n<GCMSLevel/>\r\n<ClassTestCodeMne/>\r\n<ClassTestCodeCutoff/>\r\n<AlphaInformation>\r\n<ResultType>A</ResultType>\r\n<AlphaResult>NEGATIVE</AlphaResult>\r\n<MessageCode/>\r\n<MessageCategory/>\r\n</AlphaInformation>\r\n</Result>\r\n<Result>\r\n<UnitCodeMne>5867090015</UnitCodeMne>\r\n<UnitCodeNumber>717847</UnitCodeNumber>\r\n<UnitCodeReportName1>SUBSTANCE ABUSE PANEL 5-</UnitCodeReportName1>\r\n<UnitCodeReportName2>50, OP2000</UnitCodeReportName2>\r\n<UnitCodeReqShortBillName>SAP 5-50/2000</UnitCodeReqShortBillName>\r\n<UnitCodeRefex/>\r\n<UnitCodeQBSBillCode>0006405</UnitCodeQBSBillCode>\r\n<ProfileCodeMne/>\r\n<TestCodeMne>OPI2K</TestCodeMne>\r\n<TestCodeName>OPIATES (2000 NG/ML SCREEN)</TestCodeName>\r\n<TestCodeNumber>72726</TestCodeNumber>\r\n<TestCodeType>S</TestCodeType>\r\n<ResultStatus>D</ResultStatus>\r\n<ClinicalStatus>K</ClinicalStatus>\r\n<ResultValue/>\r\n<UnitsOfMeasure/>\r\n<ReferenceRangeLow/>\r\n<ReferenceRangeHigh/>\r\n<ReferenceRange1/>\r\n<ReferenceRange2/>\r\n<SpecimenType>R</SpecimenType>\r\n<OrderableType>SAP</OrderableType>\r\n<ScreeningCutoff>2000</ScreeningCutoff>\r\n<ConfirmationCutoff>2000</ConfirmationCutoff>\r\n<GCMSLevel/>\r\n<ClassTestCodeMne/>\r\n<ClassTestCodeCutoff/>\r\n<AlphaInformation>\r\n<ResultType>A</ResultType>\r\n<AlphaResult>NEGATIVE</AlphaResult>\r\n<MessageCode/>\r\n<MessageCategory/>\r\n</AlphaInformation>\r\n</Result>\r\n<Result>\r\n<UnitCodeMne>5867090015</UnitCodeMne>\r\n<UnitCodeNumber>717847</UnitCodeNumber>\r\n<UnitCodeReportName1>SUBSTANCE ABUSE PANEL 5-</UnitCodeReportName1>\r\n<UnitCodeReportName2>50, PPCP</UnitCodeReportName2>\r\n<UnitCodeReqShortBillName>SAP 5-50/2000</UnitCodeReqShortBillName>\r\n<UnitCodeRefex/>\r\n<UnitCodeQBSBillCode>0006405</UnitCodeQBSBillCode>\r\n<ProfileCodeMne/>\r\n<TestCodeMne>PPCP</TestCodeMne>\r\n<TestCodeName>PHENCYCLIDINE </TestCodeName>\r\n<TestCodeNumber>72426</TestCodeNumber>\r\n<TestCodeType>S</TestCodeType>\r\n<ResultStatus>D</ResultStatus>\r\n<ClinicalStatus>K</ClinicalStatus>\r\n<ResultValue/>\r\n<UnitsOfMeasure/>\r\n<ReferenceRangeLow/>\r\n<ReferenceRangeHigh/>\r\n<ReferenceRange1/>\r\n<ReferenceRange2/>\r\n<SpecimenType>R</SpecimenType>\r\n<OrderableType>SAP</OrderableType>\r\n<ScreeningCutoff>25</ScreeningCutoff>\r\n<ConfirmationCutoff>25</ConfirmationCutoff>\r\n<GCMSLevel/>\r\n<ClassTestCodeMne/>\r\n<ClassTestCodeCutoff/>\r\n<AlphaInformation>\r\n<ResultType>A</ResultType>\r\n<AlphaResult>NEGATIVE</AlphaResult>\r\n<MessageCode/>\r\n<MessageCategory/>\r\n</AlphaInformation>\r\n</Result>\r\n</Results>\r\n</Donor>\r\n</LabTestResultXml>\r\n</qcs:ReceiveLabTestResult>\r\n</soapenv:Body>\r\n</soapenv:Envelope>\r\n")
                    .asString();
            String resp = response.getBody();
            resp = resp.replaceAll("\"", "");
            System.out.println(resp);
        } catch (
                UnirestException e) {
            throw new CaseFailedException("Connection failed");
        }
    }

    public void intLpGetToken() {
        try {
            HttpResponse<String> response = Unirest.post("https://auth.int.sterlingbackcheck.com/v1/tokens/authenticate")
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .header("Cache-Control", "no-cache")
                    .header("Postman-Token", "d796c839-cd17-41bb-96e9-c48b491224c6")
                    .body("{\"username\":\"tw.int@api.sterlingbackcheck.com\", \"password\":\"ce5ca701-69e2-4180-bcfb-5c6c35588155\"}")
                    .asString();
            String str = response.getBody();
            accessToken = str.split("\"")[3];
            System.out.println("Token added");
        } catch (
                UnirestException e) {
            throw new CaseFailedException("Connection failed");
        }
    }

    public void provisionLPTicket(String ticket, String accesstoken) {
        try {
            HttpResponse<String> response = Unirest.get("https://tickets.int.sterlingbackcheck.com/v1/tickets/" + ticket)
                    .header("Authorization", "Bearer " + accesstoken)
                    .header("Cache-Control", "no-cache")
                    .header("Postman-Token", "7ebfedd8-2f3a-4f93-8fdf-4b4a87b43f3a")
                    .asString();
            bodyRequest = response.getBody();

        } catch (
                UnirestException e) {
            throw new CaseFailedException("Connection failed");
        }

    }


    public void ldResultPostBack(String bodyRequest) {
        try {
            HttpResponse<String> response = Unirest.post("http://dvm-" + environment + ".aws.talentwise.com/integration/sbc/dhs_postback.php?op=sc")
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .header("Cookie", "XDEBUG_SESSION=phpstormxdebug")
                    .header("Cache-Control", "no-cache")
                    .header("Postman-Token", "d869f2ba-57f3-40ba-a727-0fc7ad2dcffc")
                    .body(bodyRequest)
                    .asString();
            System.out.println(response.getStatus());
            System.out.println(response.getBody());
        } catch (UnirestException e) {
            throw new CaseFailedException("Connection Failed");
        }

    }
}
