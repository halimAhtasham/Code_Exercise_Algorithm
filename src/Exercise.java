import java.util.Arrays;
import java.util.Scanner;

public class Exercise {

    public static int counter = 0;
    public static int[][] ncr;
    

    public static int nCr(int n, int r){
        counter++;
        if(ncr[n][r] != -1) return ncr[n][r];
        if(n < 0 || r < 0 || n < r) return ncr[n][r] = 0;  
        if(n == r || r == 0) return ncr[n][r] = 1;
        int t1 = (ncr[n-1][r-1] != -1)?ncr[n-1][r-1]:nCr(n-1,r-1);
        int t2 = (ncr[n-1][r] != -1)?ncr[n-1][r]:nCr(n-1, r);
        ncr[n][r] = t1+t2;
        return ncr[n][r];
    }

    //fibonacci method
    // public static int[] fibArray;
    // public static int fibo(int n){
    //     counter++;
    //     if(fibArray[n] != -1) return fibArray[n];
    //     if(n <= 0) return fibArray[0] = 0;
    //     if(n == 1) return fibArray[1] = 1;
    //     int t1 = (fibArray[n-1] != -1)? fibArray[n-1]:fibo(n-1);
    //     int t2 = (fibArray[n-2] != -1)? fibArray[n-2]:fibo(n-2);
    //     fibArray[n] = t1+t2;
    //     return fibArray[n];
    // }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        ncr = new int[n+1][r+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(ncr[i], -1);
        }

        int result = nCr(n, r);
        System.out.println("Combination: " + result + "\nTotal recursive calls: " + counter);

        // Fibonacci calculation
        // fibArray = new int[n+1];
        // Arrays.fill(fibArray, -1);
        // for (int i = 0; i <= n; i++) {
        //     int result = fibo(i);
        //     System.out.print(result+ " ");
        // }
        // System.out.println("\nTotal recursive calls: "+counter);
        in.close();
    }
}
