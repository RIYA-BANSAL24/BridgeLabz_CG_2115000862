import java.util.*;
abstract class FoodItem{
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName(){
        return itemName;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public abstract double calculateTotalPrice();

    public String getItemDetails() {
        return "Name of the Item: " + itemName + ", Price of the Price: " + price + ", Quantity: " + quantity;
    }
}
interface Discountable{
    public void applyDiscount(double discountPercentage);
    public String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    private double discount;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discount = 0.0;
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity() * (1 - discount / 100);
    }

    public void applyDiscount(double discountPercentage) {
        this.discount = discountPercentage;
    }

    public String getDiscountDetails() {
        return "Discount on the Veg Item: " + discount + "%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double discount;
    private static final double NONVEG_EXTRA_CHARGE = 80.0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discount = 0.0;
    }

    public double calculateTotalPrice() {
        return (getPrice() * getQuantity() + NONVEG_EXTRA_CHARGE) * (1 - discount / 100);
    }

    public void applyDiscount(double discountPercentage) {
        this.discount = discountPercentage;
    }

    public String getDiscountDetails() {
        return "Discount on Non-Veg Item: " + discount + "%";
    }
}
public class FoodDelivery {
    public static void main(String[] args) {
        List<FoodItem> orderList = new ArrayList<>();
        orderList.add(new VegItem("Kadhai Paneer", 150.0, 2));
        orderList.add(new NonVegItem("Chicken Biryani", 250.0, 1));

        for (FoodItem item : orderList) {
            System.out.println(item.getItemDetails());
            if (item instanceof Discountable) {
                Discountable discountableItem = (Discountable) item;
                discountableItem.applyDiscount(10.0); // Applying a 10% discount
                System.out.println(discountableItem.getDiscountDetails());
            }
            System.out.println("Total Price: Rs. " + item.calculateTotalPrice());
            System.out.println();
        }
    }
}
