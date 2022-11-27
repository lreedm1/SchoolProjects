//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Song.java
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
import java.io.IOException;
import java.util.Scanner;

/** NOTES
 * All methods longer than 3 lines should have an inline comment
 */

 /*
  * This class is a representation of a song
  * and interfaces with the AudioUtility class
  * which uses javax.sound.sampled to play audio
  */
public class Song{

    private String title;           // title of the song
    private String artist;          // artist of the song
    private int duration;           // duration of the song in seconds
    private AudioUtility audioClip; // audio clip of the song

    /*
    * Constructs the song object
    * 
    * @param title the song title
    * @param artist the song artist
    * @param filepath the song filepath
    * 
    * @throws IllegalArgumentException if the filepath is invalid
    */
    public Song(String title, String artist, String filepath) throws IllegalArgumentException{
        this.title = title;
        this.artist = artist;

        // checks if the file exists
        try{
            this.audioClip = new AudioUtility(filepath);
            this.duration = audioClip.getClipLength();

        } catch (IOException e){
            throw new IllegalArgumentException("Filepath is invalid");
        }
    }
    
    /*
     * Returns the song artist
     * @return the song artist
     */
    public String getArtist(){
        return this.artist;
    }

    /*
     * Returns the song titles
     * @return the song title
     */
    public String getTitle(){
        return this.title;
    }

    /*
     * Checks if the song is playing
     * @return true if the song is playing, false otherwise
     */
    public boolean isPlaying(){
        return this.audioClip.isRunning();
    }

    /*
     * Plays the song
     */
    public void play(){
        // if the song is not ready to play, reopen the audio clip
        // else play the song
        while (!this.audioClip.isReadyToPlay()){
            this.audioClip.reopenClip();
        }
        this.audioClip.startClip();
        System.out.println("Playing..." + this.toString());
    }

    /*
     * Stops the song
     */
    public void stop(){
        this.audioClip.stopClip();
    }

    /*
     * Returns the song title, duration in minutes, duration in seconds, and artist
     * 
     * @return the song information in the format in the format |"someTitle" (minutes:seconds) by someArtist)|
     */
    @Override
    public String toString(){
        return "\"" + this.title + "\" (" + this.duration / 60 + ":" + this.duration % 60 + ") by " + this.artist;
    }

    }