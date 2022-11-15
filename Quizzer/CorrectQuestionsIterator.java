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
   * @return true if there are more correct MultipleChoiceQuestion(s) in this iteration, and false otherwise
   */
  public boolean hasNext() {
    if(next == null) {
      return false;
    }
    else if(next.getData().isCorrect()) {
      return true;
    }
    else {
      next = next.getNext();
      return hasNext();
    }
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
    if(next.getData().isCorrect()) {
      MultipleChoiceQuestion result = next.getData();
      next = next.getNext();
      return result;
    }
    else {
      next = next.getNext();
      return next();
    }
  }
}
