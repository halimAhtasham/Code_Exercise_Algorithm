import java.util.Arrays;
import java.util.Scanner;

public class CombinationMemoization {
    public static int [][] memo;

    public static int com(int n , int r){
        if(memo[n][r] != -1) return memo[n][r];
        if(r == 0 || r == n) return 1;

        int t1 = (memo[n -1][r - 1] != -1) ? memo[n-1][r-1] : com(n-1, r-1);
        int t2 = (memo[n-1][r] != -1) ? memo[n-1][r] : com(n-1,r);
        memo[n][r] = t1 + t2;
        return memo[n][r];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n and r:");
        int n, r;
        n = in.nextInt();
        r = in.nextInt();
        memo = new int[n + 1][r + 1];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        int result = com(n, r);
        System.out.println("Combination : " + result);
        in.close();
    }
}
