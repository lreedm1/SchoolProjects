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
import java.util.Random;
import java.util.ArrayList;

/** @author Michelle
*/
public class Dragon {
  
  private Room currentRoom; //current location of the dragon
  private Random randGen; //random number generator used for moving
  private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n"; 
  
  /**
   * Constructor for a dragon object. Assigns values to all non-static fields.
   * @param currentRoom the current location of the dragon
   */
  public Dragon(Room currentRoom) {
    this.currentRoom = currentRoom;
    this.randGen = new Random();
  }
  
  /**
   * Getter for this Dragon's currentRoom
   * @return this Dragon's current room
   */
  public Room getCurrentRoom()
  {
    return this.currentRoom;
  }
  
  /**
   * Dragon picks one of the rooms at random and moves there if possible. If it is not a valid
   * move, then it will pick again.
   * Dragons abide by the follow rules when moving:
   * 	1) The dragon can only move into rooms that are adjacent to it.
   *    2) The dragon CANNOT move into portal rooms.
   */
  public void changeRooms()
  {
    ArrayList<Room> adjRooms = currentRoom.getAdjacentRooms();
    int randInt;
    Room destRoom;
    //randomly pick an adj room, go there! as long as it is not portal room and exists
    do {
      int numOfRooms = currentRoom.getAdjacentRooms().size();
      randInt = randGen.nextInt(numOfRooms); //[0,3]
      destRoom = adjRooms.get(randInt);
     // System.out.println("Dragon is picking room..."+ destRoom);
    }while(!canMoveTo(destRoom));
    
    this.currentRoom = destRoom;
   
  }
  /**
   * Not a required method. Just a nice helper for deciding if the Dragon is making a valid move! :)
   */
  private boolean canMoveTo(Room destination)
  {
    if(destination.getType() == RoomType.PORTAL) //can't go into portal room
      return false;
   
    return true;
  }
  
  /**
   * Returns the string that is the dragon class's warning,
   * indicating that there is one nearby.
   * @return The dragon warning message string
   */
  public static String getDragonWarning()
  {
    return DRAGON_WARNING;
  }
}
