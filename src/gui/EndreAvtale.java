package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
	private JButton b2;
	private EndreAvtaleLogic eal;
	private String bruker;

	public EndreAvtale(String bruker) {
		String[] labels = {"AvtaleID: ", "Dato: (DDMM≈≈≈≈)", "Starttid: (TTMM)", "Sluttid: (TTMM)", "Beskrivelse: ", "RomID: ", "Sted: "};
		setBruker(bruker);
		//JPanel p = new JPanel(new SpringLayout());

		eal = new EndreAvtaleLogic();
		
		setLayout(new SpringLayout());
		setSize(400,400);

		// AvtaleID
//		JLabel l0 = new JLabel(labels[0], JLabel.TRAILING);
//		add(l0);
//		textField0 = new JTextField(15);
//		l0.setLabelFor(textField0);
//		add(textField0);
//		textField0.addActionListener(this); 
		
		JPanel tekstbokser = new JPanel(new SpringLayout());
		this.add(tekstbokser, SpringLayout.NORTH);
		
		JPanel avtaleliste = new JPanel(new SpringLayout());
		this.add(avtaleliste, SpringLayout.SOUTH);

		// Dato
		JLabel l1 = new JLabel(labels[1], JLabel.TRAILING);
		tekstbokser.add(l1);
		textField1 = new JTextField(15);
		l1.setLabelFor(textField1);
		tekstbokser.add(textField1);
		textField1.addActionListener(this); 

		// Starttid
		JLabel l2 = new JLabel(labels[2], JLabel.TRAILING);
		tekstbokser.add(l2);
		textField2 = new JTextField(10);
		l2.setLabelFor(textField2);
		tekstbokser.add(textField2);
		textField2.addActionListener(this); 

		// Sluttid
		JLabel l3 = new JLabel(labels[3], JLabel.TRAILING);
		tekstbokser.add(l3);
		textField3 = new JTextField(10);
		l3.setLabelFor(textField3);
		tekstbokser.add(textField3);
		textField3.addActionListener(this); 

		// Beskrivelse
		JLabel l4 = new JLabel(labels[4], JLabel.TRAILING);
		tekstbokser.add(l4);
		textField4 = new JTextField(10);
		l4.setLabelFor(textField4);
		tekstbokser.add(textField4);
		textField4.addActionListener(this); 

		// RomID
		JLabel l5 = new JLabel(labels[5], JLabel.TRAILING);
		tekstbokser.add(l5);
		textField5 = new JTextField(10);
		l5.setLabelFor(textField5);
		tekstbokser.add(textField5);
		textField5.addActionListener(this); 

		// Sted
		JLabel l6 = new JLabel(labels[6], JLabel.TRAILING);
		tekstbokser.add(l6);
		textField6 = new JTextField(10);
		l6.setLabelFor(textField6);
		tekstbokser.add(textField6);
		textField6.addActionListener(this); 


		//Lag-avtale knapp
		JButton b1 = new JButton("Lagre endringer");
		b2 = new JButton("Slett Avtale");
		tekstbokser.add(b1);
		tekstbokser.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		String[] avtaler = eal.getAvtaler(bruker);
		
		final JList alist = new JList(avtaler);
		JScrollPane listScroller = new JScrollPane(alist);
		listScroller.setPreferredSize(new Dimension(300, 80));
		avtaleliste.add(listScroller);
		alist.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					String id = alist.getSelectedValue().toString().substring(3, 7);
					ArrayList<String> info = new ArrayList<String>();
					info = eal.getInfo(id);
					textField1.setText(info.get(0));
					textField2.setText(info.get(1));
					textField3.setText(info.get(2));
					textField4.setText(info.get(3));
					textField5.setText(info.get(4));
					textField6.setText(info.get(5));
				}
			}
			
		});

		SpringUtilities.makeCompactGrid(tekstbokser,
				7, 2, 		 //rows, cols
				6, 6,        //initX, initY
				6, 6);       //xPad, yPad
		
		SpringUtilities.makeCompactGrid(avtaleliste,
				1, 1, 		 //rows, cols
				6, 6,        //initX, initY
				6, 6);       //xPad, yPad
		
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

		eal = new EndreAvtaleLogic();

		if(e.getSource() == b2) {
			int avtaleid = Integer.parseInt(textField0.getText());
			eal.slettAvtale(avtaleid, bruker);
		} else {
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

}
