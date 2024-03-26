import java.util.Scanner;
import java.util.Calendar;

abstract class AmusementPark {
	abstract double getCost();
}

class EsselWorld extends AmusementPark {
	int cost;

	double getCost() {
		return cost;
	}
}

class Imagica extends AmusementPark {
	int cost;

	double getCost() {
		return cost;
	}
}

class Person {
	int age;
	int rides;
	int cost;
	
	Person(int age, int rides, int cost) {
		this.age = age;
		this.rides = rides;
		this.cost = cost;
	}
}

class Park {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayOfWeek);

		System.out.println("Choose a Park...");
		System.out.println("1. Imagica \n2. EsselWorld");
		System.out.print("Your choice: ");
		int option = input.nextInt();

		System.out.print("Enter number of people in the group: ");
		int grpCount = input.nextInt();
		Person[] group = new Person[grpCount];

		int extra = 0;
		if (dayOfWeek == 1 || dayOfWeek == 7) {
			extra += 300;
		}
		

		if(option == 1) {
			AmusementPark park = new Imagica();
			for (int i = 0; i < grpCount; i++) {
				System.out.print("Enter age of person {i + 1}: ");
				int age = input.nextInt();
				System.out.print("Enter number of games played: ");
				int games = input.nextInt();
				if (age > 21) {
					group[i] = new Person(age, games, 1050);
				}
				else if (age >= 60 || age <= 21) {
					group[i] = new Person(age, games, 660);
				}

				group[i].cost += 300;

				if (games > 3) {
					int extraGames = games - 3;
					group[i].cost += (extraGames * 50);
				}
			}
		}
		else if(option == 2) {
			AmusementPark park = new EsselWorld();
			for (int i = 0; i < grpCount; i++) {
				System.out.print("Enter age of person {i + 1}: ");
				int age = input.nextInt();
				System.out.print("Enter number of games played: ");
				int games = input.nextInt();
				if (age > 21) {
					group[i] = new Person(age, 0, 1500);
				}
				else if (age >= 60 || age <= 21) {
					group[i] = new Person(age, 0, 1100);
				}
				if (dayOfWeek == 1 || dayOfWeek == 7) {
					group[i].cost += 300;
				}
				if (games > 3) {
					int extraGames = games - 3;
					group[i].cost += (extraGames * 50);
				}
			}
		}
		else {
			System.out.print("Please enter a valid input!");
		}
	}
}
