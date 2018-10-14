public class Circle implements Measurable {
	protected double _radius;
	protected double pi = 3.14;
	
	public Circle(double radius) {
		_radius = radius;
	}
	
	@Override
	public double getArea() {
		return pi * (_radius*_radius);
	}

}
