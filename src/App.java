public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        for (int i = 0; i <= 10; i++) {
            while (i % 2 == 0 && i <= 10) {
                System.out.println("Even number: " + i);
                break;
            }
            if (i % 2 != 0) {
                System.out.println("Odd number: " + i);
            }
        }
    }
}