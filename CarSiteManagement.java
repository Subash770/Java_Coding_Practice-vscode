package programs;
import java.util.ArrayList;

class Car {
    private int carId;
    private String carName;
    private String type;

    // Constructor
    public Car(int carId, String carName, String type) {
        this.carId = carId;
        this.carName = carName;
        this.type = type;
    }

    // Getters and Setters
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Site {
    private int siteId;
    private int carLimit;
    private ArrayList<Car> cars;

    // Constructor
    public Site(int siteId, int carLimit) {
        this.siteId = siteId;
        this.carLimit = carLimit;
        this.cars = new ArrayList<>();
    }

    // Method to add a car
    public String addCar(Car car) {
        if (cars.size() < carLimit) {
            cars.add(car);
            return "Car added!";
        } else {
            return "Site is full!";
        }
    }

    // Method to get cars by type
    public int getCarByType(String carType) {
        if (!carType.equals("Petrol") && !carType.equals("Diesel") && !carType.equals("Electric")) {
            return -1;
        }
        int count = 0;
        for (Car car : cars) {
            if (car.getType().equals(carType)) {
                count++;
            }
        }
        return count;
    }

    // Method to remove a car by ID
    public String removeCarById(int id) {
        for (Car car : cars) {
            if (car.getCarId() == id) {
                cars.remove(car);
                return "Car out";
            }
        }
        return "No car found";
    }
}

public class CarSiteManagement {
    public static void main(String[] args) {
        Car car1 = new Car(1001, "Mycar1", "Petrol");
        Car car2 = new Car(1002, "Mycar2", "mytype");

        Site site = new Site(12, 30);

        // Adding cars
        System.out.print(site.addCar(car1)); // Output: Car added!
        System.out.print(site.addCar(car2)); // Output: Car added!

        // Getting cars by type
        System.out.print(site.getCarByType("Petrol")); // Output: 1

        // Removing car by ID
        System.out.print(site.removeCarById(1002)); // Output: Car out
    }
}
