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
 * A singly-linked node for our linked queue, which contains a Song object
 */
public class SongNode {
  private Song song; // The Song object in this node
  private SongNode next; //The next SongNode in this queue
  /**
   * Constructs a single SongNode containing the given data, not linked to any other SongNodes
   * @param data the Song for this node
   * @throws IllegalArgumentException if data is null
   */
  public SongNode(Song data) throws IllegalArgumentException{
      //TODO: Implement this method
  }
  /**
   * Constructs a single SongNode containing the given data, linked to the specified SongNode
   * @param data the Song for this node
   * @param next the next node in the queue
   * @throws IllegalArgumentException if data is null
   */
  public SongNode(Song data, SongNode next) throws IllegalArgumentException{
      //TODO: Implement this method
  }
  /**
   * Accessor method for this node's data
   * @return the Song in this node
   */
  public Song getSong(){
      //TODO: Implement this method
  }
  /**
   * Accessor method for the next node in the queue
   * @return the SongNode following this one, if any
   */
  public SongNode getNext(){
      //TODO: Implement this method
  }
  /**
   * Changes the value of this SongNode's next data field to the given value
   * @param next the SongNode to follow this one; may be null
   */
  public void setNext(SongNode next){
      //TODO: Implement this method
  }
}
