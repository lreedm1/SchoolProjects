//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Quizzer
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
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This class models a Linked Node that stores a reference to a MultipleChoiceQuestion
 */
public class LinkedNode<T> {
  private T data;
  private LinkedNode<T> next;

  /**
   * Creates a new LinkedNode with the given data and next node
   * 
   * @param data the data to be stored in this node
   * @param next the next node in the list
   * @throws NullPointerException if data is null
   */
  public LinkedNode(T data, LinkedNode<T> next) {
    if (data == null) {
      throw new NullPointerException();
    }
    this.data = data;
    this.next = next;
  }

  /**
   * Creates a new LinkedNode with the given data and null next node
   * 
   * @param data the data to be stored in this node
   * @throws NullPointerException if data is null
   */
  public LinkedNode(T data) {
    if (data == null) {
      throw new NullPointerException();
    }
    this.data = data;
  }

  /**
   * Returns the next reference to the node that comes after this one in the list,
   * or null when this is the last node in that list
   * 
   * @return gets the next reference to the node that comes after this one in the
   *         list, or null when this is the last node in that list
   */
  public LinkedNode<T> getNext() {
    return next;
  }

  /**
   * Returns the next node in the list
   * 
   * @return sets the next node in the list
   */
  public void setNext(LinkedNode<T> next) {
    this.next = next;
  }

  /**
   * Returns the data stored in this node
   * 
   * @return gets the data stored in this node
   */
  public T getData() {
    return data;
  }

  /**
   * Returns a string representation of this linked node formatted as follows:
   * 
   * data.toString() if this node does NOT have a next node in the list
   * data.toString() + "->" if this node has a next node in the list
   * @return a string representation of this linked node
   */
  @Override
  public String toString() {
    if (next == null) {
      return data.toString();
    } else {
      return data.toString() + "->";
    }
  }
}
