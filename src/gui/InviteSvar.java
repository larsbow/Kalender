package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import logikk.EndreAvtaleLogic;
import database.Database;

public class InviteSvar extends JPanel implements ActionListener {

	Database db;
	String bruker;
	int id;
	ArrayList<String> info;
	EndreAvtaleLogic eal;
	
	JLabel opprettetav;
	JTextField oatf;
	JLabel dato;
	JTextField datotf;
	JLabel start;
	JTextField starttf;
	JLabel slutt;
	JTextField slutttf;
	JLabel beskrivelse;
	JTextField btf;
	JLabel sted;
	JTextField stedtf;
	JLabel deltakere;
	JTextArea dtf;
	
	JLabel svar;
	JLabel tom;
	JButton ja;
	JButton nei;
	JLabel skjul;
	JButton s;
	
	public InviteSvar(String bruker, String avtaleid, Database db){
		this.db = db;
		this.bruker = bruker;
		this.id = Integer.parseInt(avtaleid);
		eal = new EndreAvtaleLogic();
		info = eal.getInfo(Integer.toString(this.id));
		
		setLayout(new SpringLayout());
		
		opprettetav = new JLabel("Opprettet av: ");
		this.add(opprettetav);
		
		oatf = new JTextField();
		oatf.setText(info.get(7));
		this.add(oatf);
		
		dato = new JLabel("Dato:");
		this.add(dato);
		
		datotf = new JTextField();
		datotf.setText(info.get(0));
		this.add(datotf);
		
		start = new JLabel("Starttidspunkt:");
		this.add(start);
		
		starttf = new JTextField();
		starttf.setText(info.get(1));
		
		slutt = new JLabel("Sluttid:");
		this.add(slutt);
		
		slutttf = new JTextField();
		slutttf.setText(info.get(2));
		this.add(slutttf);
		
		beskrivelse = new JLabel("beskrivelse:");
		this.add(beskrivelse);
		
		btf = new JTextField();
		btf.setText(info.get(3));
		btf.setEditable(false);
		th
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
