import java.util.Scanner;

class EvenOdd {

    public static boolean isEven (int num) {
        if (num % 2 == 0){
            return false;
        }
        return true;
    }

    public static void main (String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input start value of range: ");
        int start = input.nextInt();
        System.out.print("Input end value of range: ");
        int end = input.nextInt();
        int evenctr = 0;
        int oddctr = 0;

        System.out.print("List of even numbers in given range: ");
        for (int i = start; i <= end; i++){
            if (isEven(i)){
                System.out.print(i + " ");
                evenctr++;
            }
        }

        System.out.println();

        System.out.print("List of odd numbers in given range: ");
        for (int i = start; i <= end; i++){
            if (!isEven(i)){
                System.out.print(i + " ");
                oddctr++;
            }
        }
        
        System.out.println();

        System.out.print("Even numbers in range: ");
        System.out.println(evenctr);
        System.out.print("Odd numbers in range: ");
        System.out.println(oddctr);

        input.close();
    }
}
