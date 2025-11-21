import java.io.FileReader;
import java.io.IOException;

class FileReaderExample {
    public static void main(String[] args) {
        
        try{
        
        FileReader fr = new FileReader("Output.txt");
        
        int ch;
        
        while((ch = fr.read()) != -1){
            System.out.println((char) ch);
        }
        
        fr.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
