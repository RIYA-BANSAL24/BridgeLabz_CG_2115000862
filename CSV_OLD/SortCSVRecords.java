import java.io.*;
import java.util.*;

public class SortCSVRecords {
    public static void main(String[] args) {
        String filePath = "employee.csv";
        List<String[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                records.add(data);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }
        String[] header = records.get(0);
        records.remove(0);
        records.sort((a, b) -> Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3])));

        System.out.println("Top 5 Highest-Paid Employees:");
        System.out.println(String.join(", ", header));

        for (int i = 0; i < Math.min(5, records.size()); i++) {
            System.out.println(String.join(", ", records.get(i)));
        }
    }
}
