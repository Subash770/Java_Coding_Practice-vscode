package programs;


    class Batch {

        // Method to check if the length of the string is 12
        public boolean lengthCheck(String str) {
            return str.length() == 12;
        }
    
        // Method to validate the batch number
        public boolean batchNumberCheck(String str) {
            if (str.length() < 4) return false; // Ensure the batch number can be extracted
            char first = str.charAt(0);
            char second = str.charAt(1);
            char third = str.charAt(2);
            char fourth = str.charAt(3);
    
            // Check if first, second, and fourth characters are letters, and third is a digit
            return Character.isLetter(first) && Character.isLetter(second) 
                && Character.isDigit(third) && Character.isLetter(fourth);
        }
    
        // Method to validate the year
        public boolean yearCheck(String str) {
            int year = Integer.parseInt(str.substring(4, 8)); // Extract year
            return year >= 2015 && year <= 2020;
        }
    
        // Method to validate the month
        public boolean monthCheck(String str) {
            int month = Integer.parseInt(str.substring(8, 10)); // Extract month
            return month >= 1 && month <= 12;
        }
    
        // Method to validate the day
        public boolean dayCheck(String str) {
            int day = Integer.parseInt(str.substring(10, 12)); // Extract day
            return day >= 1 && day <= 31;
        }
    
        // Method to print the batch number if valid
        public String printBatchNumber(String str) {
            if (batchNumberCheck(str)) {
                return str.substring(0, 4); // Return the first 4 characters as batch number
            }
            return null;
        }
    
        // Method to print the date in DD/MM/YYYY format if valid
        public String printDate(String str) {
            if (yearCheck(str) && monthCheck(str) && dayCheck(str)) {
                String year = str.substring(4, 8);
                String month = str.substring(8, 10);
                String day = str.substring(10, 12);
                return day + "/" + month + "/" + year; // Return the date in DD/MM/YYYY format
            }
            return null;
        }
    }
    
    // Main class for testing
    public class BatchNumDateValidator {
        public static void main(String[] args) {
            Batch batch = new Batch();
    
            String code1 = "BL7A20181201"; // Example valid input
            String code2 = "BL7A20211301"; // Invalid month
    
            // Test cases
            System.out.println("Code: " + code1);
            System.out.println("Length Check: " + batch.lengthCheck(code1));
            System.out.println("Batch Number: " + batch.printBatchNumber(code1));
            System.out.println("Date: " + batch.printDate(code1));
    
            System.out.println("\nCode: " + code2);
            System.out.println("Length Check: " + batch.lengthCheck(code2));
            System.out.println("Batch Number: " + batch.printBatchNumber(code2));
            System.out.println("Date: " + batch.printDate(code2));
        }
    }
    