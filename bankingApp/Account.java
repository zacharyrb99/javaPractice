package bankingApp;
import java.util.Scanner;

public class Account {
    // Class Variables
    int balance = 0;
    int previousTransaction;
    String customerName;
    String customerId;

    //Class constructor
    Account (String name, String id) {
        customerName = name;
        customerId = id;
    }

    // Function for depositing money
    void deposit (int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    // Function to withdraw money
    void withdraw (int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    // Function showing previous transaction
    void getPreviousTransaction () {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrew: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occured");
        }
    }

    // Function calculating interest of current funds after a number of years
    void calculateInterest (int years) {
        double interestRate = 2.19;
        double interestRatePercent = interestRate / 100;

        double newBalance = balance * Math.pow((1 + (interestRatePercent / 12)), (12 * years));

        System.out.println("The current interest rate is: " + interestRate);
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    // Function to show main menu
    void showMenu () {
        char option = '\0';
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerId);
        System.out.println();
        System.out.println("What would you like to do today?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Deposit money");
        System.out.println("C. Withdraw money");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");
        
        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option_chosen = scan.next().charAt(0);
            option = Character.toUpperCase(option_chosen);
            System.out.println();

            switch (option) {
                // Option A: check account balance
                case 'A':
                    System.out.println("**********************************");
                    System.out.println("Balance = $" + balance);
                    System.out.println("**********************************");
                    System.out.println();
                    break;

                // Option B: deposit money
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int depositAmount = scan.nextInt();
                    deposit(depositAmount);
                    System.out.println("New Balance: " + balance);
                    System.out.println();
                    break;

                // Option C: withdraw money
                case 'C':
                    System.out.println("Enter an amount to deposit: ");
                    int withdrawAmount = scan.nextInt();
                    withdraw(withdrawAmount);
                    System.out.println("New Balance: " + balance);
                    System.out.println();
                    break;

                // Option D: view previous transaction
                case 'D':
                    System.out.println("**********************************");
                    getPreviousTransaction();
                    System.out.println("**********************************");
                    System.out.println();
                    break;

                // Option E: calculate interest based on given # of years
                case 'E':
                    System.out.println("Enter how many years of interest: ");
                    int years = scan.nextInt();
                    calculateInterest(years);
                    System.out.println();
                    break;

                // Option F: exits user from their account    
                case 'F': 
                    System.out.println("**********************************");
                    break;

                // Lets user know they entered an invalid option
                default:
                    System.out.println("Error: Invalid option. Please choose A, B, C, D, E, or F.");
                    break;
            }
        } while (option != 'F');

        System.out.println("Thank you for banking with us!");
        scan.close();
    }
}
