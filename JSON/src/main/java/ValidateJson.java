import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJson {
    public static void main(String[] args) {
        String jsonString = "{ \"name\": \"Gogo Bansal\", \"email\": \"gogobansal1215@gmail.com\", \"age\": 11 }";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            if (jsonNode.has("name") && jsonNode.has("email") && jsonNode.has("age")) {
                System.out.println("JSON is valid!");
            }
            else {
                System.out.println("JSON is missing required fields.");
            }
        } catch (Exception e) {
            System.out.println("Invalid JSON format: " + e.getMessage());
        }
    }
}
