//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Music Player 300
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
 * A FIFO linked queue of SongNodes, conforming to our QueueADT interface.
 */
public class Playlist {
  private SongNode first; // The current first song in the queue; the next one up to play (front of the queue)
  private SongNode last; // The current last song in the queue; the most-recently added one (back of the queue)
  private int numSongs; // The number of songs currently in the queue
  /**
   * Constructs a new, empty playlist queue
   */
  public Playlist(){
      //TODO: Implement this method
  }
  /**
   * Adds a new song to the end of the queue
   * @param element  the song to add to the Playlist
   */
  public void enqueue(Song element){
      //TODO: Implement this method
  }
  /**
   * Removes the song from the beginning of the queue
   * @return the song that was removed from the queue, or null if the queue is empty
   */
  public Song dequeue(){
      //TODO: Implement this method
  }
  /**
   * Returns the song at the front of the queue without removing it
   * @return the song that is at the front of the queue, or null if the queue is empty
   */
  public Song peek(){
      //TODO: Implement this method
  }
  /**
   * Returns true if and only if there are no songs in this queue
   * @return true if this queue is empty, false otherwise
   */
  public boolean isEmpty(){
      //TODO: Implement this method
  }
  /**
   * Returns the number of songs in this queue
   * @return the number of songs in this queue
   */
  public int size(){
      //TODO: Implement this method
  }
  /**
   * Creates and returns a formatted string representation of this playlist
   * @return the string representation of this playlist
   */
  @Override
  public String toString(){
      //TODO: Implement this method
  }

}
