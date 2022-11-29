//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Playlist.java
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
		first = null;
		last = null;
		numSongs = 0;
	}
	/**
	* Adds a new song to the end of the queue
	* @param element  the song to add to the Playlist
	*/
	public void enqueue(Song element){
		SongNode newNode = new SongNode(element);
		if (this.isEmpty()) {
			this.first = newNode;
			this.last = newNode;
		} else {
			this.last.setNext(newNode);
			this.last = newNode;
		}
		this.numSongs++;
	}
	/**
	* Removes the song from the beginning of the queue
	* @return the song that was removed from the queue, or null if the queue is empty
	*/
	public Song dequeue(){
		if(this.isEmpty()){
			return null;
		}
		SongNode temp = this.first;
		this.first = this.first.getNext();
		this.numSongs--;
		return temp.getSong();
	}
	/**
	* Returns the song at the front of the queue without removing it
	* @return the song that is at the front of the queue, or null if the queue is empty
	*/
	public Song peek(){
		if(this.isEmpty()){
			return null;
		}
		return this.first.getSong();
	}
	/**
	* Returns true if and only if there are no songs in this queue
	* @return true if this queue is empty, false otherwise
	*/
	public boolean isEmpty(){
		return this.numSongs == 0;
	}
	/**
	* Returns the number of songs in this queue
	* @return the number of songs in this queue
	*/
	public int size(){
		return this.numSongs;
	}
	/**
	* Creates and returns a formatted string representation of this playlist
	* @return the string representation of this playlist
	*/
	@Override
	public String toString(){
		String result = "";
		SongNode current = this.first;
		while (current != null && current.getSong() != null) {
			result += current.getSong().toString() + "\n";
			current = current.getNext();
		}
		return result;
	}
	
}
