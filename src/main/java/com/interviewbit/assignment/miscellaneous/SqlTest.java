import java.sql.*;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by avsrivathsan on 5/26/2017.
 */
public class SqlTest {

    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String userName = "sa";
            String password = "test#123";
            String url = "jdbc:sqlserver://10.47.85.60:1433" + ";databaseName=vue_dm";
            Connection con = DriverManager.getConnection(url, userName, password);

            Statement stmt = null;

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = con.createStatement();
            String sql;
            sql = "select * from epc_cls";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("epc_cls_code");

                System.out.println("ID: " + id);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
