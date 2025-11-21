import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class MarkList {
    public static void main(String[] args) {
  
        Scanner s = new Scanner(System.in);
        Map<String, List<Integer>> studentsList = new HashMap<>();
        
        System.out.println("Number of Students:");
        int totalStudents = s.nextInt();
        s.nextLine();
        
        for(int i=0; i<totalStudents;i++){
            System.out.println("Student Name: ");
            String names = s.nextLine();
            
            System.out.println("How Many marks for: "+ names);
            int marksCount = s.nextInt();
            
            List<Integer> marks = new ArrayList();
            
            for(int j=0; j<marksCount; j++){
                System.out.println("Enter Mark: "+(j+1)+" ");
                int mark = s.nextInt();
                marks.add(mark);
            }
            s.nextLine();
            studentsList.put(names, marks);
        }   
        System.out.println("\n---STUDENTS MARKS---");
        for(Map.Entry<String, List<Integer>> result : studentsList.entrySet()) {
            System.out.println(result.getKey() +" : "+result.getValue());
        }
    }
}
        
