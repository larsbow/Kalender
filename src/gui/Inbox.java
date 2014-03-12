package gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import logikk.InboxLogic;
import logikk.SpringUtilities;

public class Inbox extends JPanel {
	
	ArrayList<String> varsel = new ArrayList<String>();
	ArrayList<String> alarm = new ArrayList<String>();
	InboxLogic il;
	JTextArea varselvis;
	JTextArea alarmvis;
	
	public Inbox(String bruker){
		setLayout(new SpringLayout());
		setSize(400,400);
		
		il = new InboxLogic(bruker);
		varsel = il.getVarsel();
		alarm = il.getAlarm();
		
		
		varselvis = new JTextArea(20, varsel.size());
		this.add(varselvis);
		alarmvis = new JTextArea(20, alarm.size());
		this.add(alarmvis);
		for (int i = 0; i<varsel.size();i++){
			varselvis.append(varsel.get(i));
		}
		for (int i = 0; i<alarm.size();i++){
			alarmvis.append(alarm.get(i));
		}
		SpringUtilities.makeCompactGrid(this,
				2, 1, 		 //rows, cols
				6, 6,        //initX, initY
				6, 6);       //xPad, yPad
	}
}
