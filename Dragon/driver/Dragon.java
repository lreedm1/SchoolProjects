//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Dragon Treasure Adventure
// Course:   CS 300 Fall 2022
//
// Author:   Aarav Gupta
// Email:    agupta297@wisc.edu 
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NONE   
// Partner Email: NONE  
// Partner Lecturer's Name: NONE 
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE        
// Online Sources: NONE
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.Random;

/**
 * Dragon class creates a fire breathing dragon that can only move to rooms
 * adjacent to the ones its currently in, it gets the current room the dragon is
 * in and outputs a warning if the user is close to a dragon
 * 
 * @author reedlokken
 *
 */
public class Dragon {
    private Room currentRoom; // current location of the dragon
    private Random randGen; // random num generator used for moving
    private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n";

    /**
     * Dragon constructor initializes currentRoom and randGen
     * 
     * @param currentRoom is the location of the dragon in the game
     */
    public Dragon(Room currentRoom) {
        randGen = new Random();
        this.currentRoom = currentRoom;
    }

    /**
     * changeRooms() method is used to change the room of the dragon and checks to
     * see that the room we're sending the dragon to is 1) not a portal room and 2)
     * an adjacent room
     */
    public void changeRooms() {
        ArrayList<Room> adjacentRooms = currentRoom.getAdjacentRooms();
        int randomRoom = randGen.nextInt(adjacentRooms.size());
        Room newRoom = adjacentRooms.get(randomRoom);
        if (newRoom.isRoom() == true) {
            changeRooms();
            
        }
        else {
            currentRoom = newRoom;
        }
    }

    /**
     * getCurrentRoom() is used to retrieve the room where the dragon is
     * 
     * @return returns the current room of the dragon
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * getDragonWarning() is used to inform the user that there is a dragon in one
     * of the nearby rooms
     * 
     * @return returns a string of the dragon class warning, indicating
     *         one is near.
     */
    public static String getDragonWarning() {
        return DRAGON_WARNING;
    }
}

