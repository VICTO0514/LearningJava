import java.util.*;

class TreeSortNullHandle {

    public static void main(String[] args){
    
    TreeSet<String> products = new TreeSet<>();
    
    String[] productNames = {"Mobile" , "Tv", "Laptop", null, "Tablet", "Camera", null};
    
    for(String product : productNames) {
        try{
            if(product == null){
                throw new NullPointerException("Null product found");
            }
            else{
                products.add(product);
            }
       }
       catch(NullPointerException e) {
           System.out.println("null value skipped");
       }
   }
   
   System.out.println("Sorted Products: "+products);
   
    }
}
    
    
    
    
