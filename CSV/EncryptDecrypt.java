import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.ArrayList;
import java.util.List;
public class EncryptDecrypt{
    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY_FILE = "secret.key";
    public static void generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        try (FileOutputStream fos = new FileOutputStream(SECRET_KEY_FILE)) {
            fos.write(secretKey.getEncoded());
        }
    }

    // Load secret key
    public static SecretKey loadKey() throws Exception {
        byte[] keyBytes = new byte[16];
        try (FileInputStream fis = new FileInputStream(SECRET_KEY_FILE)) {
            fis.read(keyBytes);
        }
        return new SecretKeySpec(keyBytes, ALGORITHM);
    }

    // Encrypt a value
    public static String encrypt(String value, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(value.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // Decrypt a value
    public static String decrypt(String value, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(value));
        return new String(decrypted, StandardCharsets.UTF_8);
    }

    // Write encrypted data to CSV
    public static void writeEncryptedCSV(String fileName, List<String[]> data) throws Exception {
        SecretKey secretKey = loadKey();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Name,Email,Salary\n");
            for (String[] row : data) {
                String encryptedEmail = encrypt(row[1], secretKey);
                String encryptedSalary = encrypt(row[2], secretKey);
                writer.write(row[0] + "," + encryptedEmail + "," + encryptedSalary + "\n");
            }
        }
    }

    // Read and decrypt data from CSV
    public static List<String[]> readDecryptedCSV(String fileName) throws Exception {
        SecretKey secretKey = loadKey();
        List<String[]> decryptedData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) { // Skip header
                    firstLine = false;
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String decryptedEmail = decrypt(parts[1], secretKey);
                    String decryptedSalary = decrypt(parts[2], secretKey);
                    decryptedData.add(new String[]{parts[0], decryptedEmail, decryptedSalary});
                }
            }
        }
        return decryptedData;
    }

    public static void main(String[] args) {
        try {
            // Uncomment the first time to generate a key
            // generateKey();

            List<String[]> employees = new ArrayList<>();
            employees.add(new String[]{"Rashi", "rashi@gmail.com", "70000"});
            employees.add(new String[]{"Shantanu", "shantanu@example.com", "80000"});
            String fileName = "employees.csv";
            writeEncryptedCSV(fileName, employees);
            System.out.println("Encrypted CSV written.");
            List<String[]> decryptedData = readDecryptedCSV(fileName);
            System.out.println("Decrypted Data:");
            for (String[] row : decryptedData) {
                System.out.println("Name: " + row[0] + ", Email: " + row[1] + ", Salary: " + row[2]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}