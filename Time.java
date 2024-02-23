import java.util.Scanner;

class Time{
    public static void secstohours(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter time in seconds: ");
        int time = input.nextInt();
        int hours = time / 3600;
        int remtime = time % 3600;
        int minutes = remtime / 60;
        int seconds = remtime % 60;
        System.out.println("Equivalent time: " + hours + " hours " + minutes + " minutes " + seconds + " seconds");
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
        System.out.println("Equivalent time: " + time + " seconds");
        input.close();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Choose an option: \n 1. Convert seconds to hours, minutes and seconds. \n 2. Convert hours, minutes and seconds to seconds. \n Your choice: ");
        int option = input.nextInt();
        if (option == 1){
            secstohours();
        }
        else if (option == 2){
            hourstosecs();
        }
        else {
            System.out.println("Please choose a valid option(number)");
        }
        input.close();
    }
}