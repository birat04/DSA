package Algo;
import java.util.Scanner;
import java.util.Arrays;

public class BinarySearch {
    public static int search(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter elements in sorted order:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the element to search: ");
        int key = scanner.nextInt();

        int result = search(arr, key);

        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found.");
        }
        
        scanner.close();
    }
}