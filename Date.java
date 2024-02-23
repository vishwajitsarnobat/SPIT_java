import java.util.Scanner;

class setDate {
    int year;
    int month;
    int date;
    int hrs;
    int min;
    int sec;

    setDate() {
        year = 0;
        month = 0;
        date = 0;
        hrs = 0;
        min = 0;
        sec = 0;
    }

    setDate(int year, int month, int date) {
        this.year = year;
        this.month = month;
        this.date = date;
    }

    setDate(int year, int month, int date, int hrs, int min) {
        this.year = year;
        this.month = month;
        this.date = date;
        this.hrs = hrs;
        this.min = min;
    }

    setDate(int year, int month, int date, int hrs, int min, int sec) {
        this.year = year;
        this.month = month;
        this.date = date;
        this.hrs = hrs;
        this.min = min;
        this.sec = sec;
    }

    public static void displayDate(setDate object, int condition){
        switch(condition) {
            case 1:
                System.out.println("Year : Month : Date = " + object.year + " : " + object.month + " : " + object.date);
            
            case 2:
                System.out.println("Year : Month : Date : Hour : Minutes = " + object.year + " : " + object.month + " : " + object.date + " : " + object.hrs + " : " + object.min);

            case 3:
            System.out.println("Year : Month : Date : Hour : Minutes : Seconds = " + object.year + " : " + object.month + " : " + object.date + " : " + object.hrs + " : " + object.min + " : " + object.sec);
        }
    }
}

class Date {
    static Scanner input = new Scanner(System.in);

    public static void ymd() {
        System.out.println("Enter Year: ");
        int year = input.nextInt();
        System.out.println("Enter Month: ");
        int month = input.nextInt();
        System.out.println("Enter Date: ");
        int date = input.nextInt();
        setDate ymd = new setDate(year, month, date); 

        setDate.displayDate(ymd, 1);
    }

    public static void ymdhm() {
        System.out.println("Enter Year: ");
        int year = input.nextInt();
        System.out.println("Enter Month: ");
        int month = input.nextInt();
        System.out.println("Enter Date: ");
        int date = input.nextInt();
        System.out.println("Enter Hours: ");
        int hrs = input.nextInt();
        System.out.println("Enter Minutes: ");
        int min = input.nextInt();
        setDate ymdhm = new setDate(year, month, date, hrs, min);

        setDate.displayDate(ymdhm, 2);
    }

    public static void ymdhms() {
        System.out.println("Enter Year: ");
        int year = input.nextInt();
        System.out.println("Enter Month: ");
        int month = input.nextInt();
        System.out.println("Enter Date: ");
        int date = input.nextInt();
        System.out.println("Enter Hours: ");
        int hrs = input.nextInt();
        System.out.println("Enter Minutes: ");
        int min = input.nextInt();
        System.out.println("Enter Seconds: ");
        int sec = input.nextInt();
        setDate ymdhms = new setDate(year, month, date, hrs, min, sec);

        setDate.displayDate(ymdhms, 3);
    }

    public static void success_handling() {
        System.out.println(" 1. Re-execute \n 2. Exit");
        System.out.print("Your choice: ");
        int option = input.nextInt();

        if (option == 1) {
            execute();
        } else if (option == 2) {
            System.out.println("Code terminated");
        } else {
            System.out.println("Please enetr a valid innput");
            success_handling();
        }
    }

    public static void execute() {
        System.out.println(
                " 1. Year : Month : Date \n 2. Year : Month : Date : Hours : Minutes \n 3. Year : Month : Date : Hours : Minutes : Seconds \n 4. Exit");
        System.out.print("Your choice: ");
        int option = input.nextInt();

        if (option == 1) {
            ymd();
            success_handling();
        } else if (option == 2) {
            ymdhm();
            success_handling();
        } else if (option == 3) {
            ymdhms();
            success_handling();
        } else if (option == 4) {
            System.out.println("Code terminated");
        } else {
            System.out.println("Please enter a valid input");
            execute();
        }
    }

    public static void main(String[] args) {
        execute();
        input.close();
    }
}