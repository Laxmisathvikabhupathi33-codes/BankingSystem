class SavingsAccount extends Account implements TransactionService, LoanProcessing {

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) throws BankingException {
        if (amount > balance)
            throw new BankingException("Insufficient balance.");
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    @Override
    public void calculateInterest() {
        balance += balance * 0.04;
        System.out.println("4% savings interest added.");
    }

    @Override
    public void applyLoan(double amount) {
        System.out.println("Savings Account loan applied: " + amount);
    }
}
