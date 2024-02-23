import java.util.Scanner;

class Prime {

    public static boolean isPrime(int num){
        if (num == 1){
            return false;
        }
        else if (num == 2){
            return true;
        }
        else for (int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input starting value of range: ");
        int start = input.nextInt();
        System.out.print("Input ending value of range: ");
        int end = input.nextInt();

        System.out.print("List of prime numbers in given range: ");

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }

        input.close();
    }
}