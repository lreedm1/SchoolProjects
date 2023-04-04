/**
 * Placeholder for CarInterface
 * 
 * @author harshachilakapati
 *
 */
public class CarBD implements CarInterface {
  private String location;
  private String color;
  private String brand;
  private double price;

  public CarBD(String loc, String brand, String color, double price) {
    location = loc;
    this.color = color;
    this.brand = brand;
    this.price = price;
  }

  @Override
  public String getColor() {
    // TODO Auto-generated method stub
    return color;
  }

  @Override
  public double getPrice() {
    // TODO Auto-generated method stub
    return price;
  }

  @Override
  public String getBrand() {
    // TODO Auto-generated method stub
    return brand;
  }

  @Override
  public String getLocation() {
    // TODO Auto-generated method stub
    return location;
  }

  @Override
  public int compareTo(CarInterface otherCar) {
    // TODO Auto-generated method stub
    return Double.compare(this.price, otherCar.getPrice());
  }

}
