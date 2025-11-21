package librarypkg;
class Library{
    Book[] books;
    int count=0;
    
        public Library(int size){
        books=new Book[size];
        this.count=0;
    }
    
    public void addBook(int id,String title,String author){
        for(int i=0;i<count;i++){
            if(count<=0 && count>=books.length){
                books[count++]=new Book(id,title, author);
                System.out.println("Book added successfully");
            }
            else{
            System.out.println("Book already added");
            }
            return;
        }
     }
     
     public void viewBook(){
        for(int i=0;i<count;i++){
            books[i].display();
        }
     
     }
     
     public void borrowBook(int id) {
         for(int i=0;i<count;i++){
             if(books[i].getId()==id && !books[i].getIssue()){
                 books[i].borrowBook();
                 System.out.println("Book borrowed "+books[i].getTitle());
             }
             else{
             System.out.println("Book is already borrowed");
             }
             return;
         }
         System.out.println("No book in this name is available");
    }
    
    public void returnBook(int id) {
        for(int i=0;i<count;i++){
            if(books[i].getId()==id && books[i].getIssue()){
                books[i].returnBook();
                System.out.println("Book returned "+books[i].getTitle());
            }
            else{
            System.out.println("Book is already returned");
            }
            return;
       }
       System.out.println("No book in this name is available");
    }
    
}

