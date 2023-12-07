import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private int pageCount;
    private double price;
    private boolean hasAudioVersion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean hasAudioVersion() {
        return hasAudioVersion;
    }

    public void setHasAudioVersion(boolean hasAudioVersion) {
        this.hasAudioVersion = hasAudioVersion;
    }

    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + '\'' + ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' + ", publicationYear=" + publicationYear +
                ", pageCount=" + pageCount + ", price=" + price + ", hasAudioVersion=" + hasAudioVersion + '}';
    }
}

class BookManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        book.setId(books.size() + 1);
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findBooksByPublisher(String publisher) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getPublisher().equalsIgnoreCase(publisher)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findRecentBooks(int recentYears) {
        List<Book> result = new ArrayList<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (Book book : books) {
            if (currentYear - book.getPublicationYear() <= recentYears) {
                result.add(book);
            }
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager bookManager = loadBooksFromFile();  // Завантаження списку книг з файлу

        int choice;
        do {
            System.out.println("Меню:");
            System.out.println("1. Додати нову книгу");
            System.out.println("2. Переглянути список книг заданого автора");
            System.out.println("3. Переглянути список книг заданого видавництва");
            System.out.println("4. Переглянути список книг, випущених протягом останніх трьох років");
            System.out.println("5. Зберегти книги у файл (текстовий)");
            System.out.println("6. Зберегти книги у файл (бінарний)");
            System.out.println("7. Вийти");
            System.out.print("Ваш вибір: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addNewBook(scanner, bookManager);
                    break;
                case 2:
                    listBooksByAuthor(scanner, bookManager);
                    break;
                case 3:
                    listBooksByPublisher(scanner, bookManager);
                    break;
                case 4:
                    listRecentBooks(scanner, bookManager);
                    break;
                case 5:
                    saveBooksToTextFile(bookManager);
                    break;
                case 6:
                    saveBooksToBinaryFile(bookManager);
                    break;
            }
        } while (choice != 7);

        System.out.println("До побачення!");
    }

    private static void addNewBook(Scanner scanner, BookManager bookManager) {
        System.out.print("Введіть назву книги: ");
        scanner.nextLine();  // Очищення буфера після nextInt
        String title = scanner.nextLine();

        System.out.print("Введіть автора книги: ");
        String author = scanner.nextLine();

        System.out.print("Введіть видавництво: ");
        String publisher = scanner.nextLine();

        System.out.print("Введіть рік видання: ");
        int publicationYear = scanner.nextInt();

        System.out.print("Введіть кількість сторінок: ");
        int pageCount = scanner.nextInt();

        System.out.print("Введіть ціну: ");
        double price = scanner.nextDouble();

        System.out.print("Чи є аудіо версія книги? (true/false): ");
        boolean hasAudioVersion = scanner.nextBoolean();

        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setAuthor(author);
        newBook.setPublisher(publisher);
        newBook.setPublicationYear(publicationYear);
        newBook.setPageCount(pageCount);
        newBook.setPrice(price);
        newBook.setHasAudioVersion(hasAudioVersion);

        bookManager.addBook(newBook);
        System.out.println("Нову книгу додано до списку.");
    }

    private static void listBooksByAuthor(Scanner scanner, BookManager bookManager) {
        System.out.print("Введіть автора: ");
        scanner.nextLine();  // Очищення буфера після nextInt
        String author = scanner.nextLine();

        List<Book> books = bookManager.findBooksByAuthor(author);
        if (!books.isEmpty()) {
            System.out.println("Список книг автора " + author + ":");
            printBookList(books);
        } else {
            System.out.println("Книги автора " + author + " не знайдено.");
        }
    }

    private static void listBooksByPublisher(Scanner scanner, BookManager bookManager) {
        System.out.print("Введіть видавництво: ");
        scanner.nextLine();  // Очищення буфера після nextInt
        String publisher = scanner.nextLine();

        List<Book> books = bookManager.findBooksByPublisher(publisher);
        if (!books.isEmpty()) {
            System.out.println("Список книг видавництва " + publisher + ":");
            printBookList(books);
        } else {
            System.out.println("Книги видавництва " + publisher + " не знайдено.");
        }
    }

    private static void listRecentBooks(Scanner scanner, BookManager bookManager) {
        System.out.print("Введіть кількість останніх років: ");
        int recentYears = scanner.nextInt();

        List<Book> books = bookManager.findRecentBooks(recentYears);
        if (!books.isEmpty()) {
            System.out.println("Список книг, випущених протягом останніх " + recentYears + " років:");
            printBookList(books);
        } else {
            System.out.println("Нових книг не знайдено.");
        }
    }

    private static void printBookList(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static void saveBooksToTextFile(BookManager bookManager) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("books.txt"))) {
            oos.writeObject(bookManager);
            System.out.println("Список книг збережено у текстовий файл.");
        } catch (IOException e) {
            System.err.println("Помилка при збереженні книг у текстовий файл: " + e.getMessage());
        }
    }

    private static void saveBooksToBinaryFile(BookManager bookManager) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("books.dat"))) {
            oos.writeObject(bookManager);
            System.out.println("Список книг збережено у бінарний файл.");
        } catch (IOException e) {
            System.err.println("Помилка при збереженні книг у бінарний файл: " + e.getMessage());
        }
    }

    private static BookManager loadBooksFromFile() {
        BookManager bookManager = new BookManager();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books.dat"))) {
            Object obj = ois.readObject();
            if (obj instanceof BookManager) {
                bookManager = (BookManager) obj;
                System.out.println("Список книг завантажено з бінарного файлу.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка при завантаженні книг з бінарного файлу: " + e.getMessage());
        }
        return bookManager;
    }
}
