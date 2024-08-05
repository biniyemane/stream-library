package org.example;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a library that manages a collection of books.
 *
 * author Biniyam
 */
public class Library {
    private List<Book> books;

    /**
     * Constructor for Library class.
     */
    public Library() {
        this.books = new ArrayList<>();
    }

    /**
     * Adds a book to the library.
     *
     * @param book The book to add.
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Removes a book from the library by title.
     *
     * @param title The title of the book to remove.
     */
    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equals(title));
    }

    /**
     * Finds all books published in a specific year.
     *
     * @param year The publication year to search for.
     * @return A list of books published in the specified year.
     */
    public List<Book> findBooksByYear(int year) {
        return books.stream()
                .filter(book -> book.getPublicationYear() == year)
                .collect(Collectors.toList());
    }

    /**
     * Finds all books by a specific author.
     *
     * @param author The author to search for.
     * @return A list of books by the specified author.
     */
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    /**
     * Finds the book with the most pages.
     *
     * @return The book with the most pages, or null if no books are present.
     */
    public Book findBookWithMostPages() {
        return books.stream()
                .max((b1, b2) -> Integer.compare(b1.getPages(), b2.getPages()))
                .orElse(null);
    }

    /**
     * Finds all books with more than a specified number of pages.
     *
     * @param n The minimum number of pages.
     * @return A list of books with more than the specified number of pages.
     */
    public List<Book> findBooksWithMoreThanNPages(int n) {
        return books.stream()
                .filter(book -> book.getPages() > n)
                .collect(Collectors.toList());
    }

    /**
     * Gets all book titles in the library, sorted alphabetically.
     *
     * @return A list of all book titles, sorted alphabetically.
     */
    public List<String> getAllBookTitlesSorted() {
        return books.stream()
                .map(Book::getTitle)
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Finds all books in a specific category.
     *
     * @param category The category to search for.
     * @return A list of books in the specified category.
     */
    public List<Book> findBooksByCategory(String category) {
        return books.stream()
                .filter(book -> book.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    /**
     * Loans out a book by title.
     *
     * @param title The title of the book to loan out.
     * @return true if the book was successfully loaned out, false otherwise.
     */
    public boolean loanBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && !book.isOnLoan()) {
                book.setOnLoan(true, LocalDate.now());
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a book by title.
     *
     * @param title The title of the book to return.
     * @return true if the book was successfully returned, false otherwise.
     */
    public boolean returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.isOnLoan()) {
                book.setOnLoan(false, null);
                return true;
            }
        }
        return false;
    }

    /**
     * Calculates the late fees for a book.
     *
     * @param book The book to calculate late fees for.
     * @return The amount of late fees owed.
     */
    public double calculateLateFees(Book book) {
        if (book.isOnLoan()) {
            long daysOnLoan = ChronoUnit.DAYS.between(book.getLoanDate(), LocalDate.now());
            if (daysOnLoan > 14) {
                return (daysOnLoan - 14) * 0.5; // $0.50 per day after 2 weeks
            }
        }
        return 0;
    }
}

