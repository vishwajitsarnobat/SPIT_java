import java.util.Scanner;

class Armstrong {
	public static boolean isArmstrong(int num) {
		int cnum = num; // copy of num
		String str = Integer.toString(num);
		int length = str.length();
		int sum = 0;
		int rem = 0;
		while (num > 0){
			rem = num % 10;
			num = num / 10;
			sum = sum + (int)Math.pow(rem, length);
		}
		if (cnum == sum){
			return true;
		}
		return false;
	}

	public static void main (String args[]){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter start of range: ");
		int start = input.nextInt();
		System.out.print("Enter end of range: ");
		int end = input.nextInt();
		int ctr = 0;
		System.out.print("Armstrong numbers in the given range: ");
		for (int i = start; i <= end; i++){
			if (isArmstrong(i)){
				System.out.print(i + " ");
				ctr++;
			}
		}
		System.out.println();
		System.out.print("Total count of Armstrong numbers in the given range: ");
		System.out.println(ctr);
		input.close();
	}
}
