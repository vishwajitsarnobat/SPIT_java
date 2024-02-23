import java.util.Scanner;

class Marks {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter marks for the respective subjects: ");
		System.out.print("Physics: ");
		int Physics = input.nextInt();
		System.out.print("Maths: ");
	        int Maths = input.nextInt();
		System.out.print("English: ");
		int English = input.nextInt();
		System.out.print("DSM: ");
		int DSM = input.nextInt();
		
		if (Physics < 0 || Physics > 100 || Maths < 0 || Maths > 100 || English < 0 || English > 100 || DSM < 0 || DSM > 100){
			System.out.println("Please enter valid marks in the range 0  to 100");
		}	
		else {
			int average = (Physics + Maths + English + DSM) / 4;

			if (average >= 75) {
				System.out.println("Congratulations! You've passed with distinction");
			}
			else if (average >= 60){
				System.out.println("You've passed with First Class grades");
			}
			else if (average >= 40){
				System.out.println("You've passes with Second Class");
			} else {
				System.out.println("You've failed the exam");
			}	
		}

		input.close();	
	}
}
