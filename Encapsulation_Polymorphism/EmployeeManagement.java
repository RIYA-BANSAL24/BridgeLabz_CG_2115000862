import java.util.*;
abstract class Employee{
    private int employeeId;
    private String name;
    private int baseSalary;

    public Employee(int employeeId, String name, int baseSalary){
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId(){
        return employeeId;
    }
    public String getName(){
        return name;
    }
    public int getBaseSalary(){
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary){
        this.baseSalary = baseSalary;
    }

    abstract double calculateSalary();

    public void displayDetails(){
        System.out.println("Employee ID: " + employeeId + " Name of the employee: " + name + " and base salary of the employee: " + baseSalary + " Calculated Salary: " + calculateSalary());
    }
}
interface Department{
    public void assignDepartment(String department);

    public String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department{
    private String department;
    public FullTimeEmployee(int employeeId, String name, int baseSalary){
        super(employeeId, name, baseSalary);
    }
    public double calculateSalary(){
        return getBaseSalary();
    }
    public void assignDepartment(String departmentName){
        this.department = departmentName;
    }
    public String getDepartmentDetails(){
        return "Department: " + department;
    }
}

class PartTimeEmployee extends Employee implements Department{
    private int workHours;
    private double hourlyRate;
    private String department;

    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int workHours) {
        super(employeeId, name, 0);
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
    }
    public double calculateSalary() {
        return hourlyRate * workHours;
    }
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}
public class EmployeeManagement{
    public static void main(String[] args) {
        List <Employee> emp = new ArrayList<>();
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(85, "Rajnish", 85000);
        fullTimeEmployee.assignDepartment("Finance");
        emp.add(fullTimeEmployee);

        PartTimeEmployee partTimeEmployee = new PartTimeEmployee(102, "Riya", 50, 20);
        partTimeEmployee.assignDepartment("IT");
        emp.add(partTimeEmployee);

        // Process and display employee details using polymorphism
        for (Employee employee : emp) {
            employee.displayDetails();
            if (employee instanceof Department) {
                System.out.println(((Department) employee).getDepartmentDetails());
            }
        }
    }
}