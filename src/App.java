import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i <= 10; i++) {
            if (i % 2 != 0) {
                System.out.println("Odd number: " + i);
            }
        }
        System.out.println("Enter a string");
        in.nextLine(); // Consume the newline character left by nextInt
        String s = in.nextLine();
        System.out.println("You entered : " + s);
        in.close();
    }
} 