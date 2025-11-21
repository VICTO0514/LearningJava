package bookpkg;
class Book{
    private int id;
    private String title;
    private String author;
    private boolean isIssued;
    
    public Book(int id, String title, String author){
        this.id=id;
        this.title=title;
        this.author=author;
        this.isIssued=false;
    }
    
    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public boolean getIssue() {
        return isIssued;
    }
    
    public void borrowBook() {
        isIssued=true;
    }
    
    public void returnBook() {
        isIssued=false;
    }
    
    void display(){
        System.out.println("Bood Id: "+id+" , Title: "+title+" , Author: "+author);
    }
    
}
