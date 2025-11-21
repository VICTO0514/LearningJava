import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

class BufferedReaderEx {
    public static void main(String[] args) {
        
        String filePath = "Output.txt";
        
        try{
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            
            int ch = br.read();
            System.out.println(ch);
            
            int c;
            while((c = br.read()) != -1) {
                System.out.println((char)c);
            }
            
            String line = br.readLine();
            System.out.println(line);
            
            String lines;
            while((lines = br.readLine()) != null) {
                System.out.println(lines);
            }
            
            br.close();
            System.out.println("Data reads from "+ filePath);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
