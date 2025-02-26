import java.io.*;

public class GeneratoCSV {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "employeeReport.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    writer.write("Employee ID,Name,Department,Salary");
                    writer.newLine();
                    isFirstLine = false;
                    continue;
                }
                writer.write(line);
                writer.newLine();
            }

            System.out.println("CSV Report Generated: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error processing the file: " + e.getMessage());
        }
    }
}
