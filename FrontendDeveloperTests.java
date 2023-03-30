import static org.junit.Assert.assertEquals;
import java.util.Scanner;
import javax.naming.spi.DirStateFactory.Result;
import org.junit.Test;
import org.junit.platform.launcher.listeners.TestExecutionSummary.Failure;
import org.junit.runner.JUnitCore;

public class FrontendDeveloperTests {

  /**
   * Verifies number entered by user is equivalent to number registered by MainMenuPrompt()
   */
  @Test
  public void testMainMenuPrompt() {
    Scanner sc = new Scanner(System.in);
    CarSearchBackendFD backend = new CarSearchBackendFD();

    CarSearchFrontend frontend = new CarSearchFrontend(sc, backend);
    char expected = '4';
    System.out.println("\n\nTest: Main Menu Functionality: ");
    System.out.println("Type in 4 (for this test)");
    char actual = frontend.mainMenuPrompt();
    assertEquals(expected, actual);
  }

  /**
   * Verifies output printed to console by searchCarByPrice() is equivalent to expected result (no
   * assertEquals test, since method is void) Instead, the user should visually verify alignment
   */
  @Test
  public void testSearchCarByPrice() {
    Scanner sc = new Scanner(System.in);
    CarSearchBackendFD backend = new CarSearchBackendFD();

    CarSearchFrontend frontend = new CarSearchFrontend(sc, backend);
    System.out.println("\n\nTest: Search for cars at $22000");
    String expected = "Toyota, Newark, Purple, 22000";
    System.out.println("Expected: " + expected);
    frontend.searchCarByPrice("22000");
  }

  /**
   * Verifies output printed to console by searchCarByPrice() is equivalent to expected result for a
   * price that has no cars (no assertEquals test, since method is void) Instead, the user should
   * visually verify alignment
   */
  @Test
  public void testSearchCarByPriceNull() {
    Scanner sc = new Scanner(System.in);
    CarSearchBackendFD backend = new CarSearchBackendFD();

    CarSearchFrontend frontend = new CarSearchFrontend(sc, backend);
    System.out.println("\n\nNull test: Search for cars at $1000");

    String expected = "No car found ($1000)";
    System.out.println("Expected: " + expected);
    frontend.searchCarByPrice("1000");
  }

  /**
   * Verifies output printed to console by searchCheapest() is equivalent to expected result (no
   * assertEquals test, since method is void) Instead, the user should visually verify alignment
   */
  @Test
  public void testSearchCheapest() {
    Scanner sc = new Scanner(System.in);
    CarSearchBackendFD backend = new CarSearchBackendFD();

    CarSearchFrontend frontend = new CarSearchFrontend(sc, backend);
    String expected = "Ford, Wausau, Blue, 2000\n";

    System.out.println("\n\nTEST: Cheapest Car (type 1)");
    System.out.println("Expected: " + expected);
    frontend.runCommandLoop();
  }

  /**
   * Verifies output printed to console by searchPriciest() is equivalent to expected result (no
   * assertEquals test, since method is void) Instead, the user should visually verify alignment
   */
  @Test
  public void testSearchPriciest() {
    Scanner sc = new Scanner(System.in);
    CarSearchBackendFD backend = new CarSearchBackendFD();

    System.out.println("\n\nTest: Search for priciest car");
    CarSearchFrontend frontend = new CarSearchFrontend(sc, backend);
    String expected = "Bugatti, New York, Red, 350000";
    System.out.println("Expected: " + expected);

    frontend.searchPriciest();
  }

  /**
   * Verifies output printed to console by testCheapestCarAbovePrice() is equivalent to expected
   * result (no assertEquals test, since method is void) Instead, the user should visually verify
   * alignment
   */
  @Test
  public void testCheapestCarAbovePrice() {
    Scanner sc = new Scanner(System.in);
    CarSearchBackendFD backend = new CarSearchBackendFD();

    CarSearchFrontend frontend = new CarSearchFrontend(sc, backend);
    System.out.println("\n\nTest: Searching for cheapest car above 30000");
    String expected = "Chevy, Chicago, White, 40000";

    System.out.println("Expected: " + expected);
    frontend.searchCheapestAbovePrice("30000");
  }

  /**
   * Verifies output printed to console by testCheapestCarAbovePriceNull() is equivalent to expected
   * result when no car is found (no assertEquals test, since method is void) Instead, the user
   * should visually verify alignment
   */
  @Test
  public void testCheapestCarAbovePriceNull() {
    Scanner sc = new Scanner(System.in);
    CarSearchBackendFD backend = new CarSearchBackendFD();

    CarSearchFrontend frontend = new CarSearchFrontend(sc, backend);
    System.out.println("\n\nTest: Searching for cheapest car above 50000 (Null)");
    String expected = "No car found.";

    System.out.println("Expected: " + expected);
    frontend.searchCheapestAbovePrice("50000");
  }

  /**
   * Test to verify functionality of RunCommandLoop() when user enters a number less than 1 or
   * greater than 4
   */
  @Test
  public void testRunCommandLoopIncorrect() {
    Scanner sc = new Scanner(System.in);
    CarSearchBackendFD backend = new CarSearchBackendFD();

    CarSearchFrontend frontend = new CarSearchFrontend(sc, backend);
    System.out.println("\n\nRun command loop test:");
    System.out.println("Expected response: Invalid command. Please enter 1, 2, 3, or 4.\");");
    frontend.runCommandLoop();
  }



}
