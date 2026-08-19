abstract class Account {
    private String accountNumber;
    private String holderName;
    protected double balance;

    public static final String BANK_NAME = "SRITW Bank";

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public abstract void calculateInterest();

    public void displayDetails() {
        System.out.println("Bank: " + BANK_NAME);
        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder: " + holderName);
        System.out.println("Balance: " + balance);
    }
}
