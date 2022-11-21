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
            System.out.println("Song constructor returned " + e + " when it should have returned IllegalArgumentException");
            return false;
        }

        try{
            // test a valid file with toString, getTitle, and getArtist
            Song song = new Song("someTitle", "someArtist", "audio/1.mid");
            if (!(song.toString() == "\"someTitle\" (0:6) by someArtist)")){
                System.out.println("Song.java's toString returned |" + song.toString() + "| when it should have returned |\"someTitle\" (0:6) by someArtist|");
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
            System.out.println("Song constructor threw the unexpected exception " + e );
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

            // test the pause method
            song.pause();
            if(song.isPlaying()){
                System.out.println("Song.pause() did not pause the song");
                return false;
            }
            
        } catch (Exception e){
            System.out.println("Song.java threw the unexpected exception " + e +
                              " when testing .play() and .pause()");
            return false;
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

        System.out.println("\n-----------------End of Tests-----------------\n");
    }
    
}
