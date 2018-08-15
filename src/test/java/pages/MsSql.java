package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class MsSql {
    public String sqlID;
    public String sqlRegistrationID;

    public void mssql(String usernamebd, String passwordbd, String referenceID) {

        Connection conn = null;
        String url = "jdbc:sqlserver://10.25.12.29:49299;databaseName=OHS_QA3;integratedSecurity=true";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String userName = usernamebd;
        String password = passwordbd;
        Statement stmt;
        try {

            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, password);
            // Query String
            String query = "select top 20 r.id, r.reference_id, r.REGISTRATION_ID, r.status_id, \n" +
                    "       rs.DESCRIPTION as status_description, r.TICKET_ID,\n" +
                    "       r.*\n" +
                    "       from request r (nolock) \n" +
                    "              inner join customer c (nolock)\n" +
                    "                     on r.CUSTOMER_ID = c.id\n" +
                    "              left join R_STATUS rs (nolock)\n" +
                    "                     on r.STATUS_ID = rs.ID\n" +
                    "              where c.PLATFORM_ID in ('S1', 'TWISE') and r.REFERENCE_ID = '" + referenceID + "'\n" +
                    "       order by 1 desc";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query); // Not update, you're returning a ResultSet.
            // Get the String Columns
            if (rs.next()) {
                String sqlID = (rs.getString(1));
                String sqlRegistrationID = (rs.getString(3));
                System.out.println("ID= " + sqlID);
            }
            // Close connections
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
