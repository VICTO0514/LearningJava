import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

class BufferedWriterEx {
    public static void main(String[] args) {
        
        String filePath = "Out.txt";
        
        try{
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("BufferedWriter");
            bw.write("\n BufferedWriter example");
            
            bw.close();
            System.out.println("Data written to "+ filePath);
        }
        catch(IOException e) {
            System.out.println("An error occurred "+e.getMessage());
        }
    }
}

        
