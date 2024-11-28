package programs;    
// Header Class
class Header {
    String from;
    String to;

    // Constructor to initialize Header variables
    public Header(String from, String to) {
        this.from = from;
        this.to = to;
    }
}

// Email Class
class Email {
    Header header;
    String body;
    String greetings;

    // Constructor to initialize Email variables
    public Email(Header header, String body, String greetings) {
        this.header = header;
        this.body = body;
        this.greetings = greetings;
    }
}

// EmailOperations Class
class EmailOperations {
    // Method to validate email addresses
    public int emailVerify(Email e) {
        String emailRegex = "^[a-zA-Z_][a-zA-Z0-9_.]*@[a-zA-Z0-9]+\\.[a-zA-Z]+$";
        boolean isFromValid = e.header.from.matches(emailRegex);
        boolean isToValid = e.header.to.matches(emailRegex);

        if (isFromValid && isToValid) {
            return 2; // Both email addresses are valid
        } else if (isFromValid || isToValid) {
            return 1; // One email address is valid
        } else {
            return 0; // Both email addresses are invalid
        }
    }

    // Method to encrypt the body using Caesar cipher with shift 3
    public String bodyEncryption(Email e) {
        StringBuilder encryptedBody = new StringBuilder();

        for (char ch : e.body.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                encryptedBody.append((char) ((ch - base + 3) % 26 + base));
            } else {
                encryptedBody.append(ch); // Keep spaces and other characters unchanged
            }
        }

        return encryptedBody.toString();
    }

    // Method to create the greeting message
    public String greetingMessage(Email e) {
        String fromName = e.header.from.split("@")[0]; // Extract the name part before '@'
        return e.greetings + " " + fromName;
    }
}

// Main Class
public class EmailValidEncryptSendMessage {
    public static void main(String[] args) {
        // Create Header object
        Header header = new Header("Amit@doselect.com", "john_doe@doselect.in");

        // Create Email object
        Email email = new Email(header, "Hi John, How are you?", "Regards");

        // Create EmailOperations object
        EmailOperations emailOps = new EmailOperations();

        // Perform email verification
        int validationStatus = emailOps.emailVerify(email);
        System.out.println("Validation Status: " + validationStatus);

        // Encrypt the email body
        String encryptedBody = emailOps.bodyEncryption(email);
        System.out.println("Encrypted Body: " + encryptedBody);

        // Generate the greeting message
        String greeting = emailOps.greetingMessage(email);
        System.out.println("Greeting Message: " + greeting);
    }
}
