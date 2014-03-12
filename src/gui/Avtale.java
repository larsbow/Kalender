package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import logikk.SpringUtilities;

public class Avtale extends JPanel implements ActionListener {

	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;

	public Avtale(String bruker) {
		String[] labels = {"Dato: ", "Starttid: ", "Sluttid: ", "Beskrivelse: "};

		//JPanel p = new JPanel(new SpringLayout());
		
		setLayout(new SpringLayout());
		setSize(400,400);
		
		
		// Bruker som oppretter
		JLabel l0 = new JLabel("Bruker: ");
		add(l0);
		JLabel l00 = new JLabel(bruker);
		add(l00);
		
		// Dato
		JLabel l1 = new JLabel(labels[0], JLabel.TRAILING);
		add(l1);
		textField1 = new JTextField(15);
		l1.setLabelFor(textField1);
		add(textField1);
		textField1.addActionListener(this); 

		// Starttid
		JLabel l2 = new JLabel(labels[1], JLabel.TRAILING);
		add(l2);
		textField2 = new JTextField(10);
		l2.setLabelFor(textField2);
		add(textField2);
		textField2.addActionListener(this); 

		// Sluttid
		JLabel l3 = new JLabel(labels[2], JLabel.TRAILING);
		add(l3);
		textField3 = new JTextField(10);
		l3.setLabelFor(textField3);
		add(textField3);
		textField3.addActionListener(this); 

		// Beskrivelse
		JLabel l4 = new JLabel(labels[3], JLabel.TRAILING);
		add(l4);
		textField4 = new JTextField(10);
		l4.setLabelFor(textField4);
		add(textField4);
		textField4.addActionListener(this); 

		//Lag-avtale knapp
		JButton b1 = new JButton("Lag avtale");
		JLabel l = new JLabel(" ");
		add(b1);
		add(l);
		b1.addActionListener(this);

		SpringUtilities.makeCompactGrid(this,
				6, 2, 		 //rows, cols
				6, 6,        //initX, initY
				6, 6);       //xPad, yPad

		//JFrame frame = new JFrame("Lag Avtale");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setOpaque(true); 
		//frame.setContentPane(p);
		//frame.pack();
		//frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}



}
