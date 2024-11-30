package programs;

public class StringReverseWithoutForLoop{

    public static String reverse(String str){
        if (str == null || str.length() <= 1) {
            return str;
        }
        return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
    }
        public static void main(String[] args) {
            String input = "Revature";
            String reversed = reverse(input);
            System.out.println("Original: " + input);
            System.out.println("Reversed: " + reversed);
        }
    }


        
   