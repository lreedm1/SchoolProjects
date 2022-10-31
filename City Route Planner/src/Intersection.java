
public class Intersection {

	private final int x;
	private final int y;
	/**
	 * 
	 * @param x x coordinate for the Intersection
	 * @param y y coordinate for the Interseciton
	 */
	public Intersection(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * gets the x coordinate for the Intersection
	 * 
	 * @return returns the x coordinate for the Intersection
	 */
	public int getX() {
		return x;
	}
	/**
	 * gets the y coordinate for the Intersection
	 * 
	 * @return  returns the y coordinate for the Intersection
	 */
	public int getY() {
		return y;
	}
	/**
	 * returns a coordinate-pair representation of this Intersection in the form "(x,y)"
	 * 
	 * @override overrides the default toString() method in the Object class
	 */
	public String toString() {
		return "("+x+","+y+")";
	}
	/**
	 * returns true if the given Object is identical to this Intersection, and false otherwise
	 * 
	 * @override overrides the default eqauls() method in the Object class
	 */
	public boolean equals(Object o) {
		if (o instanceof Intersection) {
			Intersection otherItem = (Intersection) o;
			if (otherItem.getX()== x && otherItem.getY() == y) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Creates a new Intersection instance which is one step directly above this Intersection
	 * 
	 * @return returns a new Intersection instance which is one step directly above this Intersection
	 */
	public Intersection goNorth() {
		Intersection north = new Intersection(x,y+1);
		return north;
	}
	/**
	 * Creates a new Intersection instance which is one step directly below this Intersection
	 * 
	 * @return returns a new Intersection instance which is one step directly below this Intersection
	 */
	public Intersection goSouth() {
		Intersection south = new Intersection(x,y-1);
		return south;
	}
	/**
	 * Creates a new Intersection instance which is one step directly to the right of this Intersection
	 * 
	 * @return returns a new Intersection instance which is one step directly to the right of this Intersection
	 */
	public Intersection goEast() {
		Intersection east = new Intersection(x+1,y);
		return east;
	}
	/**
	 * Creates a new Intersection instance which is one step directly to the left of this Intersection
	 * 
	 * @return returns a new Intersection instance which is one step directly to the left of this Intersection
	 */
	public Intersection goWest() {
		Intersection west = new Intersection(x-1,y);
		return west;
	}
}
