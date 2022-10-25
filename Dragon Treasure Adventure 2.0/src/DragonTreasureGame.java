import java.io.File;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class DragonTreasureGame extends PApplet {
	private ArrayList<Character> characters;
	private File roomInfo;
	private File mapInfo;
	private boolean isDragonTurn = false;
	private int gameState= 0;
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
		this.imageMode(PApplet.CORNER); //Images are drawn using the x,y-coordinate as the top-left corner
		this.rectMode(PApplet.CORNERS); //When drawing rectangles interprets args as top-left corner and bottom-right corner respectively
		this.focused = true; // window will be active upon running program
		this.textAlign(CENTER); // sets the text alignment to center
		this.textSize(20); //sets the font size for the text
		roomInfo = new File("roominfo.txt");
		mapInfo = new File("map.txt");
		roomList = new ArrayList<Room>();
		characters= new ArrayList<Character>();
		Room.setProcessing(this);
		Room.loadCharacters();
	}
	private void loadCharacters() {
		System.out.println("Adding characters...");
		characters.add(new Character(getRoomByID(5),"KEYHOLDER"));
		characters.add(new Player(getRoomByID(1)));
		characters.add(new Dragon(getRoomByID(9)));
		}
	@Override
	public void keyPressed(){

	}
	public void draw() {
		roomList.get(0).draw();
		roomList.get(1).draw();
	}

}


// TODOS
//  	DragonTreasureGame 
// DONE	Room - Aarav
// DONE	TreasureRoom - Reed 
// DONE Character - Reed
// DONE	Dragon - Aarav
// DONE	Player - Reed
// DONE PortalRoom - Reed
// DONE	StartRoom - Aarav