import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private double marks;

    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
    @Override
    public String toString() {
        return "Student{ ID=" + id + ", Name='" + name + "', Age=" + age + ", Marks=" + marks + " }";
    }
}

public class ConvertCSVToStudentObjects {
    public static void main(String[] args) {
        String filePath = "student.csv";
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());
                double marks = Double.parseDouble(data[3].trim());

                Student student = new Student(id, name, age, marks);
                students.add(student);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error processing the file: " + e.getMessage());
        }
        System.out.println("Student List:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
