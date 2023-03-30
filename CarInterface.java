public interface CarInterface extends Comparable<CarInterface>{
    String getColor();
    double getPrice();
    String getBrand();
    String getLocation();
    @Override
    int compareTo(CarInterface otherCar);
}


