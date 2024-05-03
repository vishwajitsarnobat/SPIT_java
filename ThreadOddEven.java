class PrintNumber extends ThreadOddEven implements  Runnable {
    int n; // 0 for printing even numbers and 1 for odd
    Object sync1;
    Object sync2;

    PrintNumber(int n,  Object sync1, Object sync2) {
        this.n = n;
        this.sync1 = sync1;
        this.sync2 = sync2;
    }

    public void run() {
        while (true) {
            try {
                if(n % 2 == 0){
                    System.out.println("Even num: " + n);
                }
                else {
                    System.out.println("Odd num: " + n);
                }
                sumNum += n;
                n += 2;
                Thread.sleep(1000);
                synchronized (sync2) {
                   sync2.notify();
                }
                synchronized(sync1) {
                    sync1.wait();
                }
            } catch (InterruptedException e) {
                System.out.println("Faced Interrupted Exception");
                e.printStackTrace();
                break;
            }
        }
    }
}

class Sum  extends ThreadOddEven implements Runnable{
    Object sync1;
    Object sync2;

    Sum( Object sync1, Object sync2){
        this.sync1 = sync1;
        this.sync2 = sync2;
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Sum: " + sumNum);
                sumNum = 0;
                Thread.sleep(1000);
                synchronized (sync2) {
                   sync2.notify();
                }
                synchronized(sync1) {
                    sync1.wait();
                }
            } catch (InterruptedException e) {
                System.out.println("Faced Interrupted Exception");
                e.printStackTrace();
                break;
            }
        }
    }
}

public class ThreadOddEven {
    static Object sync1 = new Object();
    static Object sync2 = new Object();
    static Object sync3 = new Object();
    static Integer sumNum = 0;
    public static void main(String[] args) {
        
        PrintNumber even = new PrintNumber(0, sync1, sync2);
        PrintNumber odd = new PrintNumber(1, sync2, sync3);
        Sum sum = new Sum( sync3, sync1);

        new Thread(even).start();
        new Thread(odd).start();
        new Thread(sum).start();
    }
}