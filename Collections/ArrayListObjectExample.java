import java.util.*;

class ArrayListObjectExample {
    public static void main(String[] args){
    
    ArrayList<Object> list = new ArrayList<>();
    
    list.add("Hello");
    list.add('A');
    list.add(1);
    list.add(10.9);
    list.add(11.4f);
    list.add(true);
    
    // list.add(new Date());
    
    for(Object obj : list){
        System.out.println(obj + " (" + obj.getClass().getSimpleName() + ")");
    }
    
    }
}
    

