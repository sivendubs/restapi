import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class Covid19 {

    public static void main(String[] args) {

        try {
            Connection conn = null;
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/Coronadb", "postgres", "newuser");
            System.out.println("Connected to database successfully");
            Statement stmt = conn.createStatement();
            System.out.println("Latest Covid19 Updates\n");
            System.out.printf("%s %s %s %s\n","Country Id","Country Name","Active Cases","Recovered Cases" );
            ResultSet rs = stmt.executeQuery("Select * from coronaupdates");
            while(rs.next()){
                System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println("Failed to create JDBC db connection " + e.toString() + e.getMessage());
        }

    }
}
