import processing.core.PImage;

public class TreasureRoom extends Room {
    private static final String TREASURE_WARNING = "You sense that there is treasure nearby.\n";
    private static PImage treasureBackground; //the image ALWAYS used for treasure rooms

    public TreasureRoom(int ID) {
        super(ID, "In the back of this room, you spot a treasure chest.", treasureBackground);
    }

}