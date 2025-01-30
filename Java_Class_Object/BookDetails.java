public class BookDetails{
    public static void main(String args[]){
      Book b=new Book("Rich Dad Poor Dad","Robert Kiyosaki",600);
      b.showDetails();
   }
}
class Book{
    String title;
    String author;
    int price;
    public Book(String title, String author, int price){
        this.title=title;
        this.author=author;
        this.price=price;
    }
    public void showDetails(){
        System.out.println("Book's name is "+title);
        System.out.println("Book's author is "+author);
        System.out.println("Book's price in INR is "+price);
    }
}
