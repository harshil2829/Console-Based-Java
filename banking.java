import java.util.ArrayList;
import java.util.Scanner;

class Account {
    int accNo;
    String name;
    double balance;

    Account(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return accNo + " | " + name + " | Balance: " + balance;
    }
}

public class day6 {

    static ArrayList<Account> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Mini Banking System =====");
            System.out.println("1. Create Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Delete Account");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> viewAccounts();
                case 3 -> depositMoney();
                case 4 -> withdrawMoney();
                case 5 -> deleteAccount();
                case 6 -> System.out.println("Thank you for using banking system!");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    static void createAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        accounts.add(new Account(accNo, name, balance));
        System.out.println("Account created successfully!");
    }

    static void viewAccounts() {
        System.out.println("\nAccNo | Name | Balance");
        System.out.println("------------------------");
        for (Account a : accounts) {
            System.out.println(a);
        }
    }

    static void depositMoney() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        for (Account a : accounts) {
            if (a.accNo == accNo) {
                System.out.print("Enter Amount: ");
                double amt = sc.nextDouble();
                a.balance += amt;
                System.out.println("Deposit successful!");
                return;
            }
        }
        System.out.println("Account not found!");
    }

    static void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        for (Account a : accounts) {
            if (a.accNo == accNo) {
                System.out.print("Enter Amount: ");
                double amt = sc.nextDouble();
                if (amt <= a.balance) {
                    a.balance -= amt;
                    System.out.println("Withdrawal successful!");
                } else {
                    System.out.println("Insufficient balance!");
                }
                return;
            }
        }
        System.out.println("Account not found!");
    }

    static void deleteAccount() {
        System.out.print("Enter Account Number to delete: ");
        int accNo = sc.nextInt();

        accounts.removeIf(a -> a.accNo == accNo);
        System.out.println("Account deleted (if existed).");
    }
}
