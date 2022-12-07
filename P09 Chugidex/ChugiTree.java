//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    ChugiTree.java
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
 * This class implements a ChugidexStorage as a Binary Search Tree.
 * 
 * Notes: 1) You may NOT use any arrays or Collections objects (ArrayLists, etc)
 * in this class. 2)
 * You may NOT use any loops (for, while, etc) in this class. Recursive
 * strategies only.
 *
 */
public class ChugiTree implements ChugidexStorage {
  /**
   * The root of this ChugiTree. Set to null when tree is empty.
   */
  private BSTNode<Chugimon> root;
  /**
   * The size of this ChugiTree (total number of Chugimon stored in this BST)
   */
  private static int size;
  /**
   * Constructor for Chugitree. Should set size to 0 and root to null.
   */
  public ChugiTree() {
    size=0;
    root=null;
  }
  /**
   * Getter method for the Chugimon at the root of this BST.
   * 
   * @return the root of the BST.
   */
  public Chugimon getRoot() {
    return root.getData(); 
  }
  /**
   * A method for determining whether this ChugiTree is a valid BST. In
   * order to be a valid BST, the following must be true: For every internal
   * (non-leaf) node X of a binary tree, all the values in the node's left subtree
   * are less than the value in X, and all the values in the node's right subtree
   * are greater than the value in X.
   * 
   * @return true if this ChugiTree is a valid BST, false otherwise
   */
  public boolean isValidBST() {
    return isValidBSTHelper(root);
  }
  /**
   * A helper method for determining whether this ChugiTree is a valid BST. In
   * order to be a valid BST, the following must be true: For every internal
   * (non-leaf) node X of a binary tree, all the values in the node's left subtree
   * are less than the value in X, and all the values in the node's right subtree
   * are greater than the value in X.
   * 
   * @param node The root of the BST.
   * @return true if the binary tree rooted at node is a BST, false otherwise
   */
  public static boolean isValidBSTHelper(BSTNode<Chugimon> node) {
    if(node==null) {
      return true;
    }
    if(node.getLeft()!=null && getMax(node.getLeft()).compareTo(node.getData())>0) {
      return false;
    }
    if(node.getRight()!=null && getMin(node.getRight()).compareTo(node.getData())<0) {
      return false;
    }
    boolean leftChugimon = isValidBSTHelper(node.getLeft());
    boolean rightChugimon = isValidBSTHelper(node.getRight());
    return leftChugimon && rightChugimon;
    }
    private static Chugimon getMax(BSTNode<Chugimon> node) {
      if(node.getRight()==null) {
        return node.getData();
      }
      return getMax(node.getRight());
    }
    private static Chugimon getMin(BSTNode<Chugimon> node) {
      if(node.getLeft()==null) {
        return node.getData();
      }
      return getMin(node.getLeft());
    }
  /**
   * Checks whether this ChugiTree is empty or not
   * 
   * @return true if this tree is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return(size==0);
  }
  /**
   * Gets the size of this ChugiTree
   * 
   * @return the total number of Chugimons stored in this tree
   */
  @Override
  public int size() {
    return size; 
  }
  /**
   * Returns a String representation of all the Chugimons stored within this
   * ChugiTree in the
   * increasing order with respect to the result of Chugimon.compareTo() method.
   * The string should
   * be a comma-separated list of all the Chugimon toString() values. No spaces
   * are expected to be
   * in the resulting string. No comma should be at the end of the resulting
   * string. For instance,
   * 
   * "nameOne#12.25,nameTwo#12.56,nameTwo#89.27"
   * 
   * @return a string containing all of the Chugimon, in the increasing order.
   *         Returns an empty
   *         string "" if this BST is empty.
   * 
   */
  @Override
  public String toString() {
    return toStringHelper(root);
  }
  /**
   * Recursive helper method which returns a String representation of the
   * ChugiTree rooted at node. An example of the String representation of the
   * contents of a ChugiTree storing three Chugimons is provided in the
   * description of the above toString() method.
   * 
   * @param node references the root of a subtree
   * @return a String representation of all the Chugimons stored in the sub-tree
   *         rooted at node in
   *         increasing order. Returns an empty String "" if current is null.
   */
  protected static String toStringHelper(BSTNode<Chugimon> node) {
    if(node==null) {
      return "";
    }
    String left = toStringHelper(node.getLeft());
    String right = toStringHelper(node.getRight());
    if(left.equals("") && right.equals("")) {
      return node.getData().toString();
    }
    if(left.equals("")) {
      return node.getData().toString()+","+right;
    }
    if(right.equals("")) {
      return left+","+node.getData().toString();
    }
    return left+","+node.getData().toString()+","+right;
  }
  /**
   * Adds a new Chugimon to this ChugiTree. Duplicate Chugimons are NOT allowed.
   * 
   * @param newChugimon Chugimon to add to this ChugiTree
   * @return true if if the newChugimon was successfully added to the ChugiTree,
   *         false if a match with newChugimon is already present in the tree.
   * @throws IllegalArgumentException with a descriptive error message if
   *                                  newChugimon is null.
   */
  @Override
  public boolean add(Chugimon newChugimon) {
    if(newChugimon==null) {
      throw new IllegalArgumentException("Chugimon cannot be null");
    }
    if(root==null) {
      root=new BSTNode<Chugimon>(newChugimon);
      size++;
      return true;
    }
    return addHelper(newChugimon,root);
  }
  /**
   * Recursive helper method to insert a new Chugimon to a Pokedex rooted at node.
   * 
   * @param node        The "root" of the subtree we are inserting the new
   *                    Chugimon into.
   * @param newChugimon The Chugimon to be added to a BST rooted at node. We
   *                    assume that newChugimon is NOT null.
   * @return true if the newChugimon was successfully added to the ChugiTree,
   *         false if a match with
   *         newChugimon is already present in the subtree rooted at node.
   */
  protected static boolean addHelper(Chugimon newChugimon, BSTNode<Chugimon> node) 
{
    if(newChugimon.compareTo(node.getData())==0) {
      return false;
    }
    if(newChugimon.compareTo(node.getData())<0) {
      if(node.getLeft()==null) {
        node.setLeft(new BSTNode<Chugimon>(newChugimon));
        size++;
        return true;
      }
      return addHelper(newChugimon,node.getLeft());
    }
    if(newChugimon.compareTo(node.getData())>0) {
      if(node.getRight()==null) {
        node.setRight(new BSTNode<Chugimon>(newChugimon));
        size++;
        return true;
      }
      return addHelper(newChugimon,node.getRight());
    }
    return false;
  }
  /**
   * Searches a Chugimon given its first and second identifiers.
   * 
   * @param firstId  First identifier of the Chugimon to find
   * @param secondId Second identifier of the Chugimon to find
   * @return the matching Chugimon if match found, null otherwise.
   */
  @Override
  public Chugimon lookup(int firstId, int secondId) {
    return lookupHelper(new Chugimon(firstId,secondId),root);
  }
  /**
   * Recursive helper method to search and return a match with a given Chugimon in
   * the subtree rooted at node, if present.
   * 
   * @param toFind a Chugimon to be searched in the BST rooted at node. We assume
   *               that toFind is NOT null.
   * @param node   "root" of the subtree we are checking whether it contains a
   *               match to target.
   * @return a reference to the matching Chugimon if found, null otherwise.
   */
  protected static Chugimon lookupHelper(Chugimon toFind, BSTNode<Chugimon> node) {
    if(node==null) {
      return null;
    }
    if(toFind.compareTo(node.getData())==0) {
      return node.getData();
    }
    if(toFind.compareTo(node.getData())<0) {
      return lookupHelper(toFind,node.getLeft());
    }
    if(toFind.compareTo(node.getData())>0) {
      return lookupHelper(toFind,node.getRight());
    }
    return null;
  }
  /**
   * Computes and returns the height of this BST, counting the number of NODES
   * from root to the deepest leaf.
   * 
   * @return the height of this Binary Search Tree
   */
  public int height() {
    return heightHelper(root);
  }
  /**
   * Recursive helper method that computes the height of the subtree rooted at
   * node counting the number of nodes and NOT the number of edges from node to
   * the deepest leaf
   * 
   * @param node root of a subtree
   * @return height of the subtree rooted at node
   */
  protected static int heightHelper(BSTNode<Chugimon> node) {
    if(node==null) {
      return 0;
    }
    int left=heightHelper(node.getLeft());
    int right=heightHelper(node.getRight());
    if(left>right) {
      return left+1;
    }
    return right+1;
  }
  /**
   * Recursive method to find and return the first Chugimon, in the increasing
   * order, within this ChugiTree (meaning the smallest element stored in the
   * tree).
   * 
   * @return the first element in the increasing order of this BST, and null if
   *         the tree is empty.
   */
  @Override
  public Chugimon getFirst() {
    return getFirstHelper(root);
  }
  /**
   * Recursive helper method for getFirst().
   * 
   * @param root the node from which to find the the minimum node
   * @return the minimum element in the increasing order from the node <b>root</b>
   */
  protected static Chugimon getFirstHelper(BSTNode<Chugimon> root) {
    if(root==null) {
      return null;
    }
    if(root.getLeft()==null) {
      return root.getData();
    }
    return getFirstHelper(root.getLeft());
  }
  /**
   * Recursive method to find and return the last Chugimon, in the increasing
   * order, within this ChugiTree (meaning the greatest element stored in the
   * tree).
   * 
   * @return the last element in the increasing order of this BST, and null if the
   *         tree is empty.
   */
  @Override
  public Chugimon getLast() {
    return getLastHelper(root);
  }
  /**
   * Recursive helper method for getLast().
   * 
   * @param root the node from which to find the the maximum node
   * @return the maximum element in the increasing order from the node <b>root</b>
   */
  protected static Chugimon getLastHelper(BSTNode<Chugimon> root) {
    if(root==null) {
      return null;
    }
    if(root.getRight()==null) {
      return root.getData();
    }
    return getLastHelper(root.getRight());
  }
  /**
   * Recursive method to get the number of Chugimon with a primary or secondary
   * type of the specified type, stored in this ChugiTree.
   * 
   * @param chugiType the type of Chugimons to count. We assume that chugiType is
   *                  NOT null.
   * @return the number of all the Chugimon objects with a primary or secondary
   *         type of the
   *         specified type stored in this ChugiTree.
   */
  public int countType(ChugiType chugiType) {
    return countTypeHelper(chugiType,root);
  }
  private static int countTypeHelper(ChugiType chugiType, BSTNode<Chugimon> node) {
    if(node==null) {
      return 0;
    }
    int count=0;
    if(node.getData().getPrimaryType()==chugiType||node.getData().getSecondaryType()==chugiType) {
      count++;
    }
    return count+countTypeHelper(chugiType,node.getLeft())+countTypeHelper(chugiType,node.getRight());
  }
  /**
   * Finds and returns the in-order successor of a specified Chugimon in this
   * ChugiTree
   * 
   * @param chugi the Chugimon to find its successor
   * @return the in-order successor of a specified Chugimon in this ChugiTree
   * 
   * @throws IllegalArgumentException with a descriptive error message if
   *                                  <b>chugi</b> is null
   * @throws NoSuchElementException   with a descriptive error message if the
   *                                  Chugimon provided as input has no in-order
   *                                  successor in this ChugiTree.
   */
  @Override
  public Chugimon next(Chugimon chugi) {
    if(chugi==null) {
      throw new IllegalArgumentException("Chugimon is null");
    }
    BSTNode Nodenull = new BSTNode("");
    Chugimon chugimonster = nextHelper(chugi, root, Nodenull);
    if(chugimonster==null) {
      throw new NoSuchElementException("Chugimon is not in the tree");
    }
    return chugimonster;
  }
  /**
   * Recursive helper method to find and return the next Chugimon in the tree
   * rooted at node.
   * 
   * @param chugi a Chugimon to search its in-order successor. We assume that
   *              <b>chugi</b> is NOT
   *              null.
   * @param node  "root" of a subtree storing Chugimon objects
   * @param next  a BSTNode which stores a potentional candidate for next node
   * @return the next Chugimon in the tree rooted at node.
   * @throws NoSuchElementException with a descriptive error message if the
   *                                Chugimon provided as input has no in-order
   *                                successor in the subtree
   *                                rooted at node.
   */
  protected static Chugimon nextHelper(Chugimon chugi, BSTNode<Chugimon> node, BSTNode next) {
    if(node==null) {
      throw new NoSuchElementException("Chugimon is not in the tree");
    }
    if(node==null) {
      return null;
    }
    if(chugi.equals(node.getData())){
      if(node.getRight()!=null) {
        return getFirstHelper(node.getRight());
      }
      else {
        return null;
      }
    }
    if(chugi.compareTo(node.getData())<0) {
      next=node;
      Chugimon chugimonster = nextHelper(chugi,node.getLeft(),next);
      if(chugimonster==null) {
        return (Chugimon) node.getData();
      }else{
        return chugimonster;
      }
    }
    if(chugi.compareTo(node.getData())>0) {
      next=node;
      Chugimon chugimonster = nextHelper(chugi,node.getLeft(),next);
      if(chugimonster==null) {
        return (Chugimon) next.getData();
      }else{
        return chugimonster;
      }
    }
    return null;
  }
  /**
   * Finds and returns the in-order predecessor of a specified Chugimon in this
   * ChugiTree
   * 
   * @param chugi the Chugimon to find its predecessor
   * @return the in-order predecessor of a specified Chugimon in this ChugiTree.
   * 
   * @throws IllegalArgumentException with a descriptive error message if
   *                                  <b>chugi</b> is null
   * @throws NoSuchElementException   if there is no Chugimon directly before the
   *                                  provided Chugimon
   */
  @Override
  public Chugimon previous(Chugimon chugi) {
    return previousHelper(chugi, root, null);
  }
  /**
   * Recursive helper method to find and return the previous Chugimon in the tree
   * rooted at node.
   * 
   * @param chugi a Chugimon to search its in-order predecessor. We assume that
   *              <b>chugi</b> is NOT
   *              null.
   * @param node  "root" of a subtree storing Chugimon objects
   * @param prev  a BSTNode which stores a potentional candidate for previous node
   * @return the previous Chugimon in the tree rooted at node.
   * @throws NoSuchElementException with a descriptive error message if the
   *                                Chugimon provided as input has no in-order
   *                                predecessor in the subtree rooted at node.
   */
  protected static Chugimon previousHelper(Chugimon chugi, BSTNode<Chugimon> node,BSTNode<Chugimon> prev) {
    // Hint: you will need to use getLastHelper in this method. Below are more
    // hints.
    // base case: node is null
    // recursive cases:
    // (1) if chugi is found and if the left child is not null, use getLastHelper to
    // find and return
    // the previous chugimon. It should be the right most child of the left subtree
    // (2) if chugi is greater than the Chugimon at node, set prev as the root node
    // and search
    // recursively into the right subtree
    if(node==null) {
      throw new NoSuchElementException("Chugimon is not in the tree");
    }
    if(chugi.compareTo(node.getData())==0) {
      if(node.getLeft()!=null) {
        return getLastHelper(node.getLeft());
      }
      else {
        if(prev==null) {
          throw new NoSuchElementException("Chugimon is not in the tree");
        }
        return prev.getData();
      }
    }
    if(chugi.compareTo(node.getData())<0) {
      return previousHelper(chugi,node.getLeft(),prev);
    }
    return previousHelper(chugi,node.getRight(),node);
  }
  /**
   * Deletes a specific Chugimon from this ChugiTree.
   * 
   * @param chugi the Chugimon to delete
   * @return true if the specific Chugimon is successfully deleted, false if no
   *         match found with any
   *         Chugimon in this tree.
   * @throws IllegalArgumentException with a descriptive error message if
   *                                  <b>chugi</b> is null
   */
  @Override
  public boolean delete(Chugimon chugi) {
    if(chugi==null) {
      throw new IllegalArgumentException("Chugimon is null");
    }
    if(lookup(chugi.getFirstID(),chugi.getSecondID())==null) {
      return false;
    }
    root=deleteChugimonHelper(chugi,root);
    return true;
  }
  /**
   * Recursive helper method to search and delete a specific Chugimon from the BST
   * rooted at node
   * 
   * @param target a reference to a Chugimon to delete from the BST rooted at
   *               node. We assume that target is NOT null.
   * @param node   "root" of the subtree we are checking whether it contains a
   *               match with the target Chugimon.
   * 
   * 
   * @return the new "root" of the subtree we are checking after trying to remove
   *         target
   * @throws NoSuchElementException with a descriptive error message if there is
   *                                no Chugimon matching target in the BST rooted
   *                                at <b>node</b>
   */
  protected static BSTNode<Chugimon> deleteChugimonHelper(Chugimon target, BSTNode<Chugimon> node) {
    // TODO complete the implementation of this method. Problem decomposition and
    // hints are provided in the comments below
    // if node == null (empty subtree rooted at node), no match found, throw an
    // exception
    // Compare the target to the data at node and proceed accordingly
    // Recurse on the left or right subtree with respect to the comparison result
    // Make sure to use the output of the recursive call to appropriately set the
    // left or the right child of node accordingly
    // if match with target found, three cases should be considered. Feel free to
    // organize the order of these cases at your choice.
    // Case 1: node may be a leaf (has no children), set node to null.
    // Case 2: node may have only one child, set node to that child (whether left or
    // right child)
    // Case 3: node may have two children,
    // Replace node with a new BSTNode whose data field value is the successor of
    // target in the tree, and having the same left and right children as node.
    // Notice carefully that you cannot set the data of a BSTNode. Hint: The
    // successor is the smallest element at the right subtree of node
    //
    // Then, remove the successor from the right subtree. The successor must have up
    // to one child.
    // Make sure to return node (the new root to this subtree) at the end of each
    // case or at the end of the method.
    return null;
  }
}
