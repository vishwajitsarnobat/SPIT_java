import java.util.Scanner;

class War {
    static Scanner input = new Scanner(System.in);

    static void execute() {
        System.out.print("Enter the encrypted message: ");
        String enMsg = input.next();
        
        for (int key = 1; key <= 100; key++) {
            char[] msg = new char[enMsg.length()];
            for (int i = 0; i < enMsg.length(); i++) {
                if (enMsg.charAt(i) >= 32 + key) {
                    msg[i] = (char)(enMsg.charAt(i) - key);
                }
                else {
                    msg[i] = (char)(enMsg.charAt(i) + 95 - key);
                }
            }
            System.out.println(msg);
        }
        
        success_handling();
    }
    
    static void success_handling() {
        System.out.println(" 1. Decrypt another message \n 2. Exit");
        System.out.print("Your choice: ");
        int option = input.nextInt();

        switch (option) {
            case 1:
                execute();
                break;
        
            case 2:
                System.out.println("Code terminated");
                break;

            default:
                System.out.println("Please enter a valid input");
                success_handling();
        }
    }

    public static void main(String[] args) {
        execute();
        input.close();
    }
}