class Bank {
    private static int accountCount = 0;

    public void createAccount(Account account) {
        accountCount++;
        System.out.println("Account created successfully.");
        System.out.println("Total Accounts: " + accountCount);
    }

    // Method overloading
    public void createAccount(String accountNumber, String holderName) {
        System.out.println("Basic account request received for " + holderName);
    }

    public static int getAccountCount() {
        return accountCount;
    }
}
