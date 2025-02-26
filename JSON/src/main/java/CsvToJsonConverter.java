import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        File csvFile = new File("src/main/java/data.csv");
        try {
            String jsonOutput = convertCsvToJson(csvFile);

            System.out.println("Converted JSON:\n" + jsonOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String convertCsvToJson(File file) throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
        MappingIterator<Map<String, String>> iterator = csvMapper.readerFor(Map.class)
                .with(csvSchema)
                .readValues(file);

        List<Map<String, String>> dataList = iterator.readAll();

        ObjectMapper jsonMapper = new ObjectMapper();
        return jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataList);
    }
}
