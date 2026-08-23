import java.sql.Connection;
import java.sql.PreparedStatement;

public class AccountDAO {

    public static void saveAccount(Account account, String type) {

        String sql = "INSERT INTO accounts "
                   + "(account_number, holder_name, balance, account_type) "
                   + "VALUES (?, ?, ?, ?)";

        try {
            Connection con = DatabaseConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, account.getAccountNumber());
            ps.setString(2, account.getHolderName());
            ps.setDouble(3, account.getBalance());
            ps.setString(4, type);

            ps.executeUpdate();

            System.out.println("Account saved to database.");

            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    public static void updateBalance(String accountNumber, double balance) {

        String sql = "UPDATE accounts SET balance = ? WHERE account_number = ?";

        try {
            Connection con = DatabaseConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, balance);
            ps.setString(2, accountNumber);

            ps.executeUpdate();

            System.out.println("Database balance updated.");

            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    
}