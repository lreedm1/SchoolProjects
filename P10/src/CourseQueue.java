/*
/////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   CourseQueue.java
// Course:   CS 300 Fall 2022
//
// Author:   Reed Lokken
// Email:    RLokken@wisc.edu
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
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Array-based heap implementation of a priority queue containing Courses. Guarantees the
 * max-heap invariant, so that the Course at the root should have the highest score, and all
 * children always have a score lower than or equal to their parent's.
 * 
 * The root of a non-empty queue is always at index 0 of this array-heap.
 */
public class CourseQueue implements Iterable<Course>, PriorityQueueADT<Course>  {
  
  // data fields
  private Course[] queue;        // array max-heap of courses representing this priority queue
  private int size;              // number of courses currently in this priority queue
  private CourseQueue deepCopy;  // deep copy of this priority queue
  /**
   * Creates a new, empty CourseQueue with the given capacity
   * 
   * @param capacity the capacity of this CourseQueue
   * @throws IllegalArgumentException if the capacity is not a positive integer
   */
  public CourseQueue(int capacity) {
    size = 0;
    queue = new Course[capacity];
  }
  
  /**
   * Returns a deep copy of this CourseQueue containing all of its elements in the same order.
   * This method does not return the deepest copy, meaning that you do not need to duplicate 
   * courses. Only the instance of the heap (including the array and its size) will be duplicated.
   * 
   * @return a deep copy of this CourseQueue, which has the same capacity and size as this queue.
   */
  public CourseQueue deepCopy() {
    deepCopy = new CourseQueue(queue.length);
    deepCopy.size = size;
    // iterate through the queue and copy each element into the deep copy
    for (int i = 0; i < size; i++) {
      deepCopy.queue[i] = queue[i];
    }
    return deepCopy;
  }
  
  /**
   * Returns an Iterator for this CourseQueue which proceeds from the highest-priority to the
   * lowest-priority Course in the queue. Note that this should be an iterator over a DEEP COPY
   * of this queue.
   * 
   * @see CourseIterator
   * @return an Iterator for this CourseQueue
   */
  @Override
  public Iterator<Course> iterator() {
    return new CourseIterator(deepCopy());
  }
  
  ///////////////////////////// TODO: PRIORITY QUEUE METHODS //////////////////////////////////
  // Add the @Override annotation to these methods once this class implements PriorityQueueADT!
  
  /**
   * Checks whether this CourseQueue is empty
   * 
   * @return {@code true} if this CourseQueue is empty
   */
  @Override
  public boolean isEmpty() {
   return (size == 0);
  }
  
  /**
   * Returns the size of this CourseQueue
   * 
   * @return the size of this CourseQueue
   */
  @Override
  public int size() {
    return size;
  }
  
  /**
   * Adds the given Course to this CourseQueue and use the percolateUp() method to
   * maintain max-heap invariant of CourseQueue. Courses should be compared using 
   * the Course.compareTo() method.
   * 
   * 
   * @param toAdd Course to add to this CourseQueue
   * @throws NullPointerException if the given Course is null
   * @throws IllegalStateException with a descriptive error message if this CourseQueue is full
   */
  @Override
  public void enqueue(Course toAdd) throws NullPointerException, IllegalStateException {
    // check if the course to add is null
    if (toAdd == null) {
      throw new NullPointerException("The course to add is null");
    }

    // check if the queue is full
    if (size == queue.length) {
      throw new IllegalStateException("The queue is full");
    }

    // add the course to the queue and percolate up
    this.size += 1;
    queue[size - 1] = toAdd;
    percolateUp(size - 1);
  }
  
  /**
   * Removes and returns the Course at the root of this CourseQueue, i.e. the Course
   * with the highest priority. Use the percolateDown() method to maintain max-heap invariant of
   * CourseQueue. Courses should be compared using the Course.compareTo() method.
   * 
   * @return the Course in this CourseQueue with the highest priority
   * @throws NoSuchElementException with a descriptive error message if this CourseQueue is
   *                                empty
   */
  @Override
  public Course dequeue() throws NoSuchElementException {
    // check if the queue is empty
    if (size == 0) {
      throw new NoSuchElementException("The queue is empty");
    }

    // remove the root and percolate down
    Course root = queue[0];
    queue[0] = queue[size - 1];
    queue[size - 1] = null;
    size -= 1;
    percolateDown(0);
    return root;
  }
  
  /**
   * Returns the Course at the root of this CourseQueue, i.e. the Course with
   * the highest priority.
   * 
   * @return the Course in this CourseQueue with the highest priority
   * @throws NoSuchElementException if this CourseQueue is empty
   */
  @Override
  public Course peek() throws NoSuchElementException {
    return queue[0];
  }
  
  ///////////////////////////// TODO: QUEUE HELPER METHODS //////////////////////////////////
  
  /**
   * Restores the max-heap invariant of a given subtree by percolating its root down the tree. If 
   * the element at the given index does not violate the max-heap invariant (it is higher priority 
   * than its children), then this method does not modify the heap. 
   * 
   * Otherwise, if there is a heap violation, then swap the element with the correct child and 
   * continue percolating the element down the heap.
   * 
   * This method may be implemented iteratively or recursively.
   * 
   * @param index index of the element in the heap to percolate downwards
   * @throws IndexOutOfBoundsException if index is out of bounds - do not catch the exception
   */
  protected void percolateDown(int index) throws IndexOutOfBoundsException {
    int child = 2 * index + 1;

    // base case | if the child is out of bounds, return
    if (child >= size) {
      return;
    }

    // if the right child is greater than the left child, increment the child
    if (child + 1 < size && queue[child].compareTo(queue[child + 1]) < 0) {
      child++;
    }

    // if the parent is less than the child, swap the parent and child
    if (queue[index].compareTo(queue[child]) < 0) {
      Course temp = queue[index];
      queue[index] = queue[child];
      queue[child] = temp;
      percolateDown(child);
    }
  }
  
  /**
   * Restores the max-heap invariant of the tree by percolating a leaf up the tree. If the element 
   * at the given index does not violate the max-heap invariant (it is lower priority than its 
   * parent), then this method does not modify the heap.
   * 
   * Otherwise, if there is a heap violation, swap the element with its parent and continue
   * percolating the element up the heap.
   * 
   * This method may be implemented iteratively or recursively.
   * 
   * @param index index of the element in the heap to percolate upwards
   * @throws IndexOutOfBoundsException if index is out of bounds - do not catch the exception
   */
  protected void percolateUp(int index) throws IndexOutOfBoundsException {
    // base case | if the index is 0, then it is the root
    if (index == 0) {
      return;
    }
    // get the parent index
    int parent = (index - 1) / 2;

    // if the current index is greater than the parent, swap them
    if (queue[index].compareTo(queue[parent]) > 0) {
      Course temp = queue[index];
      queue[index] = queue[parent];
      queue[parent] = temp;
      percolateUp(parent);
    }
  }
  
  /**
   * Returns a String representing this CourseQueue, where each element (course) of the queue is 
   * listed on a separate line, in order from the highest priority to the lowest priority.
   * 
   * @author yiwei
   * @see Course#toString()
   * @see CourseIterator
   * @return a String representing this CourseQueue
   */
  @Override
  public String toString() {
    StringBuilder val = new StringBuilder();
    
    for (Course c : this) {
      val.append(c).append("\n");
    }
    
    return val.toString().trim();
  }

}
