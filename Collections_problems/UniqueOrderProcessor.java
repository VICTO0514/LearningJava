import java.util.Map;
import java.util.HashMap;

class DuplicateOrderException extends Exception {
    public DuplicateOrderException(String message) {
        super(message);
    }
}

public class UniqueOrderProcessor {
    public static Map<String, String> processOrders(String[][] orders) throws DuplicateOrderException {
        Map<String, String> orderMap = new HashMap<>();
        
        for(String[] order : orders){
            String orderId = order[0];
            String customerName = order[1];
            
            if(orderMap.containsKey(orderId)){
                throw new DuplicateOrderException("Duplicate Order ID found: "+orderId);
            }
            orderMap.put(orderId, customerName);
        }
        
        return orderMap;
    }
    
    public static void main(String[] args){
        
        String[][] orders = {
            {"0RD001", "Alice"},
            {"0RD002", "Jai"},
            {"0RD003", "Charlie"},
            {"0RD004", "David"}
        };
        
        try{
            Map<String, String> uniqueOrders = processOrders(orders);
            System.out.println("Unique Orders");
            for (Map.Entry<String, String> entry : uniqueOrders.entrySet()) {
                System.out.println("Order Id: "+ entry.getKey() + ", Customer: "+entry.getValue());
            }
        }
        catch (DuplicateOrderException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
        
        
