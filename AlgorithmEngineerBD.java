/**
 * Placeholder class for extended RB-tree
 * 
 * @author harshachilakapati
 *
 */
public class AlgorithmEngineerBD implements RedBlackTreeInterface<CarInterface> {

  @Override
  public CarInterface getRightChild(CarInterface parentNodeData) throws IllegalArgumentException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CarInterface getLeftChild(CarInterface parentNodeData) throws IllegalArgumentException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean insert(CarInterface data) throws NullPointerException, IllegalArgumentException {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean remove(CarInterface data) throws NullPointerException, IllegalArgumentException {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean contains(CarInterface data) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public CarInterface find(double key) {
    return new CarBD("a", "a", "a", 1);
  }

  @Override
  public CarInterface root() {
    return new CarBD("", "", "", 1.1);
  }

  @Override
  public CarInterface lowest() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CarInterface highest() {
    // TODO Auto-generated method stub
    return null;
  }



}
