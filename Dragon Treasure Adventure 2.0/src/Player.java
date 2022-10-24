//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Dragon Treasure Adventure 2.0
// Course:   CS 300 Fall 2022
//
// Author:   Reed Lokken
// Email:    rlokken@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Aarav Gupta
// Partner Email: agupta297@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   X Write-up states that pair programming is allowed for this assignment.
//   X We have both read and understand the course Pair Programming Policy.
//   X We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE        
// Online Sources: Github Copilot
///////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;

/** @author Michelle
*/
public class Player {

  private Room currentRoom; //current location of the player
  
  /**
   * Constructor for a player object. Assigns values to all non-static fields.
   * @param currentRoom the current location of the player
   */
  public Player(Room currentRoom) {
    this.currentRoom = currentRoom;
  }
  
  /**
   * Getter for this player's current room.
   * @return The current location of the player
   */
  public Room getCurrentRoom() {
    return this.currentRoom;
  }
  
  /**
   * Setter for this player's current room.
   * @param newRoom the location that the player is moving to
   */
  public void changeRooms(Room newRoom)
  {
    this.currentRoom = newRoom;
  }
  
  /**
   * Determines whether or not the player can move to the given destination room.
   * A valid player move is ONLY to adjacent rooms.
   * @param destination room player wants to move to
   * @return true if it is a valid movement, false otherwise
   */
  public boolean canMoveTo(Room destination)
  {
    ArrayList<Room> adjRooms = currentRoom.getAdjacentRooms();
    return adjRooms.contains(destination);
  }
  
  /**
   * Determines whether or not the player needs to teleport.
   * Players teleport when their current room is of type PORTAL
   * @return true if they should teleport, false otherwise
   */
  public boolean shouldTeleport()
  {
    if(this.currentRoom.getType() == RoomType.PORTAL)
    {
      return true; 
    }
    return false;
  }
  
  /**
   * Gets the list of rooms adjacent to where the player is currently at.
   * @return list of rooms adjacent to the current room
   */
  public ArrayList<Room> getAdjacentRoomsToPlayer()
  {
    return currentRoom.getAdjacentRooms();
  }
  
  /**
   * Determines whether or not the given dragon is in a nearby room.
   * @param d the dragon to check if nearby
   * @return true if the dragon is nearby, false otherwise
   */
  public boolean isDragonNearby(Dragon d)
  {
    return currentRoom.isAdjacent(d.getCurrentRoom());
  }
  
  /**
   * Determines whether or not a portal room is in a nearby room.
   * @return true if a portal room is nearby, false otherwise
   */
  public boolean isPortalNearby()
  {
    ArrayList<Room> adjRooms = currentRoom.getAdjacentRooms();
    for(Room r: adjRooms) {
      if(r.getType() == RoomType.PORTAL)
        return true;
    }
    
    return false;      
  }
  
  /**
   * Determines whether or not the treasure room is in a nearby room.
   * @return true if the treasure room is nearby, false otherwise
   */
  public boolean isTreasureNearby()
  {
    ArrayList<Room> adjRooms = currentRoom.getAdjacentRooms();
    for(Room r: adjRooms) {
      if(r.getType() == RoomType.TREASURE)
        return true;
    }
    
    return false;      
  }
}


