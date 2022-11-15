import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class CorrectQuestionsIterator implements Iterator<MultipleChoiceQuestion> {
  private LinkedNode<MultipleChoiceQuestion> next;

  CorrectQuestionsIterator(LinkedNode<MultipleChoiceQuestion> startNode) {
    next = startNode;
  }

  /**
   * Returns true if this iteration has more MultipleChoiceQuestion(s) answered correctly.
   * 
   * @return true if there are more correct MultipleChoiceQuestion(s) in this iteration
   */
  public boolean hasNext() {
    return next != null;
  }

  /**
   * Returns the next correct MultipleChoiceQuestion in this iteration
   * 
   * @return the next correct MultipleChoiceQuestion in this iteration
   * @throws NoSuchElementException if there is no next question
   */
  public MultipleChoiceQuestion next() throws NoSuchElementException {
    if (next == null) {
      throw new NoSuchElementException("No more questions");
    }
    MultipleChoiceQuestion result = next.getData();
    next = next.getNext();
    return result;
  }
}
