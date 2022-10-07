import java.util.Random;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Dragon Treasure Adventure
// Course:   CS 300 Fall 2022
//
// Author:   Reed Lokken
// Email:    rlokken@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NONE   
// Partner Email: NONE  
// Partner Lecturer's Name: NONE 
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE        
// Online Sources: NONE
///////////////////////////////////////////////////////////////////////////////

/**
 * Tests the following methods and classes:
 * DragonTreasureGame.java
 * Instance methods:
 * - addToAdjacentRooms(Room toAdd) -> void
 * - getAdjacentRooms() -> ArrayList<Room>
 * - getID() -> int
 * - getRoomDescription() -> String
 * - getType() -> RoomType
 * - isAdjacent(Room r) -> boolean
 * - setRoomType(RoomType newType) -> void
 * 
 * Static methods:
 * - assignTeleportLocation(int teleportID) -> void
 * - getPortalWarning() -> String
 * - getTeleportationRoom() -> int
 * - getTreasureWarning() -> String
 * 
 * Each room has a unique id, a description, and a type
 * 
 * @author reedLokken
 */
public class DragonTreasureTester {
    /*
     * Tests all 8 static methods within DragonTreasureGame.java
     * 
     * @return true if all tests pass, false otherwise
     */
    public static boolean testRoomInstanceMethods() {
        try {
            int rooms = 10;
            // create a list of IDs to test with
            Random rand = new Random();
            int[] ids = new int[rooms];
            for (int index = 0; index < ids.length; index++) {
                ids[index] = rand.nextInt(0, 1000000);
            }
            // create a list of descriptions to test with
            String[] descriptions = new String[rooms];
            for (int index = 0; index < descriptions.length; index++) {
                descriptions[index] = "This is room " + index;
            }
    
            // create a cave using the list of IDs and descriptions
            Room cave[] = new Room[rooms];
            for (int index = 0; index < cave.length; index++) {
                cave[index] = new Room(ids[index], descriptions[index]);
            }

            // test getID()
            for (int index = 0; index < cave.length; index++) {
                if (cave[index].getID() != ids[index]) {
                    System.out.println("getID() returned " + cave[index].getID() + " but expected " + ids[index]);
                    return false;
                }
            }

            // test getRoomDescription()
            for (int Index = 0; Index < cave.length; Index++) {
                if (!cave[Index].getRoomDescription().equals(descriptions[Index])) {
                    System.out.println("getRoomDescription() returned " + cave[Index].getRoomDescription()
                            + " but expected " + descriptions[Index]);
                    return false;
                }
            }

            // test setRoomType() and getType()
            for (int index = 0; index < cave.length; index++) {
                cave[index].setRoomType(RoomType.START);
                if (cave[index].getType() != RoomType.START) {
                    System.out
                            .println("getType() returned " + cave[index].getType() + " but expected " + RoomType.START);
                    return false;
                }
            }

            // test addToAdjacentRooms(), getAdjacentRooms(), and isAdjacent()
            for (int index = 0; index < cave.length; index++) {
                for (int index2 = 0; index2 < cave.length; index2++) {
                    if (index != index2) {
                        cave[index].addToAdjacentRooms(cave[index2]);
                    }
                }
            }

            for (int index = 0; index < cave.length; index++) {
                for (int index2 = 0; index2 < cave.length; index2++) {
                    if (index != index2) {
                        if (!cave[index].getAdjacentRooms().contains(cave[index2])) {
                            System.out.println(
                                    "getAdjacentRooms() did not return " + cave[index2] + " but expected it to");
                            return false;
                        }
                        if (!cave[index].isAdjacent(cave[index2])) {
                            System.out.println("isAdjacent() returned false but expected true");
                            return false;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception thrown in testRoomInstanceMethods()");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /*
     * Tests all 4 static methods within DragonTreasureGame.java
     * 
     * @return true if all tests pass, false otherwise
     */
    public static boolean testRoomStaticMethods() {
        try {
            
            // test assignTeleportLocation() and getTeleportationRoom()
            int teleportID = 5;
            Room.assignTeleportLocation(teleportID);
            if (Room.getTeleportationRoom() != teleportID) {
                System.out.println("getTeleportationRoom() returned " + Room.getTeleportationRoom() + " but expected " + teleportID);
                return false;
            }

            // test getPortalWarning()
            String portalWarning = "You feel a distortion in space nearby.\n";
            if (!Room.getPortalWarning().equals(portalWarning)) {
                System.out.println("getPortalWarning() returned " + Room.getPortalWarning() + " but expected " + portalWarning);
                return false;
            }

            // test getTreasureWarning()
            String treasureWarning = "You sense that there is treasure nearby.\n";
            if (!Room.getTreasureWarning().equals(treasureWarning)) {
                System.out.println("getTreasureWarning() returned " + Room.getTreasureWarning() + " but expected " + treasureWarning);
                return false;
            }

        } catch (Exception e) {
            System.out.println("Exception thrown in testRoomStaticMethods()");
            e.printStackTrace();
            return false;
        }
        return true;

    }
}
