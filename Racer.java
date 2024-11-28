package programs;
public class Racer {
    // Data members
    private String action;
    private int runScore;
    private int jumpScore;
    private int crawlScore;

    // Constructor
    public Racer(String action, int runScore, int jumpScore, int crawlScore) {
        this.action = action;
        this.runScore = runScore;
        this.jumpScore = jumpScore;
        this.crawlScore = crawlScore;
    }

    // Method to determine the racer's type
    public String goodAt() {
        int countJ = 0; // Count of 'j'
        int countC = 0; // Count of 'c'

        // Count occurrences of 'j' and 'c'
        for (char ch : action.toCharArray()) {
            if (ch == 'j') {
                countJ++;
            } else if (ch == 'c') {
                countC++;
            }
        }

        // Determine the result based on counts
        if (countJ == countC) {
            return "Perfect";
        } else if (countJ > countC) {
            return "Jumper";
        } else {
            return "Crawler";
        }
    }

    // Method to calculate the final score
    public int finalScore() {
        int totalScore = 0;

        // Calculate total score based on the action string
        for (char ch : action.toCharArray()) {
            if (ch == 'r') {
                totalScore += runScore;
            } else if (ch == 'j') {
                totalScore += jumpScore;
            } else if (ch == 'c') {
                totalScore += crawlScore;
            }
        }

        return totalScore;
    }

    // Main method for testing
    public static void main(String[] args) {
        Racer racer = new Racer("jjccrrj", 10, 20, 30);

        // Test goodAt() method
        System.out.println(racer.goodAt()); // Output: Jumper

        // Test finalScore() method
        System.out.println(racer.finalScore()); // Output: 140
    }
}
