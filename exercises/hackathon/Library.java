package exercises.hackathon;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import exercises.hackathon.Book;

public class Library implements Serializable {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String ISBN) {
        books.removeIf(book -> book.getISBN().equals(ISBN));
    }

    public List<Book> search(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(keyword) || book.getAuthor().contains(keyword) || book.getGenre().contains(keyword)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> displayAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public boolean checkoutBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN) && book.isAvailable()) {
                book.setAvailability(false);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN) && !book.isAvailable()) {
                book.setAvailability(true);
                return true;
            }
        }
        return false;
    }

    public void saveLibraryToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
            System.out.println("Library data saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving library data to file: " + e.getMessage());
        }
    }

    public static Library loadLibraryFromFile(String fileName) {
        Library library = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            library = (Library) ois.readObject();
            System.out.println("Library data loaded from file: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading library data from file: " + e.getMessage());
        }
        return library;
    }
}