import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AlgorithmEngineerTests {

	@Test
	public void InsertandContains() {
		
		// creating car objects to add
		AE_Car t1 = new AE_Car("WI", "Ford", "Black", 23095.00);
		AE_Car t2 = new AE_Car("IL", "Toyota", "Green", 21000.00);
		AE_Car t3 = new AE_Car("CA", "Porsche", "Pink", 54987.00);
		
		// create new rbt
		RedBlackTree<AE_Car> test = new RedBlackTree<>();
		
		//insert car objects into tree
		test.insert(t1);
		test.insert(t2);
		test.insert(t3);
		
		// if the tree contains t1, then the insert and contains
		//methods are working properly
		assertEquals(test.contains(t1), true);
	}
	
	@Test
	public void getLeftChildTest() {
		
		// creating car objects to add
		AE_Car t1 = new AE_Car("WI", "Ford", "Black", 23095.00);
		AE_Car t2 = new AE_Car("IL", "Toyota", "Green", 21000.00);
		AE_Car t3 = new AE_Car("CA", "Porsche", "Pink", 54987.00);
		
		// create new rbt
		RedBlackTree<AE_Car> test = new RedBlackTree<>();
		
		//insert car objects into tree
		test.insert(t1);
		test.insert(t2);
		test.insert(t3);
		
		// if the left child of t1 is equal to t2, then the getLeftChild
		// method is working properly
		assertEquals(test.getLeftChild(t1), t2);
	}
	
	@Test
	public void getRightChildTest() {
		
		// creating car objects to add
		AE_Car t1 = new AE_Car("WI", "Ford", "Black", 23095.00);
		AE_Car t2 = new AE_Car("IL", "Toyota", "Green", 21000.00);
		AE_Car t3 = new AE_Car("CA", "Porsche", "Pink", 54987.00);
		
		// create new rbt
		RedBlackTree<AE_Car> test = new RedBlackTree<>();
		
		//insert car objects into tree
		test.insert(t1);
		test.insert(t2);
		test.insert(t3);
		
		// if the right child of t1 is t3, then the getRightChild method
		// is working properly
		assertEquals(test.getRightChild(t1), t3);
	}
	
	@Test
	public void removeTest() {
		
		// creating car objects to add
		AE_Car t1 = new AE_Car("WI", "Ford", "Black", 23095.00);
		AE_Car t2 = new AE_Car("IL", "Toyota", "Green", 21000.00);
		AE_Car t3 = new AE_Car("CA", "Porsche", "Pink", 54987.00);
		
		// create new rbt
		RedBlackTree<AE_Car> test = new RedBlackTree<>();
		
		//insert car objects into tree
		test.insert(t1);
		test.insert(t2);
		test.insert(t3);
		
		test.remove(t3);
		
		// if the tree doesn't contain t3 anymore, the remove method is 
		// working properly
		assertEquals(test.contains(t3), false);
	}
	
	@Test
	public void LowestAndHighestTest() {
		
		// creating car objects to add
		AE_Car t1 = new AE_Car("WI", "Ford", "Black", 23095.00);
		AE_Car t2 = new AE_Car("IL", "Toyota", "Green", 21000.00);
		AE_Car t3 = new AE_Car("CA", "Porsche", "Pink", 54987.00);
		
		// create new rbt
		RedBlackTree<AE_Car> test = new RedBlackTree<>();
		
		//insert car objects into tree
		test.insert(t1);
		test.insert(t2);
		test.insert(t3);
		
		// if the lowest() returns t2, and the highest() returns t3, then
		// the highest and lowest methods are working properly
		assertEquals(test.lowest(), t2);
		assertEquals(test.highest(), t3);
	}
	
	@Test
	public void findTest() {
		// creating car objects to add
		AE_Car t1 = new AE_Car("WI", "Ford", "Black", 23095.00);
		AE_Car t2 = new AE_Car("IL", "Toyota", "Green", 21000.00);
		AE_Car t3 = new AE_Car("CA", "Porsche", "Pink", 54987.00);
				
		// create new rbt
		RedBlackTree<AE_Car> test = new RedBlackTree<>();
				
		//insert car objects into tree
		test.insert(t1);
		test.insert(t2);
		test.insert(t3);
		
		assertEquals(test.find(54987.00), t3);
		assertEquals(test.find(1.23), null);
	}
	
}
