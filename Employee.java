import java.util.Scanner;

class Posting{
	int courseWork;
	int aptitudeTest;
	int technicalTest;
	int interview;

	Posting(int courseWork, int aptitudeTest, int technicalTest, int interview){
		this.courseWork = courseWork;
		this.aptitudeTest = aptitudeTest;
		this.technicalTest = technicalTest;
		this.interview = interview;
		
		if ((technicalTest + interview + courseWork + aptitudeTest) > 80){
			System.out.println("Congratulations, You're hired!");
		}
		else {
			System.out.println("Better luck next time");
		}
	}
	
	Posting(int technicalTest, int interview){
		this.technicalTest = technicalTest;
		this.interview = interview;
		
		if ((technicalTest + interview) > 85){
			System.out.println("Congratulations, You're hired!");
		}
		else {
			System.out.println("Better luck next time");
		}
	}
	
	Posting(int interview){
		this.interview = interview;
		
		if (interview > 90){
			System.out.println("Congratulations, You're hired!");
		}
		else {
			System.out.println("Better luck next time");
		}
	}
}

class Employee{
	static Scanner input = new Scanner(System.in);

	public static void success_handler(){
		System.out.println(" 1. Re-execute \n 2. Exit");
		System.out.print("Your choice: ");
		int option = input.nextInt();
		
		if(option == 1){
			execute();
		}
		else if(option == 2){
			System.out.println("Code terminated");
		}
		else {
			System.out.println("Please enter a valid input...");
		}
	}
	
	public static void execute(){
	System.out.println(" 1. Programmer \n 2. Team Leader \n 3. Project Manager \n 4. Exit");
	System.out.print("Your choice: ");
	int option = input.nextInt();
		if (option == 1){
			System.out.print("Course Work marks: ");
			int courseWork = input.nextInt();
			System.out.print("Aptitude Test marks: ");
			int aptitudeTest = input.nextInt();
			System.out.print("Technical Test marks: ");
			int technicalTest = input.nextInt();
			System.out.print("Interview marks: ");
			int interview = input.nextInt();
			Posting programmer = new Posting(courseWork, aptitudeTest, technicalTest, interview);
			success_handler();
		}
		else if(option == 2){
			System.out.print("Technical Test marks: ");
			int technicalTest = input.nextInt();
			System.out.print("Interview marks: ");
			int interview = input.nextInt();
			Posting teamleader = new Posting(technicalTest, interview);
			success_handler();
		}
		else if(option == 3){
			System.out.print("Interview marks: ");
			int interview = input.nextInt();
			Posting projectmanager = new Posting(interview);
			success_handler();
		}
		else if(option == 4){
			System.out.println("Code terminated");
		}
		else{
			System.out.println("Please enter a valid input...");
			execute();
		}
	}

	public static void main(String args[]){
		
		execute();
		input.close();
	}
}
