import java.io.*;
import java.nio.file.*;
import java.util.*;
public class JsonConverter{
    public static void main(String[] args) {
        String jsonFilePath = "students.json";
        String csvFilePath = "students.csv";
        String convertedJsonFilePath = "convertedStudents.json";
        convertJsonToCsv(jsonFilePath, csvFilePath);
        convertCsvToJson(csvFilePath, convertedJsonFilePath);
    }
    public static void convertJsonToCsv(String jsonFilePath, String csvFilePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            content = content.trim().substring(1, content.length() - 1); // Remove outer brackets

            List<String> lines = Arrays.asList(content.split("},"));
            FileWriter fileWriter = new FileWriter(csvFilePath);
            fileWriter.append("ID,Name,Age,Grade\n");

            for (String line : lines) {
                line = line.replace("{", "").replace("}", "").trim();
                String[] keyValuePairs = line.split(",");
                List<String> values = new ArrayList<>();

                for (String pair : keyValuePairs) {
                    values.add(pair.split(":")[1].replace("\"", "").trim());
                }
                fileWriter.append(String.join(",", values) + "\n");
            }
            fileWriter.flush();
            fileWriter.close();
            System.out.println("CSV file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void convertCsvToJson(String csvFilePath, String jsonFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String headerLine = br.readLine();
            String[] headers = headerLine.split(",");
            List<String> jsonList = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                StringBuilder jsonObject = new StringBuilder("{");

                for (int i = 0; i < headers.length; i++) {
                    jsonObject.append("\"" + headers[i] + "\":\"" + values[i] + "\"");
                    if (i < headers.length - 1) {
                        jsonObject.append(",");
                    }
                }
                jsonObject.append("}");
                jsonList.add(jsonObject.toString());
            }
            Files.write(Paths.get(jsonFilePath), ("[" + String.join(",", jsonList) + "]").getBytes());
            System.out.println("JSON file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}