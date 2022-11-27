//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    MusicPlayerTester.java
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
import java.util.Scanner;

/*
 * This class tests Song.java, SongNode.java, Playlist.java, and MusicPlayer300.java
 */
public class MusicPlayerTester{
    /*
    * Invokes the tester method that tests the functionality of each file
    *
    * @param args (unused)
    */
    public static void main(String[] args){
        runAllTests();
    }
    
    /*
     * Tests the functionality of Song.java's constructor and accessor methods
     * 
     * @return true if the constructor works as expected, false otherwise
     */
    public static boolean testSongConstructor(){
        // test the constructor with an invalid file
        try {
            new Song("someTitle", "someArtist", "someFilepath");
            // the constructor does not throw an exception
            System.out.println("Song constructor did not throw an IllegalArgumentException when passed an invalid file");
            return false;
        } catch (IllegalArgumentException e){
            // the constructor throws an exception as expected
        } catch(Exception e) {
            System.out.println("Song constructor returned |" + e + "| when it should have returned IllegalArgumentException");
            return false;
        }

        try{
            // test a valid file with toString, getTitle, and getArtist
            Song song = new Song("someTitle", "someArtist", "audio/1.mid");
            if (!(song.toString().equals( "\"" + song.getTitle() + "\" (0:6) by someArtist"))){
                System.out.println("Song.java's toString returned |" + song.toString() + "| when it should have returned" + 
                                   "|\"someTitle\" (0:6) by someArtist|");
                return false;
            }
            // test the getTitle method
            String title = song.getTitle();
            if (!title.equals("someTitle")){
                System.out.println("Song.getTitle() returned " + title + " when it should have returned someTitle");
                return false;
            }

            // test the getArtist method
            String artist = song.getArtist();
            if (!artist.equals("someArtist")){
                System.out.println("Song.getArtist() returned " + artist + " when it should have returned someArtist");
                return false;
            }

        } catch (Exception e){
            System.out.println("Song constructor threw the unexpected exception |" + e + "|");
            return false;
        }

     return true;   
    }

    /*
     * Tests the functionality of Song.java's playback methods
     * 
     * @return true if the playback methods work as expected, false otherwise
     */
    public static boolean testSongPlayback(){
        try {
            Song song = new Song("someTitle", "someArtist", "audio/1.mid");
            
            // test the play method
            song.play();
            Thread.sleep(1000);
            if (!song.isPlaying()){
                System.out.println("Song.play() did not start the song");
                return false;
            }

            // test the stop method
            song.stop();
            if(song.isPlaying()){
                System.out.println("Song.stop() did not stop the song");
                return false;
            }
            
        } catch (Exception e){
            System.out.println("Song.java threw the unexpected exception |" + e +
                              "| when testing .play() and .stop()");
            return false;
        }
        return true;
    }

    /*
     * Tests the functionality of SongNode.java's Single node constructor, linked node constructor,
     * get song accesser, get next accesser, and set next mutator
     * 
     * @return true if the constructor and accessors work as expected, false otherwise
     */
    public static Boolean testSongNode(){
        try{

            // test the single node constructorand getSong method
            Song song = new Song("someTitle", "someArtist", "audio/1.mid");
            SongNode node = new SongNode(song);

            if(!node.getSong().equals(song)){
                System.out.println("SongNode.getSong() returned " + node.getSong() + 
                " when it should have returned " + song + "either the single node constructor" + 
                "or the getSong method is broken");
                return false;
            }

            // test the linked node constructor and getNext method
            Song song2 = new Song("someTitle2", "someArtist2", "audio/2.mid");
            SongNode node2 = new SongNode(song2, node);

            if(!node2.getSong().equals(song2)){
                System.out.println("SongNode.getSong() returned " + node2.getSong() + 
                " when it should have returned " + song2 + "the linked node constructor is broken");
                return false;
            }

            if(!node2.getNext().equals(node)){
                System.out.println("SongNode.getNext() returned " + node2.getNext() + 
                " when it should have returned " + node + "the linked node constructor is broken");
                return false;
            }

            // test the setNext method
            Song song3 = new Song("someTitle3", "someArtist3", "audio/3.mid");
            SongNode node3 = new SongNode(song3);
            node2.setNext(node3);

            if(!node2.getNext().equals(node3)){
                System.out.println("SongNode.setNext() did not set the next node to " + node3 + 
                " when it should have returned " + node3 + "the setNext method is broken");
                return false;
            }

        // catch any unexpected exceptions
        } catch (Exception e){
            System.out.println("SongNode.java threw the unexpected exception |" + e + "|");
            return false;
       }
        return true;
    }

    /*
     * Tests the functionality of Playlist.java's constructor, isEmpty accessor, peek accessor,
     * size accessor, toString accessor, and enqueue mutator
     * 
     * @return true if the constructor and accessors work as expected, false otherwise
     */
    public static Boolean testEnqueue(){
        try{
            // test the constructor and isEmpty method
            Playlist playlist = new Playlist();

            if(!playlist.isEmpty()){
                System.out.println("Playlist.isEmpty() returned false when it should have returned true" + 
                "the constructor is broken or the isEmpty accesor is broken");
                return false;
            }

            // test the peek accessor with an empty playlist
            if(playlist.peek() != null){
                System.out.println("Playlist.peek() returned |" + playlist.peek() + 
                "| when it should have returned |null|the peek accessor is broken");
                return false;
            }
            

            // test the size accessor with an empty playlist
            if(playlist.size() != 0){
                System.out.println("Playlist.size() returned |" + playlist.size() + 
                "| when it should have returned 0 the size accessor is broken");
                return false;
            }

            // test the enqueue mutator and peek accessor with a single node playlist
            Song song = new Song("someTitle", "someArtist", "audio/1.mid");
            playlist.enqueue(song);

            if(playlist.peek() != song){
                System.out.println("Playlist.peek() returned |" + playlist.peek() + 
                "| when it should have returned |" + song + "| the enqueue modifier or the peek accessor is broken");
                return false;
            }

            // test the size accessor with a single node playlist
            if(playlist.size() != 1){
                System.out.println("Playlist.size() returned " + playlist.size() + 
                " when it should have returned 1 the size accessor is broken");
                return false;
            }

            // test the toString accessor with a double node playlist
            Song song2 = new Song("someTitle2", "someArtist2", "audio/2.mid");
            playlist.enqueue(song2);
            
            if(!playlist.toString().equals("\"" + song.getTitle() + "\" (0:6) by " + song.getArtist() + "\n\"" +
                                           song2.getTitle() + "\" (0:6) by " + song2.getArtist() + "\n")){
                System.out.println("Playlist.toString() returned |" + playlist.toString() + 
                "| when it should have returned |\"someTitle\" (0:6) by someArtist\n\"someTitle2\" (0:6) by someArtist2|" + 
                "the enqueue modifier or the toString accessor is broken");
                return false;
            }


        }catch(Exception e){
            System.out.println("Playlist.java threw the unexpected exception |" + e + "| when testing all methods except dequeue");
        }
        return true;
    }

    /*
     * Tests the functionality of Playlist.java's dequeue mutator
     * 
     * @return true if the dequeue mutator works as expected, false otherwise
     */
    public static Boolean testDeque(){
        try{
            // test the dequeue mutator with a single node playlist
            Playlist playlist = new Playlist();
            Song song = new Song("someTitle", "someArtist", "audio/1.mid");
            playlist.enqueue(song);

            if(playlist.dequeue() != song){
                System.out.println("Playlist.dequeue() returned |" + playlist.dequeue() + 
                "| when it should have returned |" + song + "| the dequeue modifier is broken for a single node playlist with no previous dequeues");
                return false;
            }

            if(playlist.dequeue() != null){
                System.out.println("Playlist.dequeue() returned |" + playlist.dequeue() + 
                "| when it should have returned |null| the dequeue modifier is broken for a single node playlist with a previous dequeue");
                return false;
            }

            // test the dequeue mutator with a double node playlist
            Song song2 = new Song("someTitle2", "someArtist2", "audio/2.mid");
            playlist.enqueue(song);
            playlist.enqueue(song2);

            if(playlist.dequeue() != song){
                System.out.println("Playlist.dequeue() returned |" + playlist.dequeue() + 
                "| when it should have returned |" + song + "| the dequeue modifier is broken for a double node playlist");
                return false;
            }

            if(playlist.dequeue() != song2){
                System.out.println("Playlist.dequeue() returned |" + playlist.dequeue() + 
                "| when it should have returned |" + song2 + "| the dequeue modifier is broken for a double node playlist after having dequeued once");
                return false;
            }

        }catch(Exception e){
            System.out.println("Playlist.java threw the unexpected exception |" + e + "| when testing dequeue");
        }
        return true;
    }

    /* 
     * Prints the test result to the console
     * 
     * @param testName the name of the test
     * @param passed true if the test passed, false otherwise
     */
    public static void evalTestResult(Boolean result, String testName){
        if (result){
            System.out.println("PASSED     " + testName);
        } else {
            System.out.println("FAILED     " + testName + " (See above for details)\n");
        }
    }

    /*
     * Runs all tests
     */
    public static void runAllTests(){
        System.out.println("\n-----------------Running Tests-----------------\n");
        evalTestResult(testSongConstructor(), "Song.java Constructor");
        evalTestResult(testSongPlayback(), "Song.java Playback");
        evalTestResult(testSongNode(), "SongNode.java");
        evalTestResult(testEnqueue(), "Playlist.java enquee method");
        evalTestResult(testDeque(), "Playlist.java deque method");
        System.out.println("\n-----------------End of Tests-----------------\n");
    }
    
}
