public interface CarInterface extends Comparable<CarInterface> {
  // public CarInterface(String location, String brand, String color //number, double price);
  public String getColor();

  public double getPrice();

  public String getBrand();

  public String getLocation();

  @Override
  public int compareTo(CarInterface otherCar);
}
