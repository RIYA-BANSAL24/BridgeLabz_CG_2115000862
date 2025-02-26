import java.io.*;
import java.util.*;

class Student {
    int id;
    String name;
    int age;
    double marks;
    String grade;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void addMarksAndGrade(double marks, String grade) {
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }
}

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "stu1.csv";
        String file2 = "stu2.csv";
        String outputFile = "mergedStu.csv";

        Map<Integer, Student> studentMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
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

                studentMap.put(id, new Student(id, name, age));
            }
        } catch (IOException e) {
            System.out.println("Error reading " + file1 + ": " + e.getMessage());
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Skip header
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                int id = Integer.parseInt(data[0].trim());
                double marks = Double.parseDouble(data[1].trim());
                String grade = data[2].trim();

                if (studentMap.containsKey(id)) {
                    studentMap.get(id).addMarksAndGrade(marks, grade);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading " + file2 + ": " + e.getMessage());
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();
            for (Student student : studentMap.values()) {
                bw.write(student.toString());
                bw.newLine();
            }
            System.out.println("Merged file created: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing to " + outputFile + ": " + e.getMessage());
        }
    }
}
