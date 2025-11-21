import java.util.*;
class HashSetExam{
    public static void main(String[] args) {
        
        Set<String> set = new HashSet<>();
        
        set.add("Apple");
        set.add("Orange");
        set.add("Mango");
        set.add("Orange");
        
        //set.remove("Apple"); no index

        System.out.println(set);
        System.out.println(set.hashCode());
        System.out.println(set.contains("MangO"));
    }
}
