package org.example;
import java.time.LocalDate;
import java.util.List;

/**
 * Main class to test the functionality of the library management system.
 *
 * author Biniyam
 */

public class StreamMain {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books to the library
        library.addBook(new Book("Title1", "Author1", 2020, 300, "Fiction"));
        library.addBook(new Book("Title2", "Author2", 2019, 400, "Science"));
        library.addBook(new Book("Title3", "Author1", 2021, 150, "History"));

        // Find books by author
        List<Book> booksByAuthor1 = library.findBooksByAuthor("Author1");
        booksByAuthor1.forEach(book -> System.out.println(book.getTitle()));

        // Loan a book
        boolean loaned = library.loanBook("Title1");
        System.out.println("Book loaned: " + loaned);

        // Calculate late fees after 15 days
        Book book = booksByAuthor1.get(0);
        if (book.isOnLoan()) {
            book.setOnLoan(true, LocalDate.now().minusDays(15));
            double lateFees = library.calculateLateFees(book);
            System.out.println("Late fees: $" + lateFees);
        }

        // Return a book
        boolean returned = library.returnBook("Title1");
        System.out.println("Book returned: " + returned);
    }
}
