import java.util.Scanner;

public class Time{

		public static void secstohours(){
		  Scanner input = new Scanner(System.in);
		  System.out.print("Enter time in seconds: ");
		  int time = input.nextInt();
			int hours = time / 3600;
			time = time % 3600;
			int minutes = time / 60;
			time = time % 60;
			int seconds = time;
			System.out.println("Time is equivalent to: " + hours + " hours: " + minutes + " minutes: " + seconds + " seconds");
			input.close();
	  }
	  
	  public static void hourstosecs(){
	    Scanner input = new Scanner(System.in);
	    System.out.print("Enter hours: ");
	    int hours = input.nextInt();
	  	System.out.print("Enter minutes: ");
	    int minutes = input.nextInt();
	    System.out.print("Enter seconds: ");
	    int seconds = input.nextInt();
	    int time = hours * 3600 + minutes * 60 + seconds;
	    System.out.println("Time in seconds: " + time);
	    input.close();
	  }
	  
		public static void main(String args[]){
			Scanner input = new Scanner(System.in);
			System.out.print("Enter option" + "\n 1. Seconds to Hours Minutes and Seconds" + "\n 2. Hours Minutes and Seconds to seconds \n Your choice: ");
			int option = input.nextInt();
			switch(option){
				case 1:
					secstohours();
					break;
					
				case 2:
					hourstosecs();
					break;
					
				default:
					System.out.println("Enter a valid option(number)");
			}
			input.close();
		}
	}
