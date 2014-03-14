package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import logikk.AvtaleLogic;
import logikk.LoginLogic;
import logikk.SpringUtilities;

public class Avtale extends JPanel implements ActionListener {

	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	private JButton b1;
	private JButton b2;
	private JList j;
	private AvtaleLogic al;
	private String bruker;
	private Rom r;

	public Avtale(String bruker) {
		String[] labels = {"Dato: (DDMM����) ", "Starttid: (TTMM)*", "Sluttid: (TTMM)", "Beskrivelse: ", "RomID: ", "Sted: ", "Deltakere: "};
		setBruker(bruker);

		JPanel p = new JPanel(new SpringLayout());
		this.add(p,SpringLayout.NORTH);

		setLayout(new SpringLayout());
		setSize(400,400);

		// Dato
		JLabel l1 = new JLabel(labels[0], JLabel.TRAILING);
		p.add(l1);
		textField1 = new JTextField(15);
		l1.setLabelFor(textField1);
		p.add(textField1);
		textField1.addActionListener(this); 

		// Starttid
		JLabel l2 = new JLabel(labels[1], JLabel.TRAILING);
		p.add(l2);
		textField2 = new JTextField(10);
		l2.setLabelFor(textField2);
		p.add(textField2);
		textField2.addActionListener(this); 

		// Sluttid
		JLabel l3 = new JLabel(labels[2], JLabel.TRAILING);
		p.add(l3);
		textField3 = new JTextField(10);
		l3.setLabelFor(textField3);
		p.add(textField3);
		textField3.addActionListener(this); 

		// Beskrivelse
		JLabel l4 = new JLabel(labels[3], JLabel.TRAILING);
		p.add(l4);
		textField4 = new JTextField(10);
		l4.setLabelFor(textField4);
		p.add(textField4);
		textField4.addActionListener(this); 

		// RomID
		JLabel l5 = new JLabel(labels[4], JLabel.TRAILING);
		p.add(l5);
		textField5 = new JTextField(10);
		l5.setLabelFor(textField5);
		p.add(textField5);
		textField5.addActionListener(this); 

		// Sted
		JLabel l6 = new JLabel(labels[5], JLabel.TRAILING);
		p.add(l6);
		textField6 = new JTextField(10);
		l6.setLabelFor(textField6);
		p.add(textField6);
		textField6.addActionListener(this); 

		// Deltakere
		JLabel l7 = new JLabel(labels[6], JLabel.TRAILING);
		p.add(l7);
		textField7 = new JTextField(10);
		l7.setLabelFor(textField7);
		p.add(textField7);
		textField7.addActionListener(this);

		//Lag �verste rutenett
		SpringUtilities.makeCompactGrid(p,
				7, 2, 		 //rows, cols
				6, 6,        //initX, initY
				6, 6);       //xPad, yPad


		//Nytt panel for liste og knapper
		JPanel p2 = new JPanel(new SpringLayout());
		this.add(p2,SpringLayout.SOUTH);
		p2.setVisible(true);
		final JLabel j7 = new JLabel("Deltakere: ");
		p2.add(j7);

		//Liste med ansatte
		al = new AvtaleLogic();

		String[] s = al.getAnsatte();

		j = new JList(s);	
		JScrollPane listScroller = new JScrollPane(j);
		listScroller.setPreferredSize(new Dimension(300, 80));
		p2.add(listScroller);
		j.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting() && !al.textContains(textField7.getText(), j.getSelectedValue().toString())) {
					textField7.setText(textField7.getText() + j.getSelectedValue().toString() + ", ");
				}
			}

		});

		//Lag-avtale knapp	
		b2 = new JButton("Finn Rom");
		b1 = new JButton("Opprett Avtale");
		p2.add(b2);
		p2.add(b1);
		b1.addActionListener(this);
		b2.addActionListener(this);

		//Sett sammen liste og label
		SpringUtilities.makeCompactGrid(p2,
				2, 2, 		 //rows, cols
				6, 6,        //initX, initY
				6, 6);       //xPad, yPad

		//Sett sammen alt
		SpringUtilities.makeCompactGrid(this,
				2, 1, 		 //rows, cols
				6, 6,        //initX, initY
				6, 6);       //xPad, yPad

	}


	public void setBruker(String bruker) {
		this.bruker = bruker;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b2) {
			String dato = textField1.getText();
			String starttid = textField2.getText();
			String sluttid = textField3.getText();
			int deltakere = textField7.getText().split(", ").length;
			r = new Rom(dato, starttid, sluttid, deltakere);
			r.b1.addActionListener(this);


		} else if (e.getSource() == b1){

			al = new AvtaleLogic();

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
			String[] deltakere; 
			deltakere = al.extractDeltakere(bruker, textField7.getText());


			boolean success = al.lagAvtale(dato, starttid, sluttid, beskrivelse, romid, sted, deltakere, bruker );
			al.printAvtale(success);
		} else if (e.getSource() == r.b1 ) {

			String s = (String) r.j.getSelectedValue();
			if(!(s == null)) {
				textField5.setText(s.substring(4,8).replaceAll("\\D+",""));
				r.frame.setVisible(false);
			}
		}
	}
}
