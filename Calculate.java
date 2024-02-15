import java.util.Scanner;

class Test{
	double base;
	int power;
	int logBase;
	int argument;
	
	Test(){
		this.base = 2;
		this.power = 2;
		this.logBase = 2;
		this.argument = 2;
	}
	
	public static double calculate (double base, int power){
		return Math.pow(base, power);
	}
	
	public static double calculate (int logBase, int argument){
		return Math.log(argument) / Math.log(logBase);
	}
	
	public static void display(double ans){
		System.out.println("The calcuated answer is: " + ans);
	}
}

class Calculate{
	static Scanner input = new Scanner(System.in);
	
	public static void success_handling(){
		System.out.println(" 1. Re-execute \n 2. Exit");
		System.out.print("Your choice: ");
		
		int option = input.nextInt();
		
		if (option == 1){
			execute();
		}
		else if (option == 2){
			System.out.println("Code terminated");
		}
		else {
			System.out.println("Please enter a valid input...");
		}
	}
	
	public static void execute(){
		System.out.println(" 1. Calculate power \n 2. Calculate log \n 3. Exit");
		System.out.print("Your choice: ");
		
		int option = input.nextInt();
		
		if (option == 1){
			System.out.print("Base: ");
			double base = input.nextDouble();
			System.out.print("Power: ");
			int power = input.nextInt();
			double ans = Test.calculate(base, power);
			Test.display(ans);
			
			success_handling();
		}
		else if(option ==2){
			System.out.print("logBase: ");
			int logBase = input.nextInt();
			System.out.print("Argument: ");
			int argument = input.nextInt();
			double ans = Test.calculate(logBase, argument);
			Test.display(ans);
		}
		else if(option == 3){
			System.out.println("Code terminated");
		}
		else {
			System.out.println("Please enter a valid input...");
		}
	}
	
	public static void main(String args[]){
		execute();
		input.close();
	}
}
