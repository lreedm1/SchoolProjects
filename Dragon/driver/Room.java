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
 * Represents a room in the cave
 * Each room has a unique id, a description, and a type
 * 
 * @author reedLokken
 */
public class Room {
	private RoomType type; // one of the four types a room could be
	private String roomDescription; // a brief description of the room
	private ArrayList<Room> adjRooms; // arraylist that holds the rooms adjacent
	private final int ID; // unique ID for each room to identify it
	private static int teleportLocationID; // place where all portal rooms will go to
	private static final String PORTAL_WARNING = "You feel a distortion in space nearby.\n";
	private static final String TREASURE_WARNING = "You sense that there is treasure nearby.\n";

	/**
	 * Initializes a room with a description and unique ID with a default return
	 * type of RoomType.NORMAL
	 * 
	 * 
	 * @param ID              - unique id number for this room
	 * @param roomDescription - a brief description of the room
	 */
	public Room(int ID, String roomDescription) {
		this.ID = ID;
		this.roomDescription = roomDescription;
		this.type = RoomType.NORMAL;
		this.adjRooms = new ArrayList<Room>();
	}

	/**
	 * Determines if the given object is equal to this room.
	 * They are equal if other is a Room and their IDs are the same.
	 * 
	 * @param other, another object to check if it is equal to this
	 * @return true if the two rooms are equal, false otherwise
	 * @author Michelle
	 */
	@Override
	public boolean equals(Object other) {
		if (other instanceof Room) {
			Room otherRoom = (Room) other;
			return this.ID == otherRoom.ID;
		}
		return false;
	}

	/**
	 * Returns a String representation of this room.
	 * 
	 * @return the string representation of this room and
	 *         its object data field values
	 * @author Michelle
	 */
	@Override
	public String toString() {
		String s = this.ID + ": " + this.roomDescription + " (" + type + ")\n Adjacent Rooms: ";
		for (int i = 0; i < adjRooms.size(); i++) {
			s += adjRooms.get(i).ID + " ";
		}
		return s;
	}

	// sets the room type to the given type
	public void setRoomType(RoomType newType) {
		this.type = newType;
	}

	// returns the room description
	public String getRoomDescription() {
		return this.roomDescription;
	}

	// returns the room ID
	public int getID() {
		return this.ID;
	}

	// returns the room type
	public RoomType getType() {
		return null;
	}

	/**
	 * Adds a room to the list of adjacent rooms
	 * 
	 * @param room - the room to add to the list of adjacent rooms
	 * 
	 **/
	public void addToAdjacentRooms(Room room) {
		adjRooms.add(room);
	}

	// returns the list of adjacent rooms
	public ArrayList<Room> getAdjacentRooms() {
		return this.adjRooms;
	}

	// returns true if the room is adjacent, else false
	public boolean isAdjacent(Room room) {
		if (adjRooms.contains(room)) {
			return true;
		}
		return false;
	}

	// returns the warning message for the room
	public static void assignTeleportLocation(int teleportID) {
		teleportLocationID = teleportID;
	}

	// returns the teleport location ID
	public static int getTeleportationRoom() {
		return teleportLocationID;
	}

	// returns the portal warning message
	public static String getPortalWarning() {
		return PORTAL_WARNING;
	}

	// returns the treasure warning message
	public static Object getTreasureWarning() {
		return TREASURE_WARNING;
	}

}
