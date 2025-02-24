import java.lang.reflect.Field;
class Configuration {
   private static String API_KEY = "8dbf5d2a37c4178b4b0";
}
public class StaticFeild {
   public static void main(String[] args) throws Exception {
      Class<?> cls = Configuration.class;
      Field field = cls.getDeclaredField("API_KEY");
      field.setAccessible(true);
      System.out.println("Old Value: " + field.get(null));
      field.set(null, "12acvhjv5ab1");
      System.out.println("New Value: " + field.get(null));
   }
}
