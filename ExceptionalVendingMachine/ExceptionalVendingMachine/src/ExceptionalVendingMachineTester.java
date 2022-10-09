//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Exceptional Vending Machine
// Course:   CS 300 Fall 2022
//
// Author:   Reed Lokken
// Email:    rlokken@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Aarav Gupta
// Partner Email: agupta297@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   X Write-up states that pair programming is allowed for this assignment.
//   X We have both read and understand the course Pair Programming Policy.
//   X We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE        
// Online Sources: Github Copilot | Javadocs https://cs300-www.cs.wisc.edu/wp/wp-content/uploads/2020/12/fall2022/p4/doc/allclasses-index.html
///////////////////////////////////////////////////////////////////////////////

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.security.KeyStore.CallbackHandlerProtection;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;
import java.util.Scanner;

/**
 * This class implements testers to check the correctness of the methods
 * implemented in p04
 * Exceptional Vending Machine
 *
 */
public class ExceptionalVendingMachineTester {
	// TODO It is recommended but NOT required to add additional tester methods to
	// check
	// the correctness
	// of loadItems and saveVendingMachineSumary defined in the
	// ExceptionalVendingMachine class.

	/**
	 * Returns the primitive type of the given object
	 * 
	 * @return
	 */

	/**
	 * Checks the correctness of the constructor of the class Item when passed
	 * invalid inputs
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testItemConstructorNotValidInput() {
		String[] illegalDescriptions = { null, "", " " };
		Integer[] illegalExpirationDates = { -1 };

		Object[][] combinations = new Object[illegalDescriptions.length * illegalExpirationDates.length][2];
		for (int i = 0; i < illegalDescriptions.length; i++) {
			for (int j = 0; j < illegalExpirationDates.length; j++) {
				combinations[i * illegalExpirationDates.length + j][0] = illegalDescriptions[i];
				combinations[i * illegalExpirationDates.length + j][1] = illegalExpirationDates[j];
			}
		}

		for (Object combination : combinations) {
			String description = (String) ((Object[]) combination)[0];
			int expirationDate = (int) ((Object[]) combination)[1];
			try {
				Item tester = new Item(description, expirationDate);
				System.out.println("ExceptionalVendingMachine constructed " + tester + "when passed the invalid input "
						+ description + " " + expirationDate);
				return false;
			} catch (IllegalArgumentException e) {
				; // do nothing this exception was expected
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine threw the unexpected exception " + e
						+ " when passed the invalid input " + description + " " + expirationDate);
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks the correctness of the constructor of the class Item,
	 * Item.getDescription(),
	 * Item.getExpirationDate(), Item.setDescription(), and Item.toString() when
	 * passed valid inputs
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testItemConstructorGettersSetters() {
		// construct an item object with valid inputs
		String description = "Coke";
		int expirationDate = 2022;
		Item tester = new Item(description, expirationDate);

		// test .getDescription()
		String getDescription = tester.getDescription();
		if (!getDescription.equals(description)) {
			System.out.println("Item.getDescription() returned " + description
					+ " when it should have returned " + getDescription);
			return false;
		}

		// test .getExpirationDate
		int getExpirationDate = tester.getExpirationDate();
		if (getExpirationDate != expirationDate) {
			System.out.println("Item.getExpirationDate() returned " + expirationDate
					+ " when it should have returned " + getExpirationDate);
			return false;
		}

		// test .setDescription()
		String newDescription = "Sprite";
		tester.setDescription(newDescription);
		getDescription = tester.getDescription();

		if (!getDescription.equals(newDescription)) {
			System.out.println("Item.setDescription() did not change the description to " + newDescription
					+ " when it should have returned " + getDescription);
			return false;
		}

		// test .toString()
		String expected = newDescription + ": " + expirationDate;
		String toString = tester.toString();

		if (!toString.equals(expected)) {
			System.out.println("Item.toString() returned " + toString + " when it should have returned " + expected);
			return false;
		}

		return true;
	}

	/**
	 * Checks the correctness of the Item.equals() method. You should consider at
	 * least the following
	 * four scenarios. (1) Create an item with valid description and expiration
	 * date, comparing it to
	 * itself should return true. (2) Two items having the same description but
	 * different expiration
	 * dates should be equal. (3) Passing a null reference to the Item.equals()
	 * method should return
	 * false. (4) An item MUST NOT be equal to an object NOT instance of the class
	 * Item, for instance a string object.
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testItemEquals() {
		String descriptions[] = { "Chocolate", null };
		Integer expirationDates[] = { 15, 4, 1 };
	
		Object[][] combinationCount = 
			new Object[descriptions.length * expirationDates.length][2];

		for (int i = 0; i < descriptions.length; i++) {
			for (int j = 0; j < expirationDates.length; j++) {
				combinationCount[i * expirationDates.length + j][0] = descriptions[i];
				combinationCount[i * expirationDates.length + j][1] = expirationDates[j];
			}
		}

		for (Object item1 : combinationCount) {
			for (Object item2 : combinationCount) {
				String description1 = (String) ((Object[]) item1)[0];
				int expirationDate1 = (int) ((Object[]) item1)[1];
				String description2 = (String) ((Object[]) item2)[0];
				int expirationDate2 = (int) ((Object[]) item2)[1];

				Item tester1 = new Item(description1, expirationDate1);
				Item tester2 = new Item(description2, expirationDate2);

				if (tester1.equals(tester2)) {
					if (description1 == null || description2 == null) {
						System.out.println("Item.equals() returned true when passed at least one null description");
						return false;
					}
					if (!description1.equals(description2)) {
						System.out.println("Item.equals() returned true when passed two items with different descriptions");
						return false;
					}
					if (expirationDate1 != expirationDate2) {
						System.out.println("Item.equals() returned true when passed two items with different expiration dates");
						return false;
					}
				} else {
					if (description1 != null && description2 != null && description1.equals(description2)
							&& expirationDate1 == expirationDate2) {
						System.out.println("Item.equals() returned false when passed two items with the same descriptions and expiration dates");
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Checks the correctness of the constructor of the ExceptionalVendingMachine
	 * when passed invalid
	 * input
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testExceptionalVendingMachineConstructor() {
		return false; // default return statement added to resolve compiler errors
	}

	/**
	 * Checks the correctness of the following methods defined in the
	 * ExceptionalVendingMachine class
	 * when an exception is expected to be thrown:
	 * 
	 * addItem(), containsItem(), getIndexNextItem(), getItemAtIndex(),
	 * getItemOccurrences(),
	 * getItemOccurrencesByExpirationDate(), removeNextItem().
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testExceptionalVendingMachineAddContainsRemoveGetters() {
		return false; // default return statement added to resolve compiler errors
	}

	/**
	 * Checks the correctness of isEmpty(), size(), and isFull() methods defined in
	 * the
	 * ExceptionalVendingMachine class
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testEmptySizeFullExceptionalVendingMachine() {
		return false; // default return statement added to resolve compiler errors
	}

	/**
	 * Checks the correctness of loadOneItem method with respect to its
	 * specification. Consider at
	 * least the four following scenarios. (1) Successful scenario for loading one
	 * item with a valid
	 * string representation to a non-full vending machine. (2) Unsuccessful
	 * scenario for passing null
	 * or a blank string (for instance one space or empty string) to the
	 * loadOneItem() method call, an
	 * IllegalArgumentEXception is expected to be thrown. (3) Unsuccessful scenario
	 * for passing a
	 * badly formatted string to the loadOneItem method. A DataFormatException is
	 * expected to be
	 * thrown. (4) Unsuccessful scenario for trying to load an item with a valid
	 * representation to a
	 * full vending machine. An IllegalStateException is expected to be thrown.
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testLoadOneItem() {
		return false; // default return statement added to resolve compiler errors
	}

	/**
	 * Invokes all the public tester methods implemented in this class
	 * 
	 * @return true if all testers pass with no errors, and false if any of the
	 *         tester fails.
	 */
	public static boolean runAllTests() {
		boolean allTestsPassed = true;
		boolean currentTestPassed = true;

		currentTestPassed = testItemConstructorNotValidInput();
		System.out.println(currentTestPassed + "	testItemConstructorNotValidInput");
		allTestsPassed = allTestsPassed && currentTestPassed;

		currentTestPassed = testItemConstructorGettersSetters();
		System.out.println(currentTestPassed + "	testItemConstructorGettersSetters");
		allTestsPassed = allTestsPassed && currentTestPassed;

		currentTestPassed = testItemEquals();
		System.out.println(currentTestPassed + "	testItemEquals");
		allTestsPassed = allTestsPassed && currentTestPassed;

		currentTestPassed = testExceptionalVendingMachineConstructor();
		System.out.println(currentTestPassed + "	testExceptionalVendingMachineConstructor");
		allTestsPassed = allTestsPassed && currentTestPassed;

		currentTestPassed = testExceptionalVendingMachineAddContainsRemoveGetters();
		System.out.println(currentTestPassed + "	testExceptionalVendingMachineAddContainsRemoveGetters");
		allTestsPassed = allTestsPassed && currentTestPassed;

		currentTestPassed = testEmptySizeFullExceptionalVendingMachine();
		System.out.println(currentTestPassed + "	testEmptySizeFullExceptionalVendingMachine");
		allTestsPassed = allTestsPassed && currentTestPassed;

		currentTestPassed = testLoadOneItem();
		System.out.println(currentTestPassed + "	testLoadOneItem");
		allTestsPassed = allTestsPassed && currentTestPassed;

		return allTestsPassed;
	}

	/**
	 * Main method for the tester class
	 * 
	 * @param args list of input arguments if any
	 */
	public static void main(String[] args) {
		System.out.println("\n\n-------------------");
		if (runAllTests())
			System.out.println("\nCongratulations, the tests passed. You can submit your code.");
		else
			System.out.println("\nYou have bugs to fix...");
		System.out.println("-------------------\n\n");
	}
}
