import java.util.ArrayList;
import java.util.Scanner;

class MinBalanceException extends Exception {
    public String toString() {
        return "This transaction makes the account balance lower than the permitted amount!";
    }
}

class InvalidOptionException extends Exception {
    public String toString() {
        return "Please enter a valid option!";
    }
}

class AccountNumberException extends Exception {
    public String toString() {
        return "This account number is already taken. Please choose another one!";
    }
}

class UserNotFoundException extends Exception {
    public String toString() {
        return "Account number not found in the bank's user database. Please try again!";
    }
}

abstract class Account {
    String name;
    double balance;
    double accNo;

    Account(String name, double balance, double accNo) {
        this.name = name;
        this.balance = balance;
        this.accNo = accNo;
    }

    abstract void deposit(double amount);

    abstract void withdraw(double amount);

    abstract void display();
}

class Saving_Account extends Account {
    double interestRate;
    double minBalance = 100;

    Saving_Account(String name, double balance, double accNo, double interestRate, double minBalance) {
        super(name, balance, accNo);
        this.interestRate = interestRate;
        this.minBalance = minBalance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited Successfully... \n Updated Balance: " + balance);
    }

    void withdraw(double amount) {
        try {
            double temp = balance - amount;
            if (temp < minBalance) {
                throw new MinBalanceException();
            }
            balance -= amount;
            System.out.println("Amount withdrawal successful");
        } catch (MinBalanceException e) {
            System.out.println(e);
        }
    }

    void display() {
        System.out.println("Your current account balance is: " + balance);
    }

    void addInterest(double amount, double years) {
        // returns amount + simple interest
        double finalAmount = amount * years * interestRate;
        System.out.println("The final amount on adding interest will be: " + finalAmount);
    }

    void transfer(double amount) {
        try {
            double temp = balance - amount;
            if (temp < minBalance) {
                throw new MinBalanceException();
            }
            balance -= amount;

        } catch (MinBalanceException e) {
            System.out.println(e);
        }
    }
}

class BankingSystem {
    static Scanner input = new Scanner(System.in);

    public static boolean checkAccNumber(ArrayList<Saving_Account> userData, double accNo) {
        for (int i = 0; i < userData.size(); i++) {
            if (userData.get(i).accNo == accNo) {
                return false;
            }
        }
        return true;
    }

    public static void accountMenu(int i, ArrayList<Saving_Account> userData) {
        System.out.println(
                "1. Deposit money.\n2. Withdraw money.\n3. Check Amount on adding interest.\n4. Check account balance.\n5. Transfer money.\n6. Exit Bank.\n7. Access another bank account.");
        System.out.print("Your choice: ");
        int option = input.nextInt();
        Saving_Account user = userData.get(i);

        try {
            if (option < 1 || option > 7) {
                throw new InvalidOptionException();
            }
            switch (option) {
                case 1:
                    System.out.print("Input amount to be deposited: ");
                    double depositAmount = input.nextDouble();
                    user.deposit(depositAmount);
                    accountMenu(i, userData);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = input.nextDouble();
                    user.withdraw(withdrawAmount);
                    accountMenu(i, userData);
                    break;

                case 3:
                    System.out.print("Enter principal amount: ");
                    double principal = input.nextDouble();
                    System.out.print("Input number of years: ");
                    double years = input.nextDouble();
                    user.addInterest(principal, years);
                    accountMenu(i, userData);
                    break;

                case 4:
                    user.display();
                    accountMenu(i, userData);
                    break;

                case 5:
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = input.nextDouble();
                    System.out.print("Enter account number of recipient's bank: ");
                    double accNum = input.nextDouble();

                    boolean flag = false;
                    int j = -1;
                    while (!flag) {
                        for (j = 0; j < userData.size(); j++) {
                            if (userData.get(j).accNo == accNum) {
                                flag = true;
                                break;
                            }
                        }
                        if (flag) {
                            break;
                        }
                        else {
                            System.out.print("Please enter a valid account number of recipient's bank: ");
                            accNum = input.nextDouble();
                        }
                    }

                    double temp = user.balance;
                    user.transfer(transferAmount);
                    if (temp != user.balance) {
                        userData.get(j).balance += transferAmount;
                        System.out.println("Amount debited from you account, account number: " + user.accNo
                            + " and credited to account with account number: " + accNum);
                    }
                    else {
                        System.out.println("Transaction terminated!");
                    }
                    accountMenu(i, userData);
                    break;

                case 6:
                    System.out.println("See you soon :)");
                    break;

                case 7:
                    welcomeMenu(userData);
                    break;
            }
        } catch (InvalidOptionException e) {
            System.out.println(e);
            accountMenu(i, userData);
        }
    }

    public static double checkMinBalance(double minBalance, double balance) {
        while ((minBalance > balance)) {
            try {
                throw new MinBalanceException();
            } catch (MinBalanceException e) {
                System.out.println(e);
                System.out.print("Enter a valid balance: ");
                balance = input.nextDouble();
            }
        }
        return balance;
    }

    public static int createAccount(ArrayList<Saving_Account> userData) {
        System.out.print("Enter your name: ");
        input.nextLine();
        String name = input.nextLine();

        System.out.print("Enter account number: ");
        double accNo = input.nextDouble();
        // check for conflicting account number
        while (!checkAccNumber(userData, accNo)) {
            System.out.println("This account number is already taken, try something else!");
            System.out.print("Enter account number: ");
            accNo = input.nextDouble();
        }

        System.out.print("Enter minimum balance: ");
        double minBalance = input.nextDouble();

        System.out.print("Enter interest rate: ");
        double interestRate = input.nextDouble();

        System.out.print("Enter balance: ");
        double balance = input.nextDouble();
        // check for min balance
        balance = checkMinBalance(minBalance, balance);

        userData.add(new Saving_Account(name, balance, accNo, interestRate, minBalance));
        System.out.println("Account created successfully!");

        return (userData.size() - 1);
    }

    public static int login(ArrayList<Saving_Account> userData) {
        int i = 0;
        try {
            System.out.print("Enter your account number: ");
            double accNo = input.nextDouble();
            for (i = 0; i < userData.size(); i++) {
                if (userData.get(i).accNo == accNo) {
                    System.out.print("Enter your name: ");
                    input.nextLine();
                    String name = input.nextLine();
                    if (name.equals(userData.get(i).name)) {
                        System.out.println("User found successfully!");
                        return i;
                    } else {
                        System.out.println("The entered name does not match the name linked with the account number");
                    }
                }
            }
            throw new UserNotFoundException();
        } catch (UserNotFoundException e) {
            System.out.println(e);
            return -1;
        }
    }

    public static void welcomeMenu(ArrayList<Saving_Account> userData) {
        System.out.println("Welcome! Please choose an option to continue...");
        System.out.println(" 1. Login into an existing account.\n 2. Create a new account \n 3. Exit Bank.");
        System.out.print("Your choice: ");

        int i = -1;
        int opt = input.nextInt();
        while (opt != 1 && opt != 2 && opt != 3) {
            try {
                throw new InvalidOptionException();
            } catch (InvalidOptionException e) {
                System.out.println(e);
                System.out.print("Your choice: ");
                opt = input.nextInt();
            }
        }

        if (opt == 1) {
            i = login(userData);
            if (i < 0) {
                welcomeMenu(userData);
            }
            else {
                accountMenu(i, userData);
            }
        } else if (opt == 2) {
            i = createAccount(userData);
            accountMenu(i, userData);
        } else if (opt == 3) {
            System.out.println("See you soon :)");
        }
    }

    public static void main(String[] args) {
        ArrayList<Saving_Account> userData = new ArrayList<>();
        welcomeMenu(userData);
        input.close();
    }
}
