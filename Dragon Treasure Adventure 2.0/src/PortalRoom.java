import java.util.ArrayList;
import java.util.Random;
import processing.core.PImage;

public class PortalRoom extends Room {
	private Random randGen; //random number generator for location picking
	private static final String PORTAL_WARNING = "You feel a distortion in space nearby.\n";
	private static final String TELEPORT_MESSAGE = "The space distortion teleported you to another room!\n";
	private static PImage portalImage; //image of a portal to be shown in all portal rooms
	
	/**
	 * Constructs the PortalRoom object
	 * @param ID the ID of the room
	 * @param description the description of the room
	 * @param image the image of the room
	 */
	public PortalRoom(int ID, String description, processing.core.PImage image) {
		super(ID, description, image);
        randGen=new Random();
	}
	
	/**
	 * Returns the warning message for portal rooms
	 * @return the warning message for portal rooms
	 */
	public static String getPortalWarning() {
		return PORTAL_WARNING;
	}
	
	/**
	 * Returns the teleport message for portal rooms
	 * @return the teleport message for portal rooms
	 */
	public static String getTeleportMessage() {
		return TELEPORT_MESSAGE;
	}
	
	/**
	 * Sets the teleport location and returns it
	 * @return the portal location
	 */
	public Room getTeleportLocation() {
		ArrayList<Room> adajentRooms = this.getAdjacentRooms();
		int randomIndex = randGen.nextInt(adajentRooms.size());
		return adajentRooms.get(randomIndex);
	}
	
	/**
	 * Sets the image of the portal
	 */
	public void draw() {
		super.draw();
		processing.image(portalImage, 325,225);
	}
	
	public static void setPortalImage(processing.core.PImage portalImage) {
		PortalRoom.portalImage=portalImage;
	}
}
