
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class DragonTreasureGame extends PApplet {
	private ArrayList<Room>roomList;
	public static void main(String[] args) {
		PApplet.main("DragonTreasureGame");
	}

	@Override
	public void settings() {
		this.size(800,600);
	}
	@Override
	public void setup() {
		this.getSurface().setTitle("Dragon Treasure Adventure"); // sets the title of the window
		this.imageMode(PApplet.CORNER); //Images are drawn using the x,y-coordinate
		//as the top-left corner
		this.rectMode(PApplet.CORNERS); //When drawing rectangles interprets args
		//as top-left corner and bottom-right corner respectively
		this.focused = true; // window will be active upon running program
		this.textAlign(CENTER); // sets the text alignment to center
		this.textSize(20); //sets the font size for the text
		roomList = new ArrayList<Room>();
		Room.setProcessing(this);
		PImage img = this.loadImage("images/1.jpg");
		 Room r = new Room(1, "test room", img);
		 roomList.add(r);
	}
	
	public void draw() {
		roomList.get(0).draw();
	}
}
