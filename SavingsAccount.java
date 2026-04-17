public class SavingsAccount extends BankAccount {
    protected double interestRate;
    protected int withdrawalLimit;
    protected int withdrawalsThisMonth;

    public SavingsAccount(String accountNumber, String ownerName,
                          double initialBalance, double interestRate) {
        super(accountNumber, ownerName, initialBalance);
        this.interestRate = interestRate;
        this.withdrawalLimit = 3;
        this.withdrawalsThisMonth = 0;
    }

    @Override
    public void withdraw(double amount) {
        if (withdrawalsThisMonth >= withdrawalLimit) {
            System.out.println("Withdrawal limit reached for this month.");
            return;
        }
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return;
        }
        balance -= amount;
        withdrawalsThisMonth++;
        System.out.printf("Withdrew $%.2f. New balance: $%.2f (Withdrawals this month: %d/%d)%n",
                amount, getBalance(), withdrawalsThisMonth, withdrawalLimit);
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.printf("Interest applied (%.2f%%): +$%.2f. New balance: $%.2f%n",
                interestRate, interest, balance);
    }

    public void resetMonthlyWithdrawals() {
        withdrawalsThisMonth = 0;
        System.out.println("Monthly withdrawal counter reset.");
    }

    @Override
    public String getAccountType() { return "Savings"; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Rate: %.2f%% | Withdrawals: %d/%d",
                interestRate, withdrawalsThisMonth, withdrawalLimit);
    }
}
