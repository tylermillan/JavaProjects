import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private final Canvas _canvas;
	
	public MainFrame() {
		super("Main");
		setLayout(new BorderLayout());
		
		_canvas = new Canvas();
		_canvas.setPreferredSize(new Dimension(800, 600));
		add(_canvas, BorderLayout.CENTER);
		
		JButton blackButton = new JButton("Black");
		blackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_canvas.setCurrentColor(Color.black);
			}			
		});
		JButton greenButton = new JButton("Green");
		greenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_canvas.setCurrentColor(Color.green);
			}			
		});
		JButton yellowButton = new JButton("Yellow");
		yellowButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_canvas.setCurrentColor(Color.yellow);
			}			
		});
		JButton grayButton = new JButton("Gray");
		grayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_canvas.setCurrentColor(Color.gray);
			}			
		});
		JButton smallButton = new JButton("Small");
		smallButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_canvas.setSize(PaintPoint.SMALL_SIZE);
			}			
		});
		JButton mediumButton = new JButton("Medium");
		mediumButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_canvas.setSize(PaintPoint.MEDIUM_SIZE);
			}			
		});
		JButton largeButton = new JButton("Large");
		largeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_canvas.setSize(PaintPoint.LARGE_SIZE);
			}			
		});
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_canvas.clearCanvas();
			}			
		});
		
		JPanel colorButtonPanel = new JPanel(new GridLayout(4, 1));
		colorButtonPanel.add(blackButton);
		colorButtonPanel.add(greenButton);
		colorButtonPanel.add(yellowButton);
		colorButtonPanel.add(grayButton);
		JPanel size_clear_buttonPanel = new JPanel(new GridLayout(4, 1));
		size_clear_buttonPanel.add(smallButton);
		size_clear_buttonPanel.add(mediumButton);
		size_clear_buttonPanel.add(largeButton);
		size_clear_buttonPanel.add(clearButton);
		
		add(colorButtonPanel, BorderLayout.WEST);
		add(size_clear_buttonPanel, BorderLayout.EAST);

	}
}