import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.BeforeEach;

/**
 * 5 JUnit tests for BackendDeveloper code
 * 
 * @author harshachilakapati
 *
 */
public class BackendDeveloperTests {
  private CarSearchBackendBD bd;

  @BeforeEach
  public void setup() {
    // initialize a Backend object
    AlgorithmEngineerBD tree = new AlgorithmEngineerBD();
    CarReaderBD reader = new CarReaderBD();
    bd = new CarSearchBackendBD(tree, reader);
  }

  /**
   * Tests the findCarByPrice method by attempting to use a string that can be parsed into a double
   * and one that can't as input
   */
  @Test
  public void test1() {
    // try calling findCarByPrice with invalid input and seeing if null is returned
    assertNull(bd.findCarByPrice("fail"));
    // try calling with valid double input
    assertNotNull(bd.findCarByPrice("12.34"));

  }

  /**
   * Test loadData with a "valid" file and an "invalid file
   */
  @Test
  public void test2() {
    // try loading data with invalid file
    assertThrows(FileNotFoundException.class, () -> {
      bd.loadData("invalid");
    });
    // try loading data with a valid file
    assertDoesNotThrow(() -> {
      bd.loadData("valid");
    });
  }

  /**
   * Tests the getCheapestAbovePrice with invalid input that can't be parsed to a double
   */
  @Test
  public void test3() {
    assertNull(bd.getCheapestAbovePrice(".bd"));

  }

  /**
   * Tests the getCheapestAbovePrice with valid input such that the car in the root is returned.
   * Also test valid(double) input that results in null being returned
   */
  @Test
  public void test4() {
    assertEquals(bd.getCheapestAbovePrice("0.85").getPrice(), 1.1);
    assertNull(bd.getCheapestAbovePrice("1.1"));
    assertNull(bd.getCheapestAbovePrice("20"));
  }

  /**
   * Test the getCarInfo method by creating a new car and checking if the expected string is
   * returned
   */
  @Test
  public void test5() {
    CarBD car = new CarBD("H", "A", "R", 11.11);
    assertEquals("A, H, R, 11.11", bd.getCarInfo(car));
  }
}
