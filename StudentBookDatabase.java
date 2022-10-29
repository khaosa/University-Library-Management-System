/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.pkg3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class StudentBookDatabase extends Database{

    public StudentBookDatabase(String filename) {
        super(filename);
    }
    
    @Override
    public StudentBook createRecordFrom(String line){
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String delimited[] = line.split(",");
      
        
        //return new StudentBook(delimited[0], delimited[1], (LocalDate) delimited[2] );

    }
   
