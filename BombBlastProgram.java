package programs;
// BombBlast class derived from Exception
class BombBlast extends Exception {
    // Constructor to pass the message to the Exception class
    public BombBlast(String msg) {
        super(msg);  // Calls the parent class constructor to set the message
    }
}

// WalkingBoy class
class WalkingBoy {
    // Data members
    int stepSize;
    int blockSize;

    // Constructor
    public WalkingBoy(int stepSize, int blockSize) {
        this.stepSize = stepSize;
        this.blockSize = blockSize;
    }

    // Method to check if target is hit or not
    public String targetHit(String platform) throws BombBlast {
        // Divide the platform string into blocks of size blockSize
        int length = platform.length();
        int numBlocks = (length + blockSize - 1) / blockSize; // To get the number of blocks
        
        // Iterate over each block
        for (int i = 0; i < numBlocks; i++) {
            // Get the start and end indices for the current block
            int start = i * blockSize;
            int end = Math.min(start + blockSize, length);
            
            // Extract the block
            String block = platform.substring(start, end);
            
            // Consider the first 'stepSize' characters of the block
            String step = block.length() > stepSize ? block.substring(0, stepSize) : block;
            
            // Check if 'x' is in the first 'stepSize' characters
            if (step.contains("x")) {
                throw new BombBlast("You hit the target");
            }
        }
        
        // If no 'x' found, return "Win"
        return "Win";
    }
}

// Main class to test the functionality
public class BombBlastProgram {
    public static void main(String[] args) {
        try {
            // Create a WalkingBoy object with stepSize = 2 and blockSize = 3
            WalkingBoy boy = new WalkingBoy(2, 3);
            
            // Test the targetHit method with a platform string
            String result = boy.targetHit("1212121x212");
            
            // If no exception is thrown, print the result (win or loss)
            System.out.println(result);
        } catch (BombBlast e) {
            // Catch the BombBlast exception and print the message
            System.out.println("BombBlast : " + e.getMessage());
        }
    }
}


 
