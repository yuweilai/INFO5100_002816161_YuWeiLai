package exercises.hackathon;

import java.util.ArrayList;
import java.util.List;

import exercises.hackathon.Book;
import exercises.hackathon.Library;

public class LibraryApp {
    public static void main(String[] args) {
        // Create Library instance
        Library library = new Library();

        // Add some books to the library
        library.addBook(new Book("Title1", "Author1", "Fiction", "111-1111111111"));
        library.addBook(new Book("Title2", "Author2", "Fiction", "111-2222222222"));
        library.addBook(new Book("Title3", "Author3", "Romance", "111-3333333333"));

        // Display available books
        System.out.println("Available Books:");
        List<Book> availableBooks = library.displayAvailableBooks();
        for (Book book : availableBooks) {
            System.out.println(book);
        }

        // Search for a book
        System.out.println("\nSearch Results:");
        List<Book> searchResults = library.search("To Kill a Mockingbird");
        for (Book book : searchResults) {
            System.out.println(book);
        }

        // Checkout a book
        String ISBNToCheckout = "111-1111111111";
        if (library.checkoutBook(ISBNToCheckout)) {
            System.out.println("\nBook with ISBN " + ISBNToCheckout + " checked out successfully.");
        } else {
            System.out.println("\nBook with ISBN " + ISBNToCheckout + " is not available for checkout.");
        }

        // Display available books after checkout
        System.out.println("\nAvailable Books after checkout:");
        availableBooks = library.displayAvailableBooks();
        for (Book book : availableBooks) {
            System.out.println(book);
        }

        // Return a book
        String ISBNToReturn = "111-1111111111";
        if (library.returnBook(ISBNToReturn)) {
            System.out.println("\nBook with ISBN " + ISBNToReturn + " returned successfully.");
        } else {
            System.out.println("\nBook with ISBN " + ISBNToReturn + " is not checked out.");
        }

        // Display available books after return
        System.out.println("\nAvailable Books after return:");
        availableBooks = library.displayAvailableBooks();
        for (Book book : availableBooks) {
            System.out.println(book);
        }

        // Save library data to file
        library.saveLibraryToFile("library_data.ser");

        // Load library data from file
        Library loadedLibrary = Library.loadLibraryFromFile("library_data.ser");

        // Display all available books from stored within the library
        System.out.println("\nAvailable Books from Loaded Library:");
        List<Book> availableBooksAll = loadedLibrary.displayAvailableBooks();
        for (Book book : availableBooksAll) {
            System.out.println(book);
        }
    }
}