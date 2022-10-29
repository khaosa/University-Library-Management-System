/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.pkg3;

import java.time.LocalDate;


public class StudentBook implements Record{

    
    private String studentId;
    private String bookId;
    private LocalDate borrowDate;

    public StudentBook(String studentId,  String bookId, LocalDate borrowDate) {
        this.studentId = studentId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }
   
    public String getStudentId() {
        return studentId;
    }
    public String getBookId() {
        return bookId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }
    
    @Override
    public String lineRepresentation()
    {
      return this.getStudentId() + "," + this.getBookId()+ "," + this.getBorrowDate();
    }
    
    @Override
    public String getSearchKey()
    {
        return this.getStudentId() + "," + this.getBookId(); 
    }

    
    
    
    
    
}
