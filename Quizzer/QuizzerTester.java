//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Quizzer
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
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This class tests the classes in the Quizzer Project 
 */
public class QuizzerTester {
  /**
   * executes run all tests to ensure methods are working properly
   * @param args  list of input arguments if any
   */
  public static void main(String[] args){
    runAllTests();
  }
  /**
   * Runs all the tester methods defined in this QuizzerTester
   * @return true if all the tests pass, and false otherwise
   */
  public static boolean runAllTests(){
    boolean testsPassed = true;
    boolean testResult = true;
    System.out.println("-------------------------");
    System.out.println("Testing QuizzerTester");
    testResult = testMultipleChoiceQuestion();
    if (testResult) {
      System.out.println("PASSED - testMultipleChoiceQuestion()");
    } else {
      testsPassed = false;
    }
    testResult = testLinkedNode();
    if (testResult) {
      System.out.println("PASSED - testLinkedNode()");
    } else {
      testsPassed = false;
    }
    testResult = testCorrectQuestionsIterator();
    if (testResult) {
      System.out.println("PASSED - testCorrectQuestionsIterator()");
    } else {
      testsPassed = false;
    }
    testResult = testInCorrectQuestionsIterator();
    if (testResult) {
      System.out.println("PASSED - testInCorrectQuestionsIterator()");
    } else {
      testsPassed = false;
    }
    testResult = testQuizQuestionsIterator();
    if (testResult) {
      System.out.println("PASSED - testQuizQuestionsIterator()");
    } else {
      testsPassed = false;
    }
    testResult = testAddLast();
    if (testResult) {
      System.out.println("PASSED - testAddLast()");
    } else {
      testsPassed = false;
    }
    testResult = testRemoveLast();
    if (testResult) {
      System.out.println("PASSED - testRemoveLast()");
    } else {
      testsPassed = false;
    }
    testResult = testRemoveFirst();
    if (testResult) {
      System.out.println("PASSED - testRemoveFirst()");
    } else {
      testsPassed = false;
    }
    testResult = testRemove();
    if (testResult) {
      System.out.println("PASSED - testRemove()");
    } else {
      testsPassed = false;
    }
    testResult = testAdd();
    if (testResult) {
      System.out.println("PASSED - testAdd()");
    } else {
      testsPassed = false;
    }
    testResult = testAddFirst();
    if (testResult) {
      System.out.println("PASSED - testAddFirst()");
    } else {
      testsPassed = false;
    }
    if (testsPassed) {
      System.out.println("----------- ALL TESTS PASSED -----------");
    } else {
      System.out.println("----------- SOME TESTS FAILED ----------");
    }
    return testsPassed;
  }
  /**
   * Tests the MultipleChoiceQuestion class
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testMultipleChoiceQuestion(){
    return false;
  }
  /**
   * Tests the LinkedNode class
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedNode(){
    return false;
  }
  /**
   * Tests the CorrectQuestionsIterator class
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCorrectQuestionsIterator(){
    return false;
  }
  /**
   * Tests the IncorrectQuestionsIterator class
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testInCorrectQuestionsIterator(){
    return false;
  }
  /**
   * Tests the QuizQuestionsIterator class
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testQuizQuestionsIterator(){
    return false;
  }
  /**
   * Tester for ListQuizzer.addLast() method
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddLast(){
    return false;
  }
  /**
   * Tester for ListQuizzer.removeLast() method
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemoveLast(){
    try{
      ListQuizzer quizzer = new ListQuizzer();
      quizzer.removeLast();
      System.out.println("FAILED - testRemoveLast() - no exception thrown");
      return false;
    } catch (NoSuchElementException e){
      System.out.println("PASSED - testRemoveLast() - NoSuchElementException thrown");
      return true;
    } catch (Exception e){
      System.out.println("FAILED - testRemoveLast() - unexpected exception thrown");
      return false;
    }
  }
  /**
   * Tester for ListQuizzer.removeFirst() method
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemoveFirst(){
    try{
      ListQuizzer quizzer = new ListQuizzer();
      quizzer.removeFirst();
      System.out.println("FAILED - testRemoveFirst() - no exception thrown");
      return false;
    } catch (NoSuchElementException e){
      System.out.println("PASSED - testRemoveFirst() - NoSuchElementException thrown");
      return true;
    } catch (Exception e){
      System.out.println("FAILED - testRemoveFirst() - unexpected exception thrown");
      return false;
    }
  }
  /**
   * Tester for ListQuizzer.remove() method
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemove(){
    try{
      ListQuizzer quizzer = new ListQuizzer();
      quizzer.remove(0);
      System.out.println("FAILED - testRemove() - no exception thrown");
      return false;
    } catch (IndexOutOfBoundsException e){
      System.out.println("PASSED - testRemove() - IndexOutOfBoundsException thrown");
      return true;
    } catch (Exception e){
      System.out.println("FAILED - testRemove() - unexpected exception thrown");
      return false;
    }
  }
  /**
   * Tester for ListQuizzer.add() method
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAdd(){
    try{
      ListQuizzer quizzer = new ListQuizzer();
      quizzer.add(0, null);
      System.out.println("FAILED - testAdd() - no exception thrown");
      return false;
    } catch (IndexOutOfBoundsException e){
      System.out.println("PASSED - testAdd() - IndexOutOfBoundsException thrown");
      return true;
    } catch (Exception e){
      System.out.println("FAILED - testAdd() - unexpected exception thrown");
      return false;
    }
  }
  /**
   * Tester for ListQuizzer.addFirst() method
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddFirst(){
    try{
      ListQuizzer quizzer = new ListQuizzer();
      quizzer.addFirst(null);
      System.out.println("FAILED - testAddFirst() - no exception thrown");
      return false;
    } catch (NullPointerException e){
      System.out.println("PASSED - testAddFirst() - NullPointerException thrown");
      return true;
    } catch (Exception e){
      System.out.println("FAILED - testAddFirst() - unexpected exception thrown");
      return false;
    }
  }
}
