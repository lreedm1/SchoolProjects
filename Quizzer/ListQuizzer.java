public class ListQuizzer {
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
   * @param file the file to load from
   * @return the number of added MultipleChoiceQuestions to this list
   * @throws FileNotFoundException throws FileNotFoundException if file is not
   *                               found
   */
  public int loadQuestions(File file) throws FileNotFoundException {

  }

  /**
   * Allows a user to take this quiz. The quiz should be taken on a deep copy of
   * this ListQuizzer
   * 
   * @return the instance of ListQuizzer taken by the user
   */
  public ListQuizzer takeQuiz() {

  }

  /**
   * Returns true if o is a ListQuizzer which has the exact same contents as this
   * ListQuizzer
   * 
   * @param o the object to compare to this ListQuizzer
   * @return true if o is instanceof ListQuizzer with the exact same contents as
   *         this ListQuizzer, and false otherwise
   */
  @Override
  public boolean equals(Object o) {

  }

}
