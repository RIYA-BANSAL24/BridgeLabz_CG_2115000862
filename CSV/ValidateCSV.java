import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "employee.csv";
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^[0-9]{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            System.out.println("Checking for invalid records...");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String email = data[3].trim(); 
                String phone = data[4].trim();
                boolean isEmailValid = emailPattern.matcher(email).matches();
                boolean isPhoneValid = phonePattern.matcher(phone).matches();

                if (!isEmailValid || !isPhoneValid) {
                    System.out.println("Invalid Record: " + line);
                    if (!isEmailValid) {
                        System.out.println("Invalid Email: " + email);
                    }
                    if (!isPhoneValid) {
                        System.out.println("Invalid Phone Number: " + phone);
                    }
                }
            }

            System.out.println("Validation completed!");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
