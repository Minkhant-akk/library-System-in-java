package JavaClassFile;
import java.util.ArrayList;
import java.util.Scanner;

// Book class with title, author and quantity
class Book{
    private String title;
    private String author;
    private int quantity;

    public Book(String title, String author, int quantity){
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }
    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
// Class libary is to manage books and operations
public class LibrarySystem {
    private ArrayList<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // display the library system menu
    private void displayMenu(){
        System.out.println("Welcome to the library System!");
        System.out.println("1. Add Books");
        System.out.println("2. Borrow Books");
        System.out.println("3. Return Books");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
// Add books to library system

    private void addBooks(){
        System.out.println("\nAdding Books...");
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        Book newBook = new Book(title, author, quantity);

// check the book is already exist or not

        boolean bookExists = false;
        for(Book book: books){
            if(book.getTitle().equalsIgnoreCase(title)){
                book.setQuantity(book.getQuantity() + quantity);
                bookExists = true;
                break;
            }
        }
        if(!bookExists){
            books.add(newBook);
        }
        System.out.println("Book(s) added successfully!");
    }
// boork books from library 

    private void borrowBooks(){
        System.out.println("\nBorrowing Books...");
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter number of books to borrow: ");
        int quantityToBorrow = scanner.nextInt();
        scanner.nextLine();
// if the book is found in the library, output successfully
        boolean bookFound = false;
        for (Book book : books) {
            if(book.getTitle().equalsIgnoreCase(title)){
                if(book.getQuantity() >= quantityToBorrow){
                    book.setQuantity(book.getQuantity() - quantityToBorrow);
                    System.out.println("Book(s) borrowed successfully!");
            }else {
                System.out.println("Can't borrow this book! ");
            }
            bookFound = true;
            break;
        }
    }
// if the book is not found, output an error message

        if(!bookFound){
            System.out.println("Book is not found in the library.");
        }
}
// return the book to library

    private void returnBooks(){
        System.out.println("\nReturning Books...");
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter number of books to return: ");
        int quantityToReturn = scanner.nextInt();
        scanner.nextLine();

        boolean bookFound = false;
        for(Book book : books){
            if(book.getTitle().equalsIgnoreCase(title)){
                book.setQuantity(book.getQuantity() + quantityToReturn);
                System.out.println("Book(s) returned successfully!");
                bookFound = true;
                break;
            }
        }
        if(!bookFound){
            System.out.println("You're not borrow this book.");
        }
    }
// Start the library system
    public void start(){
        int choice;
        do{
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    addBooks();
                    break;
                case 2:
                    borrowBooks();
                    break;
                case 3:
                    returnBooks();
                    break;
                case 4:
                    System.out.println("Exiting Library System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }   while(choice != 4);
    }
        public static void main(String[] args){
            LibrarySystem librarySystem = new LibrarySystem();
            librarySystem.start();
        }

}