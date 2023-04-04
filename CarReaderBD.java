import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Placeholder for CarReader
 * 
 * @author harshachilakapati
 *
 */
public class CarReaderBD implements CarReaderInterface {

  @Override
  public List<CarInterface> readCarsFromFile(String filename) throws FileNotFoundException {
    if (filename.equals("invalid")) {
      throw new FileNotFoundException();
    }
    return new ArrayList<CarInterface>();
  }

}
