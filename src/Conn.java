import java.sql.*;

public class Conn {
    public  Connection conn;
    public  Statement s;
    public Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","9364");
            s= conn.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
