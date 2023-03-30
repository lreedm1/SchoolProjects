import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.io.FileNotFoundException;
import java.util.List;


public class DataWranglerTests {
	/**
	 * This method loads all of the data from the file 
	 * into a list and makes sure the size is correct.
	 * Then it checks if the color of the first car in the 
	 * arraylist is equal to black. 
	 * */
    @Test
    public void testReadCarsFromFileAndGetColor() throws FileNotFoundException {
        List<CarInterface> cars = CarReaderInterface.readCarsFromFile("./USA_cars_datasets.csv");
        assertEquals(790, cars.size());

        CarInterface car = cars.get(0);

        assertEquals("black", car.getColor());
    }
	/**
	 * This method loads all of the data from the file 
         * into a list and makes sure the size is correct.
	 * Then it checks the price of the second car and
	 * makes sure its the same as it should be.
	 * */
    @Test
    public void testReadCarsFromFileAndGetPrice() throws FileNotFoundException {
        List<CarInterface> cars = CarReaderInterface.readCarsFromFile("./USA_cars_datasets.csv");
        assertEquals(790, cars.size());

        CarInterface car = cars.get(1);
        assertEquals(2899.0, car.getPrice());
    }
	
    	/** 
	 * This method loads all of the data from the file
         * into a list and makes sure the size is correct.
	 * Then it checks the brand of second car and makes sure its correct.
	 * */
    @Test
    public void testReadCarsFromFileAndGetBrand() throws FileNotFoundException {
        List<CarInterface> cars = CarReaderInterface.readCarsFromFile("./USA_cars_datasets.csv");
        assertEquals(790, cars.size());

        CarInterface car = cars.get(2);
        assertEquals("dodge", car.getBrand());
    }

    /**
     * This method loads all of the data from the file
     * into a list and makes sure the size is correct.
     * Then it checks the fourth cars location and ensures its virginia.
     * */
    @Test
    public void testReadCarsFromFileAndGetLocation() throws FileNotFoundException {
        List<CarInterface> cars = CarReaderInterface.readCarsFromFile("./USA_cars_datasets.csv");
        assertEquals(790, cars.size());

        CarInterface car = cars.get(3);
        assertEquals("virginia", car.getLocation());
    }

    /**
     * This method loads all of the data from the file
     * into a list and makes sure the size is correct.
     * Then it checks two cars compared to each other 
     * and makes sure that the value returned is positive.
     * */
    @Test
    public void testReadCarsFromFileAndCompareTo() throws FileNotFoundException {
        List<CarInterface> cars = CarReaderInterface.readCarsFromFile("./USA_cars_datasets.csv");
        assertEquals(790, cars.size());

        CarInterface car1 = cars.get(0);
        CarInterface car2 = cars.get(1);

        assertTrue(car1.compareTo(car2) > 0);
    }
}

