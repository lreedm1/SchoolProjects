
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
 * This class checks the correctness of the implementation of the methods
 * defined
 * in the Chugimon
 * and ChugiTree classes.
 * 
 * @author Aarav Gupta and Reed Lokken
 *
 */
public class ChugidexTester {
  /**
   * Checks the correctness of the implementation of both compareTo() and equals()
   * methods defined
   * in the Chugimon class.
   * 
   * @return true when this test verifies a correct functionality, and false
   *         otherwise
   */
  public static boolean testChugimonCompareToEquals() {
    // checks to see that two chugimons are not equal if their name and first ids
    // are the same but their second id's are different
    // checks to see compareTo returns -1
    {
      Chugimon chugi1 = new Chugimon(5, 22);
      Chugimon chugi2 = new Chugimon(5, 21);
      if (!chugi1.getName().equals(chugi2.getName())) {
        System.out.println(chugi1.getName());
        System.out.println(chugi2.getName());
        System.out.println(
            "ERROR: Chugimon.equals() method failed because the names were not the same when they should have been");
        return false;
      }
      if (chugi1.equals(chugi2)) {
        System.out.println("ERROR: Chugimon.equals() method failed when second ids are different");
        return false;
      }
      if (chugi1.compareTo(chugi2) != 1) {
        System.out.println("ERROR: Chugimon.compareTo() method failed when second ids are different");
        return false;
      }
    }
    // checks to see that two chugimons are not equal if their name and second ids
    // are the same but their first id's are different
    // checks to see compareTo returns 1
    {
      Chugimon chugi1 = new Chugimon(4, 22);
      Chugimon chugi2 = new Chugimon(5, 22);
      if (!chugi1.getName().equals(chugi2.getName())) {
        System.out.println(chugi1.getName());
        System.out.println(chugi2.getName());
        System.out.println(
            "ERROR: Chugimon.equals() method failed because the names were not the same when they should have been");
        return false;
      }
      if (chugi1.equals(chugi2)) {
        System.out.println("ERROR: Chugimon.equals() method failed when first ids are different");
        return false;
      }
      if (chugi1.compareTo(chugi2) != -1) {
        System.out.println("ERROR: Chugimon.compareTo() method failed when first ids are different");
        return false;
      }

    }
    // checks to see that two chugimons are equal if their first and second ids are
    // the same
    // checks to see compareTo returns 0
    {
      Chugimon chugi1 = new Chugimon(4, 26);
      Chugimon chugi2 = new Chugimon(4, 26);
      if (!chugi1.equals(chugi2)) {
        System.out.println("ERROR: Chugimon.equals() method failed when names are different");
        return false;
      }
      if (chugi1.compareTo(chugi2) != 0) {
        System.out.println("ERROR: Chugimon.compareTo() method failed when names are different");
        return false;
      }
    }
    // checks to see that two chugimons are not equal if their names are different
    {
      Chugimon chugi1 = new Chugimon(3, 1);
      Chugimon chugi2 = new Chugimon(5, 22);
      if (chugi1.getName() == (chugi2.getName())) {
        System.out.println(
            "ERROR: Chugimon.equals() method failed because the names were the same when they should have been different");
        return false;
      }
      if (chugi1.equals(chugi2)) {
        System.out.println("ERROR: Chugimon.equals() method failed when names are different");
        return false;
      }
      if (chugi1.compareTo(chugi2) != 1) {
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
   *         otherwise
   */
  public static boolean testChugimonToString() {
    {
      Chugimon sample = new Chugimon(3, 1);
      ;
      if (!sample.toString().equals("Venuasaur#3.1")) {
        System.out.println(
            "ERROR: Chugimon.toString() method failed the correct toString should return:" + sample.toString());
        return true;
      }
    }
    return true;
  }

  /**
   * Checks the correctness of the implementation of ChugiTree.isValidBSTHelper()
   * method. This
   * tester should consider at least three scenarios. (1) An empty tree whose root
   * is null should be
   * a valid BST. (2) Consider a valid BST whose height is at least 3. Create the
   * tree using the
   * constructors of the BSTNode and its setters methods, (3) Consider a NON-valid
   * BST where the
   * search order property is violated at at least one internal node.
   * 
   * @return true when this test verifies a correct functionality, and false
   *         otherwise
   */
  public static boolean testIsValidBSTHelper() {
    //tests ChugiTree.isValidBSTHelper() on an empty tree
    if (!(ChugiTree.isValidBSTHelper(null)))
      return false;

    BSTNode<Chugimon> Node1 = new BSTNode<>(new Chugimon(63, 10));
    BSTNode<Chugimon> Node2 = new BSTNode<>(new Chugimon(69, 10));
    BSTNode<Chugimon> Node3 = new BSTNode<>(new Chugimon(104, 10));
    BSTNode<Chugimon> Node4 = new BSTNode<>(new Chugimon(56, 10));
    BSTNode<Chugimon> Node5 = new BSTNode<>(new Chugimon(135, 10));
    BSTNode<Chugimon> Node6 = new BSTNode<>(new Chugimon(145, 10));

    Node5.setRight(Node6);
    Node5.setLeft(Node2);
    Node2.setRight(Node3);
    Node2.setLeft(Node1);
    Node6.setLeft(Node4);
    //tests ChugiTree.isValidBSTHelper() on valid BST of height 3
    if (!(ChugiTree.isValidBSTHelper(Node5)))
      return false;
    Node6.setLeft(null);
    Node2.setRight(Node6);
    Node5.setRight(Node4);
    //tests ChugiTree.isValidBSTHelper() on an invalid BST of height 3
    if (ChugiTree.isValidBSTHelper(Node5))
      return false;


    return true;
  }
  /**
   * Checks the correctness of the implementation of both add() and toString()
   * methods implemented
   * in the ChugiTree class. This unit test considers at least the following
   * scenarios. (1) Create a
   * new empty ChugiTree, and check that its size is 0, it is empty, and that its
   * string
   * representation is an empty string "". (2) try adding one Chugimon and then
   * check that the add()
   * method call returns true, the tree is not empty, its size is 1, and the
   * toString() called on
   * the tree returns the expected output. (3) Try adding another Chugimon which
   * is
   * less than the
   * Chugimon at the root, (4) Try adding a third Chugimon which is greater than
   * the one at the
   * root, (5) Try adding at least two further Chugimons such that one must be
   * added at the left
   * subtree, and the other at the right subtree. For all the above scenarios, and
   * more, double
   * check each time that size() method returns the expected value, the add method
   * call returns
   * true, that the ChugiTree is a valid BST, and that the toString() method
   * returns the expected
   * string representation of the contents of the binary search tree in an
   * increasing order from the
   * smallest to the greatest Chugimon. (6) Try adding a Chugimon already stored
   * in
   * the tree. Make
   * sure that the add() method call returned false, and that the size of the tree
   * did not change.
   * 
   * @return true when this test verifies a correct functionality, and false
   *         otherwise
   */
  public static boolean testAddToStringSize() {
    // Create a new empty ChugiTree, and check that its size is 0, it is empty, and
    // that its string representation is an empty string "".
    try{
    {
      ChugiTree tree = new ChugiTree();
      if (tree.size() != 0) {
        System.out.println("ERROR: ChugiTree.size() method failed when the tree is empty");
        return false;
      }
      if (!tree.isEmpty()) {
        System.out.println("ERROR: ChugiTree.isEmpty() method failed when the tree is empty");
        return false;
      }
      if (!tree.toString().equals("")) {
        System.out.println("ERROR: ChugiTree.toString() method failed when the tree is empty");
        return false;
      }
    }
    // try adding one Chugimon and then check that the add() method call returns
    // true, the tree is not empty, its size is 1, and the toString() called on the
    // tree returns the expected output.
    {
      ChugiTree tree = new ChugiTree();
      Chugimon chugi = new Chugimon(3, 1);
      if (!tree.add(chugi)) {
        System.out.println("ERROR: ChugiTree.add() method failed when adding a Chugimon to an empty tree");
        return false;
      }
      if (tree.size() != 1) {
        System.out.println("ERROR: ChugiTree.size() method failed when the tree has one Chugimon");
        return false;
      }
      if (tree.isEmpty()) {
        System.out.println("ERROR: ChugiTree.isEmpty() method failed when the tree has one Chugimon");
        return false;
      }
      if (!tree.toString().equals("Venuasaur#3.1")) {
        System.out.println("ERROR: ChugiTree.toString() method failed when the tree has one Chugimon");
        return false;
      }
    }
    // Try adding another Chugimon which is less than the Chugimon at the root
    {
      ChugiTree tree = new ChugiTree();
      Chugimon chugi = new Chugimon(3, 1);
      Chugimon chugi2 = new Chugimon(2, 1);
      tree.add(chugi);
      if (!tree.add(chugi2)) {
        System.out.println("ERROR: ChugiTree.add() method failed when adding a Chugimon to an empty tree");
        return false;
      }
      if (tree.size() != 2) {
        System.out.println("ERROR: ChugiTree.size() method failed when the tree has one Chugimon");
        return false;
      }
      if (tree.isEmpty()) {
        System.out.println("ERROR: ChugiTree.isEmpty() method failed when the tree has one Chugimon");
        return false;
      }
      if (!tree.toString().equals("Venuasaur#2.1Venuasaur#3.1")) {
        System.out.println("ERROR: ChugiTree.toString() method failed when the tree has one Chugimon");
        return false;
      }
    }
    // Try adding a third Chugimon which is greater than the one at the root
    {
      ChugiTree tree = new ChugiTree();
      Chugimon chugi = new Chugimon(3, 1);
      Chugimon chugi2 = new Chugimon(2, 1);
      Chugimon chugi3 = new Chugimon(6, 5);
      tree.add(chugi);
      tree.add(chugi2);
      if (!tree.add(chugi3)) {
        System.out.println("ERROR: ChugiTree.add() method failed when adding a Chugimon to an empty tree");
        return false;
      }
      if (tree.size() != 3) {
        System.out.println("ERROR: ChugiTree.size() method failed when the tree has one Chugimon");
        return false;
      }
      if (tree.isEmpty()) {
        System.out.println("ERROR: ChugiTree.isEmpty() method failed when the tree has one Chugimon");
        return false;
      }
      if (!tree.toString().equals("Venuasaur#2.1Venuasaur#3.1Venuasaur#4.1")) {
        System.out.println("ERROR: ChugiTree.toString() method failed when the tree has one Chugimon");
        return false;
      }
    }
    // Try adding at least two further Chugimons such that one must be added at the
    // left subtree, and the other at the right subtree. For all the above
    // scenarios, and more, double check each time that size() method returns the
    // expected value, the add method call returns true, that the ChugiTree is a
    // valid BST, and that the toString() method returns the expected string
    // representation of the contents of the binary search tree in an increasing
    // order from the smallest to the greatest Chugimon.
    {
      ChugiTree tree = new ChugiTree();
      Chugimon chugi = new Chugimon(11, 2);
      Chugimon chugi2 = new Chugimon(2, 11);
      Chugimon chugi3 = new Chugimon(8, 4);
      Chugimon chugi4 = new Chugimon(6, 5);
      Chugimon chugi5 = new Chugimon(3, 12);
      tree.add(chugi);
      tree.add(chugi2);
      tree.add(chugi3);
      tree.add(chugi4);
      if (!tree.add(chugi5)) {
        System.out.println("ERROR: ChugiTree.add() method failed when adding a Chugimon to an empty tree");
        return false;
      }
      if (tree.size() != 5) {
        System.out.println("ERROR: ChugiTree.size() method failed when the tree has one Chugimon");
        return false;
      }
      if (tree.isEmpty()) {
        System.out.println("ERROR: ChugiTree.isEmpty() method failed when the tree has one Chugimon");
        return false;
      }
      if (!tree.toString().equals("Venuasaur#1.1Venuasaur#2.1Venuasaur#3.1Venuasaur#4.1Venuasaur#5.1")) {
        System.out.println("ERROR: ChugiTree.toString() method failed when the tree has one Chugimon");
        return false;
      }
    }
    // Try adding a Chugimon already stored in the tree. Make sure that the add()
    // method call returned false, and that the size of the tree did not change.
    {
      ChugiTree tree = new ChugiTree();
      Chugimon chugi = new Chugimon(3, 1);
      Chugimon chugi2 = new Chugimon(2, 1);
      Chugimon chugi3 = new Chugimon(4, 1);
      Chugimon chugi4 = new Chugimon(1, 1);
      Chugimon chugi5 = new Chugimon(5, 1);
      tree.add(chugi);
      tree.add(chugi2);
      tree.add(chugi3);
      tree.add(chugi4);
      tree.add(chugi5);
      if (tree.add(chugi5)) {
        System.out.println("ERROR: ChugiTree.add() method failed when adding a Chugimon to an empty tree");
        return false;
      }
      if (tree.size() != 5) {
        System.out.println("ERROR: ChugiTree.size() method failed when the tree has one Chugimon");
        return false;
      }
      if (tree.isEmpty()) {
        System.out.println("ERROR: ChugiTree.isEmpty() method failed when the tree has one Chugimon");
        return false;
      }
      if (!tree.toString().equals("Venuasaur#1.1Venuasaur#2.1Venuasaur#3.1Venuasaur#4.1Venuasaur#5.1")) {
        System.out.println("ERROR: ChugiTree.toString() method failed when the tree has one Chugimon");
        return false;
      }
    }
    {
      ChugiTree tree = new ChugiTree();
      Chugimon chugi = null;
      try{
        tree.add(chugi);
        System.out.println("ERROR: ChugiTree.add() method failed to catch IllegalArgumentException");
      }catch(IllegalArgumentException e){}
    }
  }catch (Exception e) {
    System.out.println("ERROR: ChugiTree.add() method failed to catch IllegalArgumentException");
    return false;
  }
    return true;
  }
  /**
   * This method checks mainly for the correctness of the ChugiTree.lookup()
   * method. It must
   * consider at least the following test scenarios. (1) Create a new ChugiTree.
   * Then, check that
   * calling the lookup() method on an empty ChugiTree returns false. (2) Consider
   * a ChugiTree of
   * height 3 which contains at least 5 Chugimons. Then, try to call lookup()
   * method to search for a
   * Chugimon having a match at the root of the tree. (3) Then, search for a
   * Chugimon at the right
   * and left subtrees at different levels considering successful and unsuccessful
   * search
   * operations. Make sure that the lookup() method returns the expected output
   * for
   * every method
   * call.
   * 
   * @return true when this test verifies a correct functionality, and false
   *         otherwise
   */
  public static boolean testLookup() {
    // Create a new ChugiTree. Then, check that calling the lookup() method on an
    // empty ChugiTree returns false.
    {
      ChugiTree tree = new ChugiTree();
      Chugimon one = new Chugimon(2, 11);
      if (tree.lookup(2, 11) == one) {
        System.out.println("ERROR: ChugiTree.lookup() method failed because it returned true when the tree was empty");
        return false;
      }
    }
    // Consider a ChugiTree of height 3 which contains at least 5 Chugimons. Then,
    // try to call
    // lookup() method to search for a Chugimon having a match at the root of the
    // tree.
    {
      ChugiTree tree = new ChugiTree();
      Chugimon one = new Chugimon(2, 11);
      Chugimon two = new Chugimon(6, 5);
      Chugimon three = new Chugimon(3, 12);
      Chugimon four = new Chugimon(11, 2);
      Chugimon five = new Chugimon(8, 4);
      tree.add(three);
      tree.add(two);
      tree.add(four);
      tree.add(one);
      tree.add(five);
      if (tree.lookup(2, 11) != one) {
        System.out
            .println("ERROR: ChugiTree.lookup() method failed because it returned false when the tree was not empty");
        return false;
      }
    }
    // Search for a Chugimon at the right and left subtrees at different levels
    // considering successful and
    // unsuccessful search
    {
      ChugiTree tree = new ChugiTree();
      Chugimon one = new Chugimon(2, 11);
      Chugimon two = new Chugimon(6, 5);
      Chugimon three = new Chugimon(3, 12);
      Chugimon four = new Chugimon(11, 2);
      Chugimon five = new Chugimon(8, 4);
      Chugimon six = new Chugimon(22, 9);
      Chugimon seven = new Chugimon(23, 5);
      Chugimon eight = new Chugimon(49, 7);
      Chugimon nine = new Chugimon(10, 9);
      Chugimon ten = new Chugimon(16, 10);
      tree.add(one);
      tree.add(two);
      tree.add(three);
      tree.add(four);
      tree.add(five);
      if (tree.lookup(2, 11) != one) {
        System.out
            .println("ERROR: ChugiTree.lookup() method failed because it returned false when the tree was not empty");
        return false;
      }
      if (tree.lookup(6, 5) != two) {
        System.out
            .println("ERROR: ChugiTree.lookup() method failed because it returned false when the tree was not empty");
        return false;
      }
      if (tree.lookup(3, 12) != three) {
        System.out
            .println("ERROR: ChugiTree.lookup() method failed because it returned false when the tree was not empty");
        return false;
      }
      if (tree.lookup(11, 2) != four) {
        System.out
            .println("ERROR: ChugiTree.lookup() method failed because it returned false when the tree was not empty");
        return false;
      }
      if (tree.lookup(8, 4) != five) {
        System.out
            .println("ERROR: ChugiTree.lookup() method failed because it returned false when the tree was not empty");
        return false;
      }
      if (tree.lookup(22, 9) == six) {
        System.out
            .println("ERROR: ChugiTree.lookup() method failed because it returned true when the tree was not empty");
        return false;
      }
      if (tree.lookup(23, 5) == seven) {
        System.out
            .println("ERROR: ChugiTree.lookup() method failed because it returned true when the tree was not empty");
        return false;
      }
      if (tree.lookup(49, 7) == eight) {
        System.out
            .println("ERROR: ChugiTree.lookup() method failed because it returned true when the tree was not empty");
        return false;
      }
      if (tree.lookup(10, 9) == nine) {
        System.out
            .println("ERROR: ChugiTree.lookup() method failed because it returned true when the tree was not empty");
        return false;
      }
      if (tree.lookup(16, 14) == ten) {
        System.out
            .println("ERROR: ChugiTree.lookup() method failed because it returned true when the tree was not empty");
        return false;
      }
    }
    return true;
  }

  /**
   * Checks for the correctness of ChugiTree.countType() method.
   * 
   * @return true when this test verifies a correct functionality, and false
   *         otherwise
   */
  public static boolean testCountType() {
    ChugiTree test = new ChugiTree();

    test.add(new Chugimon(1, 2)); //grass - poison B
    test.add(new Chugimon(4, 5)); //grass - none Cm
    test.add(new Chugimon(6, 7)); //fire - flying Ci
    test.add(new Chugimon(24, 10)); //poison - none A
    test.add(new Chugimon(11, 13)); //bug - flying D

    System.out.println(test.countType(ChugiType.GRASS));
    //tests with primary types with a none secondary
    if (test.countType(ChugiType.GRASS) != 2)
      return true;
    System.out.println("check1");
    //tests with type in both primary and secondary
    if (test.countType(ChugiType.POISON) != 2)
      return true;
    System.out.println("check1");
    //tests with type not in test
    if (test.countType(ChugiType.WATER) != 0)
      return false;


    return true;
  }

  /**
   * Checks for the correctness of ChugiTree.height() method. This test must
   * consider several
   * scenarios such as, (1) ensures that the height of an empty Chugimon tree is
   * zero. (2) ensures
   * that the height of a tree which consists of only one node is 1. (3) ensures
   * that the height of
   * a ChugiTree with four levels for instance, is 4.
   * 
   * @return true when this test verifies a correct functionality, and false
   *         otherwise
   */
  public static boolean testHeight() {
    // ensures that the height of an empty Chugimon tree is zero.
    {
      ChugiTree tree = new ChugiTree();
      if (tree.height() != 0) {
        System.out
            .println("ERROR: ChugiTree.height() method failed because it returned false when the tree was not empty");
        return false;
      }
    }
    // ensures that the height of a tree which consists of only one node is 1.
    {
      ChugiTree tree = new ChugiTree();
      Chugimon one = new Chugimon(1, 1);
      tree.add(one);
      if (tree.height() != 1) {
        System.out
            .println("ERROR: ChugiTree.height() method failed because it returned false when the tree was not empty");
        return false;
      }
    }
    // ensures that the height of a ChugiTree with four levels for instance, is 4.
    {
      ChugiTree tree = new ChugiTree();
      Chugimon one = new Chugimon(9, 2);
      Chugimon two = new Chugimon(4, 3);
      Chugimon three = new Chugimon(23, 4);
      Chugimon four = new Chugimon(14, 5);
      tree.add(one);
      tree.add(two);
      tree.add(three);
      tree.add(four);
      if (tree.height() != 4) {
        System.out
            .println("ERROR: ChugiTree.height() method failed because it returned false when the tree was not empty");
        return false;
      }
    }
    return true;
  }

  /**
   * Checks for the correctness of ChugiTree.getFirst() method.
   * 
   * @return true when this test verifies a correct functionality, and false
   *         otherwise
   */
  public static boolean testGetFirst() {
    try {
      {
        ChugiTree tree = new ChugiTree();
        if (tree.getFirst() != null) {
          System.out.println(
              "ERROR: ChugiTree.getFirst() method failed because it returned a chugimon when the tree was empty");
          return false;
        }
        Chugimon one = new Chugimon(2, 11);
        Chugimon two = new Chugimon(6, 5);
        Chugimon three = new Chugimon(3, 12);
        Chugimon four = new Chugimon(11, 2);
        Chugimon five = new Chugimon(8, 4);
        tree.add(one);
        tree.add(two);
        tree.add(three);
        tree.add(four);
        tree.add(five);
        if (!tree.getFirst().equals(two)) {
          System.out.println(
              "ERROR: ChugiTree.getFirst() method failed because it returned the wrong chugimon that wasn't the first one");

          return false;
        }
        return true;
      }
    } catch (Exception e) {
      System.out.println("Your tester failed because it encountered an unexpected exception");
      return false;
    }
  }

  /**
   * Checks for the correctness of ChugiTree.getLast() method.
   * 
   * @return true when this test verifies a correct functionality, and false
   *         otherwise
   */
  public static boolean testGetLast() {
    // checks to see get next works when there is a next
    {
      ChugiTree tree = new ChugiTree();
      Chugimon one = new Chugimon(2, 11);
      Chugimon two = new Chugimon(6, 5);
      Chugimon three = new Chugimon(3, 12);
      Chugimon four = new Chugimon(11, 2);
      Chugimon five = new Chugimon(8, 4);
      tree.add(one);
      tree.add(two);
      tree.add(three);
      tree.add(four);
      tree.add(five);
      if (tree.getLast() != three) {
        System.out.println(
            "ERROR: ChugiTree.getLast() method failed because it returned the wrong chugimon that wasn't the last one");
        return false;
      }
    }
    // checks to see get next works when there is no next
    {
      ChugiTree tree = new ChugiTree();
      if (tree.getLast() != null) {
        System.out
            .println("ERROR: ChugiTree.getLast() method failed because it returned a chugimon when the tree was empty");
        return false;
      }
    }
    return true;
  }

  /**
   * Checks for the correctness of ChugiTree.delete() method. This test must
   * consider at least 3
   * test scenarios. (1) Remove a Chugimon that is at leaf node (2) Remove a
   * Chugimon at non-leaf
   * node. For each of these scenarios, check that the size of the tree was
   * decremented by one and
   * that the resulting ChugiTree is a valid BST, (3) ensures that the
   * ChugiTree.delete() method
   * returns false when called on an Chugimon that is not present in the BST.
   * 
   * @return true when this test verifies a correct functionality, and false
   *         otherwise
   */
  public static boolean testDelete() {
    try{
    //Remove a Chugimon that is at leaf node 
    {
      ChugiTree tree = new ChugiTree();
      Chugimon one = new Chugimon(2, 11);
      Chugimon two = new Chugimon(6, 5);
      Chugimon three = new Chugimon(3, 12);
      Chugimon four = new Chugimon(11, 2);
      Chugimon five = new Chugimon(8, 4);
      tree.add(one);
      tree.add(two);
      tree.add(three);
      tree.add(four);
      tree.add(five);
      tree.delete(four);
      if (tree.size() != 4||!tree.isValidBST()) {
        System.out.println(
            "ERROR: ChugiTree.delete() method failed because it did not decrement the size of the tree when a chugimon was deleted");
        return false;
      }
    }
    //Remove a Chugimon at non-leaf. For each of these scenarios, check that the size of the tree was decremented by one and that the resulting ChugiTree is a valid BST
    {
      ChugiTree tree = new ChugiTree();
      Chugimon one = new Chugimon(2, 11);
      Chugimon two = new Chugimon(6, 5);
      Chugimon three = new Chugimon(3, 12);
      Chugimon four = new Chugimon(11, 2);
      Chugimon five = new Chugimon(8, 4);
      tree.add(one);
      tree.add(two);
      tree.add(three);
      tree.add(four);
      tree.add(five);
      tree.delete(two);
      if (tree.size() != 4||!tree.isValidBST()) {
        System.out.println(
            "ERROR: ChugiTree.delete() method failed because it did not decrement the size of the tree when a non-leaf chugimon was deleted");
        return false;
      }
    }
    //ensures that the ChugiTree.delete() method returns false when called on an Chugimon that is not present in the BST.
    {
      ChugiTree tree = new ChugiTree();
      Chugimon one = new Chugimon(2, 11);
      Chugimon two = new Chugimon(6, 5);
      Chugimon three = new Chugimon(3, 12);
      Chugimon four = new Chugimon(11, 2);
      Chugimon five = new Chugimon(8, 4);
      tree.add(one);
      tree.add(two);
      tree.add(three);
      tree.add(four);
      tree.add(five);
      try{
      if (tree.delete(new Chugimon(1, 1))) {
        System.out.println(
            "ERROR: ChugiTree.delete() method failed because it returned true when it should have returned false");
      }
      }catch(IllegalArgumentException e){}
    }
    }catch(Exception e){
      System.out.println("Your tester failed because it encountered an unexpected exception");
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of ChugiTree.next() method.
   * 
   * @return true when this test verifies a correct functionality, and false
   *         otherwise
   */
  public static boolean testNext() {
    {
      try {
        ChugiTree tree = new ChugiTree();
        Chugimon one = new Chugimon(2, 11);
        Chugimon two = new Chugimon(6, 5);
        Chugimon three = new Chugimon(3, 12);
        Chugimon four = new Chugimon(11, 2);
        Chugimon five = new Chugimon(8, 4);
        Chugimon six = new Chugimon(16, 10);
        tree.add(one);
        tree.add(two);
        tree.add(three);
        tree.add(four);
        tree.add(five);
        if (tree.next(four) != five) {
          System.out.println(
              "ERROR: ChugiTree.next() method failed because it returned the wrong chugimon that wasn't the next one");
          return false;
        }
        // next of last chugimon should return NoSuchElelementException
        try {
          tree.next(three);
          System.out.println(
              "ERROR: ChugiTree.next() method failed because it didn't throw the exception NoSuchElementException");
        } catch (NoSuchElementException e) {
        }

        // next of chugimon not in tree should throw the exception
        // IllegalArgumentException
        try {
          tree.next(six);
          System.out.println(
              "ERROR: ChugiTree.next() method failed because it didn't throw the exception IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
      }

      catch (Exception e) {
        System.out.println("testNext() returned the unexpected exception" + e);
        return false;
      }
      return true;
    }
  }

  /**
   * Checks for the correctness of ChugiTree.previous() method.
   * 
   * @return true when this test verifies a correct functionality, and false
   *         otherwise
   */
  public static boolean testPrevious() {
    {
      ChugiTree tree = new ChugiTree();
      Chugimon one = new Chugimon(2, 11);
      Chugimon two = new Chugimon(6, 5);
      Chugimon three = new Chugimon(3, 12);
      Chugimon four = new Chugimon(11, 2);
      Chugimon five = new Chugimon(8, 4);
      Chugimon six = new Chugimon(16, 10);
      tree.add(one);
      tree.add(two);
      tree.add(three);
      tree.add(four);
      tree.add(five);
      if (tree.previous(five) != four) {
        System.out.println(
            "ERROR: ChugiTree.previous() method failed because it returned the wrong chugimon that wasn't the previous one");
        return false;
      }
      // previous of first chugimon should be null
      if (tree.previous(two) != null) {
        System.out.println(
            "ERROR: ChugiTree.previous() method failed because it returned the wrong chugimon that wasn't the previous one");
        return false;
      }
      try {
        tree.previous(two);
        System.out.println(
            "ERROR: ChugiTree.next() method failed because it didn't throw the exception NoSuchElementException");
      } catch (NoSuchElementException e) {
      }
      try {
        tree.previous(six);
        System.out.println(
            "ERROR: ChugiTree.next() method failed because it didn't throw the exception IllegalArgumentException");
      } catch (IllegalArgumentException e) {
      }
    }
    return true;
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

// ChugiTree.java - deleteChugimonHelper()
// ChugidexTester - testCountType()
// ChugidexTester - testIsValidBSTHelper()
