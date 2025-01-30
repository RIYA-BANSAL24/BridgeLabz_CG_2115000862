public class ComputeAreaOfCircle{
   public static void main(String args[]){
      Circle c = new Circle(2.5);
      c.areaOfCircle();
      c.circumferenceOfCircle();
   }
}

class Circle{
     double radius;
     public Circle(double radius){
        this.radius=radius;
     }
     public void areaOfCircle(){
         System.out.println("Area of circle is "+(3.14*radius*radius));
     }
     public void circumferenceOfCircle(){
         System.out.println("Circumference of circle is "+(2*3.14*radius));
     }
}

