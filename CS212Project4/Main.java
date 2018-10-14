import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {	
		MainFrame frame = new MainFrame();
		//Closes the operations when frame is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}