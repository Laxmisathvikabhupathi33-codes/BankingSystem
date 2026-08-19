class CurrentAccount extends Account implements TransactionService, LoanProcessing {

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) throws BankingException {
        if (amount > balance + 5000)
            throw new BankingException("Overdraft limit exceeded.");
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    @Override
    public void calculateInterest() {
        System.out.println("Current Account: No savings interest.");
    }

    @Override
    public void applyLoan(double amount) {
        System.out.println("Current Account business loan applied: " + amount);
    }
}
