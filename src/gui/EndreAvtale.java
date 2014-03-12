package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import logikk.AvtaleLogic;
import logikk.EndreAvtaleLogic;
import logikk.SpringUtilities;

public class EndreAvtale extends JPanel implements ActionListener{

	private JTextField textField0;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private EndreAvtaleLogic eal;
	private String bruker;
	
	public EndreAvtale(String bruker) {
		String[] labels = {"AvtaleID: ", "Dato: ", "Starttid: ", "Sluttid: ", "Beskrivelse: ", "RomID: ", "Sted: "};
		setBruker(bruker);
		//JPanel p = new JPanel(new SpringLayout());

		setLayout(new SpringLayout());
		setSize(400,400);

		// AvtaleID
		JLabel l0 = new JLabel(labels[0], JLabel.TRAILING);
		add(l0);
		textField0 = new JTextField(15);
		l0.setLabelFor(textField0);
		add(textField0);
		textField0.addActionListener(this); 
		
		// Dato
		JLabel l1 = new JLabel(labels[1], JLabel.TRAILING);
		add(l1);
		textField1 = new JTextField(15);
		l1.setLabelFor(textField1);
		add(textField1);
		textField1.addActionListener(this); 

		// Starttid
		JLabel l2 = new JLabel(labels[2], JLabel.TRAILING);
		add(l2);
		textField2 = new JTextField(10);
		l2.setLabelFor(textField2);
		add(textField2);
		textField2.addActionListener(this); 

		// Sluttid
		JLabel l3 = new JLabel(labels[3], JLabel.TRAILING);
		add(l3);
		textField3 = new JTextField(10);
		l3.setLabelFor(textField3);
		add(textField3);
		textField3.addActionListener(this); 

		// Beskrivelse
		JLabel l4 = new JLabel(labels[4], JLabel.TRAILING);
		add(l4);
		textField4 = new JTextField(10);
		l4.setLabelFor(textField4);
		add(textField4);
		textField4.addActionListener(this); 

		// RomID
		JLabel l5 = new JLabel(labels[5], JLabel.TRAILING);
		add(l5);
		textField5 = new JTextField(10);
		l5.setLabelFor(textField5);
		add(textField5);
		textField5.addActionListener(this); 

		// Sted
		JLabel l6 = new JLabel(labels[6], JLabel.TRAILING);
		add(l6);
		textField6 = new JTextField(10);
		l6.setLabelFor(textField6);
		add(textField6);
		textField6.addActionListener(this); 


		//Lag-avtale knapp
		JButton b1 = new JButton("Lagre endringer");
		JLabel l = new JLabel(" ");
		add(b1);
		add(l);
		b1.addActionListener(this);

		SpringUtilities.makeCompactGrid(this,
				8, 2, 		 //rows, cols
				6, 6,        //initX, initY
				6, 6);       //xPad, yPad
	}

	public void setBruker(String bruker) {
		this.bruker = bruker;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		eal = new EndreAvtaleLogic();
		
		int avtaleid = Integer.parseInt(textField0.getText());
		String dato = textField1.getText();
		String starttid = textField2.getText();
		String sluttid = textField3.getText();
		String beskrivelse = textField4.getText();
		Object romid;
		if (textField5.getText().equals("")) {
			romid = null;
		} else {
			romid = Integer.parseInt(textField5.getText());
		}
		String sted = textField6.getText();

		boolean success = eal.endreAvtale(avtaleid, dato, starttid, sluttid, beskrivelse, romid, sted, bruker);
		eal.printAvtale(success);
	}
	
}
