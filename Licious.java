package programs;

import java.util.*;
import java.util.stream.Collectors;

// Enum Definition
enum Type {
    MEAT, FISH, OTHER
}

// Dish Class Definition
class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    // Constructor
    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    // Getters
    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    // toString method
    @Override
    public String toString() {
        return "Dish{name='" + name + "', vegetarian=" + vegetarian + ", calories=" + calories + ", type=" + type + "}";
    }
}

// DishImplementation Class Definition
class DishImplementation {

    // Method 1: Get Name and Calories based on conditions
    public List<Dish> getNameAndCalories(List<Dish> menu) {
        return menu.stream()
                .filter(dish -> dish.getType() == Type.OTHER)
                .filter(dish -> dish.getCalories() >= 200 && dish.getCalories() < 560)
                .collect(Collectors.toList());
    }

    // Method 2: Fetch three high-calorie dishes
    public List<String> threeHighCaloricDish(List<Dish> menu) {
        return menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .sorted(Comparator.comparingInt(Dish::getCalories).reversed())
                .limit(3)
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    // Method 3: Check if the menu has any vegetarian dishes
    public boolean isVegetarian(List<Dish> menu) {
        return menu.stream().anyMatch(Dish::isVegetarian);
    }
}

// Main Class

public class Licious {
    public static void main(String[] args) {
        // Sample Input
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Type.MEAT),
                new Dish("french fries", true, 530, Type.OTHER),
                new Dish("rice", true, 120, Type.OTHER),
                new Dish("pizza", true, 550, Type.OTHER),
                new Dish("salmon", false, 450, Type.FISH)
        );

        // DishImplementation instance
        DishImplementation dishImplementation = new DishImplementation();

        // Call getNameAndCalories and display output
        System.out.println(dishImplementation.getNameAndCalories(menu));
        System.out.println("----------------------------------------------------------");

        // Call threeHighCaloricDish and display output
        System.out.println(dishImplementation.threeHighCaloricDish(menu));
        System.out.println("----------------------------------------------------------");

        // Call isVegetarian and display output
        System.out.println(dishImplementation.isVegetarian(menu));
    }
}

