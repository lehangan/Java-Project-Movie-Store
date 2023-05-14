package OtherProjects.hust.soict.globalict.lab01;
import java.util.Arrays;

public class numericArray {
    public static void main(String[] args) {
        // Input array
        int[] arr = { 1789, 2035, 1899, 1456, 2013 };

        // Sort the array
        Arrays.sort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));

        // Calculate sum of array elements
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("Sum of Array Elements: " + sum);

        // Calculate average of array elements
        double average = (double) sum / arr.length;
        System.out.println("Average of Array Elements: " + average);
    }
}
