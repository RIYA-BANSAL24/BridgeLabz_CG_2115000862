import java.util.*;
public class BonusOfEmployee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] salary = new double[10];
        int[] yearsOfService = new int[10];

        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        for (int i = 0; i < 10; i++) {
            while (true) {
                System.out.print("Enter salary for employee " + (i + 1) + ": ");
                salary[i] = sc.nextDouble();
                if (salary[i] <= 0) {
                    System.out.println("Please enter a valid positive salary.");
                    continue;
                }
                System.out.print("Enter years of service " + (i + 1) + ": ");
                yearsOfService[i] = sc.nextInt();
                if (yearsOfService[i] < 0) {
                    System.out.println("Please enter a valid non-negative number.");
                    continue;
                }
                break;
            }
        }

        for (int i = 0; i < 10; i++) {
            // Calculate bonus based on years of service
            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 0.05; // 5% bonus for more than 5 years service
            } else {
                bonus[i] = salary[i] * 0.02; // 2% bonus for 5 or fewer years service
            }
            // Calculate new salary
            newSalary[i] = salary[i] + bonus[i];

            // Calculate totals
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        System.out.println("Total Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);

        for (int i = 0; i < 10; i++) {
            System.out.println("Employee " + (i + 1) + ":");
            System.out.println("Old Salary: " + salary[i]);
            System.out.println("Bonus: " + bonus[i]);
            System.out.println("New Salary: " + newSalary[i]);
        }
    }
}
