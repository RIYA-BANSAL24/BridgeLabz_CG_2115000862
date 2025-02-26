import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class User {
    private int id;
    private String name;
    private String email;
    private int age;

    public User(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
}

public class DatabaseToJson {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Riya Bansal", "riyabansal3365@gmail.com", 21));
        users.add(new User(2, "Radhika Bansal", "radhikebansal1215@gmail.com", 11));
        users.add(new User(3, "Parnika Agrawal", "parnika24@gmail.com", 17));

        try {
            generateJsonReport(users, "report.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateJsonReport(List<User> users, String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonReport = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);
        System.out.println("Generated JSON Report:\n" + jsonReport);
        objectMapper.writeValue(new File(fileName), users);
    }
}
