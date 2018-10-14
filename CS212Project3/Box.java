
public class Box extends Rectangle implements Measurable{
	private double _width;
	
	public Box(double length, double height,double width) {
		super(length,height);
		_width = width;}
	
	public double getArea() {
		return _length * _height * _width;
	}

}
