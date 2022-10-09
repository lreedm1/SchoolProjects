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
		* Creates a 2d array of objects with each combination of inputs in the format {description,integer}
		* 
		* @return every combination of inputs 
		**/
		private Object[] zipInputs(String[] descriptions, Integer[] items)  throws illegalInputs{
			Object[] combinations = Object[];
			Object[] tempCombination = Object[];
			
			for (i = 0; i < descriptions.length; i++) {
				tempCombination = Object[];
				for (j = 0; j < items.length; j++) {

				}
			}
		}
		/**
		 * Checks the correctness of the constructor of the class Item when passed
		 * invalid inputs
		 * 
		 * @return true if the test verifies a correct functionality and false if any
		 *         bug is detected
		 */
		public static boolean testItemConstructorNotValidInput() {

				String illegalDescriptions[] = { null, "", " " };
				Integer illegalExpirationDates[] = { -1, -2, -3 };

				for (int i=0;i<illegalDescriptions.length;i++) {
						try {
								Item tester = new Item(illegalDescriptions[i],illegalExpirationDates[i]);
								System.out.println("ExceptionalVendingMachine constructed " + tester + "when passed the invalid input "
												+ illegalDescriptions[i]+": "+illegalExpirationDates[i]);
								return false;
						} catch (IllegalArgumentException e) {
								; // do nothing this exception was expected
						} catch (Exception e) {
								System.out.println("ExceptionalVendingMachine threw the unexpected exception " + e
												+ " when passed an illegal input");
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
				// .getDescription()


				// .getExpirationDate

				// .setDes
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
		 * Item, for instance
		 * a string object.
		 * 
		 * @return true if the test verifies a correct functionality and false if any
		 *         bug is detected
		 */
		public static boolean testItemEquals() {
			String illegalDescriptions[] = { "Chocolate", "Chocolate", null };
			Integer illegalExpirationDates[] = { 15, 4, 1 };

			//for (int i=0;i<illegalDescriptions.length;i++) {
					try {
							Item tester = new Item(illegalDescriptions[0],illegalExpirationDates[0]);
							Item tester2 = new Item(illegalDescriptions[1],illegalExpirationDates[1]);
							Item tester3 = new Item(illegalDescriptions[2],illegalExpirationDates[2]);
							if(!illegalDescriptions[0].equals(illegalDescriptions[0]))return false;
							if(!tester1.equals(tester2))return false;
							if(!tester3.equals(null))return false;
							System.out.println("ExceptionalVendingMachine constructed " + tester + "when passed the invalid input "
											+ illegalDescriptions[i]+": "+illegalExpirationDates[i]);
							return false;
					} catch (IllegalArgumentException e) {
							; // do nothing this exception was expected
					} catch (Exception e) {
							System.out.println("ExceptionalVendingMachine threw the unexpected exception " + e
											+ " when passed an illegal input");
							return false;
					}
		//  }
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

				System.out.println("testItemConstructorNotValidInput: " + testItemConstructorNotValidInput());
				System.out.println("testItemConstructorGettersSetters: " + testItemConstructorGettersSetters());
				System.out.println("testItemEquals: " + testItemEquals());
				System.out.println("testExceptionalVendingMachineConstructor: " + testExceptionalVendingMachineConstructor());
				System.out.println("testExceptionalVendingMachineAddContainsRemoveGetters: "
								+ testExceptionalVendingMachineAddContainsRemoveGetters());
				System.out.println("testEmptySizeFullExceptionalVendingMachine: " + testEmptySizeFullExceptionalVendingMachine());
				System.out.println("testLoadOneItem: " + testLoadOneItem());
				return false; // default return statement added to resolve compiler errors
		}

		/**
		 * Main method for the tester class
		 * 
		 * @param args list of input arguments if any
		 */
		public static void main(String[] args) {
				System.out.println("runAllTests: " + runAllTests());
		}

}
