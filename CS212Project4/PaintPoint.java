import java.awt.Graphics;
import java.awt.Color;

public class PaintPoint {
	public static final int SMALL_SIZE = 0;
	public static final int MEDIUM_SIZE = 1;
	public static final int LARGE_SIZE = 2;
	
	
	private final int _x;
	private final int _y;
	private final int _size;
	private final Color _color;
	
	public PaintPoint(int x, int y,int size,Color color) {
		_x = x;
		_y = y;
		_size = size;
		_color = color;
	}
	
	public int getX() {
		return _x;
	}

	public int getY() {
		return _y;
	}
	public int getSize() {
		return _size;
	}
	public Color getColor() {
		return _color;
	}
	public void draw(Graphics g) {
		switch (_size) {
		case SMALL_SIZE:
			g.fillOval(_x, _y, 10, 10);
			break;
		case MEDIUM_SIZE:
			g.fillOval(_x, _y, 30, 30);
			break;
		case LARGE_SIZE:
			g.fillOval(_x, _y, 50, 50);
			break;
		}
	}
}
