import java.io.IOException;
import java.io.DataInputStream;
import java.io.FileInputStream;

class DataInputStreamEx {
    public static void main(String[] args) {
        
        try {
            DataInputStream d = new DataInputStream(new FileInputStream("Output.txt"));
            
            int a = d.readInt();
            double b = d.readDouble();
            
            System.out.println("a "+a);
            System.out.println("b "+ b);
            d.close();
        }
        catch(IOException e) {
            System.out.println("An error occurred "+ e.getMessage());
        }
    } 
}
