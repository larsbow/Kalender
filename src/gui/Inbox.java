package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTable;

import logikk.InboxLogic;

public class Inbox extends JPanel {
	
	JTable varsel;
	JTable alarm;
	InboxLogic il;
	
	public Inbox(String bruker){
		il = new InboxLogic(bruker);
		String[] header1 = {"Avtale", "Endring", "Sendt"};
		varsel = new JTable(il.getVarsel(), header1);
	}
}
