
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
import processing.core.PImage;

/**
 * This class models a PortalRoom that extends the class Room. Portal Rooms can
 * be used by players to teleport to other rooms in the game
 */
public class PortalRoom extends Room {
	private Random randGen; // random number generator for location picking
	private static final String PORTAL_WARNING = "You feel a distortion in space nearby.\n";
	private static final String TELEPORT_MESSAGE = "The space distortion teleported you to another room!\n";
	private static PImage portalImage; // image of a portal to be shown in all portal rooms

	/**
	 * Constructs the PortalRoom object
	 * 
	 * @param ID          the ID of the room
	 * @param description the description of the room
	 * @param image       the image of the room
	 */
	public PortalRoom(int ID, String description, processing.core.PImage image) {
		super(ID, description, image);
		randGen = new Random();
	}

	/**
	 * Returns the warning message for portal rooms
	 * 
	 * @return the warning message for portal rooms
	 */
	public static String getPortalWarning() {
		return PORTAL_WARNING;
	}

	/**
	 * Returns the teleport message for portal rooms
	 * 
	 * @return the teleport message for portal rooms
	 */
	public static String getTeleportMessage() {
		return TELEPORT_MESSAGE;
	}

	/**
	 * Sets the teleport location and returns it
	 * 
	 * @return the portal location
	 */
	public Room getTeleportLocation() {
		ArrayList<Room> adajentRooms = this.getAdjacentRooms();
		int randomIndex = randGen.nextInt(adajentRooms.size());
		return adajentRooms.get(randomIndex);
	}

	/**
	 * Sets the image of the portal
	 * 
	 * @override the draw method in Room
	 */
	public void draw() {
		processing.image(portalImage, 325, 225);
	}

	/**
	 * Sets the PortalImage to the portal image from the images folder
	 * 
	 * @param portalImage is the PImage portal Image found in the images folder
	 */
	public static void setPortalImage(processing.core.PImage portalImage) {
		PortalRoom.portalImage = portalImage;
	}
}
