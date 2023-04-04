import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.Random;

// this class tests the min and max methods in the RedBlackTree class
// using 6 junit tests
// 1. the min method should throw NoSuchElementException if the tree is empty
// 2. the min method should return the minimum value in a tree with one node
// 3. the min method should return the minumum value in a tree with
// 1000 random nodes
// 4. the max method should throw NoSuchElementException if the tree is empty
// 5. the max method should return the maximum value in a tree with one node
// 6. the max method should return the maximum value in a tree with
// 1000 random nodes

public class AlgorithmEngineerTests extends RedBlackTree<Integer> {

    @Test
    public void test1() {
        // make an empty red black tree
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        // check that the min method throws NoSuchElementException
        try {
            tree.min();
            assert(false);
        } catch (Exception e) {
            assertEquals("java.util.NoSuchElementException", e.getClass().getName());
        }
    }

    @Test
    public void test2() {
        // make a tree with one node
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.insert(1);
        // check that the min method returns the value of the node
        assertEquals(1, (int) tree.min());
    }

    @Test
    public void test3() {
        // make a tree of 1000 random integers
        Random random = new Random();
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        // keep track of the minimum value
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 1000; i++) {
            int value = random.nextInt(1000000000);
            tree.insert(value);
            if (value < min) min = value;
        }
        // check that the min method returns the minimum value
        assertEquals(min, (int) tree.min());
    }

    @Test
    public void test4() {
        // make an empty red black tree
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        // check that the max method throws NoSuchElementException
        try {
            tree.max();
            assert(false);
        } catch (Exception e) {
            assertEquals("java.util.NoSuchElementException", e.getClass().getName());
        }
    }

    @Test
    public void test5() {
        // make a tree with one node
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.insert(1);
        // check that the max method returns the value of the node
        assertEquals(1, (int) tree.max());
    }

    @Test
    public void test6() {
        // make a tree of 1000 random integers
        Random random = new Random();
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        // keep track of the maximum value
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 1000; i++) {
            int value = random.nextInt(1000000000);
            tree.insert(value);
            if (value > max) max = value;
        }
        // check that the max method returns the maximum value
        assertEquals(max, (int) tree.max());
    }

}
