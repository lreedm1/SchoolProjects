public class QuizQuestionsIterator {
  private LinkedNode<MultipleChoiceQuestion> next;
  /**
   * Creates a new QuizQuestionsIterator
   * @param startNode the first node in the list of questions
   */
  QuizQuestionsIterator(LinkedNode<MultipleChoiceQuestion> startNode){
    next = startNode;
  }
  /**
   * Returns true if this iteration has more MultipleChoiceQuestion(s).
   * @return true if there is another question to be answered, and false otherwise
   */
  public boolean hasNext(){
    return next != null;
  }
  /**
   * Returns the next MultipleChoiceQuestion in the iteration.
   * @return the next question to be answered
   * @throws NoSuchElementException if there is no next question
   */
  public MultipleChoiceQuestion next() throws NoSuchElementException{
    if (next == null) {
      throw new NoSuchElementException();
    }
    MultipleChoiceQuestion result = next.getData();
    next = next.getNext();
    return result;
  }
}
