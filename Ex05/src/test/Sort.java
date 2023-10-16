package test;
import java.util.Arrays;
import java.util.Scanner;

public class Sort{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Option 1: User input
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Option 2: Constant array for testing
        // int[] numbers = {45, 12, 78, 32, 56, 89, 23, 68, 17, 49};

        // Sort the array in ascending order
        Arrays.sort(numbers);

        // Calculate the sum of elements
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        // Compute the average value
        double average = (double) sum / numbers.length;

        // Display the sorted array, sum, and average
        System.out.println("Sorted Array: " + Arrays.toString(numbers));
        System.out.println("Sum of Array Elements: " + sum);
        System.out.println("Average of Array Elements: " + average);

        scanner.close();
    }
}
