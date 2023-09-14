public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[3];

        books[0] = new Book(1, "Clean Code", "Martin", "Book", 2017, 186, 690);
        books[1] = new Book(2, "Second World War", "Robert", "Book", 2014, 250, 340);
        books[2] = new Book(3, "Population", "John", "Book", 2007, 153, 299);

        System.out.println("All books:\n");
        printBooks(books);

        System.out.println("Books with filter:\n");

        System.out.println("Books which older than 2017:\n");
        filterYear(books, 2017);

        System.out.println("Books with more than 200 pages:\n");
        filterPages(books, 200);

        System.out.println("Books name Population:\n");
        filterName(books, "Population");

        System.out.println("Books whose author is John:\n");
        filterAuthor(books, "John");

        System.out.println("Company name is Book:\n");
        filterCompany(books, "Book");

        System.out.println("Books cheaper than 500:\n");
        filterPrice(books, 500);


    }

    private static void filterPages(Book[] books, int filterPages) {
        for (Book book : books) {
            if (filterPages < book.getPages()) {
                System.out.println(book + "\n");
            }
        }
    }

    private static void filterName(Book[] books, String filterName) {
        for (Book book : books) {
            if (book.getValue().contains("Name: " + filterName)) {
                System.out.println(book + "\n");
            }
        }
    }

    private static void filterAuthor(Book[] books, String filterAuthor) {
        for (Book book : books) {
            if (book.getValue().contains("Author: " + filterAuthor)) {
                System.out.println(book + "\n");
            }
        }
    }

    private static void filterCompany(Book[] books, String filterCompany) {
        for (Book book : books) {
            if (book.getValue().contains("Company: " + filterCompany)) {
                System.out.println(book + "\n");
            }
        }
    }

    private static void filterPrice(Book[] books, int filterPrice) {
        for (Book book : books) {
            if (filterPrice >= book.getPrice()) {
                System.out.println(book + "\n");
            }
        }
    }

    public static void printBooks(Book[] books) {
        for (Book book : books) {
            System.out.println(book + "\n");
        }
    }

    public static void filterYear(Book[] books, int filterYear) {
        for (Book book : books) {
            if (filterYear > book.getYear()) {
                System.out.println(book + "\n");
            }
        }
    }
}