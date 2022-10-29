package assignment.pkg3;

public class LibrarianUser implements Record{

    private String librarianId;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public LibrarianUser(String librarianId, String name, String email, String address, String phoneNumber) {
        this.librarianId = librarianId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setLibrarianId(String librarianId) {
        this.librarianId = librarianId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    @Override
    public String lineRepresentation() {

        return this.getSearchKey() + "," + this.getName() + "," + this.getEmail() + "," //use return statment only(?)
                + this.getAddress() + "," + this.getPhoneNumber();

    }

    @Override
    public String getSearchKey() {
        return this.librarianId;
    }

    public void printObjectData() {

        System.out.println(" ID: " + this.getSearchKey() + "\tName: " + this.getName() + "\tEmail: "
                + this.getEmail() + "\tAddress: " + this.getAddress()
                + "\tPhone number: " + this.getPhoneNumber());

    }

}
