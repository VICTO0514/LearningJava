import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        
        try{
             FileWriter fw = new FileWriter("Output.txt");
             
             fw.write("Hello, This is file writer example");
             
             fw.write('A');
             
           //  fw.write('b', 'c', 'd');
             
             fw.flush();
             fw.close();
             
             //System.out.println("Writing Completed successfully");
       }
       catch (IOException e) {
           e.printStackTrace();
       }
   }
}
