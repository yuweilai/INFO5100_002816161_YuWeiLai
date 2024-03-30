package exercises.hackathon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {
    private String title;
    private String author;
    private String genre;
    private String ISBN;
    private int borrowCount;
    private boolean availability;

    public Book(String title, String author, String genre, String ISBN) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.ISBN = ISBN;
        this.borrowCount = 0;
        this.availability = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void incrementBorrowCount() {
        borrowCount += 1;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Genre: " + genre + ", ISBN: " + ISBN + ", Availability: " + availability;
    }
}
