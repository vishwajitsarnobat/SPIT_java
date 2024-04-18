import java.util.Scanner;

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
	abstract void withdraw();
	abstract void display();
}

class Saving_Account extends Account {
	double interestRate;
	double minBalance = 100;
	
	Saving_Account(String name, double balance, double accNo, double minBalance) {
		super(name, balance, accNo);
		this.minBalance = minBalance;
	}
	
	void deposit(double amount) {
		balance += amount;
		System.out.println("Desposited Successfully... \n Updated Balance: " + balance);
	}
	
	void withdraw() {
		
	}
	
	void display() {
		
	}
	
	void addInterest() {
		
	}
	
	void transfer() {
		
	}
}

class Interest {
	public static void main (String[] args) {
		Account acc = new Saving_Account("hehe", 2, 3, 4);
	}
}
