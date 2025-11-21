package librarymanagementsystempkg;

import librarypkg.Library;
import java.util.Scanner;

public class LibraryManagementSystem{
    public static void main(String[] args){
        
        Library library=new Library(5);
        Scanner sc=new Scanner(System.in);
      
        int choice;
        
        while(true) {
        
        System.out.println("---LIBRARY MANAGEMENT SYSTEM---");
        System.out.println("1. Add book");
        System.out.println("2. View available books");
        System.out.println("3. Borrow book");
        System.out.println("4. Return book");
        System.out.println("5. Exit");
        
        System.out.println("Enter your choice");
        choice=sc.nextInt();
        sc.nextLine();
        
        switch(choice) {
        
        case 1: 
        System.out.println("Enter book id");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Title of the Book");
        String title=sc.nextLine();
        System.out.println("Enter Author Name of the book");
        String author=sc.nextLine();
        library.addBook(id,title,author);
        break;
        
        case 2:
        library.viewBook();
        break;
        
        case 3:
        System.out.println("Enter Book id to borrow book");
        id=sc.nextInt();
        library.borrowBook(id);
        break;
        
        case 4:
        System.out.println("Enter Book id to return book");
        id=sc.nextInt();
        library.returnBook(id);
        break;
        
        case 5:
        System.out.println("Existing....");
        return;
        
        default:
        System.out.println("Invalid options");
        }
        }
        
    }
}
        
        
