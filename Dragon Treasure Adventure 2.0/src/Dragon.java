
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
import java.util.Random;

/**
 * This class models a Dragon Character which extends the class Character and
 * implements the interface Moveable
 */
public class Dragon extends Character implements Moveable {
	private Random randGen; // random num generator used for moving
	private static final String DRAGON_WARNING = "You hear a fire breathing Dragon nearby!\n"; // warning that a dragon
																								// is in a nearby
																								// adjacent room
	private static final String DRAGON_ENCOUNTER = "Oh no! You ran into the fire breathing dragon!\n"; // warning
																										// telling the
																										// user that
																										// they have
																										// encountered
																										// the dragon

	/**
	 * Constructs the Dragon Object
	 * 
	 * @param currentRoom room the dragon is currently in
	 * @throws IllegalArgumentException throw an illegal argument exception if the
	 *                                  current room is not a treasure room
	 */
	public Dragon(Room currentRoom) throws IllegalArgumentException {
		super(currentRoom, "DRAGON");
		randGen = new Random();
		if (!(currentRoom instanceof TreasureRoom)) {
			throw new IllegalArgumentException("currentRoom is not a TreasureRoom");
		}
	}

	/**
	 * Checks to see if the dragon can change rooms
	 * 
	 * @return return true if the dragon can successfully change rooms and false
	 *         otherwise
	 * 
	 * @override the changeRoom() method in the Character Class
	 */
	public boolean changeRoom(Room destination) {
		if (!(destination instanceof PortalRoom)) {
			if (getAdjacentRooms().contains(destination)) {
				setCurrentRoom(destination);
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks to see if the dragon can move to a specified room
	 * 
	 * @return return true if the dragon can move to a given room and false
	 *         otherwise
	 *         
	 * @override the canMoveTo() method in the Character Class
	 */
	public boolean canMoveTo(Room destination) {
		return (destination instanceof PortalRoom); // can't go into portal room
	}

	/**
	 * Randomly picks a room that the Dragon can move to
	 * 
	 * @return return the index of the randomly selected room the Dragon picks to
	 *         move to during its turn
	 */
	public Room pickRoom() {
		ArrayList<Room> adajentRooms = this.getAdjacentRooms();
		int randomIndex = randGen.nextInt(adajentRooms.size());
		return adajentRooms.get(randomIndex);
	}

	/**
	 * Returns the Dragon Warning Message
	 * 
	 * @return gets the Dragon Warning Message
	 */
	public static String getDragonWarning() {
		return DRAGON_WARNING;
	}

	/**
	 * Returns the Dragon Encounter Message
	 * 
	 * @return gets the Dragon Encounter Message
	 */
	public static String getDragonEncounter() {
		return DRAGON_ENCOUNTER;
	}
}