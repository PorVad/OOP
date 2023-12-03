import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private int pageCount;
    private double price;
    private boolean hasAudioVersion;

    public Book(int id, String title, String author, String publisher, int publicationYear,
                int pageCount, double price, boolean hasAudioVersion) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.pageCount = pageCount;
        this.price = price;
        this.hasAudioVersion = hasAudioVersion;
    }


    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + '\'' + ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' + ", publicationYear=" + publicationYear +
                ", pageCount=" + pageCount + ", price=" + price + ", hasAudioVersion=" + hasAudioVersion + '}';
    }

    public Object getAuthor() {
        return author;
    }

    public Object getPublisher() {
        return publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        books.add(new Book(1, "Book1", "Author1", "Publisher1", 2020, 300, 20.0, true));
        books.add(new Book(2, "Book2", "Author2", "Publisher2", 2022, 250, 15.0, false));
        books.add(new Book(3, "Book3", "Author1", "Publisher1", 2021, 200, 18.0, true));

        String targetAuthor = "Author1";
        List<Book> authorBooks = findBooksByAuthor(books, targetAuthor);
        System.out.println("Список книг автора " + targetAuthor + ":");
        printBookList(authorBooks);

        String targetPublisher = "Publisher1";
        List<Book> publisherBooks = findBooksByPublisher(books, targetPublisher);
        System.out.println("\nСписок книг видавництва " + targetPublisher + ":");
        printBookList(publisherBooks);

        int recentYears = 3;
        List<Book> recentBooks = findRecentBooks(books, recentYears);
        System.out.println("\nСписок книг, випущених протягом останніх " + recentYears + " років:");
        printBookList(recentBooks);
    }

    private static List<Book> findBooksByAuthor(List<Book> books, String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    private static List<Book> findBooksByPublisher(List<Book> books, String publisher) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getPublisher().equals(publisher)) {
                result.add(book);
            }
        }
        return result;
    }

    private static List<Book> findRecentBooks(List<Book> books, int recentYears) {
        List<Book> result = new ArrayList<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (Book book : books) {
            if (currentYear - book.getPublicationYear() <= recentYears) {
                result.add(book);
            }
        }
        return result;
    }

    private static void printBookList(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
