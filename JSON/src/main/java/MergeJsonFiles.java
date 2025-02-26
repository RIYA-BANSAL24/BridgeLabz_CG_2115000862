import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class MergeJsonFiles {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode json1 = objectMapper.readTree(new File("src/main/java/file1.json"));
            JsonNode json2 = objectMapper.readTree(new File("src/main/java/file2.json"));

            // Merge JSON objects
            JsonNode mergedJson = mergeJson(json1, json2);

            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson));

            objectMapper.writeValue(new File("merged.json"), mergedJson);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JsonNode mergeJson(JsonNode mainNode, JsonNode updateNode) {
        if (mainNode.isObject() && updateNode.isObject()) {
            updateNode.fields().forEachRemaining(entry ->
                    ((com.fasterxml.jackson.databind.node.ObjectNode) mainNode).set(entry.getKey(), entry.getValue())
            );
        }
        return mainNode;
    }
}
