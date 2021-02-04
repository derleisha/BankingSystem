package bankapplication;

import java.util.Scanner;

public class Account {

    int balance;
    int previousTranscation;
    String customerName;
    String customerID;

    Account(String cName, String cID) {
        customerName = cName;
        customerID = cID;

    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTranscation = amount;

        }
    }

    void withdrawal(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTranscation = -amount;

        }
    }

    void getPreviousTranscation() {
        if (previousTranscation > 0) {
            System.out.println("Deposited: " + previousTranscation);
        } else if (previousTranscation < 0) {
            System.out.println("Withdrawn " + Math.abs(previousTranscation));
        } else {
            System.out.println("No transcation occurred!");
        }
    }

    void interest(int years) {
        double interestRate = 0.015;
        double newBalance = (balance + interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + ",your balance will be " + newBalance);

    }

    void menu() {

        while (true) {

            char selection;
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome, " + customerName + "!");
            System.out.println("Your ID is: " + customerID);
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println();
            System.out.println("A. Check your balance");
            System.out.println("B. Make a deposit");
            System.out.println("C. Make a withdrawal");
            System.out.println("D. View previous transcations");
            System.out.println("E. Calculate interest");
            System.out.println("F. Exit");
            System.out.println("Enter an option: ");
            char selection1 = input.next().charAt(0);
            selection = Character.toUpperCase(selection1);

            switch (selection) {
                case 'A':
                    System.out.println("Balance = £ " + balance);
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("Enter the amount to deposit: ");
                    int amount = input.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = input.nextInt();
                    withdrawal(amount2);
                    break;
                case 'D':
                    getPreviousTranscation();
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("Enter how many years of accured interest: ");
                    int years = input.nextInt();
                    interest(years);
                    break;
                case 'F':
                    System.out.println("Thank you for banking with us!");

            

            }
        }
    }
}

    
