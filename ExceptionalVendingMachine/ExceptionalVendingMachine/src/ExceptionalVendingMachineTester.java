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
 * implemented in p04 Exceptional Vending Machine
 *
 */
public class ExceptionalVendingMachineTester {
	// TODO It is recommended but NOT required to add additional tester methods to
	// check
	// the correctness
	// of loadItems and saveVendingMachineSumary defined in the
	// ExceptionalVendingMachine class.

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
	 * Item.getDescription(), Item.getExpirationDate(), Item.setDescription(), and
	 * Item.toString() when passed valid inputs
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
			System.out.println("Item.getDescription() returned " + description + " when it should have returned "
					+ getDescription);
			return false;
		}

		// test .getExpirationDate
		int getExpirationDate = tester.getExpirationDate();
		if (getExpirationDate != expirationDate) {
			System.out.println("Item.getExpirationDate() returned " + expirationDate + " when it should have returned "
					+ getExpirationDate);
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
	 * least the following four scenarios. (1) Create an item with valid description
	 * and expiration date, comparing it to itself should return true. (2) Two items
	 * having the same description but different expiration dates should be equal.
	 * (3) Passing a null reference to the Item.equals() method should return false.
	 * (4) An item MUST NOT be equal to an object NOT instance of the class Item,
	 * for instance a string object.
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testItemEquals() {
		// test that an item is equal to itself
		String description = "Coke";
		int expirationDate = 2022;

		Item tester = new Item(description, expirationDate);
		if (!tester.equals(tester)) {
			System.out.println("Item.equals() returned false when passed the same item");
			return false;
		}

		// test that two items with the same description but different expiration
		// dates are equal
		Item tester2 = new Item(description, expirationDate + 1);
		if (!tester.equals(tester2)) {
			System.out.println(
					"Item.equals() returned false when passed two items with the same description but different expiration dates");
			return false;
		}

		// test that passing a null reference to the Item.equals() method returns
		// false
		if (tester.equals(null)) {
			System.out.println("Item.equals() returned true when passed a null reference");
			return false;
		}

		// test that passing an object not instance of the class Item returns false
		if (tester.equals("Coke")) {
			System.out.println("Item.equals() returned true when passed an object not instance of the class Item");
			return false;
		}

		return true;
	}

	/**
	 * Checks the correctness of the constructor of the ExceptionalVendingMachine
	 * when passed invalid input
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testExceptionalVendingMachineConstructor() {
		int[] illegalCapacities = new int[] { -1, 0 };
		for (int capacity : illegalCapacities) {
			try {
				ExceptionalVendingMachine tester = new ExceptionalVendingMachine(capacity);
				System.out.println("ExceptionalVendingMachine constructor did not throw"
						+ "IllegalArgumentException when passed the invalid input " + capacity);
				return false;
			} catch (IllegalArgumentException e) {
				// do nothing
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine constructor threw exception " + e.getClass().getName()
						+ " when passed the invalid input " + capacity);
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks the correctness of the following methods defined in the
	 * ExceptionalVendingMachine class when an exception is expected to be thrown:
	 * 
	 * addItem(), containsItem(), getIndexNextItem(), getItemAtIndex(),
	 * getItemOccurrences(), getItemOccurrencesByExpirationDate(), removeNextItem().
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testExceptionalVendingMachineAddContainsRemoveGetters() {
		// addItem() method tester
		{
			// test addItem() adds an item when presented a valid input
			// and the vending machine is not full
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = "Coke";
			int expirationDate = 2022;
			try {
				tester.addItem(description, expirationDate);
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.addItem() threw exception " + e.getClass().getName()
						+ " when passed the valid input " + description + " " + expirationDate);
				return false;
			}
		}

		{
			// test addItem() throws an exception when presented a valid input
			// and the vending machine is full
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = "Coke";
			int expirationDate = 2022;
			try {
				tester.addItem(description, expirationDate);
				tester.addItem(description, expirationDate);
				System.out.println("ExceptionalVendingMachine.addItem() did not throw"
						+ "IllegalStateException when passed the valid input " + description + " " + expirationDate
						+ " and the vending machine is full");
				return false;
			} catch (IllegalStateException e) {
				// do nothing
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.addItem() threw exception " + e.getClass().getName()
						+ " when passed the valid input " + description + " " + expirationDate
						+ " and the vending machine is full");
				return false;
			}
		}

		{
			// test addItem() throws an exception when presented the invlid description null
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = null;
			int expirationDate = 2022;
			try {
				tester.addItem(description, expirationDate);
				System.out.println("ExceptionalVendingMachine.addItem() did not throw"
						+ "IllegalArgumentException when passed the invalid input " + description + " "
						+ expirationDate);
				return false;
			} catch (IllegalArgumentException e) {
				// do nothing
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.addItem() threw exception " + e.getClass().getName()
						+ " when passed the invalid input " + description + " " + expirationDate);
				return false;
			}

			// test addItem() throws an exception when presented the invlid description " "
			tester = new ExceptionalVendingMachine(1);
			description = "";
			expirationDate = 2022;
			try {
				tester.addItem(description, expirationDate);
				System.out.println("ExceptionalVendingMachine.addItem() did not throw"
						+ "IllegalArgumentException when passed the invalid input " + description + " "
						+ expirationDate);
				return false;
			} catch (IllegalArgumentException e) {
				// do nothing
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.addItem() threw exception " + e.getClass().getName()
						+ " when passed the invalid input " + description + " " + expirationDate);
				return false;
			}

			// test addItem() throws an exception when presented the invlid expirationDate
			// -1
			tester = new ExceptionalVendingMachine(1);
			description = null;
			expirationDate = -1;
			try {
				tester.addItem(description, expirationDate);
				System.out.println("ExceptionalVendingMachine.addItem() did not throw"
						+ "IllegalArgumentException when passed the invalid input " + description + " "
						+ expirationDate);
				return false;
			} catch (IllegalArgumentException e) {
				// do nothing
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.addItem() threw exception " + e.getClass().getName()
						+ " when passed the invalid input " + description + " " + expirationDate);
				return false;
			}

		}
		// containsItems() method tester
		{
			// test containsItem() returns true when presented a valid input
			// and the vending machine contains the item
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = "Coke";
			int expirationDate = 2022;
			try {
				tester.addItem(description, expirationDate);
				if (!tester.containsItem(description)) {
					System.out.println(
							"ExceptionalVendingMachine.containsItem() returned false when passed the valid input "
									+ description + " and the vending machine contains the item");
					return false;
				}
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.containsItem() threw exception " + e.getClass().getName()
						+ " when passed the valid input " + description);
				return false;
			}
		}

		{
			// test containsItem() returns false when presented a valid input
			// and the vending machine does not contain the item
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = "Coke";

			try {
				if (tester.containsItem(description)) {
					System.out.println(
							"ExceptionalVendingMachine.containsItem() returned true when passed the valid input "
									+ description + " and the vending machine does not contain the item");
					return false;
				}
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.containsItem() threw exception " + e.getClass().getName()
						+ " when passed the valid input " + description);
				return false;
			}
		}

		{
			// test containsItem() throws an exception when presented the invlid description
			// null
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = null;
			try {
				tester.containsItem(description);
				System.out.println("ExceptionalVendingMachine.containsItem() did not throw"
						+ "IllegalArgumentException when passed the invalid input " + description);
				return false;
			} catch (IllegalArgumentException e) {
				// do nothing
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.containsItem() threw exception " + e.getClass().getName()
						+ " when passed the invalid input " + description);
				return false;
			}

			// test containsItem() throws an exception when presented the invlid description
			// " "
			tester = new ExceptionalVendingMachine(1);
			description = " ";
			try {
				tester.containsItem(description);
				System.out.println("ExceptionalVendingMachine.containsItem() did not throw"
						+ "IllegalArgumentException when passed the invalid input " + description);
				return false;
			} catch (IllegalArgumentException e) {
				// do nothing
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.containsItem() threw exception " + e.getClass().getName()
						+ " when passed the invalid input " + description);
				return false;
			}
		}

		// getIndexNextItem() method tester
		{
			// test getIndexNextItem() returns the correct index when presented a valid
			// input
			// and the vending machine contains the item
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = "Coke";
			int expirationDate = 2022;
			try {
				tester.addItem(description, expirationDate);
				if (tester.getIndexNextItem(description) != 0) {
					System.out.println("ExceptionalVendingMachine.getIndexNextItem() returned "
							+ tester.getIndexNextItem(description) + " when passed the valid input " + description
							+ " and the vending machine contains the item");
					return false;
				}

			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.getIndexNextItem() threw exception "
						+ e.getClass().getName() + " when passed the valid input " + description);
				return false;
			}
		}

		{
			// test getIndexNextItem() throws NoSuchElementException when presented a valid
			// input
			// and the vending machine does not contain the item
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = "Coke";
			try {
				tester.getIndexNextItem(description);
				System.out.println("ExceptionalVendingMachine.getIndexNextItem() did not throw"
						+ "NoSuchElementException when passed the valid input " + description
						+ " and the vending machine does not contain the item");
				return false;
			} catch (NoSuchElementException e) {
				// do nothing
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.getIndexNextItem() threw exception "
						+ e.getClass().getName() + " when passed the valid input " + description);
				return false;
			}
		}

		{
			// test getindexNextItem() throws IllegalArgumentException when presented the
			// invlid description null
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = null;
			try {
				tester.getIndexNextItem(description);
				System.out.println("ExceptionalVendingMachine.getIndexNextItem() did not throw"
						+ "IllegalArgumentException when passed the invalid input " + description);
				return false;
			} catch (IllegalArgumentException e) {
				// do nothing
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.getIndexNextItem() threw exception "
						+ e.getClass().getName() + " when passed the invalid input " + description);
				return false;
			}
		}

		{
			// test getIndexNextItem() throws IllegalArgumentException when presented the
			// invlid description " "
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = " ";
			try {
				tester.getIndexNextItem(description);
				System.out.println("ExceptionalVendingMachine.getIndexNextItem() did not throw"
						+ "IllegalArgumentException when passed the invalid input " + description);
				return false;
			} catch (IllegalArgumentException e) {
				// do nothing
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.getIndexNextItem() threw exception "
						+ e.getClass().getName() + " when passed the invalid input " + description);
				return false;
			}
		}

		// getItemOccurences() method tester
		{
			// test getItemOccurences() returns the correct number of a single occurence
			// when presented
			// a valid input and the vending machine contains the item
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = "Coke";
			int expirationDate = 2022;
			try {
				tester.addItem(description, expirationDate);
				if (tester.getItemOccurrences(description) != 1) {
					System.out.println("ExceptionalVendingMachine.getItemOccurences() returned "
							+ tester.getItemOccurrences(description) + " when passed the valid input " + description
							+ " and the vending machine contains the item");
					return false;
				}

			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.getItemOccurences() threw exception "
						+ e.getClass().getName() + " when passed the valid input " + description);
				return false;
			}
		}

		{
			// test getItemOccurences() returns the correct number of multiple occurences
			// when presented
			// a valid input and the vending machine contains the item
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(4);
			String description = "Coke";
			int expirationDate = 2022;
			try {
				tester.addItem(description, expirationDate);
				tester.addItem(description, expirationDate);
				tester.addItem(description, expirationDate);
				if (tester.getItemOccurrences(description) != 3) {
					System.out.println("ExceptionalVendingMachine.getItemOccurences() returned "
							+ tester.getItemOccurrences(description) + " when passed the valid input " + description
							+ " and the vending machine contains the item");
					return false;
				}
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.getItemOccurences() threw exception "
						+ e.getClass().getName() + " when passed the valid input " + description);
				return false;
			}
		}
		{
			// test getItemOccurences() returns 0 when presented a valid input and the
			// vending machine
			// does not contain the item
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = "Coke";
			try {
				if (tester.getItemOccurrences(description) != 0) {
					System.out.println("ExceptionalVendingMachine.getItemOccurences() returned "
							+ tester.getItemOccurrences(description) + " when passed the valid input " + description
							+ " and the vending machine does not contain the item");
					return false;
				}
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.getItemOccurences() threw exception "
						+ e.getClass().getName() + " when passed the valid input " + description);
				return false;
			}
		}
		{
			// test getItemOccurences() throws IllegalArgumentException when presented an
			// invalid
			// input that is null
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = null;
			try {
				tester.getItemOccurrences(description);
				System.out.println("ExceptionalVendingMachine.getItemOccurences() did not throw"
						+ "IllegalArgumentException when passed the valid input " + description
						+ " and the vending machine does not contain the item");
				return false;
			} catch (IllegalArgumentException e) {
				// do nothing
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.getItemOccurences() threw exception "
						+ e.getClass().getName() + " when passed the valid input " + description);
				return false;
			}
		}
		{
			// test getItemOccurences() throws IllegalArgumentException when presented an
			// invalid
			// input that is an empty string
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = "";
			try {
				tester.getItemOccurrences(description);
				System.out.println("ExceptionalVendingMachine.getItemOccurences() did not throw"
						+ "IllegalArgumentException when passed the valid input " + description
						+ " and the vending machine does not contain the item");
				return false;
			} catch (IllegalArgumentException e) {
				// do nothing
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.getItemOccurences() threw exception "
						+ e.getClass().getName() + " when passed the valid input " + description);
				return false;
			}
		}
		// getItemOccurrencesByExpirationDate() method tester
		{
			// test getItemOccurrencesByExpirationDate() returns the correct number of a
			// single occurence when presented
			// a valid input and the vending machine contains the item
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = "Coke";
			int expirationDate = 2022;
			try {
				tester.addItem(description, expirationDate);
				if (tester.getItemOccurrencesByExpirationDate(description, expirationDate) != 1) {
					System.out.println("ExceptionalVendingMachine.getItemOccurrencesByExpirationDate() returned "
							+ tester.getItemOccurrencesByExpirationDate(description, expirationDate)
							+ " when passed the valid input " + expirationDate
							+ " and the vending machine contains the item");
					return false;
				}

			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.getItemOccurrencesByExpirationDate() threw exception "
						+ e.getClass().getName() + " when passed the valid input " + expirationDate);
				return false;
			}
		}
		{
			// test getItemOccurrencesByExpirationDate() returns the correct number of
			// multiple occurences when presented
			// a valid input and the vending machine contains the item
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(4);
			String description = "Coke";
			int expirationDate = 2022;
			try {
				tester.addItem(description, expirationDate);
				tester.addItem(description, expirationDate);
				tester.addItem(description, expirationDate);
				if (tester.getItemOccurrencesByExpirationDate(description, expirationDate) != 3) {
					System.out.println("ExceptionalVendingMachine.getItemOccurrencesByExpirationDate() returned "
							+ tester.getItemOccurrencesByExpirationDate(description, expirationDate)
							+ " when passed the valid input " + expirationDate
							+ " and the vending machine contains the item");
					return false;
				}
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.getItemOccurrencesByExpirationDate() threw exception "
						+ e.getClass().getName() + " when passed the valid input " + expirationDate);
				return false;
			}
		}
		{
			// test getItemOccurrencesByExpirationDate() returns 0 when presented a valid
			// input and the vending machine
			// does not contain the item
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = "Coke";
			int expirationDate = 2022;
			try {
				if (tester.getItemOccurrencesByExpirationDate(description, expirationDate) != 0) {
					System.out.println("ExceptionalVendingMachine.getItemOccurrencesByExpirationDate() returned "
							+ tester.getItemOccurrencesByExpirationDate(description, expirationDate)
							+ " when passed the valid input " + expirationDate
							+ " and the vending machine does not contain the item");
					return false;
				}
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.getItemOccurrencesByExpirationDate() threw exception "
						+ e.getClass().getName() + " when passed the valid input " + expirationDate);
				return false;
			}
		}
		{
			// test getItemOccurrencesByExpirationDate() throws IllegalArgumentException
			// when presented an invalid
			// input that is null
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = null;
			int expirationDate = 2022;
			try {
				tester.getItemOccurrencesByExpirationDate(description, expirationDate);
				System.out.println("ExceptionalVendingMachine.getItemOccurrencesByExpirationDate() did not throw"
						+ "IllegalArgumentException when passed the valid input " + expirationDate
						+ " and the vending machine does not contain the item");
				return false;
			} catch (IllegalArgumentException e) {
				// do nothing
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.getItemOccurrencesByExpirationDate() threw exception "
						+ e.getClass().getName() + " when passed the valid input " + expirationDate);
				return false;
			}
		}
		{
			// test getItemOccurrencesByExpirationDate() throws IllegalArgumentException
			// when presented an invalid
			// input that is less than 0
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = "Coke";
			int expirationDate = -1;
			try {
				tester.getItemOccurrencesByExpirationDate(description, expirationDate);
				System.out.println("ExceptionalVendingMachine.getItemOccurrencesByExpirationDate() did not throw"
						+ "IllegalArgumentException when passed the valid input " + expirationDate
						+ " and the vending machine does not contain the item");
				return false;
			} catch (IllegalArgumentException e) {
				// do nothing
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.getItemOccurrencesByExpirationDate() threw exception "
						+ e.getClass().getName() + " when passed the valid input " + expirationDate);
				return false;
			}
		}
		{
			// test getItemOccurrencesByExpirationDate() throws IllegalArgumentException
			// when presented an invalid
			// input that is blank
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = "";
			int expirationDate = 2022;
			try {
				tester.getItemOccurrencesByExpirationDate(description, expirationDate);
				System.out.println("ExceptionalVendingMachine.getItemOccurrencesByExpirationDate() did not throw"
						+ "IllegalArgumentException when passed the valid input " + expirationDate
						+ " and the vending machine does not contain the item");
				return false;
			} catch (IllegalArgumentException e) {
				// do nothing
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.getItemOccurrencesByExpirationDate() threw exception "
						+ e.getClass().getName() + " when passed the valid input " + expirationDate);
				return false;
			}
		}

		// removeNextItem() method tester
		{
			// test removeNextItem() returns the item when presented a valid input and the
			// vending machine contains the item
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = "Coke";
			int expirationDate = 2022;
			Item item = new Item(description, expirationDate);
			try {
				tester.addItem(description, expirationDate);
				if (!tester.removeNextItem(description).equals(item)) {
					System.out.println("ExceptionalVendingMachine.removeNextItem() returned "
							+ tester.removeNextItem(description) + " when passed the valid input " + description
							+ " and the vending machine contains the item");
					return false;
				}
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.removeNextItem() threw exception "
						+ e.getClass().getName() + " when passed the valid input " + description);
				return false;
			}
		}
		{
			// test removeNextItem() returns the item with the earliest expiration date when
			// presented
			// a valid input and the vending machine contains the item
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(5);
			String description = "Coke";
			int expirationDate = 2022;
			int expirationDate2 = 2021;
			Item item = new Item(description, expirationDate2);
			try {
				tester.addItem(description, expirationDate);
				tester.addItem(description, expirationDate2);
				if (!tester.removeNextItem(description).equals(item)) {
					System.out.println("ExceptionalVendingMachine.removeNextItem() returned "
							+ tester.removeNextItem(description) + " when passed the valid input " + description
							+ " and the vending machine contains the item");
					return false;
				}
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.removeNextItem() threw exception "
						+ e.getClass().getName() + " when passed the valid input " + description);
				return false;
			}
		}
		{
			// test removeNextItem() returns null when presented a valid input and the
			// vending machine does not contain the item
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = "Coke";
			try {
				if (tester.removeNextItem(description) != null) {
					System.out.println("ExceptionalVendingMachine.removeNextItem() returned "
							+ tester.removeNextItem(description) + " when passed the valid input " + description
							+ " and the vending machine does not contain the item");
					return false;
				}
			} catch (NoSuchElementException e) {
				//expected
			}catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.removeNextItem() threw exception "
						+ e.getClass().getName() + " when passed the valid input " + description);
				return false;
			}
		}
		{
			// test removeNextItem() throws IllegalArgumentException when presented an
			// invalid input that is null
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = null;
			try {
				tester.removeNextItem(description);
				System.out.println("ExceptionalVendingMachine.removeNextItem() did not throw"
						+ "IllegalArgumentException when passed the valid input " + description
						+ " and the vending machine does not contain the item");
				return false;
			} catch (IllegalArgumentException e) {
				// do nothing
			}catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.removeNextItem() threw exception "
						+ e.getClass().getName() + " when passed the valid input " + description);
				return false;
			}
		}
		{
			// test removeNextItem() throws IllegalArgumentException when presented an
			// invalid input that is blank
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = "";
			try {
				tester.removeNextItem(description);
				System.out.println("ExceptionalVendingMachine.removeNextItem() did not throw"
						+ "IllegalArgumentException when passed the valid input " + description
						+ " and the vending machine does not contain the item");
				return false;
			} catch (IllegalArgumentException e) {
				// do nothing
			}catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.removeNextItem() threw exception "
						+ e.getClass().getName() + " when passed the valid input " + description);
				return false;

			}
		}

		{
			// test getItemAtIndex() returns the correct item when presented a valid input
			// and the vending machine contains the item
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(4);
			String description = "Chocolate";
			int expirationDate = 2;
			Item item = new Item(description, expirationDate);
			try {
				tester.addItem(description, expirationDate);
				if (!tester.getItemAtIndex(0).toString().equals("Chocolate: 2")) {
					System.out.println("ExceptionalVendingMachine.getItemAtIndex() returned " + tester.getItemAtIndex(0)
							+ " when passed the valid input " + 0 + " and the vending machine contains the item");
					return false;
				}
			} catch (IndexOutOfBoundsException e) {
				// do nothing
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.getItemAtIndex() threw exception "
						+ e.getClass().getName() + " when passed the valid input " + 0);
				return false;
			}
		}
		{
			// test getItemAtIndex() throws IndexOutOfBoundsException when presented an
			// invalid
			// index that is less than 0
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(4);
			String description = "Vanilla";
			int expirationDate = 2;
			// Item item = new Item(description, expirationDate);
			try {
				tester.addItem(description, expirationDate);
				tester.getItemAtIndex(-1);
				System.out.println("ExceptionalVendingMachine.getItemAtIndex() did not throw"
						+ "IndexOutOfBoundsException when passed the valid input " + 0
						+ " and the vending machine does not contain the item");
			} catch (IndexOutOfBoundsException e) {
				// do nothing
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.getItemAtIndex() threw exception "
						+ e.getClass().getName() + " when passed the valid input " + 0);
				return false;
			}
		}

		{
			// test getItemAtIndex() throws IndexOutOfBoundsException when presented an
			// invalid
			// index that is greater than the size of the array
			ExceptionalVendingMachine tester = new ExceptionalVendingMachine(1);
			String description = "Milk";
			int expirationDate = 2;
			// Item item = new Item(description, expirationDate);
			try {
				tester.addItem(description, expirationDate);
				tester.getItemAtIndex(1);
				System.out.println("ExceptionalVendingMachine.getItemAtIndex() did not throw"
						+ "IndexOutOfBoundsException when passed the valid input " + 0
						+ " and the vending machine does not contain the item");
				return false;
			} catch (IndexOutOfBoundsException e) {
				// do nothing
			} catch (Exception e) {
				System.out.println("ExceptionalVendingMachine.getItemAtIndex() threw exception "
						+ e.getClass().getName() + " when passed the valid input " + 0);
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks the correctness of isEmpty(), size(), and isFull() methods defined in
	 * the ExceptionalVendingMachine class
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testEmptySizeFullExceptionalVendingMachine() {
		// tests the size(), isEmpty(), and isFull methods
		{
			// default size test
			ExceptionalVendingMachine o = new ExceptionalVendingMachine(3);

			if (o.size() != 0 && o.isEmpty() != true && o.isFull() == true) {
				System.out.println("Your Vending Machine does not have the default size set to 0");
				return false;
			}
			// after adding items to the vending machine test
			o.addItem("Chocolate", 0);
			o.addItem("Vanilla", 1);
			o.addItem("Peanuts", 7);
			if (o.size() != 3 || o.isEmpty() == true || o.isFull() != true) {
				System.out.println("Your Vending Machine did not have the right size after adding items");
				return false;
			}

		}
		return true;
	}

	/**
	 * Checks the correctness of loadOneItem method with respect to its
	 * specification. Consider at least the four following scenarios. (1) Successful
	 * scenario for loading one item with a valid string representation to a
	 * non-full vending machine. (2) Unsuccessful scenario for passing null or a
	 * blank string (for instance one space or empty string) to the loadOneItem()
	 * method call, an IllegalArgumentEXception is expected to be thrown. (3)
	 * Unsuccessful scenario for passing a badly formatted string to the loadOneItem
	 * method. A DataFormatException is expected to be thrown. (4) Unsuccessful
	 * scenario for trying to load an item with a valid representation to a full
	 * vending machine. An IllegalStateException is expected to be thrown.
	 * 
	 * @return true if the test verifies a correct functionality and false if any
	 *         bug is detected
	 */
	public static boolean testLoadOneItem() {
		// test loadOneItem() adds an item to a non-full vending machine

		{
			ExceptionalVendingMachine o = new ExceptionalVendingMachine(8);
			String item = "Chocolate: 0";
			try {
				o.loadOneItem(item);
			} catch (DataFormatException e) {
				System.out.println("loadOneItem() threw DataFormatException when passed the valid input " + item);
				return false;
			}
		}
		// test loadOneItem() throws IllegalArgumentException when passed a null
		// reference

		{
			ExceptionalVendingMachine o = new ExceptionalVendingMachine(8);
			try {
				o.loadOneItem(null);
			} catch (IllegalArgumentException e) {
				// expected
			} catch (Exception e) {
				System.out.println(
						"loadOneItem() threw exception " + e.getClass().getName() + " when passed a null reference");
				return false;
			}
		}
		// test that loadOneItem() throws an DataFormatException when passed a blank
		// string
		{
			ExceptionalVendingMachine o = new ExceptionalVendingMachine(8);
			try {
				o.loadOneItem(" ");
			} catch (IllegalArgumentException e) {
				// expected
			} catch (Exception e) {
				System.out.println(
						"loadOneItem() threw exception " + e.getClass().getName() + " when passed a blank string");
				return false;
			}
		}
		{

		}
		// test that loadOneItem() throws IllegalStateException when adding a
		// valid item to a full vending machine
		{
			ExceptionalVendingMachine o = new ExceptionalVendingMachine(2);
			o.addItem("Chocolate", 0);
			o.addItem("Vanilla", 1);
			try {
				o.loadOneItem("Peanuts: 7");
			} catch (IllegalStateException e) {
				// expected
			} catch (Exception e) {
				System.out.println("loadOneItem() threw exception " + e.getClass().getName()
						+ " when passed a valid item to a full vending machine");
				return false;
			}
		}
		{

		}
		return true; // default return statement added to resolve compiler errors
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
