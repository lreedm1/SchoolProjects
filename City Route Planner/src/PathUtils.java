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
import java.util.ArrayList;

public class PathUtils {
	/**
	 * 
	 */
	public PathUtils() {
	}

	/**
	 * counts the number of paths from the start intersection to the end intersection
	 * @param start the starting intersection
	 * @param end the ending intersection
	 * @return the number of paths from the start intersection to the end intersection
	 */
	public static int countPaths(Intersection start, Intersection end) {
		if (start.equals(end)) {
      return 1;
		}
    int count =0;
		count += countNorthernPaths(start, end);
		count += countEasternPaths(start, end);
		return count;
		}
		
	private static int countNorthernPaths(Intersection start, Intersection end) {
    int northernPaths =0;
		if (start.getY() < end.getY()) {
      northernPaths = countPaths(start.goNorth(), end);
		}
		return northernPaths;
	}

	private static int countEasternPaths(Intersection start, Intersection end) {
    int easternPaths =0;
		if (start.getX() < end.getX()) {
      easternPaths = countPaths(start.goEast(), end);
		}
		return easternPaths;
	}

	/**
	 * find all paths from the start point to the end point
	 * moving only north or east
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static ArrayList<Path> findAllPaths(Intersection start, Intersection end) {
		ArrayList<Path> tempPaths = new ArrayList<Path>();
		if (start.equals(end)) {
			Path newPath = new Path();
			newPath.addTail(end);
			tempPaths.add(newPath);
			return tempPaths;
		}

		addNorthernPaths(start, end, tempPaths);
		addEasternPaths(start, end, tempPaths);

		addHeads(start, tempPaths);
		return tempPaths;
	}

	private static void addHeads(Intersection start, ArrayList<Path> paths) {
		for (Path path : paths) {
			path.addHead(start);
		}
	}

	private static void addNorthernPaths(Intersection start, Intersection end, ArrayList<Path> paths) {
		if (start.getY() < end.getY()) {
			return;
		}
		paths.addAll(findAllPaths(start.goNorth(), end));
	}

	private static void addEasternPaths(Intersection start, Intersection end, ArrayList<Path> paths) {
		if (start.getX() < end.getX()) {
			return;
		}
		paths.addAll(findAllPaths(start.goEast(), end));
	}
}