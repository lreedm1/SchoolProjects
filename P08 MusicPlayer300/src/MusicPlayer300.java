//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    MusicPlayer300.java
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
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * A linked-queue based music player which plays Actual Music Files based on
 * keyboard input in an interactive console method.
 */
public class MusicPlayer300 {
    private String filterArtist; // The artist to play if filterPlay is true, null otherwise
    private boolean filterPlay; // Whether or not to filter by artist, false by default
    private Playlist playlist; // The current playlist of songs
    /*
     * Creates a new MusicPlayer300 object with an empty playlist
     */
    public MusicPlayer300() {
        this.playlist = new Playlist();
    }

    /*
     * Stops the current song if it exists and clears the current playlist 
     */
    public void clear() {
        // Stop the current song
        if (playlist.peek() != null) {
            playlist.peek().stop();
        }
        // Clear the current playlist
        while (!playlist.isEmpty()) {
            playlist.dequeue();
        }
    }
}
