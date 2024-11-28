package programs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Student class definition
class Student {
    private String name;
    private String collegeName;
    private float percentage;
    private float scholarship;

    // Constructor to initialize student details
    public Student(String name, String collegeName, float percentage) {
        this.name = name;
        this.collegeName = collegeName;
        this.percentage = percentage;
        this.scholarship = 0; // Initially no scholarship
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public float getScholarship() {
        return scholarship;
    }

    public void setScholarship(float scholarship) {
        this.scholarship = scholarship;
    }
}

// Portal class definition
class Portal {
    // List of students
    ArrayList<Student> studentList = new ArrayList<>();

    // Method to assign scholarships based on percentage
    public void assignScholarship() {
        for (Student student : studentList) {
            float percentage = student.getPercentage();
            // Assign scholarship based on percentage
            if (percentage >= 91) {
                student.setScholarship(10000);
            } else if (percentage >= 81) {
                student.setScholarship(5000);
            } else {
                student.setScholarship(0);
            }
        }
    }

    // Method to calculate total scholarship
    public float totalScholarship() {
        float total = 0;
        for (Student student : studentList) {
            total += student.getScholarship();
        }
        return total;
    }

    // Method to find the college with the maximum scholarship
    public String totalMaxScholarshipOfCollege() {
        // Map to store total scholarship by college
        Map<String, Float> collegeScholarshipMap = new HashMap<>();
        
        // Calculate total scholarship for each college
        for (Student student : studentList) {
            String collegeName = student.getCollegeName();
            float scholarship = student.getScholarship();
            collegeScholarshipMap.put(collegeName, collegeScholarshipMap.getOrDefault(collegeName, 0f) + scholarship);
        }
        
        // Find the college with the maximum scholarship
        String maxCollege = "";
        float maxScholarship = 0;
        
        for (Map.Entry<String, Float> entry : collegeScholarshipMap.entrySet()) {
            if (entry.getValue() > maxScholarship) {
                maxScholarship = entry.getValue();
                maxCollege = entry.getKey();
            }
        }
        
        return maxCollege;
    }
}

// Main class for testing
public class ScholarshipBasedOnPercentage {
    public static void main(String[] args) {
        // Create portal object
        Portal obj = new Portal();

        // Add students to the portal
        obj.studentList.add(new Student("Steve", "IIT", 89));
        obj.studentList.add(new Student("Bob", "NIT", 94));
        obj.studentList.add(new Student("Alice", "Abcd", 59));

        // Assign scholarships to students
        obj.assignScholarship();

        // Output total scholarship
        System.out.println(obj.totalScholarship()); // 15000.0

        // Output college with the maximum scholarship
        System.out.println(obj.totalMaxScholarshipOfCollege()); // NIT
    }
}


