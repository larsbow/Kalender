package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logikk.EndreAvtaleLogic;
import logikk.InboxLogic;
import logikk.LoginLogic;

public class Hovedside extends JFrame implements ActionListener{
	
	Menu menu;
	Avtale avtale;
	Inbox inbox;
	EndreAvtale endreAvtale;
	CalenderGUI kalender;
	EndreAvtaleLogic eal;
	InboxLogic il;
	EndreAlarm endrealarmbox;
	String bruker;
	
	
	public Hovedside(String bruker) {
		setSize(500,250);
		setTitle("Kalender");
		menu = new Menu(bruker);
		add(menu, BorderLayout.WEST);
		menu.lagavtale.addActionListener(this);
		menu.kalender.addActionListener(this);
		menu.inbox.addActionListener(this);
		menu.endreavtale.addActionListener(this);
		menu.loggut.addActionListener(this);
		this.bruker = bruker;
		endreAvtale = new EndreAvtale(bruker);
		il = new InboxLogic(this.bruker);
		inbox = new Inbox(this.bruker);
		
		//avtale = new Avtale(bruker);
		//add(avtale, BorderLayout.CENTER);
		setVisible(true);
		setResizable(true);	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == menu.lagavtale){
			changeToAvtale();
		} else if (arg0.getSource() == menu.kalender) {
			changeToKalender();
		} else if (arg0.getSource() == menu.inbox) {
			changeToInbox();
		} else if (arg0.getSource() == menu.endreavtale) {
			changeToEndreavtale();
		} else if (arg0.getSource() == menu.loggut) {
			changeToLoggut();
		} else if (arg0.getSource() == endreAvtale.b2){
			if (endreAvtale.alist.getSelectedValue() == null){
				Component frame = null;
				JOptionPane.showMessageDialog(frame,"Kunne ikke slette!!\nDu må velge avtale.","Feil",JOptionPane.WARNING_MESSAGE);
				return;
			}
			endreAvtale.slettAvtale();
			changeToEndreavtale();
		} else if (arg0.getSource() == inbox.slettvarsel){
			if (!(inbox.varselvis.getSelectedValue() == null)){
				il.slettVarsel(inbox.varselvis.getSelectedValue().toString().substring(0, 4));
			} else if (!(inbox.alarmvis.getSelectedValue() == null)){
				il.slettVarsel(inbox.alarmvis.getSelectedValue().toString().substring(0, 4));
			}
		changeToInbox();
		} else if (arg0.getSource() == inbox.endrealarm){
			il.endreAlarm();
			endrealarmbox.but.addActionListener(this);
		} else if (arg0.getSource() == endrealarmbox.but){
			
		}
	}
	
public void changeToAvtale(){
		clearFrame();
		avtale = new Avtale(this.bruker);
		add(avtale, BorderLayout.CENTER);
		setSize(500,400);
		setVisible(true);
	}

	private void changeToLoggut() {
		this.dispose();
		new Login();
	}

	private void changeToEndreavtale() {
		clearFrame();
		endreAvtale = new EndreAvtale(bruker);
		add(endreAvtale,  BorderLayout.CENTER);
		endreAvtale.b2.addActionListener(this);
		setSize(500,600);
		setVisible(true);
	}

	private void changeToInbox() {
		clearFrame();
		add(inbox, BorderLayout.CENTER);
		inbox.slettvarsel.addActionListener(this);
		inbox.endrealarm.addActionListener(this);
		setSize(800,300);
		setVisible(true);
	}

	private void changeToKalender() {
		clearFrame();
		kalender = new CalenderGUI(bruker);
		add(kalender, BorderLayout.CENTER);
		setSize(550, 440);
		setVisible(true);
	}	
	
	public void clearFrame(){
		Component[] comp = this.getContentPane().getComponents();
		for (int i=0; i<comp.length; i++){
			if((comp[i] instanceof Avtale) || (comp[i] instanceof Inbox) || (comp[i] instanceof EndreAvtale) || (comp[i] instanceof CalenderGUI)){
				this.remove(comp[i]);
			}
		}

		
		setVisible(true);
	}
}
