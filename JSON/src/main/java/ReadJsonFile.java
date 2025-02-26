import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ReadJsonFile {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            File file = new File("src/main/java/data.json");
            JsonNode rootNode = objectMapper.readTree(file);

            String name = rootNode.path("name").asText();
            String email = rootNode.path("email").asText();

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
