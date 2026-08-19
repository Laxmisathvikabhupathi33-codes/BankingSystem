import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("===== BANKING SYSTEM =====");
        System.out.print("Enter Account Number: ");
        String number = sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        System.out.print("Choose Account (1-Savings, 2-Current): ");
        int choice = sc.nextInt();

        Account account;

        if (choice == 1)
            account = new SavingsAccount(number, name, balance);
        else
            account = new CurrentAccount(number, name, balance);

        bank.createAccount(account);

        int option;
        do {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Account");
            System.out.println("4. Calculate Interest");
            System.out.println("5. Apply Loan");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            option = sc.nextInt();

            try {
                switch (option) {
                    case 1:
                        System.out.print("Enter amount: ");
                        account.deposit(sc.nextDouble());
                        break;

                    case 2:
                        System.out.print("Enter amount: ");
                        account.withdraw(sc.nextDouble());
                        break;

                    case 3:
                        account.displayDetails();
                        break;

                    case 4:
                        account.calculateInterest();
                        break;

                    case 5:
                        System.out.print("Enter loan amount: ");
                        ((LoanProcessing) account).applyLoan(sc.nextDouble());
                        break;

                    case 6:
                        System.out.println("Thank you for using the Banking System.");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (BankingException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (option != 6);

        sc.close();
    }
}
