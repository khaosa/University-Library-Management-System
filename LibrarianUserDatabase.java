package assignment.pkg3;

import java.util.*;
import java.io.*;

public class LibrarianUserDatabase extends Database {

    public LibrarianUserDatabase(String filename) {
        super(filename);
    }

    public String getFileName() {
        return this.filename;
    }

  
    public LibrarianUser createRecordFrom(String line) { //2
        String delimited[] = line.split(",");
        return new LibrarianUser(delimited[0], delimited[1], delimited[2], delimited[3],
                delimited[4]);

    }

    
  /*  public void printData() {
        for (int i = 0; i < records.size(); i++) {
            System.out.println("Size: " + records.size());
            System.out.println(i + 1 + "." + " ID: " + records.get(i).getSearchKey() + "\tName: " + records.get(i).getName() + "\tEmail: "
                    + records.get(i).getEmail() + "\tAddress: " + records.get(i).getAddress()
                    + "\tPhone number: " + records.get(i).getPhoneNumber());
        }
    }*/

}
