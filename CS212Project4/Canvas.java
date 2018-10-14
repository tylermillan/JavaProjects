import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Canvas extends JPanel {
	private final ArrayList<PaintPoint> _points;
	
	private Color _currentColor;
	private int _currentSize;
	
	public Canvas() {
		_points = new ArrayList<>();
		_currentColor = Color.BLACK;
		_currentSize = PaintPoint.MEDIUM_SIZE;
		
		
		MouseAdapter adapter = new MouseAdapter() {
				@Override
		    public void mouseDragged(MouseEvent e){
						PaintPoint point = new PaintPoint(e.getX(), e.getY(),_currentSize,_currentColor);
				
						_points.add(point);
						repaint();
				}
		};
		
		addMouseListener(adapter);
		addMouseMotionListener(adapter);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (PaintPoint point : _points) {
			g.setColor(point.getColor());
			point.draw(g);
		}
	}
	public void setCurrentColor(Color color) {
		_currentColor = color;
		repaint();
	}
	
	public void setSize(int size) {
		_currentSize = size;
	}
	
	public void clearCanvas() {
		_points.clear();
		repaint();
	}
}