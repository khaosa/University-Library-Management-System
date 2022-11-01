
package assignment.pkg3;

import java.time.LocalDate;

public class LibrarianRole {

    private BookDatabase booksDatabase;
    private StudentBookDatabase studentBooksDatabase;

    public void addBook(String id, String title, String authorName, String publisherName, int quantity) {

        Book temp = new Book(id, title, authorName, publisherName, quantity);
        this.booksDatabase.insertRecord(temp);
        this.booksDatabase.saveToFile();
    }

    public void setBooksDatabase(BookDatabase booksDatabase) {
        this.booksDatabase = booksDatabase;
    }

    public void setStudentBooksDatabase(StudentBookDatabase studentBooksDatabase) {
        this.studentBooksDatabase = studentBooksDatabase;
    }

    public Book[] getListOfBooks() {

        if (this.booksDatabase == null) {
            return new Book[0];
        }

        Book[] listOfBooks = new Book[this.booksDatabase.returnAllRecords().size()];
        return this.booksDatabase.returnAllRecords().toArray(listOfBooks);

    }

    public StudentBook[] getListOfBorrowingOperations() {

        if (this.studentBooksDatabase == null) {
            return new StudentBook[0];
        }

        StudentBook[] listOfBorrowingOperations = new StudentBook[this.studentBooksDatabase.returnAllRecords().size()];
        return this.studentBooksDatabase.returnAllRecords().toArray(listOfBorrowingOperations);

    }

    public int borrowBook(String studentId, String bookId, LocalDate borrowDate) {

        Book book = (Book) booksDatabase.getRecord(bookId);
        
         if (book == null) {        //book not found in books.txt
            return 0; 
        }
         
        StudentBook studentBook = (StudentBook) studentBooksDatabase.getRecord(studentId + "," + bookId);
        
      //  String extractedId = studentBook.getSearchKey();

        int quantity = book.getQuantity();
        if (quantity == 0) {
            return 0;
        } else if (studentBook!= null && studentBook.getSearchKey().equals(studentId + "," + bookId)) {
            return 1;
        } else {
            book.setQuantity(book.getQuantity() - 1);
            studentBooksDatabase.insertRecord(studentBooksDatabase.createRecordFrom(studentId + "," + bookId + "," + borrowDate));
            studentBooksDatabase.saveToFile();
            booksDatabase.saveToFile();
            return 2;

        }

    }

    public double returnBook(String studentId, String bookId, LocalDate returnDate) {

        Book book = (Book) booksDatabase.getRecord(bookId);
        StudentBook studentBook = (StudentBook) studentBooksDatabase.getRecord(studentId + "," + bookId);

        if (book == null || studentBook == null) {      
            return 0;
        }
        
        book.setQuantity(book.getQuantity() + 1); //set quantity + 1 
        
        
        double returnFee = 0; 
        int difference = returnDate.getDayOfMonth() - studentBook.getBorrowDate().getDayOfMonth();
        if (difference < 7) {
            returnFee = 0;
        } else {                                //calculate late fee
            returnFee = (difference - 7) * 0.5;
        }
        

        this.studentBooksDatabase.deleteRecord(studentId + "," + bookId);   //book is no longer borrowed, delete from records
        this.studentBooksDatabase.saveToFile(); //update studentbooks.txt
        this.booksDatabase.saveToFile();  // update books.txt

            
        return returnFee;       
    }

    public void logout() {
        if (this.booksDatabase == null || this.studentBooksDatabase == null) {
            
        }
        else{
        this.booksDatabase.saveToFile();
        this.studentBooksDatabase.saveToFile();
        }
    }

}
