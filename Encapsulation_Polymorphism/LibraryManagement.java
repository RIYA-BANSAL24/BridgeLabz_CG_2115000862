import java.util.*;
abstract class LibraryItem{
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author){
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }
    public String getItemId(){
        return itemId;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(){
        this.author = author;
    }
    public abstract String getLoanDuration();

    // Concrete method
    public String getItemDetails() {
        return "Item ID: " + itemId + ", Title of the book: " + title + ", Author: " + author;
    }
}

interface Reservable {
    public void reserveItem();
    public boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    private boolean isAvailable;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isAvailable = true;
    }

    public  String getLoanDuration() {
        return "You can borrow for 7 days.";
    }

    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is not available for reservation.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable;
    }
}

class Magazine extends LibraryItem implements Reservable {
    private boolean isAvailable;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isAvailable = true;
    }

    public String getLoanDuration() {
        return "You can borrow for 5 days.";
    }

    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Magazine reserved successfully.");
        } else {
            System.out.println("Magazine is not available for reservation.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable;
    }
}

class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isAvailable = true;
    }

    public String getLoanDuration() {
        return "You can borrow for 3 days.";
    }

    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("DVD reserved successfully.");
        } else {
            System.out.println("DVD is not available for reservation.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable;
    }
}
public class LibraryManagement {
    public static void main(String[] args) {
        List <LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(new Book("B00158", "Rich Dad Poor Dad", "Robert Kiyosaki"));
        libraryItems.add(new Magazine("M1000", "Harry Potter", "J.K.Rowling"));
        libraryItems.add(new DVD("D001", "Fundamentals of Java", "Gazihan Alankus"));

        for (LibraryItem item : libraryItems) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                System.out.println("Available for reservation: " + reservableItem.checkAvailability());
                reservableItem.reserveItem();
                System.out.println("Available after reservation: " + reservableItem.checkAvailability());
            }
            System.out.println();
        }
    }
}
