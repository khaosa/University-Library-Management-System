    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.pkg3;

import java.time.LocalDate;


public class LibrarianRole {
    
    private BookDatabase booksDatabase;
    private StudentBookDatabase studentBooksDatabase;

    public LibrarianRole(BookDatabase booksDatabase, StudentBookDatabase studentBooksDatabase) {
        this.booksDatabase = booksDatabase;
        this.studentBooksDatabase = studentBooksDatabase;
    }
    
   public void addBook(String id, String title, String authorName, String
   publisherName, int quantity){
       

        Book temp = new Book(id, title, authorName, publisherName, quantity);
        this.booksDatabase.insertRecord(temp);
        this.booksDatabase.saveToFile();
    }
   
   public Book[] getListOfBooks() {
        Book[] listOfBooks = new Book[this.booksDatabase.returnAllRecords().size()];

        return this.booksDatabase.returnAllRecords().toArray(listOfBooks);
    }
   
   public StudentBook[] getListOfBorrowingOperations(){
       
       StudentBook[] listOfBorrowingOperations = new StudentBook[this.studentBooksDatabase.returnAllRecords().size()];

        return this.studentBooksDatabase.returnAllRecords().toArray(listOfBorrowingOperations);
       
   }
   
   public int borrowBook(String studentId, String bookId, LocalDate borrowDate)
   {
       
        Book book = (Book) booksDatabase.getRecord(bookId);
        StudentBook studentBook = (StudentBook)studentBooksDatabase.getRecord(studentId+","+bookId);
       
          int quantity = book.getQuantity();
          if(quantity == 0)
              return 0;
          
           String extractedId = studentBook.getSearchKey();
           if(extractedId.equals(studentId+","+bookId))
               return 1;
           
           return 2;
       }
   }

