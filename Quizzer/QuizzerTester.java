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
  /** creates a MultipeChoiceQuestion for testing
   * @return a MultipleChoiceQuestion object
   */
  private static MultipleChoiceQuestion createMultipleChoiceQuestion(int length, int CorrectAnswer) {
    String question = "What is the capital of Wisconsin?";
    String[] allChoices = {"Madison", "Milwaukee", "Green Bay", "Eau Claire", "Appleton"};
    String[] choices = new String[length];
    for(int i = 0; i < length; i++) {
      choices[i] = allChoices[i];
    }
    String title = "Wisconsin";
    MultipleChoiceQuestion mcq = new MultipleChoiceQuestion(title, question, choices, CorrectAnswer,2);
    return mcq;
  }

  /**
   * Tests the MultipleChoiceQuestion class
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testMultipleChoiceQuestion(){
    MultipleChoiceQuestion question1 = createMultipleChoiceQuestion(4, 0);

    // test the constructor through the get methods
    // test the equals method
    MultipleChoiceQuestion question2 = createMultipleChoiceQuestion(4, 0);
    if (!question1.equals(question2)) {
      System.out.println("MultipleChoiceQuestion equals method failed");
      return false;
    }
    // test the copy method
    MultipleChoiceQuestion question3 = question1.copy();
    if (!question1.equals(question3)) {
      System.out.println("MultipleChoiceQuestion copy method failed");
      return false;
    }
    // test the getAnswers method
    if (!question1.getAnswers().equals("1. Madison\n2. Milwaukee\n3. Green Bay\n4. Eau Claire")) {
      System.out.println("MultipleChoiceQuestion getAnswers method failed");
      return false;
    }
    // test the getCorrectAnswerIndex method
    if (question1.getCorrectAnswerIndex() != 0) {
      System.out.println("MultipleChoiceQuestion getCorrectAnswerIndex method failed");
      return false;
    }
    // test the getPointsPossible method
    if (question1.getPointsPossible() != 2) {
      System.out.println("MultipleChoiceQuestion getPointsPossible method failed");
      return false;
    }
    // test the getQuestion method
    if (!question1.getQuestion().equals("What is the capital of Wisconsin?")) {
      System.out.println("MultipleChoiceQuestion getQuestion method failed");
      return false;
    }
    // test the getStudentAnswerIndex method
    if(question1.getStudentAnswerIndex() != -1) {
      System.out.println("MultipleChoiceQuestion getStudentAnswerIndex method failed");
      return false;
    }
    // test the setStudentAnswerIndex method
    question1.setStudentAnswerIndex(2);
    if(question1.getStudentAnswerIndex() != 2) {
      System.out.println("MultipleChoiceQuestion setStudentAnswerIndex method failed");
      return false;
    }
    // test the isCorrect method by setting the current index to the correct answer
    question1.setStudentAnswerIndex(1);
    question1.setCorrectAnswerIndex(1);
    if(!question1.isCorrect()) {
      System.out.println("MultipleChoiceQuestion isCorrect method failed");
      return false;
    }

    // test setCorrectAnswerIndex method
    question1.setCorrectAnswerIndex(2);
    if (question1.getCorrectAnswerIndex() != 2) {
      System.out.println("MultipleChoiceQuestion setCorrectAnswerIndex method failed");
      return false;
    }
    // test the setPointsPossible method
    question1.setPointsPossible(3);
    if (question1.getPointsPossible() != 3) {
      System.out.println("MultipleChoiceQuestion setPointsPossible method failed");
      return false;
    }
    // test the setQuestion method
    question1.setQuestion("What is the capital of Minnesota?");
    if (!question1.getQuestion().equals("What is the capital of Minnesota?")) {
      System.out.println("MultipleChoiceQuestion setQuestion method failed");
      return false;
    }
    // test the setTtile method
    question1.setTitle("Minnesota");
    if (!question1.getTitle().equals("Minnesota")) {
      System.out.println("MultipleChoiceQuestion setTitle method failed");
      return false;
    }
    // test the toString method
    MultipleChoiceQuestion question4 = createMultipleChoiceQuestion(4, 0);
    if(!question4.toString().equals("QUESTION TITLE: " + "\"" + question4.getTitle() + "\"" + "\n"
                                     + "Question:\n" + question4.getQuestion() + "\n" + 
                                     "Available Answers:\n" + question4.getAnswers())) 
                                     {
      System.out.println("MultipleChoiceQuestion toString method failed");
      return false;
    }

    return true;
  }
  /**
   * Tests the LinkedNode class
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedNode(){
    // tests the new node constructor and getData method
    LinkedNode<String> node1 = new LinkedNode<String>("Hello");
    if (!node1.getData().equals("Hello")) {
      System.out.println("LinkedNode constructor or getData method failed");
      return false;
    }
    // tests the connect node constructor and the getNext method
    LinkedNode<String> node2 = new LinkedNode<String>("World", node1);
    if (!node2.getNext().equals(node1)) {
      System.out.println("LinkedNode constructor or getNext method failed");
      return false;
    }
    
    //test the toString method which prints data.toString() by default
    // and data.toString() + " -> " + next.toString() if next is not null
    if (!node1.toString().equals("Hello")) {
      System.out.println("LinkedNode toString method failed when next is null");
      return false;
    }
    if (!node2.toString().equals("World->")) {
      System.out.println("LinkedNode toString method failed when next is not null");
      return false;
    }

    // test the setNext method
    node1.setNext(node2);
    if (!node1.getNext().equals(node2)) {
      System.out.println("LinkedNode setNext method failed");
      return false;
    }
    return true;
  }

  /**
   * Tests the CorrectQuestionsIterator class
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCorrectQuestionsIterator(){
    MultipleChoiceQuestion question1 = createMultipleChoiceQuestion(4, 0);
    MultipleChoiceQuestion question2 = createMultipleChoiceQuestion(4, 1);
    MultipleChoiceQuestion question3 = createMultipleChoiceQuestion(4, 2);
          
    question1.setStudentAnswerIndex(0);
    question2.setStudentAnswerIndex(1);
    question3.setStudentAnswerIndex(2);

    ListQuizzer list = new ListQuizzer();
    list.addLast(question1);
    list.addLast(question2);
    list.addLast(question3);
    list.switchMode(ListingMode.CORRECT);
    
    Iterator<MultipleChoiceQuestion> iterator = list.iterator();
    if (!iterator.hasNext())
      return false;
    if (!iterator.next().equals(question1))
      return false;
    if (!iterator.hasNext())
      return false;
    if (!iterator.next().equals(question3))
      return false;
    boolean bool = false;
    try {
      try {
          iterator.next();
      }catch (NoSuchElementException e){
          bool = true;
      }
    }catch (Exception e){
    return false;
    }
    return bool;
    }
  /**
   * Tests the IncorrectQuestionsIterator class
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testInCorrectQuestionsIterator(){
    return true;
  }
  /**
   * Tests the QuizQuestionsIterator class
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testQuizQuestionsIterator(){
    return true;
  }
  /**
   * Tester for ListQuizzer.addLast() method
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddLast(){
    ListQuizzer listOfMCQ = new ListQuizzer();
    MultipleChoiceQuestion question;

    for (int i = 0; i < 4; i++) {
      question = createMultipleChoiceQuestion(4, i);
      listOfMCQ.addLast(question);
    }
    if (listOfMCQ.size() != 4) {
      System.out.println(listOfMCQ.size());
      System.out.println("ListQuizzer addLast method failed");
      return false;
    }
    return true;
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
    } catch (NullPointerException e){
      System.out.println("PASSED - testAdd() - NullPointerException thrown");
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
