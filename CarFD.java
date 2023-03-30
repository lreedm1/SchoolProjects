
public class CarFD {
  
  private String location;
    private String brand;
    private String color;
    private double price;

    public CarFD(String location, String brand, String color, String number, double price) {
        this.location = location;
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getLocation() {
        return location;
    }
    }

