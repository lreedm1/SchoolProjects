import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class Room {
	private String description; // verbal description of the room
	private ArrayList<Room> adjRooms; // list of all rooms directly connect
	private final int ID; // a "unique" identifier for each room
	protected static PApplet processing; // PApplet object which the rooms will use to draw stuff to the GUI
	private PImage image; // stores the image that corresponds to the background of a room

	public Room(int ID, String description, processing.core.PImage image) {
		adjRooms = new ArrayList<Room>();
		this.ID = ID;
		this.description = description;
		this.image = image;

	}

	public int getID() {
		return this.ID;
	}

	public String getDescription() {
		return this.description;
	}

	public ArrayList<Room> getAdjacentRooms() {
		return this.adjRooms;
	}

	public static void setProcessing(processing.core.PApplet processing) {
		Room.processing = processing;
	}

	public void addToAdjacentRooms(Room toAdd) {
		this.adjRooms.add(toAdd);
	}

	public boolean isAdjacent(Room r) {
		return adjRooms.contains(r);
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Room) {
			Room otherItem = (Room) other;
			if (otherItem.getID() == (this.ID)) {
				return true;
			}
		}
		return false;
	}

	@Override
	// Returns a string in the form of "<ID>: <description>\n Adjacent Rooms: <r1's ID> <r2's ID>" list of adjacent room IDs continues for all rooms adjacent to this Room.
	public String toString() {
		String result = this.ID + ": " + this.description + "\n" + "Adjacent Rooms: ";
		for (Room r : adjRooms) {
			result += r.getID() + " ";
		}
		return result;
	}

	public void draw() {
		processing.image(image, 0,0);
		processing.fill(-7028);
		processing.rect(0, 500, 800, 600);
		processing.fill(0);
		processing.text(this.toString(), 300, 525);
		
	}

}