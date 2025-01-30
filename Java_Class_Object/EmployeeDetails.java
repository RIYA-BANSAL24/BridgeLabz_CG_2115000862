public class EmployeeDetails{
   public static void main(String args[]){
     EmployeData emp=new EmployeData("RiGo", 1215, 78);
     emp.showDetails();
   }
}
class EmployeData{
   String name;
   int id;
   double salary;
   public EmployeData(String name, int id, double salary){
       this.name=name;
       this.id=id;
       this.salary=salary;
  }
  public void showDetails(){
        System.out.println("The employee name is "+name);
        System.out.println("The employee id is "+id);
        System.out.println("The employee salary is "+salary);
  }
}

