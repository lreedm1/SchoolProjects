import java.util.ArrayList;

public class Character {
    private Room currentRoom;
    private String label;


    /**
     * Constructs the Character object
     * @param label the label of the character
     * @param currentRoom the room the character is currently in
     */
    public Character(Room currentRoom, String label) {
        this.currentRoom = currentRoom;
        this.label = label;
    }

    /**
     * returns the current room of the character
     * @return the current room of the character
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * sets the current room of the character
     * @return the label of the character
     */
    public String getLabel() {
        return label;
    }

    /** 
     * sets the current room of the character
     * @param newRoom the room the character is moving to
     */
    public void setCurrentRoom(Room newRoom) {
        this.currentRoom = newRoom;
    }

    /**
     * returns rooms that are adjacent to the current room
     * @return adjacent rooms
     */
    public ArrayList<Room> getAdjacentRooms() {
        return currentRoom.getAdjacentRooms();
    }
}
