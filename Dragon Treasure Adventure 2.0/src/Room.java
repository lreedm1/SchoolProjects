
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
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class models an unspecified room type that can be used as a base class
 * for all room types
 */
public class Room {
	private String description; // verbal description of the room
	private ArrayList<Room> adjRooms; // list of all rooms directly connect
	private final int ID; // a "unique" identifier for each room
	protected static PApplet processing; // PApplet object which the rooms will use to draw stuff to the GUI
	private PImage image; // stores the image that corresponds to the background of a room

	/**
	 * Constructs a Room Object
	 * 
	 * @param ID          id of the room
	 * @param description description of the room
	 * @param image       image that is being loaded into the room
	 */
	public Room(int ID, String description, processing.core.PImage image) {
		adjRooms = new ArrayList<Room>();
		this.ID = ID;
		this.description = description;
		this.image = image;

	}

	/**
	 * returns the ID of the room
	 * 
	 * @return gets the ID of the room
	 * 
	 */
	public int getID() {
		return this.ID;
	}

	/**
	 * returns the description of the room
	 * 
	 * @return gets the description of the room
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * returns the adjacents rooms from the ArrayList getAdjacentRooms
	 * 
	 * @return gets the adjacents rooms from the ArrayList getAdjacentRooms
	 */
	public ArrayList<Room> getAdjacentRooms() {
		return this.adjRooms;
	}

	/**
	 * sets the processing for the class
	 * 
	 * @param processing the processing type that is passed from PApplet
	 */
	public static void setProcessing(processing.core.PApplet processing) {
		Room.processing = processing;
	}

	/**
	 * Adds a room to the list of adjacent rooms
	 * 
	 * @param toAdd adds the specified room to the list of adjacent rooms
	 */
	public void addToAdjacentRooms(Room toAdd) {
		this.adjRooms.add(toAdd);
	}

	/**
	 * Checks to see if a room is adjacent to a specified room
	 * 
	 * @param r the room being check to see if it is adjacent
	 * @return true if the room is adjacent adn false otherwise
	 */
	public boolean isAdjacent(Room r) {
		return adjRooms.contains(r);
	}

	/**
	 * checks to see if an instance of room is equal to another room given the same
	 * ID
	 * 
	 * @override the equals() method of the default Object Class
	 */
	public boolean equals(Object other) {
		if (other instanceof Room) {
			Room otherItem = (Room) other;
			if (otherItem.getID() == (this.ID)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns a string in the form of "<ID>: <description>\n Adjacent Rooms: <r1's
	 * ID> <r2's ID>" list of adjacent room IDs continues for all rooms adjacent to
	 * this Room
	 * 
	 * @override the toString() method of the default Object Class
	 */
	public String toString() {
		String result = this.ID + ": " + this.description + "\n" + "Adjacent Rooms: ";
		for (Room r : adjRooms) {
			result += r.getID() + " ";
		}
		return result;
	}

	/**
	 * draws the rooms in the Dragon Treasure Game
	 */
	public void draw() {
		processing.image(image, 0, 0);
		processing.fill(-7028);
		processing.rect(0, 500, 800, 600);
		processing.fill(0);
		processing.text(this.toString(), 300, 525);

	}

}