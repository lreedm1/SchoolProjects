//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    ChugidexTester.java
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
import java.util.NoSuchElementException;
/**
 * This class checks the correctness of the implementation of the methods defined 
in the Chugimon
 * and ChugiTree classes.
 * 
 * @author TODO add your name(s)
 *
 */
public class ChugidexTester {
  /**
   * Checks the correctness of the implementation of both compareTo() and equals() 
methods defined
   * in the Chugimon class.
   * 
   * @return true when this test verifies a correct functionality, and false 
otherwise
   */
  public static boolean testChugimonCompareToEquals() {
    //checks to see that two chugimons are not equal if their name and first ids are the same but their second id's are different
    //checks to see compareTo returns -1
    {
      Chugimon chugi1 = new Chugimon(5, 22);
      Chugimon chugi2 = new Chugimon(5, 21);
      if(!chugi1.getName().equals(chugi2.getName())){
    	System.out.println(chugi1.getName());
    	System.out.println(chugi2.getName());
        System.out.println("ERROR: Chugimon.equals() method failed because the names were not the same when they should have been");
        return false;
      }
      if (chugi1.equals(chugi2)) {
        System.out.println("ERROR: Chugimon.equals() method failed when second ids are different");
        return false;
      }
      if(chugi1.compareTo(chugi2) != 1) {
        System.out.println("ERROR: Chugimon.compareTo() method failed when second ids are different");
        return false;
      }
    }
    //checks to see that two chugimons are not equal if their name and second ids are the same but their first id's are different
    //checks to see compareTo returns 1
    {
      Chugimon chugi1 = new Chugimon(4, 22);
      Chugimon chugi2 = new Chugimon(5, 22);
      if(!chugi1.getName().equals(chugi2.getName())){
    	System.out.println(chugi1.getName());
        System.out.println(chugi2.getName());
        System.out.println("ERROR: Chugimon.equals() method failed because the names were not the same when they should have been");
        return false;
      }
      if (chugi1.equals(chugi2)) {
        System.out.println("ERROR: Chugimon.equals() method failed when first ids are different");
        return false;
      }
      if(chugi1.compareTo(chugi2) != -1) {
        System.out.println("ERROR: Chugimon.compareTo() method failed when first ids are different");
        return false;
      }
    
    }
    //checks to see that two chugimons are equal if their first and second ids are the same 
    //checks to see compareTo returns 0
    {
      Chugimon chugi1 = new Chugimon(4, 26);
      Chugimon chugi2 = new Chugimon(4, 26);
      if (!chugi1.equals(chugi2)) {
        System.out.println("ERROR: Chugimon.equals() method failed when names are different");
        return false;
      }
      if(chugi1.compareTo(chugi2) != 0) {
        System.out.println("ERROR: Chugimon.compareTo() method failed when names are different");
        return false;
      }
    }
    //checks to see that two chugimons are not equal if their names are different
    {
      Chugimon chugi1 = new Chugimon(3, 1);
      Chugimon chugi2 = new Chugimon(5, 22);
      if(chugi1.getName()==(chugi2.getName())){
        System.out.println("ERROR: Chugimon.equals() method failed because the names were the same when they should have been different");
        return false;
      }
      if (chugi1.equals(chugi2)) {
        System.out.println("ERROR: Chugimon.equals() method failed when names are different");
        return false;
      }
      if(chugi1.compareTo(chugi2) != 1) {
        System.out.println("ERROR: Chugimon.compareTo() method failed when names are different");
        return false;
      }
     
    }
    return true;
  }
  /**
   * Checks the correctness of the implementation of Chugimon.toString() method.
   * 
   * @return true when this test verifies a correct functionality, and false 
otherwise
   */
  public static boolean testChugimonToString() {
	  {
	      Chugimon sample = new Chugimon(3, 1);;
	      if(!sample.toString().equals("Venuasaur#3.1")){
	        System.out.println("ERROR: Chugimon.toString() method failed the correct toString should return:"+sample.toString() );
	        return false;
	      }
	    }
	    return true;
  }
  /**
   * Checks the correctness of the implementation of ChugiTree.isValidBSTHelper() 
method. This
   * tester should consider at least three scenarios. (1) An empty tree whose root 
is null should be
   * a valid BST. (2) Consider a valid BST whose height is at least 3. Create the 
tree using the
   * constructors of the BSTNode and its setters methods, (3) Consider a NON-valid 
BST where the
   * search order property is violated at at least one internal node.
   * 
   * @return true when this test verifies a correct functionality, and false 
otherwise
   */
  public static boolean testIsValidBSTHelper() {
    // TODO complete the implementation of this method
    return false; // Default return statement added to resolve compiler errors
  }
  /**
   * Checks the correctness of the implementation of both add() and toString() 
methods implemented
   * in the ChugiTree class. This unit test considers at least the following 
scenarios. (1) Create a
   * new empty ChugiTree, and check that its size is 0, it is empty, and that its 
string
   * representation is an empty string "". (2) try adding one Chugimon and then 
check that the add()
   * method call returns true, the tree is not empty, its size is 1, and the 
toString() called on
   * the tree returns the expected output. (3) Try adding another Chugimon which is
less than the
   * Chugimon at the root, (4) Try adding a third Chugimon which is greater than 
the one at the
   * root, (5) Try adding at least two further Chugimons such that one must be 
added at the left
   * subtree, and the other at the right subtree. For all the above scenarios, and 
more, double
   * check each time that size() method returns the expected value, the add method 
call returns
   * true, that the ChugiTree is a valid BST, and that the toString() method 
returns the expected
   * string representation of the contents of the binary search tree in an 
increasing order from the
   * smallest to the greatest Chugimon. (6) Try adding a Chugimon already stored in
the tree. Make
   * sure that the add() method call returned false, and that the size of the tree 
did not change.
   * 
   * @return true when this test verifies a correct functionality, and false 
otherwise
   */
  public static boolean testAddToStringSize() {
    // TODO complete the implementation of this method
    return false; // Default return statement added to resolve compiler errors
  }
  /**
   * This method checks mainly for the correctness of the ChugiTree.lookup() 
method. It must
   * consider at least the following test scenarios. (1) Create a new ChugiTree. 
Then, check that
   * calling the lookup() method on an empty ChugiTree returns false. (2) Consider 
a ChugiTree of
   * height 3 which contains at least 5 Chugimons. Then, try to call lookup() 
method to search for a
   * Chugimon having a match at the root of the tree. (3) Then, search for a 
Chugimon at the right
   * and left subtrees at different levels considering successful and unsuccessful 
search
   * operations. Make sure that the lookup() method returns the expected output for
every method
   * call.
   * 
   * @return true when this test verifies a correct functionality, and false 
otherwise
   */
  public static boolean testLookup() {
	   // Create a new ChugiTree. Then, check that calling the lookup() method on an empty ChugiTree returns false.
	   {
	      ChugiTree tree = new ChugiTree();
	      Chugimon one =new Chugimon(1,1);
	      if(tree.lookup(1, 1)==one){
	        System.out.println("ERROR: ChugiTree.lookup() method failed because it returned true when the tree was empty");
	        return false;
	      }
	   }
	   //Consider a ChugiTree of height 3 which contains at least 5 Chugimons. Then, try to call 
	   //lookup() method to search for a Chugimon having a match at the root of the tree.
	   {
	      ChugiTree tree = new ChugiTree();
	      Chugimon one =new Chugimon(1,1);
	      Chugimon two =new Chugimon(2,2);
	      Chugimon three =new Chugimon(3,3);
	      Chugimon four =new Chugimon(4,4);
	      Chugimon five =new Chugimon(5,5);
	      tree.add(one);
	      tree.add(two);
	      tree.add(three);
	      tree.add(four);
	      tree.add(five);
	      if(tree.lookup(1, 1)!=one){
	        System.out.println("ERROR: ChugiTree.lookup() method failed because it returned false when the tree was not empty");
	        return false;
	      }
	   }
	   //Search for a Chugimon at the right and left subtrees at different levels considering successful and
	   //unsuccessful search
	   {
	      ChugiTree tree = new ChugiTree();
	      Chugimon one =new Chugimon(1,1);
	      Chugimon two =new Chugimon(2,2);
	      Chugimon three =new Chugimon(3,3);
	      Chugimon four =new Chugimon(4,4);
	      Chugimon five =new Chugimon(5,5);
	      Chugimon six =new Chugimon(6,6);
	      Chugimon seven =new Chugimon(7,7);
	      Chugimon eight =new Chugimon(8,8);
	      Chugimon nine =new Chugimon(9,9);
	      Chugimon ten =new Chugimon(10,10);
	      tree.add(one);
	      tree.add(two);
	      tree.add(three);
	      tree.add(four);
	      tree.add(five);
	      if(tree.lookup(1, 1)!=one){
	        System.out.println("ERROR: ChugiTree.lookup() method failed because it returned false when the tree was not empty");
	        return false;
	      }
	      if(tree.lookup(2, 2)!=two){
	        System.out.println("ERROR: ChugiTree.lookup() method failed because it returned false when the tree was not empty");
	        return false;
	      }
	      if(tree.lookup(3, 3)!=three){
	        System.out.println("ERROR: ChugiTree.lookup() method failed because it returned false when the tree was not empty");
	        return false;
	      }
	      if(tree.lookup(4, 4)!=four){
	        System.out.println("ERROR: ChugiTree.lookup() method failed because it returned false when the tree was not empty");
	        return false;
	      }
	      if(tree.lookup(5, 5)!=five){
	        System.out.println("ERROR: ChugiTree.lookup() method failed because it returned false when the tree was not empty");
	        return false;
	      }
	      if(tree.lookup(6, 6)==six){
	        System.out.println("ERROR: ChugiTree.lookup() method failed because it returned true when the tree was not empty");
	        return false;
	      }
	      if(tree.lookup(7, 7)==seven){
	        System.out.println("ERROR: ChugiTree.lookup() method failed because it returned true when the tree was not empty");
	        return false;
	      }
	      if(tree.lookup(8, 8)==eight){
	        System.out.println("ERROR: ChugiTree.lookup() method failed because it returned true when the tree was not empty");
	        return false;
	      }
	      if(tree.lookup(9, 9)==nine){
	        System.out.println("ERROR: ChugiTree.lookup() method failed because it returned true when the tree was not empty");
	        return false;
	      }
	      if(tree.lookup(10, 10)==ten){
	        System.out.println("ERROR: ChugiTree.lookup() method failed because it returned true when the tree was not empty");
	        return false;
	      }
	   }
	   return true;
	  }
  /**
   * Checks for the correctness of ChugiTree.countType() method.
   * 
   * @return true when this test verifies a correct functionality, and false 
otherwise
   */
  public static boolean testCountType() {
    // TODO complete the implementation of this method
    return false; // Default return statement added to resolve compiler errors
  }
  
  /**
   * Checks for the correctness of ChugiTree.height() method. This test must 
consider several
   * scenarios such as, (1) ensures that the height of an empty Chugimon tree is 
zero. (2) ensures
   * that the height of a tree which consists of only one node is 1. (3) ensures 
that the height of
   * a ChugiTree with four levels for instance, is 4.
   * 
   * @return true when this test verifies a correct functionality, and false 
otherwise
   */
  public static boolean testHeight() {
    //ensures that the height of an empty Chugimon tree is zero.
    {
      ChugiTree tree = new ChugiTree();
      if(tree.height()!=0){
        System.out.println("ERROR: ChugiTree.height() method failed because it returned false when the tree was not empty");
        return false;
      }
    }
    //ensures that the height of a tree which consists of only one node is 1.
    {
      ChugiTree tree = new ChugiTree();
      Chugimon one =new Chugimon(1,1);
      tree.add(one);
      if(tree.height()!=1){
        System.out.println("ERROR: ChugiTree.height() method failed because it returned false when the tree was not empty");
        return false;
      }
    }
    //ensures that the height of a ChugiTree with four levels for instance, is 4.
    {
      ChugiTree tree = new ChugiTree();
      Chugimon one =new Chugimon(9,2);
      Chugimon two =new Chugimon(4,3);
      Chugimon three =new Chugimon(23,4);
      Chugimon four =new Chugimon(14,5);
      tree.add(one);
      tree.add(two);
      tree.add(three);
      tree.add(four);
      if(tree.height()!=4){
        System.out.println("ERROR: ChugiTree.height() method failed because it returned false when the tree was not empty");
        return false;
      }
    }
    return true; 
  }
  /**
   * Checks for the correctness of ChugiTree.getFirst() method.
   * 
   * @return true when this test verifies a correct functionality, and false 
otherwise
   */
  public static boolean testGetFirst() {
    {
      ChugiTree tree = new ChugiTree();
      Chugimon one =new Chugimon(1,1);
      Chugimon two =new Chugimon(2,2);
      Chugimon three =new Chugimon(3,3);
      Chugimon four =new Chugimon(4,4);
      Chugimon five =new Chugimon(5,5);
      tree.add(one);
      tree.add(two);
      tree.add(three);
      tree.add(four);
      tree.add(five);
      if(tree.getFirst()!=one){
        System.out.println("ERROR: ChugiTree.getFirst() method failed because it returned the wrong chugimon that wasn't the first one");
        return false;
      }
    }
    {
      ChugiTree tree = new ChugiTree();
      if(tree.getFirst()!=null){
        System.out.println("ERROR: ChugiTree.getFirst() method failed because it returned a chugimon when the tree was empty");
        return false;
      }
    }
    return true;
  }
  /**
   * Checks for the correctness of ChugiTree.getLast() method.
   * 
   * @return true when this test verifies a correct functionality, and false 
otherwise
   */
  public static boolean testGetLast() {
    {
      ChugiTree tree = new ChugiTree();
      Chugimon one =new Chugimon(1,1);
      Chugimon two =new Chugimon(2,2);
      Chugimon three =new Chugimon(3,3);
      Chugimon four =new Chugimon(4,4);
      Chugimon five =new Chugimon(5,5);
      tree.add(one);
      tree.add(two);
      tree.add(three);
      tree.add(four);
      tree.add(five);
      if(tree.getLast()!=five){
        System.out.println("ERROR: ChugiTree.getLast() method failed because it returned the wrong chugimon that wasn't the last one");
        return false;
      }
    }
    {
      ChugiTree tree = new ChugiTree();
      if(tree.getLast()!=null){
        System.out.println("ERROR: ChugiTree.getLast() method failed because it returned a chugimon when the tree was empty");
        return false;
      }
    }
    return true;
  }
  /**
   * Checks for the correctness of ChugiTree.delete() method. This test must 
consider at least 3
   * test scenarios. (1) Remove a Chugimon that is at leaf node (2) Remove a 
Chugimon at non-leaf
   * node. For each of these scenarios, check that the size of the tree was 
decremented by one and
   * that the resulting ChugiTree is a valid BST, (3) ensures that the 
ChugiTree.delete() method
   * returns false when called on an Chugimon that is not present in the BST.
   * 
   * @return true when this test verifies a correct functionality, and false 
otherwise
   */
  public static boolean testDelete() {
    // TODO complete the implementation of this method
    return false; // Default return statement added to resolve compiler errors
  }
  /**
   * Checks for the correctness of ChugiTree.next() method.
   * 
   * @return true when this test verifies a correct functionality, and false 
otherwise
   */
  public static boolean testNext() {
    // TODO complete the implementation of this method
    return false; // Default return statement added to resolve compiler errors
  }
  /**
   * Checks for the correctness of ChugiTree.previous() method.
   * 
   * @return true when this test verifies a correct functionality, and false 
otherwise
   */
  public static boolean testPrevious() {
    // TODO complete the implementation of this method
    return false; // Default return statement added to resolve compiler errors
  }
  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testChugimonCompareToEquals: " + 
testChugimonCompareToEquals());
    System.out.println("testChugimonToString(): " + testChugimonToString());
    System.out.println("testIsValidBSTHelper(): " + testIsValidBSTHelper());
    System.out.println("testAddToStringSize(): " + testAddToStringSize());
    System.out.println("testLookup(): " + testLookup());
    System.out.println("testHeight(): " + testHeight());
    System.out.println("testCountType(): " + testCountType());
    System.out.println("testGetFirst(): " + testGetFirst());
    System.out.println("testGetLast(): " + testGetLast());
    System.out.println("testDelete(): " + testDelete());
    System.out.println("testNext(): " + testNext());
    System.out.println("testPrevious(): " + testPrevious());
  }
  
}
