import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class PersonalDetails {
    private String name;
    private int age;
    private String phone;
    
    public PersonalDetails(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        
    }
    
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Phone: "+phone;
    }
}

class DetailsMap {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        List<PersonalDetails> list = new ArrayList<>();
        Map<String, PersonalDetails> map = new HashMap<>();
        
        System.out.println("Number of Details");
        int n = sc.nextInt();
        sc.nextLine();
        
        for(int i=1;i <= n;i++){
            System.out.println("Detail "+i);

        System.out.println("Name: ");
        String name = sc.nextLine();
        
        System.out.println("Age: ");
        int age = sc.nextInt();
        
        System.out.println("Phone: ");
        sc.nextLine();
        String phone = sc.nextLine();
        
        PersonalDetails p = new PersonalDetails(name,age,phone);
        list.add(p);     
        map.put("Detail " + i,p);
       }
       System.out.println("PERSONAL DETAILS:");
       for(Map.Entry<String, PersonalDetails> entry : map.entrySet()){
       
           String key = entry.getKey();
           PersonalDetails value = entry.getValue();
           
           System.out.println(key+" ");
           System.out.println(value+" ");
       }
   }
}
    
    
        
        
        
        
