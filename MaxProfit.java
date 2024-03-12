import java.util.Scanner;

class MaxProfit {
    static Scanner input = new Scanner(System.in);

    static int execute(int[] arr) {

        int[] max = new int[arr.length];
        int[] min = new int[arr.length];
        int maxCtr = 0;
        int minCtr = 0;
        int sum = 0;
        boolean flag = false;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                max[maxCtr++] = arr[i];
            } else if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                min[minCtr++] = arr[i];
            }
        }

        // the below for loop is used to check whether the curve is increasing or decreasing in the beginning
        // loop is necessary as the initial values or all values may be all equal
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                flag = true;
                break;
            }
            else if (arr[i] < arr[i + 1]) {
                flag = false;
                break;
            }
        }

        if (flag) { // true flag implies graph decreases in the beginning and hence min.length >= max.length
            if (max.length == min.length) {
                for (int i = 0; i < min.length; i++) {
                    sum += (max[i] - min[i]); // if both min and max are equal, it implies that the graph ends with decreasing curve
                    // so the share is sold at the last maxima
                }
            }
            else {
                for (int i = 0; i < min.length - 1; i++) {
                    sum += (max[i] - min[i]); // max.length is 1 less than min.length, the graph ends with increasing curve
                    // so share is bought at last minima and is needed to be sold at last value
                }
                sum += (arr[arr.length - 1] - min[min.length - 1]); // subtracting last element of array from last element of minima
            }
        }
        else {  // false flag implies graph increases in the beginning and hence min.length <= max.length
            if (max.length == min.length) {
                sum += (max[0] - arr[0]); // subtracting first element of array from first element of max
                for (int i = 0; i < max.length - 1; i++) {
                    sum += (max[i + 1] - min[i]); // if both min and max are equal, it implies that the graph ends with increasing curve
                    // so the share is bought at the last minima and should be sold at last value
                }
                sum += arr[arr.length - 1] - min[min.length - 1]; // subtracting last element of min from last element of array
            }
            else {
                sum += max[0] - arr[0]; // subtracting first element of array from first element of max
                for (int i = 0; i < max.length; i++) {
                    sum += (max[i + 1] - min[i]); // max.length is 1 more than min.length, extra element is already used before loop.
                    //  the graph ends with decreasing curve, share sold at last maxima
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.print("Enter size of your array: ");
        int size = input.nextInt();
        int[] arr = new int[size];
        int ctr = 0;
        System.out.println("Start entering values in your array");
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + ": ");
            arr[ctr++] = input.nextInt();
        }
        
        System.out.println("The maximum possible profit is: Rs. " + execute(arr));
    }
}