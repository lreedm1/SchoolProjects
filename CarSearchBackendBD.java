import java.io.FileNotFoundException;
import java.util.List;

public class CarSearchBackendBD implements CarSearchBackendInterface {
  // tree that holds all of the cars with unique prices in the dataset
  private RedBlackTreeInterface<CarInterface> rbTree;
  // used to read cars from a file to be able to add them into tree
  private CarReaderInterface carReader;

  /**
   * 
   * @param rbTree    Empty tree used to store cars in
   * @param carReader object that assists in reading cars from a file
   */
  public CarSearchBackendBD(RedBlackTreeInterface<CarInterface> rbTree,
      CarReaderInterface carReader) {
    // initialize fields
    this.rbTree = rbTree;
    this.carReader = carReader;
  }

  /**
   * Reads cars from file and attempts to add them to tree. This step ignores cars with duplicate
   * prices and invalid cars
   * 
   * @param
   */
  @Override
  public void loadData(String filename) throws FileNotFoundException {
    // takes cars from file and adds them to list
    List<CarInterface> list = carReader.readCarsFromFile(filename);
    // iterates through list adding valid cars with unique prices into tree
    for (CarInterface car : list) {
      try {
        rbTree.insert(car);
      } catch (Exception e) {

      }
    }

  }

  /**
   * @param price Price to look up in tree
   */
  @Override
  public CarInterface findCarByPrice(String price) {
    // try parsing price into an int
    Double p;
    try {
      p = Double.parseDouble(price);
    } catch (Exception e) {// if it can't be parsed into an int return null
      return null;
    }
    // return the result of rbt search
    return rbTree.find(p);
  }

  /**
   * Returns the cheapest car in tree
   */
  @Override
  public CarInterface getCheapest() {
    return rbTree.lowest();
  }

  /**
   * Returns the most expensive car in dataset
   */
  @Override
  public CarInterface getPriciest() {
    return rbTree.highest();
  }

  /**
   * Returns the cheapest car above a certain price
   * 
   * @param minPrice is the price to search for cars above
   */
  @Override
  public CarInterface getCheapestAbovePrice(String minPrice) {
    CarInterface root = rbTree.root();
    // try parsing price into an int
    double p;
    try {
      p = Double.parseDouble(minPrice);
    } catch (Exception e) {// if it can't be parsed into an int return null
      return null;
    }
    // loop to iterate through tree to find cheapest car above certain value
    while (root != null) {
      // if leaf node is reached and is still smaller than minPrice
      if (rbTree.getLeftChild(root) == null && rbTree.getRightChild(root) == null
          && Double.compare(root.getPrice(), p) <= 0) {
        return null;
      }
      // if current node's value is greater than minPrice and if left value is smaller than minPrice
      // or null then return current node
      if ((Double.compare(root.getPrice(), p) > 0 && rbTree.getLeftChild(root) == null)
          || (Double.compare(root.getPrice(), p) > 0
              && Double.compare(rbTree.getLeftChild(root).getPrice(), p) <= 0)) {
        return root;
      }
      // current node is smaller than minPrice search in right subtree
      if (Double.compare(root.getPrice(), p) <= 0) {
        root = rbTree.getRightChild(root);
      }
      // current node is larger than minPrice search in left subtree
      else {
        root = rbTree.getLeftChild(root);
      }
    }
    // not found
    return null;

  }

  /**
   * Converts car information into a string
   */
  @Override
  public String getCarInfo(CarInterface car) {
    return "" + car.getBrand() + ", " + car.getLocation() + ", " + car.getColor() + ", "
        + car.getPrice();
  }

}
