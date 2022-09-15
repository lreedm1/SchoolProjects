/**
 *           FILE HEADER (INCLUDE IN EVERY FILE)
 * 
 * Title: VendingMachineTester.java
 * Course: CS 300 Fall 2022
 * 
 * Author: Reed Lokken
 * Email:    Rlokken@wisc.edu
 * Lecturer: Hobbes LeGault
 * 
 *           PAIR PROGRAMMERS COMPLETE THIS SECTION
 * 
 * Partner Name:    Isha Puri
 * Partner Email:   IPuri@wisc.edu
 * Partner Lecturer's Name: Mouna Kacem
 * 
 * VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
 *  X Write-up states that pair programming is allowed for this assignment.
 *  X We have both read and understand the course Pair Programming Policy.
 *  X We have registered our team prior to the team registration deadline. 
 */


import java.util.Arrays;

// Javadoc style class header comes here
public class VendingMachineTester {
  // Checks the correctness of getIndexNextItem defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  public static boolean testGetIndexNextItem() {
    // Test scenarios normal and edge cases
    // Recall that the VendingMachine.getNextItem method gets the next item to be dispensed given
    // its description without removing it.

    // 1. Next item to be dispensed is NOT found: the expected output is -1
    {
      // define the vending machine
      String[][] items =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      int itemsCount = 3;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("candy", items, itemsCount) != -1) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did not return "
                + "-1 when no match found.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 2. Next item to be dispensed is at index 0
    {
      String[][] items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 0) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains multiple matches with the "
                + "provided item description and the matching item with the soonest expiration date "
                + "is at index 0.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 3. Next item to be dispensed is at the end of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Chocolate", items, itemsCount) != 6) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains multiple matches with the "
                + "provided item description and the matching item with the soonest expiration date "
                + "is at the end of the array");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 4. Next item to be dispensed is at the middle of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 3) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains matches with the provided "
                + "item description with different expiration dates.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    return true; // No bug detected
  }

  // Checks the correctness of containsItem defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  public static boolean testContainsItem() {
    // Define at least two test scenarios: (1) successful search returning true and (2) unsuccessful
    // search returning false.

    // 1. Successful search: the expected output is true
    {
      // define the vending machine
      String[][] items =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      int itemsCount = 3;

      // check the correctness of the output
      if (!VendingMachine.containsItem("Water", items, itemsCount)) {
        System.out.println(
            "testContainsItem-scenario 1. Problem detected: Your containsItem did not return "
                + "true when the item is found.");
        return false;
      }
      // Check that the method returns false when the item is not found
      if (VendingMachine.containsItem("Candy", items, itemsCount)) {
        System.out.println(
            "testContainsItem-scenario 1. Problem detected: Your containsItem did not return "
                + "false when the item is not found.");
        return false;
      }
    }
    return true; // No bug detected
  }

  // Checks the correctness of getItemAtIndex defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  public static boolean testGetItemAtIndex() {
    // Define at least two test scenarios: (1) the provided index is out of the range
    // 0..itemsCount-1, (2) the provided index is in bounds [0..itemsCount-1].
    // For each test scenario, ensure that the method returned the exact expected string output
    // without making any changes to the contents of the array.

    // define the vending machine
    String[][] items =
        new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
    int itemsCount = 3;

    // check that the array contains {"Water", "15"} at index 0 and that the method did not make
    // changes to the contents of the array
    if (!VendingMachine.getItemAtIndex(0, items, itemsCount).equals("Water, 15")) {
      System.out.println(
          "testGetItemAtIndex-scenario 1. Problem detected: Your getItemAtIndex did not return "
              + "the expected output when the provided index is in bounds.");
      return false;
    }
    // Check that the method returns null when the provided index is out of bounds
    if (VendingMachine.getItemAtIndex(3, items, itemsCount) != null) {
      System.out.println(
          "testGetItemAtIndex-scenario 1. Problem detected: Your getItemAtIndex did not return "
              + "null when the provided index is out of bounds.");
      return false;
    }

    if (!Arrays.deepEquals(items, new String[][] {{"Water", "15"}, {"Chocolate", "10"},
        {"Juice", "20"}, null, null, null})) {
      System.out.println(
          "testGetItemAtIndex-scenario 1. Problem detected: Your getItemAtIndex made changes "
              + "to the content of the array passed as input.");
      return false;
    }
    
    return true; // No bug detected
  }

  // Checks the correctness of getItemOccurrences defined in the VendingMachine class.
  public static boolean testGetItemsOccurrences() {
    // Define at least two test scenarios: (1) no match found so that the method returns zero,
    // (2) the items array contains multiple occurrences of the provided item description.

    // For each test scenario, ensure that the method returned the expected output without making
    // any changes to the contents of the array.

    // define the vending machine
    String[][] items =
        new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
            {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
    int itemsCount = 7;

    // check that the method returns 0 when no match is found
    if (VendingMachine.getItemsOccurrences("Coke", items, itemsCount) != 0) {
      System.out.println(
          "testGetItemsOccurrences-scenario 1. Problem detected: Your getItemsOccurrences did "
              + "not return 0 when no match is found.");
      return false;
    }
    // check that the method returns 2 when two matches are found
    if (VendingMachine.getItemsOccurrences("Water", items, itemsCount) != 2) {
      System.out.println(
          "testGetItemsOccurrences-scenario 2. Problem detected: Your getItemsOccurrences did "
              + "not return 2 when two matches are found.");
      return false;
    }
    // check that the method does not make changes to the contents of the array
    if (!Arrays.deepEquals(items, new String[][] {{"Water", "15"}, {"Chocolate", "10"},
        {"Juice", "20"}, {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"},
        null, null})) {
      System.out.println(
          "testGetItemsOccurrences-scenario 2. Problem detected: Your getItemsOccurrences made "
              + "changes to the content of the array passed as input.");
      return false;
    }
    return true;
  }

  // Checks the correctness of addItem defined in the VendingMachine class.
  public static boolean testAddItem() {
    // Define at least three test scenarios: (1) adding a new item to an empty vending machine whose
    // size is zero (provided itemsCount == 0), (2) adding a new item to a non-empty non-full
    // vending machine, and (3) adding a new item to a full vending machine where the provided
    // itemsCount equals the length of the provided items array.

    // For each tester scenario, check for the expected returned size of the vending machine and
    // the expected content of the items array after the method call returns.

    // define the vending machine
    String[][] items = new String[2][2];
    int itemsCount = 0;

    // check that the method returns 1 when adding a new item to an empty vending machine
    if (VendingMachine.addItem("Water", "15", items, itemsCount) != 1) {
      System.out.println(
          "testAddItem-scenario 1. Problem detected: Your addItem did not return 1 when adding "
              + "a new item to an empty vending machine.");
      if (items[0][0] != "Water" || items[0][1] != "15") {
        System.out.println(
            "testAddItem-scenario 1. Problem detected: Your addItem did not add the new item "
                + "to the vending machine.");
      }
      return false;
    }
    // check that the method returns 2 when adding a new item to a non-empty non-full vending machine
    if (VendingMachine.addItem("Chocolate", "10", items, itemsCount) != 2) {
      System.out.println(
          "testAddItem-scenario 2. Problem detected: Your addItem did not return 2 when adding "
              + "a new item to a non-empty non-full vending machine.");
      if (items[1][0] != "Chocolate" || items[1][1] != "10") {
        System.out.println(
            "testAddItem-scenario 2. Problem detected: Your addItem did not add the new item "
                + "to the vending machine.");
      }
      return false;
    }
    // check that the method returns 2 when adding a new item to a full vending machine
    if (VendingMachine.addItem("Juice", "20", items, itemsCount) != 2) {
      System.out.println(
          "testAddItem-scenario 3. Problem detected: Your addItem did not return 2 when adding "
              + "a new item to a full vending machine.");
      if (items[1][0] != "Chocolate" || items[1][1] != "10") {
        System.out.println(
            "testAddItem-scenario 3. Problem detected: Your addItem added a new item to a full "
                + "vending machine.");
      }
      return false;
    }
    return true;
  }

  // Checks the correctness of removeNextItem defined in the VendingMachine class.
  public static boolean testRemoveNextItem() {
    // Define at least four test scenarios: (1) trying to remove a non-existing item from a vending
    // machine (the vending machine can be empty or not), (2) the next item to be removed matching
    // the provided description is at index 0 of the array, (3) the next item to be removed is at
    // index itemsCount of the array (at the end of the array), and (4) the next item to be removed
    // is at a middle index of the provided items array.

    // For each tester scenario, check for the expected returned size of the vending machine and
    // the expected content of the items array after the method call returns.

    
      // define the vending machine
      String[][] items =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};

      // check that the method returns 7 when trying to remove a non-existing item from a non-empty
      // vending machine
      if (VendingMachine.removeNextItem("Coke", items, 7) != 7) {
        System.out.println(
            "testRemoveNextItem-scenario 1. Problem detected: Your removeNextItem did not return "
                + "7 when trying to remove a non-existing item from a non-empty vending machine.");
        if (!Arrays.deepEquals(items, new String[][] {{"Water", "15"}, {"Chocolate", "10"},
            {"Juice", "20"}, {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"},
            null, null})) {
          System.out.println(
              "testRemoveNextItem-scenario 1. Problem detected: Your removeNextItem made changes "
                  + "to the content of the array passed as input.");
        }        
        return false;
      }
      // check that the method can remove the first item in the vending machine
      if (VendingMachine.removeNextItem("Water", items, 7) != 6) {
        System.out.println(
            "testRemoveNextItem-scenario 2. Problem detected: Your removeNextItem did not return "
                + "6 when trying to remove the first item in the vending machine.");
        if (!Arrays.deepEquals(items, new String[][] {{"Chocolate", "10"}, {"Juice", "20"},
            {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null,
            null})) {
          System.out.println(
              "testRemoveNextItem-scenario 2. Problem detected: Your removeNextItem did not remove "
                  + "the first item in the vending machine.");
        }
        // check that the method can remove the last item in the vending machine
        if (VendingMachine.removeNextItem("Chocolate", items, 6) != 5) {
          System.out.println(
              "testRemoveNextItem-scenario 3. Problem detected: Your removeNextItem did not return "
                  + "5 when trying to remove the last item in the vending machine.");
          if (!Arrays.deepEquals(items, new String[][] {{"Chocolate", "10"}, {"Juice", "20"},
              {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, null, null, null, null})) {
            System.out.println(
                "testRemoveNextItem-scenario 3. Problem detected: Your removeNextItem did not "
                    + "remove the last item in the vending machine.");
          }
        // check that the method can remove an item in the middle of the vending machine
        if (VendingMachine.removeNextItem("Water", items, 5) != 4) {
          System.out.println(
              "testRemoveNextItem-scenario 4. Problem detected: Your removeNextItem did not "
                  + "return 4 when trying to remove an item in the middle of the vending machine.");
          if (!Arrays.deepEquals(items, new String[][] {{"Chocolate", "10"}, {"Juice", "20"},
              {"Water", "5"}, {"Candy", "30"}, null, null, null, null, null})) {
            System.out.println(
                "testRemoveNextItem-scenario 4. Problem detected: Your removeNextItem did not "
                    + "remove an item in the middle of the vending machine.");
          }
            return false;
          }
          return false;
        }
        return false;
      }
  return false;
  }

  // This method returns false if any of the tester methods defined in this class fails, and true
  // if no bug detected.
  public static boolean runAllTests() {
    return testGetIndexNextItem() && testContainsItem() && testGetItemAtIndex()
        && testGetItemsOccurrences() && testAddItem() && testRemoveNextItem()
        && testGetItemsSummary();
  }

  // main method to call the tester methods defined in this class
  public static void main(String[] args) {
    System.out.println("runAllTests(): " + runAllTests());
  }

}
