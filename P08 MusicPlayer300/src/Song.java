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
import java.io.File;
import java.util.Scanner;

/**
 * A representation of a single Song. Interfaces with the provided AudioUtility
 * class, which uses
 * the javax.sound.sampled package to play audio to your computer's audio output
 * device
 */
public class Song {

  private String title; // The title of this song
  private String artist; // The artist of this song
  private int duration; // The duration of this song in number of seconds
  private AudioUtility audioClip; // This song's AudioUtility interface to javax.sound.sampled

  /**
   * Initializes all instance data fields according to the provided values
   * 
   * @param title    the title of the song, set to empty string if null
   * @param artist   the artist of this song, set to empty string if null
   * @param filepath the full relative path to the song file, begins with the
   *                 "audio" directory for P08
   * @throws IllegalArgumentException if the song file cannot be read
   */
  public Song(String title, String artist, String filepath) throws IllegalArgumentException {
    if(filepath.canRead()!=true) {
      throw new IllegalArgumentException("Song file cannot be read");
    }
    this.title = title;
    this.artist = artist;
    this.audioClip = new AudioUtility(filepath);
  }

  /**
   * Tests whether this song is currently playing using the AudioUtility
   * 
   * @return true if the song is playing, false otherwise
   */
  public boolean isPlaying() {
    return audioClip.isRunning();
  }

  /**
   * Accessor method for the song's title
   * 
   * @return the title of this song
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Accessor method for the song's artist
   * 
   * @return the artist of this song
   */
  public String getArtist() {
    return this.artist;
  }

  /**
   * Uses the AudioUtility to start playback of this song, reopening the clip for
   * playback if necessary
   */
  public void play() {
    if (!this.audioClip.isPlaying()) {
      this.audioClip.startClip();
    }
  }

  /**
   * Uses the AudioUtility to stop playback of this song
   */
  public void stop() {
    if (this.audioClip.isPlaying()) {
      this.audioClip.stopClip();
    }
  }

  /**
   * Creates and returns a string representation of this Song. 
   * 
   * @return a formatted string representation of this Song
   */
  @Override
  public String toString() {
    return "\"" + this.title + "\" by " + this.artist + " (" + this.duration / 60 + ":"
        + this.duration % 60 + ")";
  }
}