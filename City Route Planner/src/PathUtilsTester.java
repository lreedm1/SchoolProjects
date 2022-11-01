import java.util.Scanner;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Exceptional Vending Machine
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
public class PathUtilsTester {
	/**
	 * 
	 * @return
	 */
	public PathUtilsTester() {

	}

	/**
	 * 
	 * @return
	 */
	public static boolean testCountPathsNoPath() {
		return false;
	}

	/**
	 * 
	 * @return
	 */
	public static boolean testCountPathsOnePath() {
		return false;
	}

	/**
	 * 
	 * @return
	 */
	public static boolean testCountPathsRecursive() {
		return false;
	}

	/**
	 * 
	 * @return
	 */
	public static boolean testFindAllPathsNoPath() {
		return false;
	}

	/**
	 * 
	 * @return
	 */
	public static boolean testFindAllPathsOnePath() {
		return false;
	}

	/**
	 * 
	 * @return
	 */
	public static boolean testFindAllPathsRecursive() {
		return false;
	}

	public static void main(String[] args) {
		try (Scanner keyboard = new Scanner(System.in)) {
			int startX, startY, endX, endY;
			String input = "Y";
			while (input.equalsIgnoreCase("Y")) {
				System.out.print("Enter starting X coordinate: ");
				startX = keyboard.nextInt();
				System.out.print("Enter starting Y coordinate: ");
				startY = keyboard.nextInt();
				System.out.print("Enter ending X coordinate: ");
				endX = keyboard.nextInt();
				System.out.print("Enter ending Y coordinate: ");
				endY = keyboard.nextInt();
				Intersection start = new Intersection(startX, startY);
				Intersection end = new Intersection(endX, endY);
				System.out.println("Number of paths from start to end: "
						+ PathUtils.countPaths(start, end));
				System.out.println("List of possible paths:");
				for (Path p : PathUtils.findAllPaths(start, end)) {
					System.out.println(p);
				}
				do {
					System.out.print("Try another route? (Y/N): ");
					input = keyboard.next();
				} while (!input.equalsIgnoreCase("Y")
						&& !input.equalsIgnoreCase("N"));
			}
		}
	}
}

// TODO:
// 1. Implement the PathUtilsTester class
// 2. Write clas headers for all methods
// 3. Write javadoc comments for all methods
// 4. Implement the @param and @return tags for all methods
