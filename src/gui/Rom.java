package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import logikk.SpringUtilities;


public class Rom extends JFrame implements ActionListener {

	private JList j;
	private JFrame frame;
	RomLogikk rl;
	
	public Rom(String dato, String starttid, String sluttid) {

		JPanel p = new JPanel(new SpringLayout());
		
		rl = new RomLogikk();
		
		Integer[] ledige = rl.finnLedige(dato, starttid, sluttid);

		j = new JList(ledige);	
		JScrollPane listScroller = new JScrollPane(j);
		listScroller.setPreferredSize(new Dimension(300, 80));
		p.add(listScroller);
		
		JButton b1 = new JButton("Godkjenn");
		p.add(b1);
		
		SpringUtilities.makeCompactGrid(p,
				2, 1, 		 //rows, cols
				6, 6,        //initX, initY
				6, 6);       //xPad, yPad
		
		frame = new JFrame("Velg Rom");
		p.setOpaque(true); 
		frame.setContentPane(p);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
