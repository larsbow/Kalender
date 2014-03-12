package gui;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Test extends JFrame {
	public JFrame frame;



	public Test() {
		frame = new JFrame();
		frame.setSize(1000, 1000);
		setResizable(true);
		JPanel panel = new JPanel(new SpringLayout());
		panel.setSize(400, 400);
		
		frame.add(panel);
		//frame.getContentPane().setLayout(new GridLayout(3, 3));
		JButton label = new JButton(new ImageIcon("dfsd/01.png"));
		label.setLocation(0, 0);
		JButton s = new JButton(new ImageIcon("dfsd/02.png"));
		s.setLocation(500, 500);
		
		panel.add(label);
		/*
		panel.add(new JButton(new ImageIcon("dfsd/02.png")));
		panel.add(new JButton(new ImageIcon("dfsd/04.png")));
		panel.add(new JButton(new ImageIcon("dfsd/03.png")));
		*/
		//frame.pack();
		frame.setVisible(true);
	}
}
