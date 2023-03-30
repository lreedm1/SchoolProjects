import java.io.FileNotFoundException;

public interface CarSearchBackendInterface {   
    // public CarFDSearchBackendInterface(RedBlackTreeInterface<CarFDInterface> rbTree, CarFDReaderInterface CarFDReader);
    public void loadData(String filename) throws FileNotFoundException;
    public CarFD findCarByPrice(String price);
    public CarFD getCheapest();
    public CarFD getPriciest();
    public CarFD getCheapestAbovePrice(String minPrice);
    public CarFD getMostExpensive(String category, String identifier);
    public String getCarInfo(CarInterface CarFD);
}
