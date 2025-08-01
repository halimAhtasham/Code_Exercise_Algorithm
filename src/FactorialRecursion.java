import java.util.Scanner;
public class FactorialRecursion {
    public static int counter = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number to calculate its factorial:");
        int n = in.nextInt();
        long result = factorial(n);
        System.out.println("Factorial of " + n + " is: " + result);
        System.out.println("Total recursive calls: " + counter);
        in.close();
    }
    private static long factorial(int n) {
        counter++;
        if (n <= 1) return 1l;
        long result = factorial(n - 1);
        return n * result;
    }
}
