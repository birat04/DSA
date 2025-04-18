package Algo;
import java.util.Scanner;

public class FactorialRecursive {
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // Base case: 0! and 1! = 1
        }
        return n * factorial(n - 1); // Recursive case
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();

        if (num < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            System.out.println("Factorial of " + num + " is: " + factorial(num));
        }
    }
}
