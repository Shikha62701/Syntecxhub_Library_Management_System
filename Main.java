import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. View All Books");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {

                case 1:
                    try {
                        System.out.print("Enter Book ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Book Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter Author Name: ");
                        String author = sc.nextLine();

                        if (title.trim().isEmpty() || author.trim().isEmpty()) {
                            System.out.println("Title and author cannot be empty.");
                        } else {
                            Book book = new Book(id, title, author);
                            library.addBook(book);
                        }

                    } catch (Exception e) {
                        System.out.println("Invalid Book ID.");
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Enter Book ID to remove: ");
                        int id = Integer.parseInt(sc.nextLine());
                        library.removeBook(id);
                    } catch (Exception e) {
                        System.out.println("Invalid Book ID.");
                    }
                    break;

                case 3:
                    System.out.print("Enter book title to search: ");
                    String title = sc.nextLine();
                    library.searchBook(title);
                    break;

                case 4:
                    library.displayBooks();
                    break;

                case 5:
                    try {
                        System.out.print("Enter Book ID to issue: ");
                        int id = Integer.parseInt(sc.nextLine());
                        library.issueBook(id);
                    } catch (Exception e) {
                        System.out.println("Invalid Book ID.");
                    }
                    break;

                case 6:
                    try {
                        System.out.print("Enter Book ID to return: ");
                        int id = Integer.parseInt(sc.nextLine());
                        library.returnBook(id);
                    } catch (Exception e) {
                        System.out.println("Invalid Book ID.");
                    }
                    break;

                case 7:
                    System.out.println("Thank you for using Library Management System!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please select 1-7.");
            }
        }
    }
}

