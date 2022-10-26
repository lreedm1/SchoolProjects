
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Exceptional Vending Machine
// Course:   CS 300 Fall 2022
//
// Author:   Aarav Gupta
// Email:    agupta297@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Reed Lokken
// Partner Email: rlokken@wisc.edu
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

/**
 * This class models a Character who is entered into the game. A character can
 * be a player, keyholder, or a dragon
 */
public class Character {
	private Room currentRoom; // the current room a character will be in
	private String label; // label of the character (i.e "DRAGON")

	/**
	 * Constructs the Character object
	 * 
	 * @param label       label of the character
	 * @param currentRoom room the character is currently in
	 */
	public Character(Room currentRoom, String label) {
		this.currentRoom = currentRoom;
		this.label = label;
	}

	/**
	 * returns the current room of the character
	 * 
	 * @return the current room of the character
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * sets the current room of the character
	 * 
	 * @return the label of the character
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * sets the current room of the character
	 * 
	 * @param newRoom the room the character is moving to
	 */
	public void setCurrentRoom(Room newRoom) {
		this.currentRoom = newRoom;
	}

	/**
	 * returns rooms that are adjacent to the current room
	 * 
	 * @return adjacent rooms
	 */
	public ArrayList<Room> getAdjacentRooms() {
		return currentRoom.getAdjacentRooms();
	}
}
