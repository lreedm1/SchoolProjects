
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
import processing.core.PImage;

/**
 * This class models the treasure room that the treasure is located in. This
 * class extends the Room class
 */
public class TreasureRoom extends Room {
	private static final String TREASURE_WARNING = "You sense that there is treasure nearby.\n";
	private static PImage treasureBackground; // the image ALWAYS used for treasure rooms

	/**
	 * Constructs the TreasureRoom object
	 * 
	 * @param ID the ID of the room
	 */
	public TreasureRoom(int ID) {
		super(ID, "In the back of this room, you spot a treasure chest.", treasureBackground);
	}

	/**
	 * @return the warning message for treasure rooms
	 */
	static String getTreasureWarning() {
		return TREASURE_WARNING;
	}

	/**
	 * Sets the image of the treasure room
	 * 
	 * @param treasureBackground the image of the treasure room
	 * @return true if the image was set, false otherwise
	 */
	public boolean playerCanGrabTreasure(Player p) {
		if (p.hasKey() && p.getCurrentRoom().equals(this)) {
			return true;
		}
		return false;
	}

	/**
	 * Sets the background image for the TreasureRoom class
	 * 
	 * @param the background image for the TreasureRoom class
	 */
	public static void setTreasureBackground(PImage treasureBackground) {
		TreasureRoom.treasureBackground = treasureBackground;
	}
}