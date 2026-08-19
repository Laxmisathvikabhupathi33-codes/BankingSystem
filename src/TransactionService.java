interface TransactionService {
    void deposit(double amount);
    void withdraw(double amount) throws BankingException;

    default void log(String message) {
        System.out.println("LOG: " + message);
    }
}
