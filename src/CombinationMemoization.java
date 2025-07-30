import java.util.Arrays;
import java.util.Scanner;

public class CombinationMemoization {
    public static int [][] memo;
    public static int counter = 0;

    public static int com(int n , int r){
        counter++;
        // Check if the value is already computed
        if(n < 0 || r < 0) return 0; // If n or r is negative, combination is not defined
        if(memo[n][r] != -1) return memo[n][r];
        // Base case: if r is 0 or n equals r, return 1
        if(r == 0 || r == n) return 1;
        // Recursive case: calculate combination using memoization
        if(n < r) return 0; // If n is less than r, combination is not defined
        // Check memoization table for previously computed values
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
        System.out.println("Total recursive calls: " + counter);
        in.close();
    }
}
