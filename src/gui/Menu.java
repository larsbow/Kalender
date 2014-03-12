package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import logikk.SpringUtilities;

public class Menu extends JPanel{
	
	protected JButton lagavtale;
	protected JButton kalender;
	protected JButton inbox;
	protected JButton endreavtale;
	protected JButton loggut;
	
	public Menu(){
		setSize(100, 400);
		setLayout(new SpringLayout());
		
		String[] labels = {"Lag Avtale", "Kalender", "Inbox", "Endre Avtale", "Logg ut"};
		
		lagavtale = new JButton(labels[0]);
		add(lagavtale);
		
		kalender = new JButton(labels[1]);
		add(kalender);
		
		inbox = new JButton(labels[2]);
		add(inbox);
		
		endreavtale = new JButton(labels[3]);
		add(endreavtale);
		
		loggut = new JButton(labels[4]);
		add(loggut);
		
		SpringUtilities.makeCompactGrid(this, 5, 1, 6, 6, 6, 6);
	}
		
}
	
