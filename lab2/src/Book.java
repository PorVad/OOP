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

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPages() {
        return pages;
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