import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void removeBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {

                if (book.isIssued()) {
                    System.out.println("Cannot remove an issued book.");
                    return;
                }

                books.remove(book);
                System.out.println("Book removed successfully!");
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public void searchBook(String title) {
        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                book.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            book.displayBook();
        }
    }

    public void issueBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {

                if (book.isIssued()) {
                    System.out.println("Book is already issued.");
                } else {
                    book.setIssued(true);
                    System.out.println("Book issued successfully!");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    public void returnBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {

                if (!book.isIssued()) {
                    System.out.println("Book is already available.");
                } else {
                    book.setIssued(false);
                    System.out.println("Book returned successfully!");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }
}