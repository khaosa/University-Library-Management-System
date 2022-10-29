
package assignment.pkg3;

public class Book implements Record{

         
    private String bookId;
    private String title;
    private String authorName;
    private String publisherName;
    private int quantity;

    public Book(String bookId, String title, String authorName, String publisherName, int quantity) {
        this.bookId = bookId;
        this.title = title;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.quantity = quantity;
    }
  
    @Override
    public String getSearchKey() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    
    public int getQuantity() {
        return quantity;
    }
    
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
      public String lineRepresentation() {

        return this.getSearchKey() + "," + this.getTitle() + "," + this.getAuthorName()+ ","
                + this.getPublisherName()+ "," + this.getQuantity();

    }

    
    
 
    
}
