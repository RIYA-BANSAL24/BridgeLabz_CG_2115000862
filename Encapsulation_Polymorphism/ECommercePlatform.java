import java.util.*;
abstract class Product{
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price){
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId(){
        return productId;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    abstract double calculateDiscount();
}

interface Taxable{
    public double calculateTax();
    public String getTaxDetails();
}

class Electronics extends Product implements Taxable{
    public Electronics(int productId, String name, double price){
        super(productId, name, price);
    }
    public double calculateDiscount(){
        return getPrice() * 0.10;
    }
    public double calculateTax(){
        return getPrice() * 0.15;
    }
    public String getTaxDetails(){
        return "Tax Details for electronic device: " + calculateTax();
    }
}
class Clothing extends Product implements Taxable{
    public Clothing(int productId, String name, double price){
        super(productId, name, price);
    }
    public double calculateDiscount(){
        return getPrice() * 0.50;
    }
    public double calculateTax(){
        return getPrice() * 0.10;
    }
    public String getTaxDetails(){
        return "Clothing tax details: " + calculateTax();
    }
}
class Groceries extends Product implements Taxable{
    public Groceries(int productId, String name, double price){
        super(productId, name, price);
    }
    public double calculateDiscount(){
        return getPrice() * 0.35;
    }
    public double calculateTax(){
        return getPrice() * 0.10;
    }
    public String getTaxDetails(){
        return "Grocery tax details: " + calculateTax();
    }
}
public class ECommercePlatform {
    public static void finalPriceCalculation(List <Product> pro) {
        for (Product p : pro) {
            double basePrice = p.getPrice();
            double discount = p.calculateDiscount();
            double tax = (p instanceof Taxable) ? ((Taxable) p).calculateTax() : 0;
            double finalPrice = basePrice + tax - discount;

            System.out.println("Product Name: " + p.getName());
            System.out.println("Base Price: " + basePrice);
            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax);
            System.out.println("Final Price: " + finalPrice);
        }
    }
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Electronics(101, "Laptop", 50055));
        productList.add(new Clothing(102, "Skirt",500));
        productList.add(new Groceries(103, "Rice flour" , 800));
        finalPriceCalculation(productList);
    }
}
