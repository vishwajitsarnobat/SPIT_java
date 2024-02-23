import java.util.Scanner;

class User {
    String name;
    int age;
    int balance;

    User(String name, int age, int balance) {
        this.name = name;
        this.age = age;
        this.balance = balance;
    }
}

class Movie {
    String movie_name;
    int age_limit;
    int cost;

    Movie(String movie_name, int age_limit, int cost) {
        this.movie_name = movie_name;
        this.age_limit = age_limit;
        this.cost = cost;
    }
}

class Main {
    public static void watch(User user) {
        Movie POC = new Movie("Pirates of the Carribean Series", 18, 500);
        Movie Tenet = new Movie("Tenet", 14, 350);
        Movie Interstellar = new Movie("Interstellar", 16, 350);
        Movie JW = new Movie("John Wick Series", 16, 500);
        Movie MI = new Movie("Mission Impossible Series", 16, 600);
        Movie Inception = new Movie("Inception", 16, 350);
        Movie Veronica = new Movie("Veronica", 16, 400);

        Scanner input = new Scanner(System.in);
        System.out.println("Choose a movie to watch: \n 1. Pirates of the Carribean Series \n 2. Tenet");
        System.out.println(" 3. Interstellar \n 4. John Wick Series \n 5. Mission Impossible Series");
        System.out.println(" 6. Inception \n 7. Veronica \n 8. Exit");
        System.out.print("Your choice: ");
        int option = input.nextInt();

        switch (option) {
            case 1:
                verify(user, POC);
                break;

            case 2:
                verify(user, Tenet);
                break;

            case 3:
                verify(user, Interstellar);
                break;

            case 4:
                verify(user, JW);
                break;

            case 5:
                verify(user, MI);
                break;

            case 6:
                verify(user, Inception);
                break;

            case 7:
                verify(user, Veronica);
                break;

            case 8:
                System.out.println("See you soon! :)");
                break;

            default:
                System.out.println("Please choose a valid option!");
                watch(user);
        }
        input.close();
    }

    public static void failure_handling(User user) {
        Scanner input = new Scanner(System.in);
        System.out.print(" 1. Choose something else to stream. \n 2. Exit. \n Your choice: ");
        int option = input.nextInt();
        if (option == 1) {
            watch(user);
        } else if (option == 2) {
            System.out.println("See you soon! :)");
        } else {
            System.out.println("Please choose a valid option: ");
            failure_handling(user);
        }
        input.close();
    }

    public static void success_handling(User user) {
        Scanner input = new Scanner(System.in);
        System.out.println(" 1. Stream something else. \n 2. Exit");
        int option = input.nextInt();
        if (option == 1) {
            watch(user);
        } else if (option == 2) {
            System.out.println("See you soon! :)");
        } else {
            System.out.println("Please choose a valid option");
            success_handling(user);
        }
        input.close();
    }

    public static void verify(User user, Movie movie) {
        if (user.age < movie.age_limit) {
            System.out.println("Sorry! but this movie is not suggested for your age.");
            failure_handling(user);
        } else if (user.balance < movie.cost) {
            System.out.println("You don't have enough balance to stream this.");
            failure_handling(user);
        } else {
            user.balance -= movie.cost;
            System.out.println(" Amount debited: " + movie.cost + "\n Remaining account balance: " + user.balance);
            System.out.println(" Happy Streaming! :) \n\n ---------------------------- \n");
            success_handling(user);
        }
    }

    public static void movie(User user) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose an option: \n 1. Watch a movie. \n 2. Check account balance. \n 3. Exit.");
        System.out.print("Your choice: ");
        int option = input.nextInt();

        if (option == 1) {
            watch(user);
        } else if (option == 2) {
            System.out.println("Your account balance is: " + user.balance);
            movie(user);
        } else if (option == 3) {
            System.out.println("See you soon! :)");
        } else {
            System.out.println("Please choose a valid option!");
            movie(user);
        }
        input.close();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome! Please enter your credentials below: ");
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.print("Enter your age: ");
        int age = input.nextInt();
        System.out.print("Enter your account balance: ");
        int balance = input.nextInt();
        User user = new User(name, age, balance);

        movie(user);

        input.close();
    }
}