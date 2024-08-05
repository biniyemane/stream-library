package org.example;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user of the library.
 *
 * author Biniyam
 */
public class User {
    private String name;
    private int libraryCardNumber;
    private List<Book> borrowedBooks;

    /**
     * Constructor for User class.
     *
     * @param name              The name of the user.
     * @param libraryCardNumber The library card number of the user.
     */
    public User(String name, int libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters and setters

    /**
     * Gets the name of the user.
     *
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the library card number of the user.
     *
     * @return The library card number of the user.
     */
    public int getLibraryCardNumber() {
        return libraryCardNumber;
    }

    /**
     * Gets the list of books borrowed by the user.
     *
     * @return The list of books borrowed by the user.
     */
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    /**
     * Adds a book to the list of borrowed books.
     *
     * @param book The book to borrow.
     */
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    /**
     * Removes a book from the list of borrowed books.
     *
     * @param book The book to return.
     */
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}

