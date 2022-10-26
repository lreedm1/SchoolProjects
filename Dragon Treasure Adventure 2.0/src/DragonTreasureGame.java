
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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class models the Dragon Treasure Game and extends the PApplet class
 * provided to us in the java docs. In addition, it creates a user interactive
 * 800 by 600 pixel screen
 */
public class DragonTreasureGame extends PApplet {
	private ArrayList<Character> characters; // List of the characters being added to the game
	private File roomInfo; // information about the types of rooms
	private File mapInfo; // information about how many rooms are there and which ones are adjacent to
							// each other
	private boolean isDragonTurn = false; // boolean indicating when its the dragon's turn
	private int gameState = 0; // gameState (0 means the game is continuing, 1, means the player won, and 2
								// means the player lost)
	private ArrayList<Room> roomList; // List of the rooms the characters can move betweeen

	/**
	 * Generates the game using the PApplet Library
	 * 
	 * @param args executes the game
	 */
	public static void main(String[] args) {
		PApplet.main("DragonTreasureGame");
	}

	/**
	 * Get the room objected associated with the given ID.
	 * 
	 * @param id the ID of the room to retrieve
	 * @return the Room that corresponds to that id
	 * @author Michelle
	 */
	private Room getRoomByID(int id) {
		int indexToEdit = roomList.indexOf(new Room(id, "dummy", null));
		Room toEdit = roomList.get(indexToEdit);
		return toEdit;
	}

	/**
	 * Loads in room info using the file stored in roomInfo
	 * 
	 * @author Michelle
	 */
	private void loadRoomInfo() {
		System.out.println("Loading rooms...");
		Scanner fileReader = null;
		try {

			// scanner to read from file
			fileReader = new Scanner(roomInfo);

			// read line by line until none left
			while (fileReader.hasNext()) {
				String nextLine = fileReader.nextLine();

				// parse info and create new room
				String[] parts = nextLine.split(" \\| ");
				int ID = Integer.parseInt(parts[1].trim()); // get the room id
				String imageName = null;
				String description = null;
				PImage image = null;
				Room newRoom = null;

				if (parts.length >= 3) {
					imageName = parts[2].trim();
					image = this.loadImage("images" + File.separator + imageName);

				}

				if (parts.length == 4) {
					description = parts[3].trim(); // get the room description
				}

				switch (parts[0].trim()) {
				case "S":
					newRoom = new StartRoom(ID, image);
					break;
				case "R":
					newRoom = new Room(ID, description, image);
					break;
				case "P":
					newRoom = new PortalRoom(ID, description, image);
					break;
				case "T":
					newRoom = new TreasureRoom(ID);
					break;
				default:
					break;
				}

				if (newRoom != null) {
					roomList.add(newRoom);
				}
			}
		} catch (IOException e) { // handle checked exception
			e.printStackTrace();
		} finally {
			if (fileReader != null)
				fileReader.close(); // close scanner regardless of what happened for security reasons :)
		}
	}

	/**
	 * Loads in room connections using the file stored in mapInfo
	 * 
	 * @author Michelle
	 */
	private void loadMap() {
		System.out.println("Loading map...");
		Scanner fileReader = null;
		try {
			// scanner to read from file
			fileReader = new Scanner(mapInfo);

			// read line by line until none left
			while (fileReader.hasNext()) {

				// parse info
				String nextLine = fileReader.nextLine();
				String parts[] = nextLine.split(" ");
				int id = Integer.parseInt(parts[0]);

				Room toEdit = getRoomByID(id); // get the room we need to update info for adjacent rooms

				// add all the rooms to the adj room list of toEdit
				for (int i = 1; i < parts.length; i++) {
					Room toAdjAdd = getRoomByID(Integer.parseInt(parts[i]));
					toEdit.addToAdjacentRooms(toAdjAdd);
				}
			}
		} catch (IOException e) { // handle checked exception
			e.printStackTrace();
		} finally { // close scanner regardless of what happened for security reasons :)
			if (fileReader != null)
				fileReader.close();
		}
	}

	/**
	 * Get the room objected associated with the given ID.
	 * 
	 * @param id the ID of the room to retrieve
	 * @return the Room that corresponds to that id
	 * @author Michelle
	 */
	private void loadCharacters() {
		System.out.println("Adding characters...");
		characters.add(new Character(getRoomByID(5), "KEYHOLDER"));
		characters.add(new Player(getRoomByID(1)));
		characters.add(new Dragon(getRoomByID(9)));
	}

	/**
	 * sets the screen size to 800 pixels by 600 pixels
	 * 
	 * @override settings() in PApplet
	 */
	public void settings() {
		this.size(800, 600);
	}

	/**
	 * sets up the screen, initializes arraylists, and loads information using the
	 * text files as well as the loadCharacters method
	 * 
	 * @override setup() in PApplet
	 */
	public void setup() {
		this.getSurface().setTitle("Dragon Treasure Adventure"); // sets the title of the window
		this.imageMode(PApplet.CORNER); // Images are drawn using the x,y-coordinate as the top-left corner
		this.rectMode(PApplet.CORNERS); // When drawing rectangles interprets args as top-left corner and bottom-right
										// corner respectively
		this.focused = true; // window will be active upon running program
		this.textAlign(CENTER); // sets the text alignment to center
		this.textSize(20); // sets the font size for the text
		roomInfo = new File("roominfo.txt");
		mapInfo = new File("map.txt");
		roomList = new ArrayList<Room>();
		characters = new ArrayList<>();
		PImage treasureBackground = loadImage("images/treasure.jpg"); //HAVE TO ADD SRC/ FOR TESTING PURPOSES
		TreasureRoom.setTreasureBackground(treasureBackground);
		PImage portalImage = loadImage("images/portal.png"); // HAVE TO ADD SRC/ FOR TESTING PURPOSES
		PortalRoom.setPortalImage(portalImage);
		Room.setProcessing(this);
		loadRoomInfo();
		loadMap();
		loadCharacters();
	}

	/**
	 * When keypressed is true, a player can switch between rooms given that the key
	 * being pressed is a valid entry, if not the program redirects him/her to try a
	 * different key. Only numbers from 1-9 are accepted for the purposes of this
	 * program
	 * 
	 * @override keyPressed() in PApplet
	 */
	public void keyPressed() {
		Player player = null;
		for (Character character : characters) {
			if (character instanceof Player) {
				player = (Player) character;
			}
		}
		int roomID = (int) key - 48;
		System.out.println(roomID);
		if (gameState != 0) {
			System.out.println("Game is not in progress, game state is: " + gameState);
			return;
		}
		try {
			Room newRoom = getRoomByID(roomID);
			if (player.changeRoom(newRoom) && gameState == 0) {
				isDragonTurn = true;
				return;
			}
		} catch (IndexOutOfBoundsException e) {
		}
		System.out.println("Please pick a valid room");
	}

	/**
	 * Draws the game
	 * 
	 * @override draw() in PApplet
	 */
	public void draw() {
		// identify the player, dragon, and keyholder
		Player player = null;
		Dragon dragon = null;
		Character keyHolder = null;
		for (Character character : characters) {
			if (character instanceof Player) {
				player = (Player) character;
			}
			if (character instanceof Dragon) {
				dragon = (Dragon) character;
			}
			if (character.getLabel().equals("KEYHOLDER")) {
				keyHolder = character;
			}
		}
		// identify the portal room
		PortalRoom portalRoom = null;
		for (Room room : roomList) {
			if (room instanceof PortalRoom) {
				portalRoom = (PortalRoom) room;
			}
		}

		// draw the room
		player.getCurrentRoom().draw();
		// print the dragon warning message if the dragon is nearby
		if (player.isDragonNearby(dragon)) {
			System.out.println(Dragon.getDragonWarning());
		}
		// print the treasure warning message if the player is near the treasure room
		if (player.isTreasureNearby()) {
			System.out.println(TreasureRoom.getTreasureWarning());
		}
		// print the portal warning message if the player is near the portal room
		// and display the portal image
		if (player.isPortalNearby()) {
			portalRoom.draw();
			System.out.println(PortalRoom.getPortalWarning());

		}

		/**
		 * check if the player can grab the key, if they can let them get it they can
		 * obtain the key if they are in the same room as the keyholder If they obtain
		 * the key, print "KEY OBTAINED" to the console
		 */
		if (player.getCurrentRoom().equals(keyHolder.getCurrentRoom())) {
			player.obtainKey();
			System.out.println("KEY OBTAINED");
		}

		/**
		 * Check if the player needs to teleport because they are in a room with a
		 * portal If they do teleport successfully, print the message to the console.
		 */
		player.teleport();

		// Check if it's the dragon's turn to move, move the dragon if isDragonTurn is
		// true
		if (isDragonTurn) {
			Room newRoom = dragon.pickRoom();
			dragon.changeRoom(newRoom);
			isDragonTurn = false;
		}
		/**
		 * Update the gameState datafield to reflect the current game state If the
		 * player is in the treasure room, the game is won and gameState = 1 If the
		 * player is in the same room as the dragon, the game is lost and gameState = 2
		 */
		if (player.getCurrentRoom().equals(dragon.getCurrentRoom())) {
			gameState = 2;
			fill(255, 0, 0);
			rect(0, 0, 800, 600);
			fill(0);
			text("You Lost!", 400, 300);
		} else if (player.getCurrentRoom() instanceof TreasureRoom) {
			gameState = 1;
			fill(0, 255, 0);
			rect(0, 0, 800, 600);
			fill(0);
			text("You Won!", 400, 300);
		} else {
			gameState = 0;
		}
	}
}
