package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

import com.sun.org.apache.bcel.internal.generic.NEW;

import logikk.AvtaleLogic;
import logikk.AvtaleOversikt;
import logikk.CalenderLogic;

public class CalenderGUI extends JPanel implements ActionListener{
	//JPanel panel = new JPanel();
	// JButton btnAddFlight = new JButton(new ImageIcon("dfsd/04.png")); // må inn i for løkken

	JButton date1;
	JButton date2;
	JButton date3;
	JButton date4;
	JButton date5;
	JButton date6;
	JButton date7;
	JButton date8;
	JButton date9;
	JButton date10;
	JButton date11;
	JButton date12;
	JButton date13;
	JButton date14;
	JButton date15;
	JButton date16;
	JButton date17;
	JButton date18;
	JButton date19;
	JButton date20;
	JButton date21;
	JButton date22;
	JButton date23;
	JButton date24;
	JButton date25;
	JButton date26;
	JButton date27;
	JButton date28;
	JButton date29;
	JButton date30;
	JButton date31;
	JButton lastMonth;
	JButton nextMonth;

	Date date;
	Calendar calend = Calendar.getInstance();
	int year = calend.get(Calendar.YEAR);
	int month = calend.get(Calendar.MONTH) + 1;
	String bruker;
	HentAvtaleGUI avt;
	AvtaleOversikt oversikt;


	CalenderLogic cal = new CalenderLogic();


	public CalenderGUI(String bruker) {
		this.bruker= bruker;
		printCalender(year,month);

	}


	public void printDays(int[][] days) {
		setBounds(10, 10, 300, 300);
		setLayout(null); // kanskje inne i for løkke, for hver gang vi adder
		
		
		String måned = "" + month;

		if (month < 10) {
			måned = "0" + month;
		}
		
		
		int y = 70;
		for (int i = 0; i < 6; i++) {
			int x = 0;
			for (int j = 0; j < 7; j++) {
				switch (days[i][j]) {
				case 1:
					date1 = new JButton("01");
					date1.setBounds(x, y, 50, 50);
					date1.setBackground(Color.white);
					add(date1);
					date1.addActionListener(this);
					oversikt = new AvtaleOversikt(bruker, "01" + måned + year );
					if(oversikt.kollega && oversikt.user)
						date1.setBackground(Color.orange);
					else if(oversikt.kollega)
						date1.setBackground(Color.blue);
					else if (oversikt.user)
						date1.setBackground(Color.green);
					break;
				case 2:
					date2 = new JButton("02");
					date2.setBounds(x, y, 50, 50);
					date2.setBackground(Color.white);
					add(date2);
					date2.addActionListener(this);
					break;
				case 3:
					date3 = new JButton("03");
					date3.setBounds(x, y, 50, 50);
					date3.setBackground(Color.white);
					add(date3);
					date3.addActionListener(this);
					break;
				case 4:
					date4 = new JButton("04");
					date4.setBounds(x, y, 50, 50);
					date4.setBackground(Color.white);
					add(date4);
					date4.addActionListener(this);
					break;
				case 5:
					date5 = new JButton("05");
					date5.setBounds(x, y, 50, 50);
					date5.setBackground(Color.white);
					add(date5);
					date5.addActionListener(this);
					break;
				case 6:
					date6 = new JButton("06");
					date6.setBounds(x, y, 50, 50);
					date6.setBackground(Color.white);
					add(date6);
					date6.addActionListener(this);
					break;
				case 7:
					date7 = new JButton("07");
					date7.setBounds(x, y, 50, 50);
					date7.setBackground(Color.white);
					add(date7);
					date7.addActionListener(this);
					break;
				case 8:
					date8 = new JButton("08");
					date8.setBounds(x, y, 50, 50);
					date8.setBackground(Color.white);
					add(date8);
					date8.addActionListener(this);
					break;
				case 9:
					date9 = new JButton("09");
					date9.setBounds(x, y, 50, 50);
					date9.setBackground(Color.white);
					add(date9);
					date9.addActionListener(this);
					break;
				case 10:
					date10 = new JButton("10");
					date10.setBounds(x, y, 50, 50);
					date10.setBackground(Color.white);
					add(date10);
					date10.addActionListener(this);
					break;
				case 11:
					date11 = new JButton("11");
					date11.setBounds(x, y, 50, 50);
					date11.setBackground(Color.white);
					add(date11);
					date11.addActionListener(this);
					break;
				case 12:
					date12 = new JButton("12");
					date12.setBounds(x, y, 50, 50);
					date12.setBackground(Color.white);
					add(date12);
					date12.addActionListener(this);
					break;
				case 13:
					date13 = new JButton("13");
					date13.setBounds(x, y, 50, 50);
					date13.setBackground(Color.white);
					add(date13);
					date13.addActionListener(this);
					break;
				case 14:
					date14 = new JButton("14");
					date14.setBounds(x, y, 50, 50);
					date14.setBackground(Color.white);
					add(date14);
					date14.addActionListener(this);
					break;
				case 15:
					date15 = new JButton("15");
					date15.setBounds(x, y, 50, 50);
					date15.setBackground(Color.white);
					add(date15);
					date15.addActionListener(this);
					break;
				case 16:
					date16 = new JButton("16");
					date16.setBounds(x, y, 50, 50);
					date16.setBackground(Color.white);
					add(date16);
					date16.addActionListener(this);
					break;
				case 17:
					date17 = new JButton("17");
					date17.setBounds(x, y, 50, 50);
					date17.setBackground(Color.white);
					add(date17);
					date17.addActionListener(this);
					break;
				case 18:
					date18 = new JButton("18");
					date18.setBounds(x, y, 50, 50);
					date18.setBackground(Color.white);
					add(date18);
					date18.addActionListener(this);
					break;
				case 19:
					date19 = new JButton("19");
					date19.setBounds(x, y, 50, 50);
					date19.setBackground(Color.white);
					add(date19);
					date19.addActionListener(this);
					break;
				case 20:
					date20 = new JButton("20");
					date20.setBounds(x, y, 50, 50);
					date20.setBackground(Color.white);
					add(date20);
					date20.addActionListener(this);
					break;
				case 21:
					date21 = new JButton("21");
					date21.setBounds(x, y, 50, 50);
					date21.setBackground(Color.white);
					add(date21);
					date21.addActionListener(this);
					break;
				case 22:
					date22 = new JButton("22");
					date22.setBounds(x, y, 50, 50);
					date22.setBackground(Color.white);
					add(date22);
					date22.addActionListener(this);
					break;
				case 23:
					date23 = new JButton("23");
					date23.setBounds(x, y, 50, 50);
					date23.setBackground(Color.white);
					add(date23);
					date23.addActionListener(this);
					break;
				case 24:
					date24 = new JButton("24");
					date24.setBounds(x, y, 50, 50);
					date24.setBackground(Color.white);
					add(date24);
					date24.addActionListener(this);
					break;
				case 25:
					date25 = new JButton("25");
					date25.setBounds(x, y, 50, 50);
					date25.setBackground(Color.white);
					add(date25);
					date25.addActionListener(this);
					break;
				case 26:
					date26 = new JButton("26");
					date26.setBounds(x, y, 50, 50);
					date26.setBackground(Color.white);
					add(date26);
					date26.addActionListener(this);
					break;
				case 27:
					date27 = new JButton("27");
					date27.setBounds(x, y, 50, 50);
					date27.setBackground(Color.white);
					add(date27);
					date27.addActionListener(this);
					break;
				case 28:
					date28 = new JButton("28");
					date28.setBounds(x, y, 50, 50);
					date28.setBackground(Color.white);
					add(date28);
					date28.addActionListener(this);
					break;
				case 29:
					date29 = new JButton("29");
					date29.setBounds(x, y, 50, 50);
					date29.setBackground(Color.white);
					add(date29);
					date29.addActionListener(this);
					break;
				case 30:
					date30 = new JButton("30");
					date30.setBounds(x, y, 50, 50);
					date30.setBackground(Color.white);
					add(date30);
					date30.addActionListener(this);
					break;
				case 31:
					date31 = new JButton("31");
					date31.setBounds(x, y, 50, 50);
					date31.setBackground(Color.white);
					add(date31);
					date31.addActionListener(this);
					break;

					//	default:	//trenger ikke defualt		
					//	JButton date = new JButton(new ImageIcon("dfsd/00.png"));
					//	date.setBounds(x, y, 50, 50);
					//	add(date);
					//	break;
				}
				x += 55;
			}
			y += 55;

			//add(panel);	
			//setSize(400, 400);
			//setTitle("Kalender");
			//setLocationRelativeTo(null);
			//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
		}

	}


	public void printCalender(int year, int month) {
		int[][] sek = cal.getCalender(year, month);		
		printDays(sek);

		setBounds(10, 10, 300, 300);
		setLayout(null);
		JButton currentMonth = new JButton(cal.getMonthName(month));
		lastMonth = new JButton("<--");
		nextMonth = new JButton("-->");
		JButton currentYear = new JButton("" + year);
		JLabel dager = new JLabel("     MA              TI             ON            TO              FR             LØ            SØ  ");

		currentMonth.setBounds(62, 0, 160, 30);
		currentYear.setBounds(286, 0, 94, 30);
		dager.setBounds(0, 35, 380, 30);
		lastMonth.setBounds(0, 0, 60, 30);
		nextMonth.setBounds(224, 0, 60, 30);


		add(currentMonth);
		add(currentYear);
		add(nextMonth);
		add(lastMonth);
		add(dager);

		nextMonth.addActionListener(this);
		lastMonth.addActionListener(this);
		
		updateUI();

	}
	@Override


	public void actionPerformed(ActionEvent event) {
		String måned = "" + month;

		if (month < 10) {
			måned = "0" + month;
		}

		if(event.getSource() == date1) {
			changeToDato("01" + måned + year);
		}
		if(event.getSource() == date2)
			changeToDato("02" + måned + year);

		if(event.getSource() == date3)
			changeToDato("03" + måned + year);

		if(event.getSource() == date4)
			changeToDato("04" + måned + year);

		if(event.getSource() == date5)
			changeToDato("05" + måned + year);

		if(event.getSource() == date6)
			changeToDato("06" + måned + year);

		if(event.getSource() == date7)
			changeToDato("07" + måned + year);

		if(event.getSource() == date8)
			changeToDato("08" + måned + year);

		if(event.getSource() == date9)
			changeToDato("09" + måned + year);

		if(event.getSource() == date10)
			changeToDato("10" + måned + year);

		if(event.getSource() == date11)
			changeToDato("" + 11 + måned + year);
		
		if(event.getSource() == date12){
			changeToDato("" + 12 + måned + year);
		}
		if(event.getSource() == date13)
			changeToDato("" + 13 + måned + year);
		if(event.getSource() == date14)
			changeToDato("" + 14 + måned + year);
		if(event.getSource() == date15)
			changeToDato("" + 15 + måned + year);
		if(event.getSource() == date16)
			changeToDato("" + 16 + måned + year);
		if(event.getSource() == date17)
			changeToDato("" + 17 + måned + year);
		if(event.getSource() == date18)
			changeToDato("" + 18 + måned + year);
		if(event.getSource() == date19)
			changeToDato("" + 19 + måned + year);
		if(event.getSource() == date20)
			changeToDato("" + 20 + måned+ year);
		if(event.getSource() == date21)
			changeToDato("" + 21 + måned + year);
		if(event.getSource() == date22)
			changeToDato("" + 22 + måned + year);
		if(event.getSource() == date23)
			changeToDato("" + 23 + måned + year);
		if(event.getSource() == date24)
			changeToDato("" + 24 + måned + year);
		if(event.getSource() == date25)
			changeToDato("" + 25 + måned + year);
		if(event.getSource() == date26)
			changeToDato("" + 26 + måned + year);
		if(event.getSource() == date27)
			changeToDato("" + 27 + måned + year);
		if(event.getSource() == date28)
			changeToDato("" + 28 + måned + year);
		if(event.getSource() == date29)
			changeToDato("" + 29 + måned + year);
		if(event.getSource() == date30)
			changeToDato("" + 30 + måned + year);
		if(event.getSource() == date31)
			changeToDato("" + 31 + måned + year);

		if(event.getSource() == lastMonth) {
			if (month == 1) {
				this.month = 12;
				this.year = year - 1;
			}
			else
				this.month = month - 1;
			this.removeAll();
			printCalender(year,month);
		}

		if(event.getSource() == nextMonth) {
			if (this.month == 12) {
				this.month = 1;
				this.year = year + 1;
			}
			else
				this.month = month + 1;
			this.removeAll();
			printCalender(year,month);
		}
	}

	private void changeToDato(String dato) {
		this.removeAll();
		avt = new HentAvtaleGUI(this.bruker, dato);
		add(avt, BorderLayout.CENTER);
		setSize(800,300);
		setVisible(true);
		avt.updateUI();
	}
	
}
