import java.util.Scanner;

public class ATMSimulator {
    private double balance;
    
    public ATMSimulator(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited $%.2f. New balance: $%.2f\n", amount, balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Successfully withdrew $%.2f. Remaining balance: $%.2f\n", amount, balance);
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
    
    public void checkBalance() {
        System.out.printf("Current balance: $%.2f\n", balance);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATMSimulator atm = new ATMSimulator(1000.00); // Initial balance set to $1000

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = getValidInt(scanner);
            
            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = getValidDouble(scanner);
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = getValidDouble(scanner);
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static double getValidDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid amount: ");
            }
        }
    }
    
    private static int getValidInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }
}