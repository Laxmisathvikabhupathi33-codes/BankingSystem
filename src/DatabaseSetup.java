import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {

    public static void main(String[] args) {

        String sql = "CREATE TABLE IF NOT EXISTS accounts ("
                   + "account_number TEXT PRIMARY KEY,"
                   + "holder_name TEXT NOT NULL,"
                   + "balance REAL NOT NULL,"
                   + "account_type TEXT NOT NULL)";

        try {
            Connection con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();

            stmt.executeUpdate(sql);

            System.out.println("Accounts table created successfully.");

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error creating table.");
            System.out.println(e.getMessage());
        }
    }
}