public class CheckingAccount extends BankAccount {
    protected double overdraftLimit;
    protected double transactionFee;

    public CheckingAccount(String accountNumber, String ownerName,
                           double initialBalance, double overdraftLimit) {
        super(accountNumber, ownerName, initialBalance);
        this.overdraftLimit = overdraftLimit;
        this.transactionFee = 1.50;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        double totalDeduction = amount + transactionFee;
        if (balance + overdraftLimit < totalDeduction) {
            System.out.println("Exceeds overdraft limit. Transaction denied.");
            return;
        }
        balance -= totalDeduction;
        System.out.printf("Withdrew $%.2f (fee: $%.2f). New balance: $%.2f%n",
                amount, transactionFee, balance);
        if (balance < 0) {
            System.out.printf("  ⚠ Account is overdrawn by $%.2f%n", Math.abs(balance));
        }
    }

    public double getAvailableFunds() {
        return balance + overdraftLimit;
    }

    @Override
    public String getAccountType() { return "Checking"; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Overdraft Limit: $%.2f | Fee: $%.2f",
                overdraftLimit, transactionFee);
    }
    
    public void NewMethod5() {
}
}
