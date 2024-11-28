package programs;
// Exception classes
class ShortageException extends Exception {
    public ShortageException(String msg) {
        super(msg);
    }
}

class TendorException extends Exception {
    public TendorException(String msg) {
        super(msg);
    }
}

// Build class
 class Build {
    public int length;
    public int width;

    // Constructor
    public Build(int length, int width) {
        this.length = length;
        this.width = width;
    }

    // Method to determine if the build is possible
    public String builder(int blength, int bwidth, int count) throws ShortageException, TendorException {
        int totalArea = this.length * this.width; // Total area of the build
        int brickArea = blength * bwidth; // Area of one brick
        int bricksRequired = totalArea / brickArea; // Total bricks required (if exact division is possible)

        // Check if the brick dimensions evenly divide the build dimensions
        boolean lengthDivisible = (this.length % blength == 0);
        boolean widthDivisible = (this.width % bwidth == 0);

        // Case 1: Dimensions match, sufficient bricks
        if (lengthDivisible && widthDivisible && bricksRequired <= count) {
            return "Builder!!";
        }

        // Case 2: Dimensions match, insufficient bricks
        if (lengthDivisible && widthDivisible && bricksRequired > count) {
            throw new ShortageException("Need more bricks");
        }

        // Case 3: Dimensions mismatch, sufficient bricks
        if ((!lengthDivisible || !widthDivisible) && bricksRequired <= count) {
            throw new TendorException("Building dimension mismatched");
        }

        // Case 4: Dimensions mismatch, insufficient bricks
        if ((!lengthDivisible || !widthDivisible) && bricksRequired > count) {
            throw new ShortageException("Need more bricks with dimension mismatched");
        }

        return ""; // Should not reach here
    }
}

// Main class for testing
public class BuilderBricks {
    public static void main(String[] args) {
        try {
            Build build = new Build(100, 100);

            // Test case 1: Sufficient bricks, dimensions match
            System.out.println(build.builder(10, 10, 100));

            // Test case 2: Insufficient bricks, dimensions match
            System.out.println(build.builder(10, 10, 50));
        } catch (ShortageException | TendorException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        try {
            // Test case 3: Sufficient bricks, dimensions mismatch
            Build build = new Build(100, 100);
            System.out.println(build.builder(15, 10, 100));
        } catch (ShortageException | TendorException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        try {
            // Test case 4: Insufficient bricks, dimensions mismatch
            Build build = new Build(100, 100);
            System.out.println(build.builder(15, 10, 50));
        } catch (ShortageException | TendorException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}


    

