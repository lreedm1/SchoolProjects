import java.util.ArrayList;
import java.util.NoSuchElementException;
public class Path {
	private ArrayList<Intersection>intersections;
	/**
	 * Initializes this Path to start as empty
	 */
	public Path() {
		intersections = new ArrayList<Intersection>();
	}
	/**
	 * gets the number of intersections in this Path
	 * 
	 * @return returns the length of the ArrayList intersections
	 */
	public int length() {
		return intersections.size();
	}
	/**
	 * gets the first intersection in the ArrayList intersections
	 * 
	 * @return returns the first intersection in the ArrayList intersections
	 * @throws throws NoSuchElementException if intersections is empty
	 */
	public Intersection getHead() throws NoSuchElementException{
		if(length()<=0) {
			throw new NoSuchElementException("Error: Path is empty");
		}
		return intersections.get(0);
	}
	/**
	 * gets the last intersection in the ArrayList intersections
	 * 
	 * @return returns the last intersection in the ArrayList intersections
	 * @throws throws NoSuchElementException if intersections is empty
	 */
	public Intersection getTail() {
		if(length()<=0) {
			throw new NoSuchElementException("Error: Path is empty");
		}
		return intersections.get(length()-1);
	}
	/**
	 * Adds the given Intersection to the end of this Path if it is a valid addition
	 * 
	 * @param toAdd the interseciton that needs to be added to intersections
	 * @throw throw an IllegalArgumentException if the intersection that is being added is invalid
	 */
	public void addTail(Intersection toAdd) throws IllegalArgumentException{
		if(toAdd.equals(toAdd.goEast())||toAdd.equals(toAdd.goNorth())||length()==0) {
			intersections.add(toAdd);
		}
		else {
			throw new IllegalArgumentException("Error: The Intersection you are trying to add is invalid");
		}
	}
	/**
	 * Adds the given Intersection to the front of this Path if it is a valid addition
	 * 
	 * @param toAdd the interseciton that needs to be added to intersections
	 * @throw throw an IllegalArgumentException if the intersection that is being added is invalid
	 */
	public void addHead(Intersection toAdd) {
		if(toAdd.equals(toAdd.goSouth())||toAdd.equals(toAdd.goWest())||length()==0) {
			intersections.add(toAdd);
		}
		else {
			throw new IllegalArgumentException("Error: The Intersection you are trying to add is invalid");
		}
	}
	/**
	 * returns a string that is formatted using the coordinates followed by this Path
	 * 
	 * @override overrides the toString() method in the Object class
	 */
	public String toString() {
		String result = "";
		if(length()==0) {
			return "Empty";
		}
		else {
		for(int i =0; i< length(); i++) {
			result+= intersections.get(i) + ("->");
		}
		return result;
		}
	}
}
