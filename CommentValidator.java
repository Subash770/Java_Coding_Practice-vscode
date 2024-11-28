package programs;
    // Custom Exception Class: SpamCommentException
class SpamCommentException extends Exception {
    public SpamCommentException(String msg) {
        super(msg);
    }
}

// Validator Class
class Validator {
    // Method to validate the comment
    public String checkComment(String comment) throws SpamCommentException {
        String[] spamWords = {"abcde", "lmno", "pqrst", "wxyz"};
        String[] commentWords = comment.split("\\s+");
        int spamCount = 0;

        for (String word : commentWords) {
            for (String spamWord : spamWords) {
                if (word.equalsIgnoreCase(spamWord)) {
                    spamCount++;
                }
            }
        }

        if (spamCount > 2) {
            throw new SpamCommentException("account ban due to spam comment");
        } else if (spamCount > 0) {
            throw new SpamCommentException("spam comment");
        }

        return "comment is not spam";
    }

    // Method to post the comment
    public String commentTheString(String comment) {
        try {
            // Validate the comment using checkComment method
            String validationResult = checkComment(comment);
            return "comment posted"; // If no exception, comment is posted
        } catch (SpamCommentException e) {
            return e.getMessage(); // Return specific SpamCommentException message
        } catch (Exception e) {
            return "other exception"; // Handle other exceptions
        }
    }
}

// Main Class to Test the Code
public class CommentValidator {
    public static void main(String[] args) {
        Validator obj = new Validator();

        try {
            // Test checkComment method
            System.out.println(obj.checkComment("hello my name is steve"));
            System.out.println(obj.checkComment("hello my name is steve and using abcde abcde lmno"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Test commentTheString method
        System.out.println(obj.commentTheString("hello my name is steve"));
        System.out.println(obj.commentTheString("my comment includes abcde abcde lmno"));
    }
}
