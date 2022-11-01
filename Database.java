/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.pkg3;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

abstract public class Database {
    
    ArrayList<Record> records = new ArrayList<Record>();
    String filename;
    
    public Database(String filename) {
        this.filename = filename;        
        this.readFromFile();
    }
    
    public void readFromFile() //1 
    {
        File file = new File(filename);
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                this.insertRecord(createRecordFrom(line));
            }
            input.close();
        } catch (Exception e) {
            System.out.println("Error opening file.");
        }
    }
    
    public abstract Record createRecordFrom(String line); //2

    public ArrayList<Record> returnAllRecords() {        //3
        return records;
    }
    
    public int getUserIndex(String key) //helper function to avoid code duplication
    {
        for (int i = 0; i < records.size(); i++) {
            if (key.equals(records.get(i).getSearchKey())) // check if key equals librarianId
            {
                return i;
            }
        }
        return -1;      //user doesn't exist
    }
    
    public boolean contains(String key) {           //4

        if (this.getUserIndex(key) < 0) //user doesnt exist
        {
            return false;
        } else {
            return true;
        }
    }
    
    public Record getRecord(String key) { //5
        
        int index = this.getUserIndex(key);
        if (index < 0) {          //user does not exist   
            return null;
        } else {
            return records.get(index);  //get user
        }
    }
    
    public void insertRecord(Record record) { //6

        if (this.getUserIndex(record.getSearchKey()) < 0) // no Recordwith the same id found
        {
            records.add(record);
        } else {
            System.out.println("User with ID " + record.getSearchKey() + " already exists.");
        }
        
    }
    
    public void deleteRecord(String key) {  //7

        int index = this.getUserIndex(key);
        
        if (index < 0) {
            System.out.println("User with ID " + key + " not found.");
        } else {
            records.remove(index);
            System.out.println("Record " + key + " deleted.");
        }
        
    }
    
    public void saveToFile() {
        
        try {
            FileWriter writer = new FileWriter(filename);
            for (int i = 0; i < records.size(); i++) {

                //*** use lineRepresentation method from librarianUser class instead of code duplication above
                writer.write(records.get(i).lineRepresentation() + "\n");
                
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error saving to file.");
            
        }
    }
    
}
