import java.util.*;

class InvalidTrackSelectionException extends Exception {
    public InvalidTrackSelectionException(String message) {
        super(message);
    }
}

class Playlist{
    
    List<String> playlist = new LinkedList<>();
    
    public Playlist(){
        playlist.add("song 1");
        playlist.add("song 2");
        playlist.add("song 3");
    }
    
    public void playAt(int index) throws InvalidTrackSelectionException {
        if(index < 0 || index >= playlist.size()) {
            throw new InvalidTrackSelectionException("Invalid track index: "+index);
        }
        System.out.println("Now playing: "+playlist.get(index));
    }
    
    public static void main(String[] args) {
        Playlist list = new Playlist();
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter the index of the song to play");
        int index = s.nextInt();
        
        try{
            list.playAt(index);
        } 
        catch(InvalidTrackSelectionException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
    
    
    
    
