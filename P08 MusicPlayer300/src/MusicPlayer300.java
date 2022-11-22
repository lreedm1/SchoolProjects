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
import java.util.Scanner;
/**
 *
 * A linked-queue based music player which plays Actual Music Files based on
 * keyboard input in an interactive console method.
 */
public class MusicPlayer300 {
  private Playlist playlist; // The current playlist of Songs
  private boolean filterPlay; // Whether the current playback mode should be filtered by artist 
  private String filterArtist; // The artist to play if filterPlay is true; should be null otherwise

  /**
   * Creates a new MusicPlayer300 with an empty playlist
   */
  public MusicPlayer300(){
      //TODO: Implement this method
      filterPlay =false;
  }

  /**
   * Stops any song that is playing and clears out the playlist
   */
  public void clear() {
      //TODO: Implement this method
  }

  /**
   * Loads a playlist from a provided file, skipping any individual songs which
   * cannot be loaded
   * 
   * @param file the File object to load
   * @throws FileNotFoundException if the playlist file cannot be loaded
   */
  public void loadPlaylist(File file) throws FileNotFoundException {
      //TODO: Implement this method
  }

  /**
   * Loads a single song to the end of the playlist given the title, artist, and
   * filepath
   * 
   * @param title    the title of the song
   * @param artist   the artist of this song
   * @param filepath the full relative path to the song file, begins with the
   *                 "audio" directory for P08
   * @throws IllegalArgumentException if the song file cannot be read
   */
  public void loadOneSong(String title, String artist, String filepath) throws IllegalArgumentException {
      //TODO: Implement this method
  }

  /**
   * Provides a string representation of all songs in the current playlist
   * 
   * @return a string representation of all songs in the current playlist
   */
  public String printPlaylist() {
      //TODO: Implement this method
  }

  /**
   * Creates and returns the menu of options for the interactive console program.
   * 
   * @return the formatted menu String
   */
  public String getMenu() {
      //TODO: Implement this method
  }

  /**
   * Stops playback of the current song (if one is playing) and advances to the
   * next song in the playlist.
   * 
   * @throws IllegalStateException if the playlist is null or empty, or becomes
   *                               empty at any time during this method
   */
  public void playNextSong() throws IllegalStateException {
      //TODO: Implement this method
  }

  /**
   * Interactive method to display the MusicPlayer300 menu and get keyboard input
   * from the user
   * 
   * @param in Music File that is being scanned
   */
  public void runMusicPlayer300(Scanner in) {
      //TODO: Implement this method
  }
}
