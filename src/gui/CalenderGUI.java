package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.*;

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
	
	int year; int month;
	CalenderLogic cal = new CalenderLogic();


	public CalenderGUI() {
		//addKeyListeners();
		//addMouseListeners();
		//setSize(400, 350);

		// blankArea.addMouseListener(this)

		printCalender(2014,3);
		
	}


	public void printDays(int[][] days) {
		setBounds(10, 10, 300, 300);
		setLayout(null); // kanskje inne i for løkke, for hver gang vi adder

		int y = 70;
		for (int i = 0; i < 6; i++) {
			int x = 0;
			for (int j = 0; j < 7; j++) {
				switch (days[i][j]) {
				case 1:
					date1 = new JButton(new ImageIcon("dfsd/01.png"));
					date1.setBounds(x, y, 50, 50);
					add(date1);
					date1.addActionListener(this);
					break;
				case 2:
					date2 = new JButton(new ImageIcon("dfsd/02.png"));
					date2.setBounds(x, y, 50, 50);
					add(date2);
					date2.addActionListener(this);
					break;
				case 3:
					date3 = new JButton(new ImageIcon("dfsd/03.png"));
					date3.setBounds(x, y, 50, 50);
					add(date3);
					date3.addActionListener(this);
					break;
				case 4:
					date4 = new JButton(new ImageIcon("dfsd/04.png"));
					date4.setBounds(x, y, 50, 50);
					add(date4);
					date4.addActionListener(this);
					break;
				case 5:
					date5 = new JButton(new ImageIcon("dfsd/05.png"));
					date5.setBounds(x, y, 50, 50);
					add(date5);
					date5.addActionListener(this);
					break;
				case 6:
					date6 = new JButton(new ImageIcon("dfsd/06.png"));
					date6.setBounds(x, y, 50, 50);
					add(date6);
					date6.addActionListener(this);
					break;
				case 7:
					date7 = new JButton(new ImageIcon("dfsd/07.png"));
					date7.setBounds(x, y, 50, 50);
					add(date7);
					date7.addActionListener(this);
					break;
				case 8:
					date8 = new JButton(new ImageIcon("dfsd/08.png"));
					date8.setBounds(x, y, 50, 50);
					add(date8);
					date8.addActionListener(this);
					break;
				case 9:
					date9 = new JButton(new ImageIcon("dfsd/09.png"));
					date9.setBounds(x, y, 50, 50);
					add(date9);
					date9.addActionListener(this);
					break;
				case 10:
					date10 = new JButton(new ImageIcon("dfsd/10.png"));
					date10.setBounds(x, y, 50, 50);
					add(date10);
					date10.addActionListener(this);
					break;
				case 11:
					date11 = new JButton(new ImageIcon("dfsd/11.png"));
					date11.setBounds(x, y, 50, 50);
					add(date11);
					date11.addActionListener(this);
					break;
				case 12:
					date12 = new JButton(new ImageIcon("dfsd/12.png"));
					date12.setBounds(x, y, 50, 50);
					add(date12);
					date12.addActionListener(this);
					break;
				case 13:
					date13 = new JButton(new ImageIcon("dfsd/13.png"));
					date13.setBounds(x, y, 50, 50);
					add(date13);
					date13.addActionListener(this);
					break;
				case 14:
					date14 = new JButton(new ImageIcon("dfsd/14.png"));
					date14.setBounds(x, y, 50, 50);
					add(date14);
					date14.addActionListener(this);
					break;
				case 15:
					date15 = new JButton(new ImageIcon("dfsd/15.png"));
					date15.setBounds(x, y, 50, 50);
					add(date15);
					date15.addActionListener(this);
					break;
				case 16:
					date16 = new JButton(new ImageIcon("dfsd/16.png"));
					date16.setBounds(x, y, 50, 50);
					add(date16);
					date16.addActionListener(this);
					break;
				case 17:
					date17 = new JButton(new ImageIcon("dfsd/17.png"));
					date17.setBounds(x, y, 50, 50);
					add(date17);
					date17.addActionListener(this);
					break;
				case 18:
					date18 = new JButton(new ImageIcon("dfsd/18.png"));
					date18.setBounds(x, y, 50, 50);
					add(date18);
					date18.addActionListener(this);
					break;
				case 19:
					date19 = new JButton(new ImageIcon("dfsd/19.png"));
					date19.setBounds(x, y, 50, 50);
					add(date19);
					date19.addActionListener(this);
					break;
				case 20:
					date20 = new JButton(new ImageIcon("dfsd/20.png"));
					date20.setBounds(x, y, 50, 50);
					add(date20);
					date20.addActionListener(this);
					break;
				case 21:
					date21 = new JButton(new ImageIcon("dfsd/21.png"));
					date21.setBounds(x, y, 50, 50);
					add(date21);
					date21.addActionListener(this);
					break;
				case 22:
					date22 = new JButton(new ImageIcon("dfsd/22.png"));
					date22.setBounds(x, y, 50, 50);
					add(date22);
					date22.addActionListener(this);
					break;
				case 23:
					date23 = new JButton(new ImageIcon("dfsd/23.png"));
					date23.setBounds(x, y, 50, 50);
					add(date23);
					date23.addActionListener(this);
					break;
				case 24:
					date24 = new JButton(new ImageIcon("dfsd/24.png"));
					date24.setBounds(x, y, 50, 50);
					add(date24);
					date24.addActionListener(this);
					break;
				case 25:
					date25 = new JButton(new ImageIcon("dfsd/25.png"));
					date25.setBounds(x, y, 50, 50);
					add(date25);
					date25.addActionListener(this);
					break;
				case 26:
					date26 = new JButton(new ImageIcon("dfsd/26.png"));
					date26.setBounds(x, y, 50, 50);
					add(date26);
					date26.addActionListener(this);
					break;
				case 27:
					date27 = new JButton(new ImageIcon("dfsd/27.png"));
					date27.setBounds(x, y, 50, 50);
					add(date27);
					date27.addActionListener(this);
					break;
				case 28:
					date28 = new JButton(new ImageIcon("dfsd/28.png"));
					date28.setBounds(x, y, 50, 50);
					add(date28);
					date28.addActionListener(this);
					break;
				case 29:
					date29 = new JButton(new ImageIcon("dfsd/29.png"));
					date29.setBounds(x, y, 50, 50);
					add(date29);
					date29.addActionListener(this);
					break;
				case 30:
					date30 = new JButton(new ImageIcon("dfsd/30.png"));
					date30.setBounds(x, y, 50, 50);
					add(date30);
					date30.addActionListener(this);
					break;
				case 31:
					date31 = new JButton(new ImageIcon("dfsd/31.png"));
					date31.setBounds(x, y, 50, 50);
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

	public void keyPressed(KeyEvent event) {
		int key;
		

		if (Character.isLetter(event.getKeyChar()))
			key = event.getKeyChar();
		else
			key = event.getKeyCode();

		switch (key) {
		case KeyEvent.VK_UP:
		case 'w':

		}
	}

	public void mouseClicked(MouseEvent event) {
		if (event.getClickCount() > 10);
		System.out.println("det fungerer");
	}


	public void printCalender(int year, int month) {		
		int[][] sek = cal.getCalender(year, month);		
		printDays(sek);
		
		setBounds(10, 10, 300, 300);
		setLayout(null);
		JButton currentMonth = new JButton(cal.getMonthName(month));
		JButton currentYear = new JButton("" + year);
		JLabel dager = new JLabel("     MA              TI             ON            TO              FR             LØ            SØ  ");
		
		currentMonth.setBounds(0, 0, 100, 30);
		currentYear.setBounds(280, 0, 100, 30);
		dager.setBounds(0, 35, 380, 30);
		
		
		add(currentMonth);
		add(currentYear);
		add(dager);
		
	}
	@Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == date1)
        	System.out.println("det fungerer");
        if(event.getSource() == date2)
        	System.out.println("det fungerer");
        if(event.getSource() == date3)
        	System.out.println("det fungerer");
        if(event.getSource() == date4)
        	System.out.println("det fungerer");
        if(event.getSource() == date5)
        	System.out.println("det fungerer");
        if(event.getSource() == date6)
        	System.out.println("det fungerer");
        if(event.getSource() == date7)
        	System.out.println("det fungerer");
        if(event.getSource() == date8)
        	System.out.println("det fungerer");
        if(event.getSource() == date9)
        	System.out.println("det fungerer");
        if(event.getSource() == date10)
        	System.out.println("det fungerer");
        if(event.getSource() == date11)
        	System.out.println("det fungerer");
        if(event.getSource() == date12)
        	System.out.println("det fungerer");
        if(event.getSource() == date13)
        	System.out.println("det fungerer");
        if(event.getSource() == date14)
        	System.out.println("det fungerer");
        if(event.getSource() == date15)
        	System.out.println("det fungerer");
        if(event.getSource() == date16)
        	System.out.println("det fungerer");
        if(event.getSource() == date17)
        	System.out.println("det fungerer");
        if(event.getSource() == date18)
        	System.out.println("det fungerer");
        if(event.getSource() == date19)
        	System.out.println("det fungerer");
        if(event.getSource() == date20)
        	System.out.println("det fungerer");
        if(event.getSource() == date21)
        	System.out.println("det fungerer");
        if(event.getSource() == date22)
        	System.out.println("det fungerer");
        if(event.getSource() == date23)
        	System.out.println("det fungerer");
        if(event.getSource() == date24)
        	System.out.println("det fungerer");
        if(event.getSource() == date25)
        	System.out.println("det fungerer");
        if(event.getSource() == date26)
        	System.out.println("det fungerer");
        if(event.getSource() == date27)
        	System.out.println("det fungerer");
        if(event.getSource() == date28)
        	System.out.println("det fungerer");
        if(event.getSource() == date29)
        	System.out.println("det fungerer");
        if(event.getSource() == date30)
        	System.out.println("det fungerer");
        if(event.getSource() == date31)
        	System.out.println("det fungerer");
   }
}
