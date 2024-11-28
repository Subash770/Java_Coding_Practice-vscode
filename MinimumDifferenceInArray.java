package programs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumDifferenceInArray {
    public List<List<Integer>> minimumDifference(int[] arr) {
        // Sort the array to simplify finding pairs with minimum difference
        Arrays.sort(arr);

        // Initialize variables
        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        // Find the minimum difference
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        // Find all pairs with the minimum difference
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff == minDiff) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i - 1]);
                pair.add(arr[i]);
                result.add(pair);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumDifferenceInArray m = new MinimumDifferenceInArray();

        // Example 1
        int[] arr1 = {4, 2, 1, 3};
        System.out.println(m.minimumDifference(arr1)); // Output: [[1, 2], [2, 3], [3, 4]]

        // Example 2
        int[] arr2 = {12, 2, 5, 9, 11, 22, 25};
        System.out.println(m.minimumDifference(arr2)); // Output: [[11, 12]]
    }
}
