package programs;
    
import java.util.ArrayList;
import java.util.List;

// Coffee class
class Coffee {
    // Properties
    private String type;
    private String size;
    private int quantity;

    // Constructor
    public Coffee(String type, String size, int quantity) {
        this.type = type;
        this.size = size;
        this.quantity = quantity;
    }

    // Getters
    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public int getQuantity() {
        return quantity;
    }
}

// Order class
class Order {
    // Properties
    private String customerName;
    private List<Coffee> coffeeList;

    // Constructor
    public Order(String customerName, List<Coffee> coffeeList) {
        this.customerName = customerName;
        this.coffeeList = coffeeList;
    }

    // Getters
    public String getCustomerName() {
        return customerName;
    }

    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }
}

// CoffeeShop class
class CoffeeShop {
    // Constants for prices
    private static final double[][] PRICES = {
            {2.00, 2.50, 3.00}, // Regular
            {3.00, 3.50, 4.00}, // Latte
            {3.50, 4.00, 4.50}, // Cappuccino
            {2.50, 3.00, 3.50}  // Espresso
    };

    // Method to calculate total cost
    public static double calculateTotalCost(Order order) {
        double totalCost = 0.0;

        for (Coffee coffee : order.getCoffeeList()) {
            int typeIndex = getTypeIndex(coffee.getType());
            int sizeIndex = getSizeIndex(coffee.getSize());

            if (typeIndex != -1 && sizeIndex != -1) {
                totalCost += PRICES[typeIndex][sizeIndex] * coffee.getQuantity();
            }
        }

        return totalCost;
    }

    // Helper method to get the index for the coffee type
    private static int getTypeIndex(String type) {
        switch (type) {
            case "Regular":
                return 0;
            case "Latte":
                return 1;
            case "Cappuccino":
                return 2;
            case "Espresso":
                return 3;
            default:
                return -1; // Invalid type
        }
    }

    // Helper method to get the index for the coffee size
    private static int getSizeIndex(String size) {
        switch (size) {
            case "Small":
                return 0;
            case "Medium":
                return 1;
            case "Large":
                return 2;
            default:
                return -1; // Invalid size
        }
    }
}

// CoffeeShopProgram class
public class CoffeeShopProgram {
    public static void main(String[] args) {
        // Creating coffee lists for orders
        List<Coffee> coffee = new ArrayList<>();
        coffee.add(new Coffee("Regular", "Small", 27));
        coffee.add(new Coffee("Latte", "Medium", 5));
        coffee.add(new Coffee("Cappuccino", "Large", 3));

        List<Coffee> coffee1 = new ArrayList<>();
        coffee1.add(new Coffee("Espresso", "Small", 2));
        coffee1.add(new Coffee("Latte", "Large", 1));

        // Creating orders
        Order order = new Order("Customer 1", coffee);
        Order order1 = new Order("Customer 2", coffee1);

        // Calculating and displaying total costs
        System.out.println(CoffeeShop.calculateTotalCost(order));  // Output: 85.0
        System.out.println(CoffeeShop.calculateTotalCost(order1)); // Output: 9.0
    }
}
