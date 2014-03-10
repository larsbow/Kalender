package gui;

import javax.swing.JFrame;

public class Main extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public static void Main(String[] args) {
		new Main().setVisible(true);;
	}
	
	private Main() {
		super("Kalender");
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
	}
}

lololol