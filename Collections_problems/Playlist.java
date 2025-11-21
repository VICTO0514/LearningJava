import java.util.*;

class InvalidTrackSelectionException extends Exception {
    public InvalidTrackSelectionException(String message) {
        super(message);
    }
}

class Playlist{
    
    List<String> playlist = new LinkedList<>();
    
    public playlist(){t
        playlist.add("song 1");
        playlist.add("song 2");
        playlist.add("song 3");
    }
    
    public void playAt(int index) throws InvalidTrackSelectionException {
        if(index < 0 || index >= playlist.size()) {
            throw InvalidTrackSelectionException("Invalid track index: "+index);
        }
        System.out.println("Now playing: "+playlist.get(index));
    }
    
    public static void main(String[] args) {
        playlist list = new playlist();
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter the index of the song to play");
        int index = s.nextInt();
        
        try{
            playlist.playAt(index);
        } 
        catch(InvalidTrackSelectionException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
    
    
    
    
