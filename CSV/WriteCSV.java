import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "employee.csv";
        String[] employees = {
            "ID,Name,Department,Salary",
            "101,Riya Bansal,IT,60000",
            "102,Anjali Rajput,Sales,55000"
        };
        
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String emp : employees) {
                writer.write(emp + "\n");
            }
            System.out.println("CSV file created successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
