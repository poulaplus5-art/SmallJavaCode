public abstract class BankAccount {
    protected String accountNumber;
    protected String ownerName;
    protected double balance;

    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    // Common methods
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.printf("Deposited $%.2f. New balance: $%.2f%n", amount, balance);
    }

    public abstract void withdraw(double amount);
    public abstract String getAccountType();

    @Override
    public String toString() {
        return String.format("[%s] Account #%s | Owner: %s | Balance: $%.2f",
                getAccountType(), accountNumber, ownerName, balance);
    }
}
