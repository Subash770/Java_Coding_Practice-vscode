package programs;
import java.util.Scanner;

// Define an enum type called TrafficColor
enum TrafficColor {
    RED, GREEN, YELLOW;
}

public class TrafficLightSystem {

    // Function to return the next color in the sequence
    public static TrafficColor nextColor(TrafficColor currentColor) {
        switch (currentColor) {
            case RED:
                return TrafficColor.GREEN;
            case GREEN:
                return TrafficColor.YELLOW;
            case YELLOW:
                return TrafficColor.RED;
            default:
                return null; // This case will never be reached
        }
    }

    // Function to print the color
    public static void printColor(TrafficColor color) {
        switch (color) {
            case RED:
                System.out.println("RED");
                break;
            case GREEN:
                System.out.println("GREEN");
                break;
            case YELLOW:
                System.out.println("YELLOW");
                break;
        }
        System.out.println(); // Add a new line after each color display
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the total number of colors to switch through
        System.out.print("Enter the total number of color switches: ");
        int totalSwitches = scanner.nextInt();

        // Initialize the current color to GREEN as per the sample
        TrafficColor currentColor = TrafficColor.GREEN;

        // Loop through the number of color switches
        for (int i = 0; i < totalSwitches; i++) {
            // Print the current color
            printColor(currentColor);

            // Move to the next color
            currentColor = nextColor(currentColor);
        }

        scanner.close();
    }
}


    