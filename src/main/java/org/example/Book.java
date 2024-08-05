package org.example;

import java.time.LocalDate;

/**
 * Represents a book in the library.
 *
 * @author  Biniyam Yemane-berhane
 */
public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private int pages;
    private String category;
    private boolean isOnLoan;
    private LocalDate loanDate;

    /**
     * Constructor for Book class.
     *
     * @param title           The title of the book.
     * @param author          The author of the book.
     * @param publicationYear The publication year of the book.
     * @param pages           The number of pages in the book.
     * @param category        The category of the book.
     */
    public Book(String title, String author, int publicationYear, int pages, String category) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.category = category;
        this.isOnLoan = false;
    }

    // Getters and setters

    /**
     * Gets the title of the book.
     *
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the author of the book.
     *
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets the publication year of the book.
     *
     * @return The publication year of the book.
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * Gets the number of pages in the book.
     *
     * @return The number of pages in the book.
     */
    public int getPages() {
        return pages;
    }

    /**
     * Gets the category of the book.
     *
     * @return The category of the book.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Checks if the book is on loan.
     *
     * @return true if the book is on loan, false otherwise.
     */
    public boolean isOnLoan() {
        return isOnLoan;
    }

    /**
     * Sets the loan status of the book.
     *
     * @param onLoan   The loan status to set.
     * @param loanDate The date when the book was loaned.
     */
    public void setOnLoan(boolean onLoan, LocalDate loanDate) {
        isOnLoan = onLoan;
        this.loanDate = loanDate;
    }

    /**
     * Gets the loan date of the book.
     *
     * @return The loan date of the book.
     */
    public LocalDate getLoanDate() {
        return loanDate;
    }
}

