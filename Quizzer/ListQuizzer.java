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
   * Checks to see if the list is empty
   * 
   * @throws NullPointerException if question is null
   * @return true if this list is empty and false otherwise
   */
  public boolean isEmpty() throws NullPointerException{
    if(head==null&&tail==null) {
      throw new NullPointerException("The list is empty");
    }
    return size!=0;
  }

  /**
   * Gets the size of this list
   * 
   * @return the size of this list
   */
  public int size() {
    return size;
  }

  /**
   * Sets the listing mode of this list to the one provided as input
   * 
   * @param listingMode listing mode to set
   */
  public void switchMode(ListingMode listingMode) {
    this.listingMode = listingMode;
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
    if(question==null) {
      throw new NullPointerException("The question is null");
    }
    if(index<0||index>size) {
      throw new IndexOutOfBoundsException("The index is out of bounds");
    }
    LinkedNode<MultipleChoiceQuestion> newNode = new LinkedNode<MultipleChoiceQuestion>(question);
    if(index==0) {
      newNode.setNext(head);
      head = newNode;
      if(size==0) {
        tail = newNode;
      }
    }
    else if(index==size) {
      tail.setNext(newNode);
      tail = newNode;
    }
    else {
      LinkedNode<MultipleChoiceQuestion> current = head;
      for(int i=0;i<index-1;i++) {
        current = current.getNext();
      }
      newNode.setNext(current.getNext());
      current.setNext(newNode);
    }
    size++;
  }

  /**
   * Adds a specific MutlipleChoiceQuestion to the head of this list
   * 
   * @param question the question to be added
   * @throws NullPointerException throws NullPointerException if question is null
   */
  public void addFirst(MultipleChoiceQuestion question) throws NullPointerException {
    if(question==null) {
      throw new NullPointerException("The question is null");
    }
    LinkedNode<MultipleChoiceQuestion> newNode = new LinkedNode<MultipleChoiceQuestion>(question);
    newNode.setNext(head);
    head = newNode;
    if(size==0) {
      tail = newNode;
    }
    size++;
  }

  /**
   * Adds a specific MutlipleChoiceQuestion to the tail of this list
   * 
   * @param question the question to be added
   * @throws NullPointerException throws NullPointerException if question is null
   */
  public void addLast(MultipleChoiceQuestion question) throws NullPointerException {
    if(question==null) {
      throw new NullPointerException("The question is null");
    }
    LinkedNode<MultipleChoiceQuestion> newNode = new LinkedNode<MultipleChoiceQuestion>(question);
    if(size==0) {
      head = newNode;
    }
    else {
      tail.setNext(newNode);
    }
    tail = newNode;
    size++;
  }

  /**
   * Removes all the question from this list. The list should be empty after this
   * method is called
   */
  public void clear() {
    head=null;
    tail=null;
    size=0;
  }

  /**
   * Checks whether this list contains a match with someQuestion
   * 
   * @param someQuestion some question to find
   * @return true if this list contains a match with someQuestion and false
   *         otherwise
   */
  public boolean contains(MultipleChoiceQuestion someQuestion) {
    LinkedNode<MultipleChoiceQuestion> current = head;
    while(current!=null) {
      if(current.getData().equals(someQuestion)) {
        return true;
      }
      current=current.getNext();
    }
    return false;
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
    if(index<0||index>=size) {
      throw new IndexOutOfBoundsException("The index is out of bounds");
    }
    LinkedNode<MultipleChoiceQuestion> current = head;
    for(int i=0;i<index;i++) {
      current = current.getNext();
    }
    return current.getData();
  }

  /**
   * Gets the MultipleChoiceQuestion at the head of this list
   * 
   * @return the MultipleChoiceQuestion at the head of this list
   * @throws NoSuchElementException throws NoSuchElementException if this list is
   *                                empty
   */
  public MultipleChoiceQuestion getFirst() throws NoSuchElementException {
    if(size==0) {
      throw new NoSuchElementException("The list is empty");
    }
    return head.getData();
  }

  /**
   * Gets the MultipleChoiceQuestion at the tail of this list
   * 
   * @return the MultipleChoiceQuestion at the tail of this list
   * @throws NoSuchElementException throws NoSuchElementException if this list is
   *                                empty
   */
  public MultipleChoiceQuestion getLast() throws NoSuchElementException {
    if(size==0) {
      throw new NoSuchElementException("The list is empty");
    }
    return tail.getData();
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
    if(index<0||index>=size) {
      throw new IndexOutOfBoundsException("The index is out of bounds");
    }
    MultipleChoiceQuestion removedQuestion;
    if(index==0) {
      removedQuestion = head.getData();
      head = head.getNext();
      if(size==1) {
        tail = null;
      }
    }
    else {
      LinkedNode<MultipleChoiceQuestion> current = head;
      for(int i=0;i<index-1;i++) {
        current = current.getNext();
      }
      removedQuestion = current.getNext().getData();
      current.setNext(current.getNext().getNext());
      if(index==size-1) {
        tail = current;
      }
    }
    size--;
    return removedQuestion;
  }

  /**
   * Removes and returns the MultipleChoiceQuestion at the head of this list
   * 
   * @return the MultipleChoiceQuestion at the head of this list
   * @throws NoSuchElementException throws NoSuchElementException if this list is
   *                                empty
   */
  public MultipleChoiceQuestion removeFirst() throws NoSuchElementException {
    if(size==0) {
      throw new NoSuchElementException("The list is empty");
    }
    MultipleChoiceQuestion removedQuestion = head.getData();
    head = head.getNext();
    if(size==1) {
      tail = null;
    }
    size--;
    return removedQuestion;
  }

  /**
   * Removes and returns the MultipleChoiceQuestion at the tail of this list
   * 
   * @return the MultipleChoiceQuestion at the tail of this list
   * @throws NoSuchElementException throws NoSuchElementException if this list is
   *                                empty
   */
  public MultipleChoiceQuestion removeLast() throws NoSuchElementException {
    if(size==0) {
      throw new NoSuchElementException("The list is empty");
    }
    MultipleChoiceQuestion removedQuestion = tail.getData();
    if(size==1) {
      head = null;
      tail = null;
    }
    else {
      LinkedNode<MultipleChoiceQuestion> current = head;
      while(current.getNext()!=tail) {
        current = current.getNext();
      }
      current.setNext(null);
      tail = current;
    }
    size--;
    return removedQuestion;
  }

  /**
   * Returns an iterator to iterate through this list with respect to the
   * listingMode
   * 
   * @return an iterator to iterate through this list with respect to the
   *         listingMode of this list.
   */
  public Iterator<MultipleChoiceQuestion> iterator() {
    //TODO: implement this method
    return null;
  }

  /**
   * Calculates the total points of the correctly answered questions of this
   * ListQuizzer
   * 
   * @return the score of this ListQuizzer
   */
  public int calculateScore() {
    //TODO: implement this method
   return 0;
  }

  /**
   * Calculates the total possible points of this ListQuizzer
   * 
   * @return the score of this ListQuizzer
   */
  public int calculateTotalPoints() {
    //TODO: implement this method
    return 0;
  }

  /**
   * Returns a deep copy of this list
   * 
   * @return a deep copy of this list
   */
  public ListQuizzer copy(){
    //TODO: implement this method
    return null;
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
