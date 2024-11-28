package programs;

import java.util.ArrayList;
import java.util.Collections;

class ArrayListOps {
    
    // Method to create an ArrayList with 'n' components set to 0
    public ArrayList<Integer> convertArrayListtoInt(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(0); // Add 0 to the list 'n' times
        }
        return list;
    }

    // Method to reverse the elements of an ArrayList
    public ArrayList<Integer> reverse(ArrayList<Integer> list) {
        ArrayList<Integer> reversedList = new ArrayList<>(list); // Create a copy of the list
        Collections.reverse(reversedList); // Reverse the copy
        return reversedList;
    }
}

// Renamed the Source class to ArrayListOperations2 and made it public
public class ArrayListOperations2 {
    public static void main(String[] args) {
        ArrayListOps ops = new ArrayListOps();

        // Test convertArrayListtoInt
        ArrayList<Integer> zeroList = ops.convertArrayListtoInt(4);
        System.out.println(zeroList); // Expected Output: [0, 0, 0, 0]

        // Test reverse
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10, 25, 33, 28, 10, 12);
        ArrayList<Integer> reversedList = ops.reverse(list);
        System.out.println(reversedList); // Expected Output: [12, 10, 28, 33, 25, 10]
    }
}


    

