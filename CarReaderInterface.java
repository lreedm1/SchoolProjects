import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;


public interface CarReaderInterface {
    // public CarReaderInterface();

    public static List<CarInterface> readCarsFromFile(String filename) throws FileNotFoundException{
        List<CarInterface> carList = new ArrayList<>();
        Set<Double> uniquePrices = new HashSet<>();

        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        scanner.nextLine(); // Skip header line
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] carData = line.split(",");

            String location = carData[10].trim();
            String brand = carData[2].trim();
            String color = carData[7].trim();
            double price = Double.parseDouble(carData[1].trim());

            if (!uniquePrices.contains(price)) {
                Car car = new Car(location, brand, color, price);
                carList.add(car);
                uniquePrices.add(price);
            }
        }


        scanner.close();
        return carList;
    }

}

