import java.io.FileNotFoundException;

public class CarSearchBackendFD implements CarSearchBackendInterface{

  // CarFD(String location, String brand, String color, String number, double price)
  CarFD cheapCarFD = new CarFD("Wausau", "Ford", "Blue", "10", 2000.0);
  CarFD expensiveCarFD = new CarFD("New York", "Bugatti", "Red", "11", 350000.0);
  CarFD abovePriceCarFD = new CarFD("Chicago", "Chevy", "White", "13", 40000.0);
  CarFD specificCarFD = new CarFD("Newark", "Toyota", "Purple", "14", 22000.0);

  @Override
  public void loadData(String filename) throws FileNotFoundException {
    // TODO Auto-generated method stub
    
  }
  
  @Override
  public CarFD findCarByPrice(String price) {
    if(price.equals("22000")) {
    return specificCarFD;
    }
    else {
      return null;
    }
  }

  @Override
  public CarFD getCheapest() {
    return cheapCarFD;
  }

  @Override
  public CarFD getPriciest() {
    return expensiveCarFD;
  }

  @Override
  public CarFD getCheapestAbovePrice(String minPrice) {
    if(minPrice.equals("30000")) {
    return abovePriceCarFD;
    }
    else {
      return null;
    }
  }

  @Override
  public CarFD getMostExpensive(String category, String identifier) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getCarInfo(CarInterface CarFD) {
    // TODO Auto-generated method stub
    return null;
  }

}
