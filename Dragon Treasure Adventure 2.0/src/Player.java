
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
 * This class models a Player Character which extends the class Character and
 * implements the interface Moveable
 */
public class Player extends Character implements Moveable {
	private boolean hasKey = false;

	/**
	 * Constructs the Player object
	 * 
	 * @param currentRoom the room the player is currently in
	 */
	public Player(Room currentRoom) {
		super(currentRoom, "PLAYER");
	}

	/**
	 * Checks if the player can move to the given destination
	 * 
	 * @param destination the room the player is trying to move to
	 * @return true if the player can move to the destination, false otherwise
	 * 
	 * @override the canMoveTo() method in the Character class
	 */
	public boolean canMoveTo(Room destination) {
		if (this.getCurrentRoom().equals(destination) || !this.getAdjacentRooms().contains(destination)
				|| (destination instanceof TreasureRoom && !this.hasKey())) {
			return false;
		}
		return true;
	}

	/**
	 * Changes the room where the player is
	 * 
	 * @param destination the room the player is moving to
	 * @return true if the change is successful (a valid move), and false otherwise
	 * 
	 * @override the changeRoom() method in the Character class
	 */
	public boolean changeRoom(Room destination) {
		if (canMoveTo(destination)) {
			if (destination instanceof PortalRoom) {
				// destination = ((PortalRoom) destination).getTeleportLocation();
				teleport();
			}
			this.setCurrentRoom(destination);
			return true;
		}
		return false;
	}

	/**
	 * If the player has the key, they can grab the treasure
	 * 
	 * @return true if the player has the key, false otherwise
	 */
	public boolean hasKey() {
		return hasKey;
	}

	/**
	 * Determines whether or not the given dragon is nearby by getting the adjacent
	 * rooms of the dragon and checking if the player is in one of them
	 * 
	 * @param dragon the dragon to check
	 * @return true if the dragon is nearby, false otherwise
	 */
	public boolean isDragonNearby(Dragon dragon) {
		ArrayList<Room> adjacentRooms = dragon.getAdjacentRooms();
		return adjacentRooms.contains(this.getCurrentRoom());
	}

	/**
	 * Determines whether or not the given treasure room is nearby
	 * 
	 * @return true if the treasure room is nearby, false otherwise
	 */
	public boolean isTreasureNearby() {
		for (Room room : this.getAdjacentRooms()) {
			if (room instanceof TreasureRoom) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Determines whether or not a portal room is nearby
	 * 
	 * @return true if a portal room is nearby, false otherwise
	 */
	public boolean isPortalNearby() {
		for (Room room : this.getAdjacentRooms()) {
			if (room instanceof PortalRoom) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gives the player the key
	 */
	public void obtainKey() {
		hasKey = true;
	}

	/**
	 * Checks if the player needs to teleport and moves them if needed
	 */
	public void teleport() {
		if (this.getCurrentRoom() instanceof PortalRoom) {
			PortalRoom portalRoom = (PortalRoom) this.getCurrentRoom();
			this.setCurrentRoom(portalRoom.getTeleportLocation());
			System.out.println(PortalRoom.getTeleportMessage());
		}
	}
}
