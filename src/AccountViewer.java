import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountViewer {

    public static void main(String[] args) {

        String sql = "SELECT * FROM accounts";

        try {
            Connection con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("===== ACCOUNTS IN DATABASE =====");

            while (rs.next()) {
                System.out.println("Account Number: " + rs.getString("account_number"));
                System.out.println("Holder Name: " + rs.getString("holder_name"));
                System.out.println("Balance: " + rs.getDouble("balance"));
                System.out.println("Account Type: " + rs.getString("account_type"));
                System.out.println("-----------------------------");
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}