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

      
        Arrays.sort(numbers);

       
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        
        double average = (double) sum / numbers.length;

       
        System.out.println("Sorted Array: " + Arrays.toString(numbers));
        System.out.println("Sum of Array Elements: " + sum);
        System.out.println("Average of Array Elements: " + average);

        scanner.close();
    }
}
