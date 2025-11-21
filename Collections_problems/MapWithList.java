import java.util.*;

class MapWithList {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        Map<String, List<String>> map = new HashMap<>();
        
        System.out.println("No. of users");
        int users = Integer.parseInt(s.nextLine());
        
        for(int i=1;i<=users;i++){
            System.out.println("\nUser: "+i);
            
            System.out.println("ID");
            String id = s.nextLine();
            
            System.out.println("Mobile Number Count for "+id);
            int numberCount = Integer.parseInt(s.nextLine());
            
            List<String> mobileList = new ArrayList<>();
            for(int j=1;j<=numberCount;j++){
                 System.out.println("Mobile Number");
                 String mobile = s.nextLine();
                 mobileList.add(mobile);
            }
            
            map.put(id,mobileList);
        }
        
        System.out.println("---USERS MOBILE NUMBERS---");
        for(Map.Entry<String, List<String>> c : map.entrySet()) {
            System.out.println("User Id: "+ c.getKey());
            List<String> field = c.getValue();
            
            for(String phone : field){
                System.out.println(phone);
            }
        }
    }
}
            
            
        
