import java.util.*;

class Employee {
    private int id;
    private String name;
    
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String toString() {
        return "Employee -> Id: " + id + ", Name: " + name;
    }
}
    
class EmployeeMain {

    public static void main(String[] args){

    	Scanner s = new Scanner(System.in);
    	
    	System.out.println("Number of Employees Details to be add.");
    	int totalEmployees = s.nextInt();
    	s.nextLine();
    	
    	System.out.println();
    	
    	List<Employee> employeesDetails = new ArrayList<>();
    	
    	for(int i = 0;i < totalEmployees; i++){
    	    System.out.println("Enter Details for Employee " + (i+1));
    	    
    	    System.out.println("ID: ");
    	    int id = s.nextInt();
    	    s.nextLine();
    	    
    	    System.out.println("NAME: ");
    	    String name = s.nextLine();

    	    employeesDetails.add(new Employee(id, name));
     }
    	
     System.out.println("\n-----------------");
    	    	
     List<String> projectDetails = new LinkedList<>();
    	
     for(int i = 0; i < totalEmployees; i++){
         System.out.println("Enter Project update for Employee " + (i+1) + " ");
    	   String project = s.nextLine();
    	   projectDetails.add(project);
     }
     
     System.out.println("\n-----------------");
     
     System.out.println("EMPLOYEES LIST");
     for(Employee e : employeesDetails){
         System.out.println(e);
     }
     
     System.out.println("PROJECT UPDATES");
     for(String p : projectDetails){
         System.out.println(p);
     }
     
     s.close();

    }
}
    
    
