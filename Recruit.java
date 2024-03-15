import java.util.Scanner;

class Recruitment {
    static void rules(int marks, int totalMarks) {
        if (marks > (double) (totalMarks * 0.6)) {
            System.out.println();
            System.out.println("Congrats! You've passed the test. You have scored " + marks + " marks out of 32");
        } else {
            System.out.println();
            System.out.println("Better Luck next time. You have scored " + marks + " marks out of 32");
        }
    }
}

class Testing extends Recruitment {
    static Scanner input = new Scanner(System.in);

    static int check(int[] options) {
        int[] mark0 = { 2, 1, 1, 0, 4, 2, 4, 0 }; // incorrect answers.
        int[] mark2 = { 1, 2, 2, 0, 3, 1, 3, 0 };
        int[] mark3 = { 4, 3, 4, 0, 1, 3, 1, 2 };
        int[] mark4 = { 3, 4, 3, 3, 2, 4, 2, 1 };
        int sum = 0;

        for (int i = 0; i < options.length; i++) {
            if (options[i] == mark2[i]) {
                sum += 2;
            } else if (options[i] == mark3[i]) {
                sum += 3;
            } else if (options[i] == mark4[i]) {
                sum += 4;
            }
        }
        return sum;
    }

    static void takeTest() {
        int[] options = new int[8];
        int ctr = 0;
        System.out.println("Section A: ");
        System.out.println(
                "\n 1. What is the vision of the company? \n     1. To grow socially. \n     2. To go bankrupt. \n     3. To grow together along with all the employees. \n     4. To maximise profits");
        System.out.print("Your choice: ");
        options[ctr++] = input.nextInt();
        System.out.println(
                "\n 2. How long will you stay in this role? \n     1. A month. \n     2. A year. \n     3. More than 2 years. \n     4. More than 5 years.");
        System.out.print("Your choice: ");
        options[ctr++] = input.nextInt();

        System.out.println();
        System.out.println("Section B: ");
        System.out.println(
                "\n 1. What is the final method in Java? \n     1. No idea. \n     2. variable values cannot be changed. \n     3. Methods that cannot be overridden. \n     4. Used to fix methods, classes and variables in java");
        System.out.print("Your choice: ");
        options[ctr++] = input.nextInt();
        System.out.println(
                "\n 2. What is the latest version of Java? \n     1. 19.0. \n     2. 20.0. \n     3. 21.0.  \n     4. 22.0.");
        System.out.print("Your choice: ");
        options[ctr++] = input.nextInt();

        System.out.println();
        System.out.println("Section C: ");
        System.out.println(
                "\n 1. What did you learn about Java in your last job? \n     1. Everything. \n     2. Tried to learn as much as possible everyday. \n     3. Basics of java \n     4. No idea what java is");
        System.out.print("Your choice: ");
        options[ctr++] = input.nextInt();
        System.out.println(
                "\n 2. What do you wish to learn? \n     1. Nothing. \n     2. Everything from scratch. \n     3. Advanced concepts.  \n     4. Everything necessary for getting the job done.");
        System.out.print("Your choice: ");
        options[ctr++] = input.nextInt();

        System.out.println();
        System.out.println("Section D: ");
        System.out.println(
                "\n 1. What makes a team successful? \n     1. Individual Hard Work. \n     2. Team coordination. \n     3. Good Leadership \n     4. Depends on the assigned task.");
        System.out.print("Your choice: ");
        options[ctr++] = input.nextInt();
        System.out.println(
                "\n 2. Do you work faster in a team or as an individual? \n     1. Team. \n     2. Individual.");
        System.out.print("Your choice: ");
        options[ctr++] = input.nextInt();

        int marks = check(options);

        rules(marks, 32);
    }
}

class Recruit {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("1. Take test. \n 2. Exit.");
        System.out.print("Your choice: ");
        int opt = input.nextInt();
        if (opt == 1) {
            System.out.println();
            Testing.takeTest();
        }
    }
}