public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[2];

        books[0] = new Book(1, "Clean Code", "Martin", "Book", 2017, 186, 690);
        books[1] = new Book(2, "Robert", "Second World War", "Book", 2014, 250, 340);
//        books[2] = new Book(3, "Jhon", "Population", "Book", 2007, 153, 299);

        System.out.println("All books:\n");
        printBooks(books);
    }

    public static void printBooks(Book[] books) {
        for(int i = 0; i < books.length; i++) {
            System.out.println(books[i] + "\n");
        }
    }
}