public class Car implements CarInterface {
    private String location;
    private String brand;
    private String color;
    private double price;

    public Car(String location, String brand, String color, double price) {
        this.location = location;
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public int compareTo(CarInterface otherCar) {
        return (int)(this.price - otherCar.getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0;
    }


}

