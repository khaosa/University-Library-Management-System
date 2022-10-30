/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment.pkg3;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Assignment3 {

    public static void main(String[] args) {
  
        
       StudentBookDatabase database = new StudentBookDatabase("filename.txt");
       
       BookDatabase Database = new BookDatabase("x.txt");
       
       //AdminRole khalid = new AdminRole(Database);
       
       Book test1 = new Book("B2568", "BookTtitle", "khalid", "khalid", 1);
       StudentBook test2 = database.createRecordFrom("7693,B2568,12-02-2022");
       
    
       database.insertRecord(test2);
       Database.insertRecord(test1);
       
       LibrarianRole khalid = new LibrarianRole(Database, database);
        System.out.println(khalid.borrowBook(test2.getStudentId(), test2.getBookId(), test2.getBorrowDate()));
       // System.out.println(test.getStudentId() + ", " + test.getBookId() + ", " + test.getBorrowDate());
                
       
       
      

       

       // LibrarianUser[] newArray = khalid.getListOfLibrarians();*/

    }
}
