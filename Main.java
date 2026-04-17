public class Main {
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║       BANK ACCOUNT SYSTEM DEMO       ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        // --- Savings Account Demo ---
        System.out.println("━━━  Savings Account  ━━━");
        SavingsAccount savings = new SavingsAccount("SAV-1001", "Alice Johnson", 5000.00, 3.5);
        System.out.println(savings);
        System.out.println();

        savings.deposit(1000.00);
        savings.withdraw(500.00);
        savings.withdraw(200.00);
        savings.withdraw(100.00);
        savings.withdraw(50.00);   // Should be denied (limit reached)
        savings.applyInterest();
        System.out.println("\nAfter operations:");
        System.out.println(savings);

        System.out.println();

        // --- Checking Account Demo ---
        System.out.println("━━━  Checking Account  ━━━");
        CheckingAccount checking = new CheckingAccount("CHK-2002", "Bob Smith", 1000.00, 500.00);
        System.out.println(checking);
        System.out.println();

        checking.deposit(250.00);
        checking.withdraw(300.00);
        checking.withdraw(900.00);   // Goes into overdraft
        checking.withdraw(400.00);   // Should be denied
        System.out.printf("Available funds (incl. overdraft): $%.2f%n", checking.getAvailableFunds());
        System.out.println("\nAfter operations:");
        System.out.println(checking);

        System.out.println();

        // --- Polymorphism Demo ---
        System.out.println("━━━  Polymorphism: All Accounts  ━━━");
        BankAccount[] accounts = {
            new SavingsAccount("SAV-3001", "Carol White", 8000.00, 2.0),
            new CheckingAccount("CHK-4001", "David Brown", 3000.00, 300.00),
            savings,
            checking
        };

        for (BankAccount acc : accounts) {
            System.out.printf("%-10s | %-15s | Balance: $%,.2f%n",
                    acc.getAccountType(), acc.ownerName, acc.balance);
        }

        System.out.println("\n✔ Demo complete.");
    }
}
