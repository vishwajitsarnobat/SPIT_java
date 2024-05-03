import java.util.ArrayList;
import java.util.Scanner;

class Cricketer {
    String player_name;
    int runs_hit;
    int innings_count;
    int not_out_count;
    double batting_avg;

    Cricketer(String player_name,
        int runs_hit,
        int innings_count,
        int not_out_count,
        double batting_avg) {
            this.player_name = player_name;
            this.runs_hit = runs_hit;
            this.innings_count = innings_count;
            this.not_out_count = not_out_count;
            batting_avg = calculate_avg();
    }

    double calculate_avg() {
        return (double) runs_hit / (innings_count - not_out_count);
    }

    double get_avg() {
        return batting_avg;
    }
}

class Cricket {
    static Scanner input = new Scanner(System.in);

    static void sortAndDisplay(ArrayList<Cricketer> team) {
        team.sort((c1, c2) -> Double.compare(c1.batting_avg, c2.batting_avg));
        System.out.println("Player rankings as per batting average: ");
        for (int i = 0; i < team.size(); i++) {
            Cricketer member = team.get(i);
            System.out.print((i + 1) + "] Player name: " + member.player_name + ", ");
            System.out.print("Runs scored: " + member.runs_hit + ", ");
            System.out.print("Innings played: " + member.innings_count + ", ");
            System.out.print("Not out innings: " + member.not_out_count + "\n");
        }
    }

    static void addPlayer(ArrayList<Cricketer> team) {
        System.out.print("Enter player name: ");
        String player_name = input.nextLine();
        System.out.print("Enter total runs: ");
        int runs_hit = input.nextInt();
        while(runs_hit < 0) {
            try {
                throw new ArithmeticException("Runs scored cannot be negative!");
            }
            catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.print("Enter valid total runs: ");
                runs_hit = input.nextInt();
            }
        }

        System.out.print("Enter innings played: ");
        int innings_count = input.nextInt();
        while(innings_count < 1) {
            try {
                throw new ArithmeticException("Innings played scored cannot less than 1!");
            }
            catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.print("Enter valid innings played: ");
                innings_count = input.nextInt();
            }
        }

        System.out.print("Enter not out innings: ");
        int not_out_count = input.nextInt();
        while(innings_count < not_out_count) {
            try {
                throw new IllegalArgumentException("Not out count cannot exceed innings played");
            }
            catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.print("Enter valid not out count: ");
                not_out_count = input.nextInt();
            }
        }

        team.add(new Cricketer(player_name, runs_hit, innings_count, not_out_count, not_out_count));
        System.out.println("Player data created successfully!");
    }
    public static void main(String[] args) {
        ArrayList<Cricketer> team = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            addPlayer(team);
            input.nextLine();
        }
        System.out.print("\n");
        sortAndDisplay(team);
    }
}