package programs;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int salary;

    // Parameterized constructor
    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for salary
    public int getSalary() {
        return salary;
    }

    // Setter for salary
    public void setSalary(int salary) {
        this.salary = salary;
    }

    // Overriding toString for formatted output
    @Override
    public String toString() {
        return "<name: " + name + " salary: " + salary + ">";
    }
}

class EmployeeInfo {
    // Enum to define sort methods
    public enum SortMethod {
        BYNAME, BYSALARY
    }

    // Method to sort employees based on SortMethod
    public List<Employee> sort(List<Employee> emps, final SortMethod method) {
        return emps.stream()
                .sorted((e1, e2) -> {
                    if (method == SortMethod.BYNAME) {
                        return e1.getName().compareTo(e2.getName());
                    } else if (method == SortMethod.BYSALARY) {
                        return Integer.compare(e1.getSalary(), e2.getSalary());
                    }
                    return 0;
                })
                .collect(Collectors.toList());
    }

    // Method to check if a character is present in all employee names
    public boolean isCharacterPresentInAllNames(Collection<Employee> entities, String character) {
        return entities.stream()
                .allMatch(e -> e.getName().contains(character));
    }
}

public class EmployeeEnumSort {
    public static void main(String[] args) {
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee("Mickey", 100000));
        emps.add(new Employee("Timmy", 50000));
        emps.add(new Employee("Annny", 40000));

        EmployeeInfo employeeInfo = new EmployeeInfo();

        // Sort by name
        List<Employee> sortedByName = employeeInfo.sort(emps, EmployeeInfo.SortMethod.BYNAME);
        System.out.println(sortedByName);

        // Sort by salary
        List<Employee> sortedBySalary = employeeInfo.sort(emps, EmployeeInfo.SortMethod.BYSALARY);
        System.out.println(sortedBySalary);

        // Check if character "y" is present in all names
        boolean isCharPresent = employeeInfo.isCharacterPresentInAllNames(emps, "z");
        System.out.println(isCharPresent);
    }
}
