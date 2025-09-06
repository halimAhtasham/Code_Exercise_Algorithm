import java.util.Arrays;
import java.util.Scanner;

public class Exercise {

    // Factorial Recursive method
    public static int factorial(int n){
        if(n == 0) return 1;
        return n * factorial(n-1);
    }


    // Recursive power method
    // public static long power(long base, long power){
    //     if(power == 0) return 1l;
    //     if(power == 1) return base;
    //     long temp = power(base, power-1);
    //     return base * temp;
    // }


    // Efficient power recursive method 
    // public static long power(long base, long power){
    //     if(power == 0) return 1l;
    //     if(power == 1) return base;
    //     long temp = power(base, power/2);
    //     if(power % 2 == 0) return temp * temp;
    //     else return base * temp * temp;
    // }


    // Fibonacci Recursive method
    // public static int fibo(int n){
    //     if(n == 0) return 0;
    //     if(n == 1) return 1;
    //     return fibo(n-1) + fibo(n-2);
    // }

    public static int counter = 0;

    // Fibonacci Memoization Method
    // public static int[] f;
    // public static int fibo(int n){
    //     counter++;
    //     if(f[n] != -1) return f[n];
    //     if(n <= 0) return f[0] = 0;
    //     if(n == 1) return f[1] = 1;
    //     int t1 = (f[n-1] != -1)? f[n-1]: fibo(n-1);
    //     int t2 = (f[n-2] != -1)? f[n-2]: fibo(n-2);
    //     f[n] = t1 + t2;
    //     return f[n];
    // }


    // nCr Recursive Method
    // public static int nCr(int n , int r){
    //     if(n < r) return 0;
    //     if(r== 0 || r == n) return 1;
    //     return nCr(n-1, r-1) + nCr(n-1, r);
    // }


    // nCr memoization method
    // public static int[][] com;
    // public static int com(int n, int r){
    //     counter++;
    //     if(com[n][r] != -1) return com[n][r];
    //     if(n < r) return 0;
    //     if(r == 0 || r == n) return com[n][r] = 1;
    //     int t1 = (com[n-1][r-1] != -1)? com[n-1][r-1]: com(n-1, r-1);
    //     int t2 = (com[n-1][r] != -1)? com[n-1][r]: com(n-1, r);
    //     com[n][r] = t1 + t2;
    //     return com[n][r];
    // }


    public static int[][] lcs;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(factorial(n));
        System.out.println("\n"+counter);
        // long base = in.nextInt();   // Recursive power method
        // long power = in.nextInt();
        // long result = power(base, power);
        // System.out.println("Power :" + result);

        // int result = factorial(n); // Factorial
        // System.out.println("Factorial: "+ result);
        in.close();
    }
}
