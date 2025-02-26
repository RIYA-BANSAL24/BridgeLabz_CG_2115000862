import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFile {
    public static void main(String[] args) {
        String filePath = "student.csv";
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (count == 0 && isHeader(data)) {
                    count++;
                    continue;
                }
                System.out.println("Student ID   : " + data[0]);
                System.out.println("Name         : " + data[1]);
                System.out.println("Age          : " + data[2]);
                System.out.println("Marks        : " + data[3]);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
    private static boolean isHeader(String[] data) {
        return data[0].equalsIgnoreCase("ID") || data[1].equalsIgnoreCase("Name");
    }
}
