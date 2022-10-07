
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Dragon Treasure Adventure
// Course:   CS 300 Fall 2022
//
// Author:   Reed Lokken
// Email:    rlokken@wisc.edu
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

/**
 * Simulates a player as if they were playing the game
 * 
 * @author reedlokken
 * 
 */

public class Player {
    private Room currentRoom; // current location of the player

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * canMoveTo() checks if a player's desired move is adjacent to the room they
     * are currently in
     * 
     * @param destination the room the player wants to move to
     * @return true if the desired room is adjacent to the current room, false
     */
    public boolean canMoveTo(Room destination) {
        for (int i = 0; i < currentRoom.getAdjacentRooms().size(); i++) {
            if (currentRoom.getAdjacentRooms().get(i).getID() == destination.getID()
                    && currentRoom.getAdjacentRooms().get(i).getRoomDescription() == destination.getRoomDescription()
                    && currentRoom.getAdjacentRooms().get(i) == destination) {
                return true;
            }
        }
        return false;
    }

    /**
     * changeRoom() method sets the currentRoom to the newroom provided by the user
     * 
     * @param newRoom is a Room object that replaces the currentRoom value;
     */
    public void changeRoom(Room newRoom) {
        currentRoom = newRoom;
    }

    /**
     * getAdjacentRoomsToPlayer method is a list of adjacent rooms next to the room
     * the player is currently in
     * 
     * @return the list of rooms adjacent to where the player is currently at.
     */
    public ArrayList<Room> getAdjacentRoomsToPlayer() {
        return currentRoom.getAdjacentRooms();
    }

    /**
     * getCurrentRoom() method is used to retrieve the current room the player is in
     * 
     * @return the current room of the player
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * isDragonNearby() method is used to check if there is a dragon in one of the
     * adjacent rooms in the list of rooms next to the player
     * 
     * @return true if there is a dragon in a nearby room
     */
    public boolean isDragonNearby(Dragon dragon) {
        for (int i = 0; i < currentRoom.getAdjacentRooms().size(); i++) {
            if (currentRoom.getAdjacentRooms().get(i) == dragon.getCurrentRoom())
                return true;
        }
        return false;
    }

    /**
     * checks if there is a portal in one of the
     * adjacent rooms
     * 
     * @return true if there is a nearby portal room
     */
    public boolean isPortalNearby() {
        for (int i = 0; i < currentRoom.getAdjacentRooms().size(); i++) {
            if (currentRoom.getAdjacentRooms().get(i).getType() == RoomType.PORTAL)
                return true;
        }
        return false;
    }

    /**
     * isTreasureNearby method is used to check if there is a portal in one of the
     * adjacent rooms in the list of rooms next to the player
     * 
     * @return true if there is a nearby treasure room
     */
    public boolean isTreasureNearby() {
        for (int i = 0; i < currentRoom.getAdjacentRooms().size(); i++) {
            if (currentRoom.getAdjacentRooms().get(i).getType() == RoomType.TREASURE)
                return true;
        }
        return false;
    }

    /**
     * shouldTeleport() method tells a user if the player needs to teleport if their
     * current room is a portal room
     * 
     * @return true if the current room is a portal room
     */
    public boolean shouldTeleport() {
        return currentRoom.getType() == RoomType.PORTAL;
    }

}

