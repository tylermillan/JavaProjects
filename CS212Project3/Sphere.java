
public class Sphere extends Circle {

	public Sphere(double radius) {
		super(radius);}
	
	public double getArea() {
		return 4*(pi * (_radius*_radius));
	}
}
