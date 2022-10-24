/* Class to represent each room of the dungeon as an object*/
import java.util.ArrayList;

/** @author Michelle
*/
public class Room {
  
  private RoomType type; //one of the four types a room could be
  private String roomDescription; //a brief description of the room
  private ArrayList<Room> adjRooms; //arraylist that holds the rooms adjacent to the current room, up to 4
  private final int ID; //unique name for each room to identify it
  private static int teleportLocationID; //place where all portal rooms will go to
  private static final String PORTAL_WARNING = "You feel a distortion in space nearby.\n";
  private static final String TREASURE_WARNING = "You sense that there is treasure nearby.\n";
 
  /**
   * Constructor for the room object. Assigns values to the non-static fields. 
   * The default type should be RoomType.NORMAL.
   * @param id the unique id number for this room
   * @param roomDescription a brief description of this room
   */
  public Room(int ID, String roomDescription) {
    this.ID = ID;
    this.roomDescription = roomDescription;
    this.adjRooms =  new ArrayList<Room>();
    this.type = RoomType.NORMAL;
  }
  
  /**
   * Getter for the type instance field
   * @return this object's roomtype
   */
  public RoomType getType(){
    return this.type;
  }
  
  /**
   * Getter for the id instance field
   * @return this object's id
   */
  public int getID() {
    return this.ID;
  }
  
  /**
   * Getter for the adjRooms instance field
   * @return this object's list of rooms adjacent to it
   */
  public ArrayList<Room> getAdjacentRooms() {
    return this.adjRooms;
  }
  
  /**
   * Takes the given room and adds it to this object's list of adjacent rooms
   * @param toAdd room to be added to the adjacent rooms list
   */
  public void addToAdjacentRooms(Room toAdd) {
 
    this.adjRooms.add(toAdd);
  }
  
  /**
   * Getter for the description instance field
   * @return this object's description
   */
  public String getRoomDescription() {
    return this.roomDescription;
  }
  
  /**
   * Changes this objects type to the roomtype given
   * @param newType The new roomtype of this Room object.
   */
  public void setRoomType(RoomType newType) {
    this.type = newType;
  }
  
  /**
   * Sets the class field teleportLocation to the int given.
   * @param teleportID the id of the room where all portals should teleport to
   */
  public static void assignTeleportLocation(int teleportID) {
    Room.teleportLocationID = teleportID;
  }
  
  /**
   * Returns the string that is the room class's portal warning,
   * indicating that there is one nearby.
   * @return The portal warning message string
   */
  public static String getPortalWarning() {
    return Room.PORTAL_WARNING;
  }
  
  /**
   * Returns the string that is the room class's treasure warning,
   * indicating that the treasure room nearby.
   * @return The treasure warning message string
   */
  public static String getTreasureWarning() {
    return Room.TREASURE_WARNING;
  }  
  
  /**
   * Returns the id of the room where all portals will teleport to.
   * @return the id of the teleportLocation room
   */
  public static int getTeleportationRoom()
  {
    return Room.teleportLocationID;
  }
  
  /**
   * Checks whether this given room is adjacent to this one or not.
   * @param r The room that you are seeing if it is adjacent to this.
   * @return true if they are adjacent, false otherwise
   */
  public boolean isAdjacent(Room r)
  {
    return adjRooms.contains(r);
  }
  
  /**Checks whether or not this Room is equal to the other.*/
  @Override
  public boolean equals(Object other)
  {
    if(other instanceof Room) {
      Room otherRoom = (Room)other;
      return this.ID == otherRoom.ID;
    }
    
    return false;
  }
  
  /**
   * Returns a String representation of this Room.
   */
  @Override
  public String toString()
  {
    String s = this.ID +": " + this.roomDescription+ " (" + type +")\n Adjacent Rooms: ";
    for(int i = 0; i<adjRooms.size(); i++)
    {
      s+= adjRooms.get(i).ID +" ";
    }
    
    return s;
  } 
  
  
 
}
