import java.io.IOException;
import java.io.FileInputStream;

class FileInputStreamEx {
    public static void main(String[] args) {
        //String filePath = "Output.txt";
        
        try{
             FileInputStream i = new FileInputStream("Output.txt");
             
                          
             int avail = i.available();
             System.out.println(avail);
        
             int line;
             while((line = i.read()) != -1) {
                 System.out.println(line);
             }

             i.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
        
        
