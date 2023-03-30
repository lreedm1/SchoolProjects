
public class AE_Car implements CarInterface{
	
	private String location;
	private String brand;
	private String color;
	private double price;

	public AE_Car (String location, String brand, String color, double price) {
		this.location = location;
		this.brand = brand;
		this.color = color;
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
	public int compareTo(AE_Car o) {
		// TODO Auto-generated method stub
		return Double.compare(this.price, o.price);
	}
}
