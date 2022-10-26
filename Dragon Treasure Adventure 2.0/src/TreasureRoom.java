import processing.core.PImage;
public class TreasureRoom extends Room {
    private static final String TREASURE_WARNING = "You sense that there is treasure nearby.\n";
    private static PImage treasureBackground; //the image ALWAYS used for treasure rooms
w
    /**
     * Constructs the TreasureRoom object
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
     * @param the background image for the TreasureRoom class
     */
    public static void setTreasureBackground(PImage treasureBackground) {
        TreasureRoom.treasureBackground = treasureBackground;
    }
}