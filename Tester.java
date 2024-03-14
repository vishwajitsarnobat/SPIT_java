import java.util.Scanner;

class Recruitment {

    static void marks(double marks, double totalMarks) {
        if (marks > totalMarks * 0.6) {
            System.out.println("Congrats! You've passed the test");
        } else {
            System.out.println("Better Luck next time");
        }
    }
}

class Testing extends Recruitment {
    static Scanner input = new Scanner(System.in);

    static boolean exists(int opt, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == opt) {
                return true;
            }
        }
        return false;
    }

    static double check(int[] marks) {
        int[] mark0 = {2, 1, 1, 0, 4, 2, 4, 0};
        int[] mark2 = {1, 2, 2, 0, 3, 1, 3, 0};
        int[] mark3 = {4, 3, 4, 0, 1, 3, 1, 2};
        int[] mark4 = {3, 4, 3, 3, 2, 4, 2, 1};

        int[] sum = new int[4];
        for (int i = 0; i < marks.length; i++) {
            if (exists(marks[i], mark0)) {
                sum[0]++;
            }
            else if (exists(marks[i], mark2)) {
                sum[1]++;
            }
            else if (exists(marks[i], mark3)) {
                sum[2]++;
            }
            else if (exists(marks[i], mark4)) {
                sum[3]++;
            }
        }

        double total = 0;
        for (int i = 0; i < 4; i++){
            total += sum[i];
        }
        return total;
    }

    static void takeTest() {
        System.out.println("Section A: ");
        System.out.println("\n 1. What is the vision of the company? \n 1. To grow socially. \n 2. To go bankrupt. \n 3. To grow together along with all the employees. \n 4. To maximize profits");
        System.out.println("\n 2. How long will you stay in this role? \n 1. A month. \n 2. A year. \n 3. More than 2 years. \n 4. More than 5 years.");

        int a1 = input.nextInt();

        System.out.println("Section B: ");
        System.out.println("\n 1. What is final method in Java? \n 1. No idea. \n 2. variable values cannot be changed. \n 3. Methods that cannot be overridden. \n 4. Used to fix methods, classes and variables in java");
        System.out.println("\n 2. What is the latest version of Java? \n 1. 19.0. \n 2. 20.0. \n 3. 21.0.  \n 4. 22.0.");

        int a2 = input.nextInt();

        System.out.println("Section C: ");
        System.out.println("\n 1. What did you learn about Java in last job? \n 1. Everything. \n 2. Tried to learn as much as possible everyday. \n 3. Basics of java \n 4. No idea what java is");
        System.out.println("\n 2. What do you wish to learn? \n 1. Nothing. \n 2. Everything from scratch. \n 3. Advanced concepts.  \n 4. Everything necessary for getting the job done.");

        int a3 = input.nextInt();

        System.out.println("Section D: ");
        System.out.println("\n 1. What makes a team successful? \n 1. Individual Hardwork. \n 2. Team co-ordination. \n 3. Good Leadership \n 4. Depends on the assigned task.");
        System.out.println("\n 2. Do you work faster in team or as individual? \n 1. Team. \n 2. Individual.");

        int a4 = input.nextInt();

        int[] arr = {a1, a2, a3, a4};
        double total = check(arr);
        double totalMarks = 32;

        Recruitment.marks(total, totalMarks);
    }
}

class Tester {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // System.out.print()
        Testing.takeTest();
    }
}