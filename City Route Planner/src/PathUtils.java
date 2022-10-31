import java.util.ArrayList;

public class PathUtils {
	/**
	 * 
	 */
	public PathUtils() {

	}

	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int countPaths(Intersection start, Intersection end) {
		int count = 0;
		if (start.equals(end)) {
			return count;
		} else {

		}
		return count;
	}

	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static ArrayList<Path> findAllPaths(Intersection start, Intersection end) {
		Path list = new Path();
		ArrayList<Path> result = new ArrayList<Path>();
		int xPos = start.getX(); // x position
		int yPos = start.getY(); // y position
		int i; // Loop index
		Intersection curr = new Intersection(xPos, yPos);
		if (start.equals(end)) {
			xPos = start.getX();
			yPos = start.getY();
			for (i = 0; i < result.size(); ++i) {
				System.out.println(result.get(i).toString());
			}
		} else {
			// if path needs to go north
			if (yPos < end.getY()) {
				for (i = yPos; i < end.getY(); ++i) {
					xPos = start.goNorth().getX();
					yPos = start.goNorth().getY();
					list.addHead(curr);
					findAllPaths(curr, end);
				}
			}
			// if path needs to go south
			if (yPos > end.getY()) {
				for (i = yPos; i > end.getY(); --i) {
					xPos = start.goSouth().getX();
					yPos = start.goSouth().getY();
					list.addTail(curr);
					findAllPaths(curr, end);

				}
			}
			// if path needs to go east
			if (xPos < end.getX()) {
				for (i = xPos; i > end.getX(); ++i) {
					xPos = start.goEast().getX();
					yPos = start.goEast().getY();
					list.addHead(curr);
					findAllPaths(curr, end);
				}
			}
			// if path needs to go west
			if (xPos > end.getX()) {
				for (i = xPos; i > end.getX(); --i) {
					xPos = start.goWest().getX();
					yPos = start.goWest().getY();
					list.addTail(curr);
					findAllPaths(curr, end);
				}
			}
			result.add(list);
		}
		return result;
	}
}
