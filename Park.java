import java.util.Scanner;
import java.util.Calendar;

abstract class AmusementPark {
	abstract int getCost();
}

class EsselWorld extends AmusementPark {
	int cost;

    EsselWorld(Person[] group) {
        for (int i = 0; i < group.length; i++) {
            cost += group[i].cost;
        }
    }

	int getCost() {
		return cost;
	}
}

class Imagica extends AmusementPark {
	int cost;

    Imagica(Person[] group) {
        for (int i = 0; i < group.length; i++) {
            cost += group[i].cost;
        }
    }

	int getCost() {
		return cost;
	}
}

class Person {
	int age;
	int[] games;
	int cost;
	
	Person(int age, int[] games, int cost) {
		this.age = age;
		this.games = games;
		this.cost = cost;
	}
}

class Park {
    static int extraGamesCost(int[] games) {
        int extraCost = 0;
        for (int i = 0; i < games.length; i++) {
            if (games[i] != 1 && games[i] != 2 && games[i] != 3) {
                extraCost += 50;
            }
        }
        return extraCost;
    }

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
			for (int i = 0; i < grpCount; i++) {
				System.out.print("Enter age of person " + (i + 1) + ": ");
				int age = input.nextInt();

                System.out.print("Enter number of games played: ");
                int gamesCount = input.nextInt();
                int[] games = new int[gamesCount]; 
				System.out.print("Enter game number of games played (space seperated): ");
				for (int j = 0; j < gamesCount; j++) {
                    games[j] = input.nextInt();
                }

                int cost = 0;
				if (age > 21) {
					cost += 1050;
				}
				else if (age >= 60 || age <= 21) {
					cost += 660;
				}
                
                cost += extra;
                cost += extraGamesCost(games);

                group[i] = new Person(age, games, cost);
			}
            AmusementPark imagica = new Imagica(group);

            // execution
            for (int i = 0; i < grpCount; i++) {
                int spent = group[i].cost;
                int played = group[i].games.length;
                int nplayed = 7 - played;
                System.out.println("Person " + (i + 1) + " spent Rs. " + spent);
                System.out.println("Person " + (i + 1) + " played " + played + " games");
                System.out.println("Person " + (i + 1) + " didn't play " + nplayed + " games");
                System.out.print("Person " + (i + 1) + " played the games: ");
                for (int j = 0; j < played; j++) {
                    System.out.print(group[i].games[j] + " ");
                }
            }
            int totalCost = imagica.getCost();
            System.out.println("Total Cost: " + totalCost);
		}
		else if(option == 2) {
			for (int i = 0; i < grpCount; i++) {
				System.out.print("Enter age of person " + (i + 1) + ": ");
				int age = input.nextInt();

                System.out.print("Enter number of games played: ");
                int gamesCount = input.nextInt();
                int[] games = new int[gamesCount]; 
				System.out.print("Enter game number of games played (space seperated): ");
				for (int j = 0; j < gamesCount; j++) {
                    games[j] = input.nextInt();
                }

                int cost = 0;
				if (age > 21) {
					cost += 1500;
				}
				else if (age >= 60 || age <= 21) {
					cost += 1100;
				}
                
                cost += extra;
                cost += extraGamesCost(games);
                
                group[i] = new Person(age, games, cost);
			}
            AmusementPark esselworld = new EsselWorld(group);

            //execution
            for (int i = 0; i < grpCount; i++) {
                int spent = group[i].cost;
                int played = group[i].games.length;
                int nplayed = 5 - played;
                System.out.println("Person " + (i + 1) + " spent Rs. " + spent);
                System.out.println("Person " + (i + 1) + " played " + played + " games");
                System.out.println("Person " + (i + 1) + " didn't play " + nplayed + " games");
                System.out.print("Person " + (i + 1) + " played the games: ");
                for (int j = 0; j < played; j++) {
                    System.out.print(group[i].games[j] + " ");
                }
            }
            int totalCost = esselworld.getCost();
            System.out.println("Total Cost: " + totalCost);
		}
		else {
			System.out.print("Please enter a valid input!");
		}

        input.close();
	}
}
