import java.io.*;
import java.util.*;

public class DetectDuplicatesCSV {
    public static void main(String[] args) {
        String filePath = "data.csv";
        Set<Integer> uniqueIds = new HashSet<>();
        List<String> duplicateRecords = new ArrayList<>();

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
                if (!uniqueIds.add(id)) {
                    duplicateRecords.add(line);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        if (duplicateRecords.isEmpty()) {
            System.out.println("No duplicate records found.");
        } else {
            System.out.println("Duplicate Records Found:");
            for (String record : duplicateRecords) {
                System.out.println(record);
            }
        }
    }
}
