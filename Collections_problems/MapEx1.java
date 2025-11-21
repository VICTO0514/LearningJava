import java.util.*;

class MapEx1{

    public static void main(String[] args){

Map<String, Object> user1 = new HashMap<>();
user1.put("Age", 10);
user1.put("Name", "Victoria");

Map<String, Object> user2 = new HashMap<>();
user2.put("Age", 21);
user2.put("Name", "Jayasri");

Map<Integer, Map<String, Object>> map = new HashMap<>();
map.put(101, user1);
map.put(102, user2);

for(Map.Entry<Integer, Map<String, Object>> entry : map.entrySet()) {
    
    int id = entry.getKey();
    Map<String, Object> field = entry.getValue();
    
    System.out.println("ID: "+id);
    
    for(Map.Entry<String, Object> e : field.entrySet()) {
        System.out.println(e.getKey() + " : " + e.getValue());
    }
}

}
}


/*
// Using entrySet
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}

// Using keySet
for (String key : map.keySet()) {
    System.out.println("Key: " + key +"," + "Values: "+ map.get(key));
}

// Using values
for (Integer value : map.values()) {
    System.out.println("Value: " + value);
} */


