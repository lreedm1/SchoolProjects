
/**
 *           FILE HEADER (INCLUDE IN EVERY FILE)
 * 
 * Title:     Main.java
 * Course:    CS 300 Fall 2022
 * 
 * Author:    Reed Lokken
 * Email:     Rlokken@wisc.edu
 * Lecturer:  Hobbes LeGault
 * 

 * VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
 *  X Write-up states that pair programming is allowed for this assignment.
 *  X We have both read and understand the course Pair Programming Policy.
 *  X We have registered our team prior to the team registration deadline. 
 * 
 * ALWAYS CREDIT OUTSIDE HELP
 * 
 * Persons: NONE
 * Online Sources: Github Copilot
 */

import java.util.Random;
import java.io.File;
import processing.core.PImage;

/**
 * WalkingSim.java is a class that creates a walking animation
 * of a random amount of 'walkers' within a Processing window.
 *
 */

public class WalkingSim {

  private static int bgColor;
  private static Random randGen;
  private static Walker[] walkers;
  private static PImage[] frames;

  /**
   * Runs the file using an external library
   * 
   */
  public static void main(String[] args) {
    Utility.runApplication(); // starts the application
  }

  /**
   * Generates a random background color, initializes an array of size 8
   * and fills it with a random amount of walkers, and initializes an array
   * of size 8 and fills it frames used to animate the walkers.
   * 
   * @param bgColor - the randomlly generated background color
   * 
   * @param randGen - a random number generator used to generate the background
   *                color
   * 
   * @param walkers - the array that stores walkers
   * 
   * @param frames  - an array of frames used to animate the walkers
   * 
   * @param index   - the index of the array that is being filled
   * 
   * @param x       - the x coordinate of the walker
   * 
   * @param y       - the y coordinate of the walker
   */
  public static void setup() {
    randGen = new Random();
    Random number = new Random();
    bgColor = randGen.nextInt();
    frames = new PImage[Walker.NUM_FRAMES];
    for (int index = 0; index < 8; index++) {
      frames[index] = Utility.loadImage("images" + File.separator + "walk-" + index + ".png");

    }
    walkers = new Walker[8];
    walkers[0] = new Walker();
    int walkerCount = number.nextInt(9);
    for (int index = 0; index < walkerCount; index++) {
      float x = randGen.nextInt(Utility.width());
      float y = randGen.nextInt(Utility.height());
      walkers[index] = new Walker(x, y);
    }

  }

  /**
   * Draws the background color, updates the walkers' position and frame, and
   * draws the walkers
   * 
   * @param bgColor - the randomlly generated background color
   * 
   * @param walkers - the array that stores walkers
   * 
   * @param frames  - an array of frames used to animate the walkers
   * 
   * @param x       - the x coordinate of the walker
   */
  public static void draw() {
    Utility.background(bgColor);
    for (int index = 0; index < walkers.length; index++) {
      Walker image = walkers[index];
      if (image != null) {
        if (image.isWalking()) {
          image.update();
          float x = (image.getPositionX() + 3) % Utility.width();
          image.setPositionX(x);
        }
        Utility.image(frames[image.getCurrentFrame()], image.getPositionX(), image.getPositionY());
      }

    }

  }

  /**
   * Returns true if the mouse is over the walker, false otherwise
   * 
   * @param image      - the walker that is being checked
   * 
   * @param halfHeight - half the height of the window
   * 
   * @param halfWidth  - half the width of the window
   * 
   * @param imageX     - the x coordinate of the walker
   * 
   * @param imageY     - the y coordinate of the walker
   * 
   * @param mouseX     - the x coordinate of the mouse
   * 
   * @param mouseY     - the y coordinate of the mouse
   * 
   */
  public static boolean isMouseOver(Walker image) {
    int halfHeight = frames[0].height / 2;
    int halfWidth = frames[0].width / 2;
    float imageX = image.getPositionX();
    float imageY = image.getPositionY();
    float mouseX = Utility.mouseX();
    float mouseY = Utility.mouseY();

    if (mouseX > imageX - halfWidth && mouseX < imageX + halfWidth && mouseY > imageY - halfHeight
        && mouseY < imageY + halfHeight)
      return true;
    else
      return false;
  }

  /**
   * Checks if a mouse click is over a walker, and if it is, sets the walker to
   * walking
   * 
   * @param walkers - the array that stores walkers
   * 
   * @param index   - the index of the array that is being checked
   * 
   */
  public static void mousePressed() {
    for (int index = 0; index < walkers.length; index++) {
      if (walkers[index] != null && isMouseOver(walkers[index])) {
        walkers[index].setWalking(true);
        break;
      }

    }

  }

  /**
   * Checks if one of the following keys is pressed [A,a,S,s]
   * if the key is [A,a], all walkers null walkers are initialized
   * and all walkers are set to walking. If the key is [S,s], all
   * walkers are set to not walking.
   * 
   * @param walkers - the array that stores walkers
   * 
   * @param index   - the walker that is being checked
   * 
   * @param newX    - the new x coordinate of the walker
   * 
   * @param newY    - the new y coordinate of the walker
   * 
   */
  public static void keyPressed(char character) {
    if (character == 'a' || character == 'A') {
      for (int index = 0; index < walkers.length; index++) {
        if (walkers[index] == null) {
          float newX = randGen.nextInt(Utility.width());
          float newY = randGen.nextInt(Utility.height());
          walkers[index] = new Walker(newX, newY);
        }

      }

    }
    if (character == 's' || character == 'S') {
      for (int index = 0; index < walkers.length; index++) {
        if (walkers[index] != null) {
          walkers[index].setWalking(false);
        }
        
      }

    }

  }

}
