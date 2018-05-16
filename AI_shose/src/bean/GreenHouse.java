package bean;

public class GreenHouse {
	int id;
	int temperature;
	int humidity;
	int illumination;
	boolean isbreed;
	String type;
	double area;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public int getIllumination() {
		return illumination;
	}
	public void setIllumination(int illumination) {
		this.illumination = illumination;
	}
	public boolean isIsbreed() {
		return isbreed;
	}
	public void setIsbreed(boolean isbreed) {
		this.isbreed = isbreed;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public GreenHouse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GreenHouse(int id, int temperature, int humidity, int illumination, boolean isbreed, String type,
			double area) {
		super();
		this.id = id;
		this.temperature = temperature;
		this.humidity = humidity;
		this.illumination = illumination;
		this.isbreed = isbreed;
		this.type = type;
		this.area = area;
	}
	@Override
	public String toString() {
		return "GreenHouse [id=" + id + ", temperature=" + temperature + ", humidity=" + humidity + ", illumination="
				+ illumination + ", isbreed=" + isbreed + ", type=" + type + ", area=" + area + "]";
	}
}
