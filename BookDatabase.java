/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.pkg3;


public class BookDatabase extends Database {

    public BookDatabase(String filename) {
        super(filename);
    }

    public String getFileName() {
        return this.filename;
    }

    @Override
    public Book createRecordFrom(String line) { //2
        String delimited[] = line.split(",");
        return new Book(delimited[0], delimited[1], delimited[2], delimited[3],
                Integer.parseInt(delimited[4]));
    }



    /*public void printData() {
        for (int i = 0; i < records.size(); i++) {
            System.out.println("Size: " + records.size());
            System.out.println(i + 1 + "." + " ID: " + records.get(i).getSearchKey() + "\tName: " + records.get(i).getTitle() 
                    + "\tAuthor: " + records.get(i).getAuthorName()+ "\tPublisher: " + records.get(i).getPublisherName()
                    + "\tQuantity: " + records.get(i).getQuantity());
        }
    }*/

}


