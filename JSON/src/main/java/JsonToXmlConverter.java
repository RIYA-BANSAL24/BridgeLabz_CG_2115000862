import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.XML;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        String jsonString = """
        {
            "name": "Riya Bansal",
            "email": "riyabansal3365@gmail.com",
            "age": 21
        }
        """;

        try {
            // Convert JSON to XML
            String xmlString = convertJsonToXml(jsonString);

            System.out.println("Converted XML:\n" + xmlString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String convertJsonToXml(String jsonString) throws Exception {
        JSONObject jsonObject = new JSONObject(jsonString);
        return XML.toString(jsonObject);
    }
}
