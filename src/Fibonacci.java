import java.util.Scanner;

public class Fibonacci {

    public static int fibonacci(int n){
        if(n <= 0) return 0;
        if(n == 1) return 1;
        int t = fibonacci(n - 1) + fibonacci(n - 2);
        return t;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter how many Fibonacci numbers to generate:");
        int n = in.nextInt();
        // int k = fibonacci(n);
        for(int i = 0; i <= n; i++){
            int k = fibonacci(i);
            System.out.print(k+ " ");
        }
        in.close();
    }
}
