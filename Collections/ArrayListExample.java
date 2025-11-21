import java.util.*;

public class ArrayListExample{
    public static void main(String[] args) {
    
    ArrayList<Integer> l = new ArrayList<>();
    
    l.add(10);
    l.add(20);
    l.add(30);
    l.add(40);
    
    l.add(1,11);
    System.out.println(l);
    ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(50,60)); //fixed size
    l2.add(100);
    l.addAll(l2);
    
    System.out.println(l);
    System.out.println(l2);
    System.out.println("Element at index 2: "+l.get(5));
    l.set(2,22);
    
    System.out.println("Size: "+l.size());
    
    System.out.println("Contains: "+l.contains(30));
    
    l.remove(3);
    
    l.remove(Integer.valueOf(50));
    
    System.out.println("Empty: "+l.isEmpty());
    
    for(Integer num:l){
    System.out.println(num+" ");
    }
    
    Integer[] a = l.toArray(new Integer[0]);
    System.out.println("As arrays: "+Arrays.toString(a));
    }
}
