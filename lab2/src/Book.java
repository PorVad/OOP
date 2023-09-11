public class Book {
    private int idBook;
    private String name;
    private String author;
    private String company;
    private int year;
    private int pages;
    private int price;

     public Book(int idBook, String name, String author, String company, int year, int pages, int price) {
         this.idBook = idBook;
         this.name = name;
         this.author = author;
         this.company = company;
         this.year = year;
         this.pages = pages;
         this.price = price;
     }

     public void setValue(int idBook, String name, String author, String company, int year, int pages, int price) {
         this.idBook = idBook;
         this.name = name;
         this.author = author;
         this.company = company;
         this.year = year;
         this.pages = pages;
         this.price = price;
     }

     public String getValue() {
         return "ID: " + idBook + "\n" +
                 "Name: " + name + "\n" +
                 "Author: " + author + "\n" +
                 "Company: " + company + "\n" +
                 "Year: " + year + "\n" +
                 "Pages: " + pages + "\n" +
                 "Price: " + price;
     }

    @Override
    public String toString() {
        return getValue();
    }
}