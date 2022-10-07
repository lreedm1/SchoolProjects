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
// Partner Email: Agupta297@wisc.edu
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

public class Item {
    private String description;
    private int expirationDate;

    public Item(String description, int expirationDate) throws IllegalArgumentException {
        this.description = description;
        this.expirationDate = expirationDate;
        if (expirationDate < 0 || description.equals(null) || description.equals("")) {
            throw new IllegalArgumentException("Error: Your description or expirationDate input is Invalid");
        }
    }

    public String getDescription() {
        return description;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public void setDescription(String description) throws IllegalArgumentException {
        // TODO
    }

    @Override
    public String toString() {
        // TODO
        return null;
    }

    public boolean equals(Object other) {
        // TODO
        return false;
    }

}
