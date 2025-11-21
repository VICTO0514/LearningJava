import java.util.*;
import java.io.*;

class EmptyLineException extends Exception {
    public EmptyLineException(String message) {
        super(message);
    }
}

class FileBasedCityFilter {
    public static void main(String[] args) {
        
        HashSet<String> citySet = new HashSet<>();
        
        File file = new File("CityNames.txt");
        
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            
            while((line = reader.readLine()) != null) {
                line = line.trim();
            
                if(line.isEmpty()){
                    throw new EmptyLineException("Empty Line Detected");
                }
                else{
                citySet.add(line);
                }
           }
      }
       
       catch(EmptyLineException e){
           System.out.println("Warning" + e.getMessage());
       }
       catch(FileNotFoundException e){
           System.out.println("File is not found" + e.getMessage());
       }
       catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
       }
        
        System.out.println("Unique Cities: "+citySet.size());
           System.out.println(citySet);
       }
}
