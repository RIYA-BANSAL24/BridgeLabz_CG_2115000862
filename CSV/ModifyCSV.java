import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ModifyCSV {
    public static void main(String[] args) {
        String inputFile = "employee.csv";
        String outputFile = "updatedEmployee.csv";
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (isFirstLine) {
                    isFirstLine = false;
                } else {
                    if (data[2].trim().equalsIgnoreCase("IT")) {
                        double salary = Double.parseDouble(data[3]);
                        salary *= 1.10;  // Increase by 10%
                        data[3] = String.format("%.2f", salary); // Format salary to 2 decimal places
                    }
                }
                records.add(data);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error processing the file: " + e.getMessage());
            return;
        }
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(outputFile))) {
            for (String[] record : records) {
                bw.write(String.join(",", record));
                bw.newLine();
            }
            System.out.println("Updated salaries saved to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }
}
