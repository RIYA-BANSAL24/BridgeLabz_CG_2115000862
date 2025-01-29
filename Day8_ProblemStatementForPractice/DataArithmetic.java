import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class DataArithmetic {
   public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);

       System.out.print("Enter a date (yyyy-MM-dd): ");
       String Date = sc.nextLine();
       LocalDate date = LocalDate.parse(Date);
       LocalDate modifiedDate = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
       System.out.println("Modified Date: " + modifiedDate.format(formatter));
   }
}

