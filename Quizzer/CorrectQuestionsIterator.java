public class CorrectQuestionsIterator {
  private LinkedNode<MultipleChoiceQuestion> next;

  CorrectQuestionsIterator(LinkedNode<MultipleChoiceQuestion> startNode) {
    next = startNode;
  }

  /**
   * Returns true if there is another question to be answered correctly
   * 
   * @return true if there is another question to be answered correctly, and false
   *         otherwise
   */
  public boolean hasNext() {
    return next != null;
  }

  /**
   * Returns the next question to be answered correctly
   * 
   * @return the next question to be answered correctly
   * @throws NoSuchElementException if there is no next question
   */
  public MultipleChoiceQuestion next() throws NoSuchElementException {
    if (next == null) {
      throw new NoSuchElementException();
    }
    MultipleChoiceQuestion result = next.getData();
    next = next.getNext();
    return result;
  }
}
