import java.io.FileInputStream;
import java.sql.*;

public class DriverClass {

    public static void main(String[] args) {

        try {
            //Load the driver
            //  Class.forName("com.mysql.jdbc.Driver");

            // Create Connection
            String url = "jdbc:mysql://localhost:3306/sonydb";
            String username = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url, username, password);

            if (connection.isClosed()) {
                System.out.println("Connection is closed");
            } else {
                System.out.println("Connection created");


                // Create Statement with Query
                String query = "SELECT call_status FROM tv_details WHERE id = 20";
                Statement st = connection.createStatement();
                ResultSet set = st.executeQuery(query);

                while (set.next()) {
                    String callStatus = set.getString("call_status");
                    System.out.println(callStatus);
                }

                //Create Table

//                String createTable = "CREATE TABLE SAMPLE( id int(20) primary key auto_increment, name varchar(255) not null)";
//                Statement st2 = con.createStatement();
//                st.executeUpdate(createTable);
//                System.out.println("Table created");


                //Create Prepared Statement with Query

                String q2 = "insert into SAMPLE(name) values(?)";

                PreparedStatement preparedStatement = connection.prepareStatement(q2);
//                preparedStatement.setString(1, "Rahim");
//                preparedStatement.executeUpdate();
//                System.out.println("Inserted....");


     //           String createTable2 = "CREATE TABLE IMAGE( id int(20) primary key auto_increment, img  blob)";
       //         st.executeUpdate(createTable2);
                System.out.println("Table created");

                String q3 = "insert into IMAGE(img) values(?)";

                PreparedStatement preparedStatement2 = connection.prepareStatement(q3);

                FileInputStream fis = new FileInputStream("C:\\Users\\EATL\\Desktop\\download.jpg");

                preparedStatement2.setBlob(1,fis, fis.available());

                preparedStatement2.executeUpdate();

                connection.close();



            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
