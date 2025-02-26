import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

class CarNew {
    private String brand;
    private String model;
    private int year;

    public CarNew(String brand, String model, int year) {
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

public class ListToJsonArray {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            List<Car> cars = new ArrayList<>();
            cars.add(new Car("Tesla", "Model S", 2023));
            cars.add(new Car("Ford", "Mustang", 2022));
            cars.add(new Car("Toyota", "Corolla", 2021));

            // Convert list to JSON array
            String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(cars);

            System.out.println(jsonArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
