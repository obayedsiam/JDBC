import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DriverClass {

    public static void main(String[] args) {

        try {
            //Load the driver
          //  Class.forName("com.mysql.jdbc.Driver");

            // Create Connection
            String url = "jdbc:mysql://localhost:3306/sonydb";
            String username = "root";
            String password = "";
            Connection con = DriverManager.getConnection(url, username, password);

            if (con.isClosed()) {
                System.out.println("Connection is closed");
            } else {
                System.out.println("Connection created");

                String query = "SELECT call_status FROM tv_details WHERE id = 20";

                Statement st = con.createStatement();
                ResultSet set = st.executeQuery(query);

                while(set.next()){
                    String callStatus = set.getString("call_status");
                    System.out.println(callStatus);
                }

                con.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
