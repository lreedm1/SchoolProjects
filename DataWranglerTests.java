import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.io.FileNotFoundException;
import java.util.List;


public class DataWranglerTests {
    @Test
    public void testReadCarsFromFileAndGetColor() throws FileNotFoundException {
        List<CarInterface> cars = CarReaderInterface.readCarsFromFile("./USA_cars_datasets.csv");
        assertEquals(790, cars.size());

        CarInterface car = cars.get(0);

        assertEquals("black", car.getColor());
    }

    @Test
    public void testReadCarsFromFileAndGetPrice() throws FileNotFoundException {
        List<CarInterface> cars = CarReaderInterface.readCarsFromFile("./USA_cars_datasets.csv");
        assertEquals(790, cars.size());

        CarInterface car = cars.get(1);
        assertEquals(2899.0, car.getPrice());
    }

    @Test
    public void testReadCarsFromFileAndGetBrand() throws FileNotFoundException {
        List<CarInterface> cars = CarReaderInterface.readCarsFromFile("./USA_cars_datasets.csv");
        assertEquals(790, cars.size());

        CarInterface car = cars.get(2);
        assertEquals("dodge", car.getBrand());
    }

    @Test
    public void testReadCarsFromFileAndGetLocation() throws FileNotFoundException {
        List<CarInterface> cars = CarReaderInterface.readCarsFromFile("./USA_cars_datasets.csv");
        assertEquals(790, cars.size());

        CarInterface car = cars.get(3);
        assertEquals("virginia", car.getLocation());
    }

    @Test
    public void testReadCarsFromFileAndCompareTo() throws FileNotFoundException {
        List<CarInterface> cars = CarReaderInterface.readCarsFromFile("./USA_cars_datasets.csv");
        assertEquals(790, cars.size());

        CarInterface car1 = cars.get(0);
        CarInterface car2 = cars.get(1);

        assertTrue(car1.compareTo(car2) > 0);
    }
}

