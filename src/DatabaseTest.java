import java.sql.Connection;

public class DatabaseTest {

    public static void main(String[] args) {

        try {
            Connection con = DatabaseConnection.getConnection();

            System.out.println("Database connected successfully.");

            con.close();

        } catch (Exception e) {
            System.out.println("Database connection failed.");
            System.out.println(e.getMessage());
        }
    }
}