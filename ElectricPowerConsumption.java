package programs;
import java.util.ArrayList;
import java.util.List;

class ElectricalDevice {
    // Data members
    private String deviceName;
    private double powerConsumption;
    private boolean isOn;

    // Constructor
    public ElectricalDevice(String deviceName, double powerConsumption) {
        this.deviceName = deviceName;
        this.powerConsumption = powerConsumption;
        this.isOn = false; // Default state is off
    }

    // Method to get the power consumption of the device
    public double getPowerConsumption() {
        return isOn ? powerConsumption : 0.0;
    }

    // Method to turn the device on
    public void turnOn() {
        isOn = true;
    }

    // Method to turn the device off
    public void turnOff() {
        isOn = false;
    }

    // Method to check if the device is on
    public boolean isOn() {
        return isOn;
    }

    // Method to check if the device is off
    public boolean isOff() {
        return !isOn;
    }
}

class Room {
    // Data members
    private String name;
    private List<ElectricalDevice> devices;

    // Constructor
    public Room(String name) {
        this.name = name;
        this.devices = new ArrayList<>();
    }

    // Method to add a device to the room
    public void addDevice(ElectricalDevice device) {
        devices.add(device);
    }

    // Method to calculate the total power consumption of all active devices
    public double getTotalPowerConsumption() {
        double totalPower = 0.0;
        for (ElectricalDevice device : devices) {
            totalPower += device.getPowerConsumption();
        }
        return totalPower;
    }
}

public class ElectricPowerConsumption {
    public static void main(String[] args) {
        // Creating electrical devices
        ElectricalDevice laptop = new ElectricalDevice("Laptop", 50.0);
        laptop.turnOn(); // Turn on the laptop
        System.out.println(laptop.getPowerConsumption()); // Output: 50.0

        ElectricalDevice refrigerator = new ElectricalDevice("Refrigerator", 150.0);
        refrigerator.turnOn(); // Turn on the refrigerator
        System.out.println(refrigerator.getPowerConsumption()); // Output: 150.0

        // Creating a room and adding devices
        Room guestRoom = new Room("Guest Room");
        guestRoom.addDevice(laptop);
        guestRoom.addDevice(refrigerator);

        // Calculating total power consumption in the room
        System.out.println(guestRoom.getTotalPowerConsumption()); // Output: 200.0
    }
}
