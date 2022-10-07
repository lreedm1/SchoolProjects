/**
* NOT A CAKE
*
*/
public class Pig {
    //data fields
    private double weight; // weight in kilos
    private int age; // age in months
    private String name; // name of the pig

    // static data field
    private int totalDroveSize = 0; // 


    // constructor(s)
    public Pig(double weight, int age, String name) {
        try {
            if (weight < 0 || weight > 1000) {
                throw new IllegalArgumentException("Weight must be between 0 and 1000");
            }
            this.weight = weight;
            if (age < 0 || age > 100) {
                throw new IllegalArgumentException("Age must be between 0 and 100");
            }
            this.age = age;
            if (name == null || name.length() == 0) {
                throw new IllegalArgumentException("Name must be between 1 and 100 characters");
            }
            this.name = name;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // accessors
    public static int getTotalDroveSize() {
        return totalDroveSize;
    }

    public double getWeight() {
        return this.weight;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    //
}