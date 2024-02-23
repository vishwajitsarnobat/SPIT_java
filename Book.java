import java.util.Scanner;

class Book {
    static Scanner input = new Scanner(System.in);
    static int[][] review_arr = new int[5][100];
    static int ctr = 0;
    static String[] book = {"The Alchemist", "The Lord of the Rings", "Wuthering Heights", "To Kill a Mockingbird", "1984"};

    static void evaluate_popular() {
        int max_avg = 0;
        int popular_book = -1;
        for (int i = 0; i < review_arr.length; i++){
            int avg = 0;
            for (int j = 0; j < 5; j++){
                avg += review_arr[i][j];
            }
            if (avg > max_avg){
                max_avg = avg;
                popular_book = i;
            }
        }
        
        System.out.println("The most popular book is: " + book[popular_book]);
    }

    static boolean review_monitor(int review) {
        if (review >= 1 && review <= 5){
            return true;
        }
        else {
            return false;
        }
    }

    static void success_handling() {
        System.out.println(" 1. Enter reviews as a new user. \n 2. Evaluate most popular book \n 3. Exit");
        System.out.print("Your choice: ");
        int option = input.nextInt();

        if (option == 1) {
            add_review();
        }
        else if (option == 2) {
            evaluate_popular();
        }
        else if (option == 3){
            System.out.println("Code terminated");
        }
        else {
            System.out.println("Please enter a valid input...");
        }
    }

    static void add_review() {
        System.out.println("Enter the ratings for following books: ");

        for (int i = 0; i < 5; i++) {
            System.out.print(book[i] + ": ");
            int review = input.nextInt();
            while (!review_monitor(review)){
                System.out.print("Please enter a valid review: ");
                review = input.nextInt();
            }            
                review_arr[i][ctr] = review;
        }

        ctr++;

        success_handling();
    }


    public static void main (String[] args) {
        System.out.println("NOTE: The program can take reviews from max of 100 users");
        add_review();
        input.close();
    }
}