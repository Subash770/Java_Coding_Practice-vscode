package programs;


import java.util.Scanner;

// Define an enum type called TrafficColor
enum TrafficColor {
    RED, GREEN, YELLOW;
}

public class TrafficLightSystemNextOnly {

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
                throw new IllegalArgumentException("Invalid TrafficColor");
        }
    }

    // Function to map integer input to TrafficColor enum
    public static TrafficColor mapToColor(int colorCode) {
        switch (colorCode) {
            case 1:
                return TrafficColor.RED;
            case 2:
                return TrafficColor.GREEN;
            case 3:
                return TrafficColor.YELLOW;
            default:
                throw new IllegalArgumentException("Invalid input: Use 1 for RED, 2 for GREEN, 3 for YELLOW");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of color inputs
        System.out.print("Enter the number of colors: ");
        int numberOfInputs = scanner.nextInt();

        // Process each input to determine the next color
        System.out.println("Enter the colors (1 for RED, 2 for GREEN, 3 for YELLOW):");
        for (int i = 0; i < numberOfInputs; i++) {
            int colorCode = scanner.nextInt();
            TrafficColor currentColor = mapToColor(colorCode);
            TrafficColor nextColor = nextColor(currentColor);
            System.out.println("Next color: " + nextColor);
        }

        scanner.close();
    }
}


  
