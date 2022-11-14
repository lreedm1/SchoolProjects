public class IncorrectQuestionsIterator {
  private LinkedNode<MultipleChoiceQuestion> next;

  IncorrectQuestionsIterator(LinkedNode<MultipleChoiceQuestion> startNode) {
    next = startNode;
  }

  /**
   * Returns true if there is another question to be answered incorrectly
   * 
   * @return true if there is another question to be answered incorrectly, and
   *         false otherwise
   */
  public boolean hasNext() {
    return next != null;
  }

  /**
   * Returns the next question to be answered incorrectly
   * 
   * @return the next question to be answered incorrectly
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
