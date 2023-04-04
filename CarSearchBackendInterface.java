import java.io.FileNotFoundException;

public interface CarSearchBackendInterface {
  // public CarSearchBackendInterface(RedBlackTreeInterface<CarInterface> rbTree, CarReaderInterface
  // carReader);
  public void loadData(String filename) throws FileNotFoundException;

  public CarInterface findCarByPrice(String price);

  public CarInterface getCheapest();

  public CarInterface getPriciest();

  public CarInterface getCheapestAbovePrice(String minPrice);

  public String getCarInfo(CarInterface car);

}

