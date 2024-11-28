package programs;
    
// Product Class
class Product {
    String name;
    double price;
    String coupon;

    // Constructor
    public Product(String name, double price, String coupon) {
        this.name = name;
        this.price = price;
        this.coupon = coupon;
    }
}

// Custom Exception Class
class InvalidCouponException extends Exception {
    // Constructor
    public InvalidCouponException(String msg) {
        super(msg);
    }
}

// Validator Class
class Validator {
    // Method to validate the coupon
    public String validateCoupon(Product p) throws InvalidCouponException {
        // Check if the coupon matches the pattern "<name>-<discount>"
        if (p.coupon != null && p.coupon.contains("-")) {
            String[] parts = p.coupon.split("-");
            if (parts.length == 2) {
                String couponName = parts[0];
                try {
                    int discountValue = Integer.parseInt(parts[1]);

                    // Check if the coupon name matches the product name and discount is valid
                    if (couponName.equals(p.name) && discountValue >= 10 && discountValue <= 25) {
                        return "Valid Coupon";
                    }
                } catch (NumberFormatException e) {
                    // Invalid discount value format
                }
            }
        }

        // If validation fails, throw an exception
        throw new InvalidCouponException("Invalid Coupon");
    }

    // Method to calculate net price
    public double netPrice(Product p) {
        try {
            // Validate the coupon first
            String validation = validateCoupon(p);

            if (validation.equals("Valid Coupon")) {
                // Extract the discount value from the coupon
                String[] parts = p.coupon.split("-");
                int discountValue = Integer.parseInt(parts[1]);

                // Calculate the discount price
                double discountPrice = (p.price * discountValue) / 100.0;

                // Calculate and return the net price
                return p.price - discountPrice;
            }
        } catch (InvalidCouponException e) {
            // If coupon is invalid, return the total price
        }

        return p.price;
    }
}

// Main Class
public class ProductCouponValidator {
    public static void main(String[] args) {
        // Create a Product object
        Product obj = new Product("IPhone", 25000, "IPhone-10");

        // Create a Validator object
        Validator val = new Validator();

        // Validate coupon and calculate net price
        try {
            String valCop = val.validateCoupon(obj);
            System.out.println("valCop = \"" + valCop + "\"");
        } catch (InvalidCouponException e) {
            System.out.println(e.getMessage());
        }

        double price = val.netPrice(obj);
        System.out.println("price = " + price);
    }
}

