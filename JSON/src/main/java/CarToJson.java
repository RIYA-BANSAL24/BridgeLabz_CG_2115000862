import com.fasterxml.jackson.databind.ObjectMapper;

class Car {
    private String brand;
    private String model;
    private int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}

public class CarToJson {
    public static void main(String[] args) {
        try {
            Car car = new Car("Tesla", "Model S", 2023);

            // Convert Java Object to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(car);

            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
