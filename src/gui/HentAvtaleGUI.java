package gui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import logikk.AvtaleLogic;
import logikk.HentAvtaler;
import logikk.SpringUtilities;

public class HentAvtaleGUI extends JPanel {
	
	ArrayList<String> varsel = new ArrayList<String>();
	HentAvtaler il;
	JList kollegaVis;
	JList brukerVis;
	JLabel brukerLabe;
	JLabel kollegaLabe;
	JPanel buts;
	JButton slettAvtale;
	JButton endreAvtale;
	
	public HentAvtaleGUI(String bruker, String dato){
		setLayout(new SpringLayout());
		setSize(400,400);
		
		il = new HentAvtaler(bruker, dato);
//		varsel = il.getVarsel();
//		alarm = il.getAlarm();
		
		kollegaLabe = new JLabel("Kollegaers avtaler");
		this.add(kollegaLabe);
		
		String[] brukerList = il.getAvtaleBruker();
		String[] kollegaList = il.getAvtaleKollega();
		
		kollegaVis = new JList(kollegaList);
		JScrollPane scrollvarsel = new JScrollPane(kollegaVis);
		scrollvarsel.setPreferredSize(new Dimension(400,100));
		this.add(scrollvarsel);
		
		brukerLabe = new JLabel("Dine avtaler");
		this.add(brukerLabe);
		
		System.out.println(brukerList);
		brukerVis = new JList(brukerList);
		JScrollPane scrollBruker = new JScrollPane(brukerVis);
		scrollBruker.setPreferredSize(new Dimension(400,100));
		this.add(scrollBruker);
		
		buts = new JPanel(new SpringLayout());
		buts.setSize(400, 100);
		buts.setVisible(true);
		this.add(buts);
		
		slettAvtale = new JButton("Slett Avtale");
		buts.add(slettAvtale);
		
		endreAvtale = new JButton("Endre Avtale");
		buts.add(endreAvtale);
		
		
		SpringUtilities.makeCompactGrid(buts,
				1, 2, 		 //rows, cols
				6, 6,        //initX, initY
				6, 6);       //xPad, yPad
		
		
//		for (int i = 0; i<varsel.size();i++){
//			varselvis.append(varsel.get(i));
//		}
//		for (int i = 0; i<alarm.size();i++){
//			alarmvis.append(alarm.get(i));
//		}
		SpringUtilities.makeCompactGrid(this,
				5, 1, 		 //rows, cols
				6, 6,        //initX, initY
				6, 6);       //xPad, yPad
	}

}
