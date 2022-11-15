import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class QuizzerTester {
  /**
   * 
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
    testResult = testIncorrectQuestionsIterator();
    if (testResult) {
      System.out.println("PASSED - testIncorrectQuestionsIterator()");
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
    return false;
  }
  /**
   * Tester for ListQuizzer.removeFirst() method
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemoveFirst(){
    return false;
  }
  /**
   * Tester for ListQuizzer.remove() method
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testRemove(){
    return false;
  }
  /**
   * Tester for ListQuizzer.add() method
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAdd(){
    return false;
  }
  /**
   * Tester for ListQuizzer.addFirst() method
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddFirst(){
    return false;
  }
}
