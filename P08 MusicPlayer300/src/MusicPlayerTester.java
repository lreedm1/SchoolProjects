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
public class MusicPlayerTester {
    /*
    * Invokes the tester method that tests the functionality of each file
    *
    * @param args (unused)
    */
    public static void main(String[] args){
        runAllTests();
    }
    
    /*
     * Tests the functionality of Song.java's constructor
     * 
     * @return true if the constructor works as expected, false otherwise
     */
    public static boolean testSongConstructor() {
        // test the constructor with an invalid file
        try {
            Song song = new Song("someTitle", "someArtist", "someFilepath");
            // the constructor does not throw an exception
            System.out.println("Song constructor did not throw an IllegalArgumentException when passed an invalid file");
            return false;
        } catch (IllegalArgumentException e) {
            // the constructor throws an exception as expected
        } catch(Exception e) {
            System.out.println("Song constructor returned " + e + " when it should have returned IllegalArgumentException");
            return false;
        }
        // test a valid file with toString, getTitle, and getArtist
        Song song = new Song("someTitle", "someArtist", "audio/1.mid");
        String toString = song.toString();
        System.out.println(toString);
        //TODO: implement the toString method when .toString is written

        // test the getTitle method
        String title = song.getTitle();
        if (!title.equals("someTitle")) {
            System.out.println("Song.getTitle() returned " + title + " when it should have returned someTitle");
            return false;
        }

        // test the getArtist method
        String artist = song.getArtist();
        if (!artist.equals("someArtist")) {
            System.out.println("Song.getArtist() returned " + artist + " when it should have returned someArtist");
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
            System.out.println("PASSED — " + testName);
        } else {
            System.out.println("*FAILED* — " + testName + " - See above for details");
        }
    }

    /*
     * Runs all tests
     */
    public static void runAllTests(){
        System.out.println("\n-----------------Running Tests-----------------\n");
        evalTestResult(testSongConstructor(), "SongConstructor");

        System.out.println("\n-----------------End of Tests-----------------\n");
    }
    
}
