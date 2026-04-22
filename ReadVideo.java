package filehandling;
import java.io.File;
import java.io.IOException;

public class ReadVideo {
	public static void main(String[] args) throws IOException {

		//Change this to your video path
        String filePath = "src/filehandling/videoo.mp4";

        File file = new File(filePath);

        // Check if file exists
        if (!file.exists()) {
            System.out.println("File not found: " + file.getAbsolutePath());
            return;
        }

        try {
            //Open using Linux default video player
            ProcessBuilder pb = new ProcessBuilder("vlc", file.getAbsolutePath());
            pb.start();

            System.out.println("Opening video...");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }		
    }
}
