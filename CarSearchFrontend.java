import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The CarSearchFrontend class implements the CarSearchFrontendInterface and provides a user
 * interface for searching cars in a CarFD database provided by the backend.
 */
public class CarSearchFrontend implements CarSearchFrontendInterface {
  private final Scanner userInput;
  private final CarSearchBackendFD backend;

  /**
   * Creates a new CarSearchFrontend with the given user input and backend.
   * 
   * @param userInput the Scanner used to read user input.
   * @param backend   the CarSearchBackendInterface used to search for cars.
   */
  public CarSearchFrontend(Scanner userInput, CarSearchBackendFD backend) {
    this.userInput = userInput;
    this.backend = backend;
  }

  /**
   * Runs the main command loop of the frontend, continuously prompting the user for commands until
   * they choose to quit.
   */
  @Override
  public void runCommandLoop() {
    while (true) {
      char command = mainMenuPrompt();
      if(command == 'q') {
        return;
      }
      if (command == '1') {
        searchCheapest();
        break;
      }
      if (command == '2') {
        searchPriciest();
        break;
      }
      if (command == '3') {
        searchCheapestAbovePrice(getUserInput());
        break;
      }
      if (command == '4') {
        searchCarByPrice(getUserInput());
        break;
      } else {
        System.out.println("Invalid command. Please enter 1, 2, 3, or 4.");
      }

    }
  }


  /**
   * Prompts the user for a main menu command and returns the command character entered by the user.
   * 
   * @return the command character entered by the user.
   */
  @Override
  public char mainMenuPrompt() {
    System.out.println("Select a command: type [q] to quit");
    System.out.println("[1] Find cheapest car");
    System.out.println("[2] Find priciest car");
    System.out.println("[3] Find cheapest CarFD above a price");
    System.out.println("[4] Find CarFD by price");
    String input = getUserInput();
    if (input.length() != 1) {
      System.out.println("Length too large");
      return '\0';
    }
    return input.charAt(0);
  }

  /**
   * Prompts the user for input and returns the input as a String.
   * 
   * @return the user input as a String.
   */
  @Override
  public String getUserInput() {
    System.out.print("> ");
    String given = userInput.nextLine().trim();
    return given;
  }

  /**
   * Searches for a CarFD with the given price and prints the CarFD details to the console. If no CarFD is
   * found, prints "No CarFD found." to the console.
   * 
   * @param priceStr the String representation of the price to search for.
   */
  @Override
  public void searchCarByPrice(String priceStr) {
    System.out.println("\n\nSearching for cars priced at " + priceStr + "...");

    try {
      CarFD CarFD = backend.findCarByPrice(priceStr);
      if (CarFD == null) {
        System.out.printf("No CarFD found ($%s)", priceStr);
      } else {
        System.out.print("CarFD $" + priceStr + ": ");
        printCarDetails(CarFD);
      }
    } catch (NumberFormatException e) {
      System.out.println("Invalid price. Please enter an integer.");
    }
  }

  /**
   * Searches for the cheapest CarFD in the database and prints the CarFD details to the console. If no
   * CarFD is found, prints "No CarFD found." to the console.
   */
  @Override
  public void searchCheapest() {
    System.out.println("\nSearching for cheapest...");
    CarFD CarFD = backend.getCheapest();
    if (CarFD == null) {
      System.out.println("No CarFD found (Cheapest)");
    } else {
      System.out.print("Cheapest Car: ");
      printCarDetails(CarFD);
    }
  }

  /**
   * Searches for the most expensive CarFD in the database and prints the CarFD details to the console.
   * If no CarFD is found, prints "No CarFD found." to the console.
   */
  @Override
  public void searchPriciest() {
    System.out.println("\nSearching for priciest...");
    CarFD CarFD = backend.getPriciest();
    if (CarFD == null) {
      System.out.println("No CarFD found (priciest)");
    } else {
      System.out.print("Priciest Car: ");
      printCarDetails(CarFD);
    }
  }

  /**
   * Loads in the file requested by the user
   */
  @Override
  public void loadFile() {
    System.out.println("\nEnter the name of the file with your dataset: ");
    try {
      Scanner sc = new Scanner(System.in);
      String givenFile = sc.next();
      sc.close();
      backend.loadData(givenFile);
    } catch (FileNotFoundException ex) {
      System.out.println("We could not find the file: givenFile");
      System.out.println("(Enter [q] to quit)\n");
      loadFile(); // rerun until user enters valid file
    }
  }

  /**
   * Finds the cheapest CarFD in the given database, above a certain threschold provided by the user
   * 
   * @param minPriceStr: the price threschold
   */
  @Override
  public void searchCheapestAbovePrice(String minPriceStr) {
    System.out.println("\nSearching for cheapest CarFD above " + minPriceStr + "...");
    try {
      CarFD CarFD = backend.getCheapestAbovePrice(minPriceStr);
      if (CarFD == null) {
        System.out.println("No CarFD found.");
      } else {
        System.out.print("Car: ");
        printCarDetails(CarFD);
      }
    } catch (NumberFormatException e) {
      System.out.println("Invalid price. Please enter an integer.");
    }
  }

  /**
   * Prints out the details of the given CarFD in the following format: Toyota, new jersey, red, 6300
   * 
   * @param car: the CarFD object we are extracting the information from
   */
  @Override
  public void printCarDetails(CarFD car) {
    System.out.printf("%s, %s, %s, %d%n", car.getBrand(), car.getLocation(), car.getColor(),
        (int)car.getPrice());
  }


}
