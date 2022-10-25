import java.util.ArrayList;

public class Player extends Character implements Moveable{
    private boolean hasKey = false;

    /**
     * Constructs the Player object
     * @param currentRoom the room the player is currently in
     */
    public Player(Room currentRoom) {
        super(currentRoom, "Player");
    }

    /**
     * Checks if the player can move to the given destination
     * @param destination the room the player is trying to move to
     * @return true if the player can move to the destination, false otherwise
     */
    public boolean canMoveTo(Room destination) {
        if (destination instanceof PortalRoom) {
            return false;
        }
        return true;
    }

    /**
     * Changes the room where the player is
     * @param destination the room the player is moving to
     * @return true if the change is successful (a valid move), and false otherwise
     */
    public boolean changeRoom(Room destination) {
        if (canMoveTo(destination)) {
            this.setCurrentRoom(destination);
            return true;
        }
        return false;
    }

    /**
     * If the player has the key, they can grab the treasure
     * @return true if the player has the key, false otherwise
     */
    public boolean hasKey() {
        return hasKey;
    }

    /**
     * Determines whether or not the given dragon is nearby
     * by getting the adjacent rooms of the dragon and checking
     * if the player is in one of them
     * @param dragon the dragon to check
     * @return true if the dragon is nearby, false otherwise
     */
    public boolean isDragonNearby(Dragon dragon) {
        if (dragon.getAdjacentRooms().contains(this.getCurrentRoom())) {
            return true;
        }
        return false;
    }

    /**
     * Determines whether or not the given treasure room is nearby
     * @return true if the treasure room is nearby, false otherwise
     */
    public boolean isTreasureNearby() {
        if (this.getCurrentRoom() instanceof TreasureRoom) {
            return true;
        }
        return false;
    }

    /**
     * Determines whether or not a portal room is nearby
     * @return true if a portal room is nearby, false otherwise
     */
    public boolean isPortalNearby() {
        if (this.getCurrentRoom() instanceof PortalRoom) {
            return true;
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
     * Checks if the player needs to teleport
     * and moves them if needed
     */
    public void teleport() {
        if (this.getCurrentRoom() instanceof PortalRoom) {
            PortalRoom portalRoom = (PortalRoom) this.getCurrentRoom();
            this.setCurrentRoom(portalRoom.getTeleportLocation());
        }
    }
}
