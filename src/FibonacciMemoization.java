import java.util.Arrays;
import java.util.Scanner;

public class FibonacciMemoization {
    public static int[] fibo;
    public static int counter = 0;

    public static int fibo(int n){
        counter++;
        if(fibo[n] != -1) return fibo[n]; // Check if the value is already computed
        if(n <= 0) return fibo[n] = 0;
        if(n == 1) return fibo[n] = 1;

        int t1 = (fibo[n - 1] != -1)? fibo[n - 1] : fibo(n - 1);
        int t2 = (fibo[n - 2] != -1) ? fibo[n - 2] : fibo(n - 2);
        fibo[n] = t1 + t2;
        return fibo[n];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter how many Fibonacci numbers to generate:");
        int n = in.nextInt();
        fibo = new int[n + 1];
        Arrays.fill(fibo, -1);
        for (int i = 0; i <= n; i++) {
            fibo(i);
        }
        for (int result : fibo) {
            System.out.print(result + " ");
        }
        System.out.println("\nTotal recursive calls: " + counter);
        in.close();
    }
}
