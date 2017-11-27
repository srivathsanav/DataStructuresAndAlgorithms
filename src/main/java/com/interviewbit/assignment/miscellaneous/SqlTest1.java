/**
 * Created by avsrivathsan on 8/21/2017.
 */
import java.sql.*;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by avsrivathsan on 5/26/2017.
 */
public class SqlTest1 {

    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String userName = "sa";
            String password = "test#123";
            String url = "jdbc:sqlserver://10.47.58.60:1433" + ";databaseName=vue_dm";
            Connection con = DriverManager.getConnection(url, userName, password);
            con.setAutoCommit(false);


            try (CallableStatement cs = con.prepareCall("{call usp_process_rfid_eas_sales_dataconsolidation1 (?, ?)}")) {
                cs.setString(1, "1");
                ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
                Date date = Date.from(utc.toInstant());
                long epochMillis = utc.toEpochSecond() * 1000;
                cs.setTimestamp(2, new Timestamp(epochMillis));

            //    cs.execute();
               final ResultSet output = cs.executeQuery();
                System.out.println(output.next());
                con.commit();

            }    catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

