import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;

class BufferedInputStreamEx {
    public static void main(String[] args) {
        
        try {
            BufferedInputStream i = new BufferedInputStream(new FileInputStream("Output.txt"));

            int b;
            while((b = i.read()) != -1) {
                System.out.println(b);
            }
            
            i.close();
            System.out.println("Datas readed");
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
