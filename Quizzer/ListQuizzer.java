import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ListQuizzer implements Iterable {
  private LinkedNode<MultipleChoiceQuestion> head;
  private LinkedNode<MultipleChoiceQuestion> tail;
  private int size;
  private ListingMode listingMode;

  public ListQuizzer() {
    head = null;
    tail = null;
    size = 0;
    listingMode = ListingMode.ALL;
  }

  /**
   * Adds a question to the end of the list of questions
   * 
   * @param question the question to be added
   * @throws NullPointerException if question is null
   * @return true if the question was added, and false otherwise
   */
  public boolean isEmpty() {

  }

  /**
   * Gets the size of this list
   * 
   * @return the size of this list
   */
  public int size() {

  }

  /**
   * Sets the listing mode of this list to the one provided as input
   * 
   * @param listingMode listing mode to set
   */
  public void switchMode(ListingMode listingMode) {

  }

  /**
   * Adds a specific MultipleChoiceQuestion to a given position of this list
   * 
   * @param index    the position to add the question
   * @param question the question to be added
   * @throws NullPointerException      throws NullPointerException if question is
   *                                   null
   * @throws IndexOutOfBoundsException throws IndexOutOfBoundsException if index
   *                                   is out of bounds
   */
  public void add(int index, MultipleChoiceQuestion question) throws NullPointerException, IndexOutOfBoundsException {

  }

  /**
   * Adds a specific MutlipleChoiceQuestion to the head of this list
   * 
   * @param question the question to be added
   * @throws NullPointerException throws NullPointerException if question is null
   */
  public void addFirst(MultipleChoiceQuestion question) throws NullPointerException {

  }

  /**
   * Adds a specific MutlipleChoiceQuestion to the tail of this list
   * 
   * @param question the question to be added
   * @throws NullPointerException throws NullPointerException if question is null
   */
  public void addLast(MultipleChoiceQuestion question) throws NullPointerException {

  }

  /**
   * Removes all the question from this list. The list should be empty after this
   * method is called
   */
  public void clear() {

  }

  /**
   * Checks whether this list contains a match with someQuestion
   * 
   * @param someQuestion some question to find
   * @return true if this list contains a match with someQuestion and false
   *         otherwise
   */
  public boolean contains(MultipleChoiceQuestion someQuestion) {

  }

  /**
   * Returns the MultipleChoiceQuestion stored at the given index within this list
   * 
   * @param index index of the MultipleChoiceQuestion to return
   * @return the MultipleChoiceQuestion stored at the given index within this list
   * @throws IndexOutOfBoundsException throws IndexOutOfBoundsException if index
   *                                   is out of bounds
   */
  public MultipleChoiceQuestion get(int index) throws IndexOutOfBoundsException {

  }

  /**
   * Gets the MultipleChoiceQuestion at the head of this list
   * 
   * @return the MultipleChoiceQuestion at the head of this list
   * @throws NoSuchElementException throws NoSuchElementException if this list is
   *                                empty
   */
  public MultipleChoiceQuestion getFirst() throws NoSuchElementException {

  }

  /**
   * Gets the MultipleChoiceQuestion at the tail of this list
   * 
   * @return the MultipleChoiceQuestion at the tail of this list
   * @throws NoSuchElementException throws NoSuchElementException if this list is
   *                                empty
   */
  public MultipleChoiceQuestion getLast() throws NoSuchElementException {

  }

  /**
   * Removes and returns the MultipleChoiceQuestion at the given index
   * 
   * @param index index of the MultipleChoiceQuestion to remove
   * @return the MultipleChoiceQuestion at the given index
   * @throws IndexOutOfBoundsException throws IndexOutOfBoundsException if index
   *                                   is out of bounds
   */
  public MultipleChoiceQuestion remove(int index) throws IndexOutOfBoundsException {

  }

  /**
   * Removes and returns the MultipleChoiceQuestion at the head of this list
   * 
   * @return the MultipleChoiceQuestion at the head of this list
   * @throws NoSuchElementException throws NoSuchElementException if this list is
   *                                empty
   */
  public MultipleChoiceQuestion removeFirst() throws NoSuchElementException {

  }

  /**
   * Removes and returns the MultipleChoiceQuestion at the tail of this list
   * 
   * @return the MultipleChoiceQuestion at the tail of this list
   * @throws NoSuchElementException throws NoSuchElementException if this list is
   *                                empty
   */
  public MultipleChoiceQuestion removeLast() throws NoSuchElementException {

  }

  /**
   * Returns an iterator to iterate through this list with respect to the
   * listingMode
   * 
   * @return an iterator to iterate through this list with respect to the
   *         listingMode of this list.
   */
  public Iterator<MultipleChoiceQuestion> iterator() {

  }

  /**
   * Calculates the total points of the correctly answered questions of this
   * ListQuizzer
   * 
   * @return the score of this ListQuizzer
   */
  public int calculateScore() {

  }

  /**
   * Calculates the total possible points of this ListQuizzer
   * 
   * @return the score of this ListQuizzer
   */
  public int calculateTotalPoints() {

  }

  /**
   * Returns a deep copy of this list
   * 
   * @return a deep copy of this list
   */
  public ListQuizzer copy() {

  }

 /**
* Loads MultipleChoiceQuestions from a file
*
* @author Jeff and Mouna
*
* @param file file to read
* @return the number of added MultipleChoiceQuestions to this list
* @throws FileNotFoundException if the file is not found
*/
public int loadQuestions(File file) throws FileNotFoundException {
  int loadedCount = 0; // count of loaded multiple choice questions
  int answerCount = 0; // count of possible answers per question
  int indexCorrectAnswer = 0; // index of the correct answer
  int points = 0; // possible points for a multiple choice question
  // try to read the file
  Scanner reader = null; // scanner to read the file line by line
  int lineNumber = 0; // number of the last read line
  try {
  reader = new Scanner(file);
  // parse the file lines - while loop to read parts of each multiple choice question
  while (reader.hasNextLine()) { // no more lines to read
  // read title
  String title = reader.nextLine();
  lineNumber++;
  // read question stem
  if (!reader.hasNextLine()) { // no more lines to read
  return loadedCount;
  }
  String question = reader.nextLine();
  lineNumber++;
  // read possible answers count
  if (!reader.hasNextLine()) { // no more lines to read
  return loadedCount;
  }
  String count = reader.nextLine();
  lineNumber++;
  // check the validity of count
  try {
  answerCount = Integer.parseInt(count.trim());
  if (answerCount <= 0 || answerCount > 10) {
  throw new NumberFormatException();
  }
  } catch (NumberFormatException e) { // count invalid - print an error message and return
  System.out.println("Syntax error! A positive integer less or equal to 10 is expected at line "+ lineNumber + (". Load questions operation interrupted!"));
  return loadedCount;
  }
  // valid count -> create the answerList array
  String[] answerList = new String[answerCount];
  int index = 0;
  while (index < answerCount && reader.hasNextLine()) {
  String answer = reader.nextLine();
  lineNumber++;
  answerList[index] = answer;
  index++;
  }
  // read index of the correct answer
  if (!reader.hasNextLine()) { // no more lines to read
  return loadedCount;
  }
  String line = reader.nextLine();
  lineNumber++;
  try { // check the validity of the index of the correct answer
  indexCorrectAnswer = Integer.parseInt(line.trim());
  if (indexCorrectAnswer < 0 || indexCorrectAnswer >= answerCount) 
  {
  throw new NumberFormatException();
  }
  } catch (NumberFormatException e) { // indexCorrectAnswer invalid - print error and return 
  System.out.println("Syntax error! A positive integer less than " + answerCount + " is expected at line " + lineNumber + (". Load questions operation interrupted!"));
  return loadedCount;
  }
  // valid index of the correct answer -> read possible points
  // read points
  if (!reader.hasNextLine()) { // no more lines to read
  return loadedCount;
  }
  line = reader.nextLine();
  lineNumber++;
  try { // check the validity of the index of the correct answer
  points = Integer.parseInt(line.trim());
  if (points < 0) {
  throw new NumberFormatException();
  }
  } catch (NumberFormatException e) { // invalid points - print error message and return 
  System.out.println("Syntax error! A positive integer for possible points " + " is expected at line " + lineNumber + (". Load questions operation interrupted!"));
  return loadedCount;
  }
  // create and add quizQuestion
  MultipleChoiceQuestion quizQuestion =
  new MultipleChoiceQuestion(title, question, answerList, 
  indexCorrectAnswer, points);
  this.addLast(quizQuestion);
  loadedCount += 1;
  System.out.println("Question " + loadedCount + " loaded!");
  }
  } finally {
  if (reader != null)
  reader.close();
  }
  return loadedCount;
  }

  /**
   * Allows a user to take this quiz. The quiz should be taken on a deep
   * copy of this ListQuizzer.
   * This method should not make any changes to the contents of this
   * ListQuizzer.
   *
   * @author Jeff and Mouna
   *
   * @return the instance of ListQuizzer taken by the user. It should
   *         include the user's responses.
   */
  public ListQuizzer takeQuiz() {
    ListQuizzer copy = this.copy();
    copy.switchMode(ListingMode.ALL);
    Scanner input = new Scanner(System.in);
    for (MultipleChoiceQuestion question : copy) {
    System.out.println(question);
    System.out.print("Enter your answer: ");
    int entry = input.nextInt();
    question.setStudentAnswerIndex(entry - 1);
    if (question.isCorrect()) {
    System.out.println("Correct!");
    } else {
    System.out.println("Incorrect!");
    }
    }
    int correctPoints = copy.calculateScore();
    int totalPoints = copy.calculateTotalPoints();
    System.out.println("Your Score: " + correctPoints);
    System.out.println("Percentage: " + correctPoints / totalPoints);
    input.close();
    return copy;
    }

  /**
   * Returns true if o is a ListQuizzer which has the exact same contents
   * as this ListQuizzer
   *
   * @author Mouna
   *
   * @param o an object to compare with
   * @return true if o is instanceof ListQuizzer with the exact same
   *         contents as this ListQuizzer
   */
  @Override
  public boolean equals(Object o) {
    if (o instanceof ListQuizzer) {
      ListQuizzer other = (ListQuizzer) o;
      if (this.size() != other.size())
        return false;
      this.switchMode(ListingMode.ALL);
      other.switchMode(ListingMode.ALL);
      Iterator<MultipleChoiceQuestion> iterator = this.iterator();
      Iterator<MultipleChoiceQuestion> otherIterator = other.iterator();
      while (iterator.hasNext()) {
        if (!iterator.next().equals(otherIterator.next()))
          return false;
      }
      return true;
    }
    return false;
  }

}
