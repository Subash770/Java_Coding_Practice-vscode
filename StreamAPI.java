package programs;
import java.util.List;
import java.util.stream.IntStream;
import java.util.Arrays;

class StreamApiMethods {
    
    // Method to count the number of components in the ArrayList
    public int count(List<String> list) {
        // Use stream to count the number of elements in the list
        return (int) list.stream().count();
    }
    
    // Method to check if a number is perfect using IntStream
    public boolean checkPerfect(int number) {
        // Calculate the sum of divisors of the number excluding itself
        int sum = IntStream.range(1, number)
                          .filter(i -> number % i == 0)
                          .sum();
        
        // Return true if the sum of divisors equals the number (perfect number)
        return sum == number;
    }
    
    // Method to check if any element in the list contains the letter 'e'
    public void match(List<String> list) {
        // Use anyMatch to check if any element contains 'e'
        boolean containsE = list.stream()
                                .anyMatch(s -> s.contains("e"));
        
        // Print the appropriate message based on the result
        if (containsE) {
            System.out.println("Cant fool the system, that sentence contain e");
        } else {
            System.out.println("Great Job that sentence does not contain e");
        }
    }
}


public class StreamAPI {
    public static void main(String[] args) {
        // Sample data
        List<String> list = Arrays.asList("Hello", "world", "example", "java");
        
        // Create Source object to call methods
        StreamApiMethods s = new StreamApiMethods();
        
        // Test count method
        System.out.println("Count: " + s.count(list));  // Output: 4
        
        // Test checkPerfect method
        System.out.println("Is 6 perfect? " + s.checkPerfect(6));  // Output: true
        System.out.println("Is 28 perfect? " + s.checkPerfect(28));  // Output: true
        System.out.println("Is 10 perfect? " + s.checkPerfect(10));  // Output: false
        
        // Test match method
        s.match(list);  // Output: Cant fool the system, that sentence contain e
    }
}


    
