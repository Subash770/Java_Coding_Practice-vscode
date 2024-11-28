package programs;
import java.util.ArrayList;
import java.util.Collections;
public class ArraylistOperations {

    // Method to calculate the sum of the given ArrayList
    public int sum(ArrayList<Integer> numbers) {
        int total = 0;
        for (int i : numbers) {
            total += i;
        }
        return total;
    }

    // Setting the element at index 2 as 20  //01234--indexing  //12345--size
    public ArrayList<Integer> index(ArrayList<Integer> list) {
        if (list.size() > 2) {
            list.set(2, 20);
        }
        return list;
    }

    // Retrieve the element at index 1      //01234--indexing  //12--size
    public int retrieve(ArrayList<Integer> list) {
        if (list.size() > 1) {
            return list.get(1);
        }
        return -1; // Return -1 if index 1 does not exist
    }
    //method to reverse the arraylist
    public ArrayList<Integer> reverse(ArrayList<Integer> numbers){
        Collections.reverse(numbers);
        return numbers;
    }
    //method to convert the arrayllist into a single int
    public int convertToInt(ArrayList<Integer>numbers){
        StringBuilder sb=new StringBuilder();
        for(int i:numbers){
            sb.append(i);
        }
        return Integer.parseInt(sb.toString());
    }
    // Main method
    public static void main(String[] args) { // Corrected "Main" to "main"
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(10);
        numbers.add(15);
        numbers.add(40);

        ArraylistOperations a = new ArraylistOperations();

        // Testing sum method
        int resultsum = a.sum(numbers);
        System.out.println("Sum of numbers: " + resultsum);

        // Testing index method
        ArrayList<Integer> secondIndex = a.index(numbers);
        System.out.println("Modified list: " + secondIndex);

        // Testing retrieve method
        int firstIndex = a.retrieve(numbers);
        System.out.println("Retrieved value at index 1: " + firstIndex);

        ArrayList<Integer> reversedArray=a.reverse(numbers);
        System.out.println("Reversed array :"+reversedArray);

        int valueInt=a.convertToInt(numbers);
        System.out.println("Converted int :"+valueInt);
    }
}
