import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.regex.Pattern;

public class ValidateEmail {
    public static void main(String[] args) {
        String jsonData = """
        {
            "email": "riyabansal3365@gmail.com"
        }
        """;

        try {
            validateEmail(jsonData);
            System.out.println("Email is valid!");
        } catch (Exception e) {
            System.out.println("Invalid email: " + e.getMessage());
        }
    }

    public static void validateEmail(String jsonData) throws Exception {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonData);

        if (!jsonNode.has("email")) {
            throw new Exception("Missing required field: email");
        }

        String email = jsonNode.get("email").asText();

        if (!pattern.matcher(email).matches()) {
            throw new Exception("Invalid email format: " + email);
        }
    }
}
