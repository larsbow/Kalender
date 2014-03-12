package gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;

import logikk.InboxLogic;

public class Inbox extends JPanel {
	
	ArrayList<String> varsel = new ArrayList<String>();
	ArrayList<String> alarm = new ArrayList<String>();
	InboxLogic il;
	JList varselvis;
	JList alarmvis;
	
	public Inbox(String bruker){
		il = new InboxLogic(bruker);
		varsel = il.getVarsel();
		alarm = il.getAlarm();
	}
}
