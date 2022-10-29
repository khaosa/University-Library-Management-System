package assignment.pkg3;


public class AdminRole {

    private LibrarianUserDatabase database;

    public AdminRole(LibrarianUserDatabase database) {
        this.database = database;
    }

    public LibrarianUserDatabase getDatabase() {
        return database;
    }

    public void setDatabase(LibrarianUserDatabase database) {
        this.database = database;
    }

    public void addLibrarian(String librarianId, String name, String email,
            String address, String phoneNumber) {

        LibrarianUser temp = new LibrarianUser(librarianId, name, email, address, phoneNumber);
        this.database.insertRecord(temp);
        this.database.saveToFile();
    }

    public LibrarianUser[] getListOfLibrarians() {
        LibrarianUser[] listOfLibrarians = new LibrarianUser[this.database.returnAllRecords().size()];

        return this.database.returnAllRecords().toArray(listOfLibrarians);

    }

    public void removeLibrarian(String key) {

        this.database.deleteRecord(key);
        this.database.saveToFile();
    }

    public void logout() {
        this.database.saveToFile();
    }

}
