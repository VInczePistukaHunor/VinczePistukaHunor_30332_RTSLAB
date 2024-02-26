package Lab1;

import java.util.Arrays;
import java.util.Random;

public class Ex3_RandomNumberSorter {
    public static void main(String[] args) {
        // Create an array to store the random numbers
        int[] numbers = new int[10];

        // Generate and store 10 random numbers
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100); // Generates random numbers between 0 and 99
        }

        // Display the unsorted numbers
        System.out.println("Unsorted Numbers:");
        for (int number : numbers) {
            System.out.println(number);
        }

        // Sort the array
        Arrays.sort(numbers);

        // Display the sorted numbers
        System.out.println("\nSorted Numbers:");
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
