import java.io.FileNotFoundException;
import java.util.List;

public interface CarReaderInterface {
  // public CarReaderInterface();
  public List<CarInterface> readCarsFromFile(String filename) throws FileNotFoundException;
}

