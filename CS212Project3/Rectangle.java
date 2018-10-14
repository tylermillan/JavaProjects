
public class Rectangle implements Measurable {
	protected double _length;
	protected double _height;

	public Rectangle(double length, double height) {
		_length = length;
		_height = height;}
	
	@Override
	public double getArea() {
		return _length * _height;
	}

}
