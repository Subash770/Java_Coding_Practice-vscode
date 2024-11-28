package programs;

public class SeasonExample {

    // Enum Definition
    public enum Season {
        SPRING, SUMMER, FALL, WINTER
    }

    // Method to get the season based on the month
    public static String getSeason(int month) {
        if (month == 3 || month == 4 || month == 5) {
            return Season.SPRING.name();
        } else if (month == 6 || month == 7 || month == 8) {
            return Season.SUMMER.name();
        } else if (month == 9 || month == 10 || month == 11) {
            return Season.FALL.name();
        } else if (month == 12 || month == 1 || month == 2) {
            return Season.WINTER.name();
        } else {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
    }

    // Method to print the season in the specified format
    public static String printSeason(Season season) {
        return season.name() + " Season";
    }

    // Main Method for Testing
    public static void main(String[] args) {
        // Example Usage
        int month = 7; // Example input for month
        String seasonName = SeasonExample.getSeason(month); // Get the season
        System.out.println(SeasonExample.printSeason(Season.valueOf(seasonName))); // Print the season
    }
}
