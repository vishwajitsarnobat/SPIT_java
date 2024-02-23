import java.util.Scanner;

class Account {
    int balance;
    int ROI;

    Account(int balance, int ROI) {
        this.balance = balance;
        this.ROI = ROI;
    }
}

class Bank {
    private static Scanner input = new Scanner(System.in);

    public static void action(Account account) {
        System.out.println("Choose the action to be executed: \n 1. Deposit money. \n 2. Withdraw money.");
        System.out.println(" 3. View account balance. \n 4. Calculate compound interest. \n 5. Exit.");
        System.out.print("Your choice: ");
        int option = input.nextInt();

        switch (option) {
            case 1:
                deposit(account);
                action(account);
                break;

            case 2:
                withdraw(account);
                action(account);
                break;

            case 3:
                view_balance(account);
                action(account);
                break;

            case 4:
                calc_comp_interest(account);
                action(account);
                break;

            case 5:
                System.out.println("Have a nice day! Visit again!");
                break;

            default:
                System.out.println("Please choose a valid option: ");
                break;
        }
    }

    public static void deposit(Account account) {
        System.out.print("Enter amount to be deposited: ");
        int amount = input.nextInt();
        account.balance += amount;
        System.out.println("Amount deposited successfully...");
        System.out.println("Updated account balance: " + account.balance);
    }

    public static void withdraw(Account account) {
        System.out.print("Enter amount to withdraw: ");
        int amount = input.nextInt();
        if (account.balance < amount) {
            System.out.println("Withdrawal terminated! Insufficient account balance...");
        } else {
            account.balance -= amount;
            System.out.println("Amount withdrawal successful...");
            System.out.println("Updated account balance: " + account.balance);
        }
    }

    public static void calc_comp_interest(Account account) {
        System.out.print("Enter Principal amount: ");
        int amount = input.nextInt();
        System.out.print("Enter time period in years: ");
        int years = input.nextInt();
        int interest = (int) (amount * Math.pow((1 + (account.ROI / 100.0)), years));
        System.out.println("Compound Interest for the given data will be: " + interest);
    }

    public static void view_balance(Account account) {
        System.out.println("Your current account balance is: " + account.balance);
    }

    public static void main(String[] args) {
        System.out.print("Account balance: ");
        int balance = input.nextInt();
        System.out.print("Rate of Interest (in %): ");
        int ROI = input.nextInt();

        Account account = new Account(balance, ROI);
        action(account);
        input.close();
    }
}