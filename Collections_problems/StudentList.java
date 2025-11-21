import java.util.Map;
import java.util.HashMap;

class StudentList{
    
    public static void main(String[] args) {
    
    Map<String, Integer> student1 = new HashMap<>();
    student1.put("Science" , 97);
    student1.put("Maths" , 87);
    
    Map<String, Integer> student2 = new HashMap<>();
    student2.put("Science" , 98);
    student2.put("Maths" , 95);
    
    Map<String, Map<String, Integer>> names1 = new HashMap<>();
    names1.put("Victoria", student1);
    
    Map<String, Map<String, Integer>> names2 = new HashMap<>();
    names2.put("Jayasri", student2); 
    
    Map<Integer, Map<String, Map<String, Integer>>> studentsList = new HashMap<>();
    studentsList.put(1, names1);
    studentsList.put(2, names2);
    
    for(Map.Entry<Integer, Map<String, Map<String, Integer>>> entry : studentsList.entrySet()) {
        int idNo = entry.getKey();
        Map<String, Map<String, Integer>> name = entry.getValue();
        
        System.out.println("\nID: "+idNo);
        
        for(Map.Entry<String, Map<String, Integer>> list : name.entrySet()) {
           String studentName = list.getKey();
           Map<String, Integer> marks = list.getValue();

           System.out.println("STUDENT NAME: "+studentName);
           
               for(Map.Entry<String, Integer> total : marks.entrySet()) {
                   System.out.println(total.getKey() + " : " + total.getValue());
               }
        }
    }
    
    }
}

    
