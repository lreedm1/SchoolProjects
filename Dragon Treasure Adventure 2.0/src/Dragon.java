import java.util.ArrayList;
import java.util.Random;

public class Dragon extends Character implements Moveable{
    private Random randGen; //random num generator used for moving
    private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n";
    private static final String DRAGON_ENCOUNTER = "Oh no! You ran into the fire breathing dragon!\n";
    
    
    public Dragon(Room currentRoom) throws IllegalArgumentException{
        super(currentRoom, "DRAGON");
        randGen= new Random();
        if(!(currentRoom instanceof TreasureRoom)){
            throw new IllegalArgumentException("currentRoom is not a TreasureRoom");
        }
    }
    @Override
    public boolean changeRoom(Room destination){
        if(!(destination instanceof PortalRoom)){
            if(getAdjacentRooms().contains(destination)){
                setCurrentRoom(destination);
                return true;
            }
        }
        return false;
    }
    
    public boolean canMoveTo(Room destination){
         return(destination instanceof PortalRoom); //can't go into portal room
    }
    public Room pickRoom(){
        ArrayList<Room> adajentRooms = this.getAdjacentRooms();
		int randomIndex = randGen.nextInt(adajentRooms.size());
		return adajentRooms.get(randomIndex);
    }

    public static String getDragonWarning(){
        return DRAGON_WARNING;
    }

    public static String getDragonEncounter(){
        return DRAGON_ENCOUNTER;
    }
}