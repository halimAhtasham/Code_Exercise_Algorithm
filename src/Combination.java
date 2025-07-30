import java.util.Scanner;

public class Combination {
    public static int counter = 0;

    // Recursive method to calculate combination
    // This method does not use memoization
    public static int combination(int n, int r){
        counter++;
        if(n == r || r == 0) return 1;
        int t1 = combination(n - 1, r - 1);
        int t2 = combination(n - 1, r);
        return t1 + t2;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n and r:");
        int n , r;
        n = in.nextInt();
        r = in.nextInt();
        int result = combination(n, r);
        System.out.println("Combination : " + result);
        System.out.println("Total recursive calls: " + counter);
        in.close();
    }
}
