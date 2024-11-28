package programs;
// Custom Exception: InvalidEmailException
class InvalidEmailException extends Exception {
    public InvalidEmailException(String msg) {
        super(msg);  // Pass the message to the parent Exception class
    }
}

// Custom Exception: InvalidPasswordException
class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String msg) {
        super(msg);  // Pass the message to the parent Exception class
    }
}

// Custom Exception: PasswordNotMatchException
class PasswordNotMatchException extends Exception {
    public PasswordNotMatchException(String msg) {
        super(msg);  // Pass the message to the parent Exception class
    }
}

// Register Class
class Register {
    
    // Method to validate the credentials
    public String checkCredentials(String email, String pass, String cpass) throws Exception {
        // Check if email contains "@" and "."
        if (!email.contains("@") || !email.contains(".")) {
            throw new InvalidEmailException("Invalid Email");
        }
        
        // Check if password length is at least 6 characters
        if (pass.length() < 6) {
            throw new InvalidPasswordException("Invalid Password");
        }
        
        // Check if password matches confirm password
        if (!pass.equals(cpass)) {
            throw new PasswordNotMatchException("Password not match");
        }
        
        // If all validations pass, return "Registered"
        return "Registered";
    }
}

// Main class to test the functionality
public class UserRegisterValidation {
    public static void main(String[] args) {
        try {
            // Create a Register object and test the checkCredentials method
            Register user = new Register();
            String result = user.checkCredentials("tushar@gmail.com", "hiiiiii", "hiiiiii");
            
            // If no exception is thrown, print the result
            System.out.println(result);
        } catch (InvalidEmailException e) {
            System.out.println("InvalidEmailException: " + e.getMessage());
        } catch (InvalidPasswordException e) {
            System.out.println("InvalidPasswordException: " + e.getMessage());
        } catch (PasswordNotMatchException e) {
            System.out.println("PasswordNotMatchException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Exception: " + e.getMessage());
        }
    }
}



