import java.util.Arrays;
import java.util.Scanner;

public class Exercise {
    public static int counter = 0;
    public static int[] fibArray;
    public static int fibo(int n){
        counter++;
        if(fibArray[n] != -1) return fibArray[n];
        if(n <= 0) return fibArray[0] = 0;
        if(n == 1) return fibArray[1] = 1;
        int t1 = (fibArray[n-1] != -1)? fibArray[n-1]:fibo(n-1);
        int t2 = (fibArray[n-2] != -1)? fibArray[n-2]:fibo(n-2);
        fibArray[n] = t1+t2;
        return fibArray[n];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        fibArray = new int[n+1];
        Arrays.fill(fibArray, -1);
        for (int i = 0; i <= n; i++) {
            int result = fibo(i);
            System.out.print(result+ " ");
        }
        System.out.println("\nTotal recursive calls: "+counter);
        in.close();
    }
}
