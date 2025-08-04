import java.util.ArrayList;
import java.util.Scanner;

class ATM {
    private double balance;
    private ArrayList<String> history;

    public ATM() {
        balance = 1000.0;
        history = new ArrayList<>();
    }

    public void showBalance() {
        System.out.println("Your current balance is ₹" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            history.add("Deposited ₹" + amount);
            System.out.println("₹" + amount + " has been added to your account.");
        } else {
            System.out.println("Enter a valid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            history.add("Withdrew ₹" + amount);
            System.out.println("You have withdrawn ₹" + amount);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    public void showHistory() {
        System.out.println("Transaction History:");
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String record : history) {
                System.out.println("- " + record);
            }
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();

        String storedUser = "user01";
        String storedPin = "1234";

        System.out.println("Welcome to the ATM");
        System.out.print("Enter User ID: ");
        String user = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        if (!user.equals(storedUser) || !pin.equals(storedPin)) {
            System.out.println("Login failed. Invalid credentials.");
            return;
        }

        System.out.println("Login successful!");

        int option;
        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    atm.showBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double deposit = scanner.nextDouble();
                    atm.deposit(deposit);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdraw = scanner.nextDouble();
                    atm.withdraw(withdraw);
                    break;
                case 4:
                    atm.showHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Please select a valid option.");
            }
        } while (option != 5);

        scanner.close();
    }
}
