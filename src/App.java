import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello, World!");
        for (int i = 0; i <= 10; i++) {
            if (i % 2 != 0) {
                System.out.println("Odd number: " + i);
            }
        }
        System.out.println("Enter a value: ");
        int k = in.nextInt();
        System.out.println("You entered the value: " + k);
        in.close();
    }
}