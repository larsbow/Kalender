package gui;


import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.*;

import database.CalenderLogic;

public class CalenderGUI extends JPanel{
	//JPanel panel = new JPanel();
	// JButton btnAddFlight = new JButton(new ImageIcon("dfsd/04.png")); // må inn i for løkken

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

		int y = 0;
		for (int i = 0; i < 6; i++) {
			int x = 0;
			for (int j = 0; j < 7; j++) {
				switch (days[i][j]) {
				case 1:
					JButton date1 = new JButton(new ImageIcon("dfsd/01.png"));
					date1.setBounds(x, y, 50, 50);
					add(date1);
					break;
				case 2:
					JButton date2 = new JButton(new ImageIcon("dfsd/02.png"));
					date2.setBounds(x, y, 50, 50);
					add(date2);
					break;
				case 3:
					JButton date3 = new JButton(new ImageIcon("dfsd/03.png"));
					date3.setBounds(x, y, 50, 50);
					add(date3);
					break;
				case 4:
					JButton date4 = new JButton(new ImageIcon("dfsd/04.png"));
					date4.setBounds(x, y, 50, 50);
					add(date4);
					break;
				case 5:
					JButton date5 = new JButton(new ImageIcon("dfsd/05.png"));
					date5.setBounds(x, y, 50, 50);
					add(date5);
					break;
				case 6:
					JButton date6 = new JButton(new ImageIcon("dfsd/06.png"));
					date6.setBounds(x, y, 50, 50);
					add(date6);
					break;
				case 7:
					JButton date7 = new JButton(new ImageIcon("dfsd/07.png"));
					date7.setBounds(x, y, 50, 50);
					add(date7);
					break;
				case 8:
					JButton date8 = new JButton(new ImageIcon("dfsd/08.png"));
					date8.setBounds(x, y, 50, 50);
					add(date8);
					break;
				case 9:
					JButton date9 = new JButton(new ImageIcon("dfsd/09.png"));
					date9.setBounds(x, y, 50, 50);
					add(date9);
					break;
				case 10:
					JButton date10 = new JButton(new ImageIcon("dfsd/10.png"));
					date10.setBounds(x, y, 50, 50);
					add(date10);
					break;
				case 11:
					JButton date11 = new JButton(new ImageIcon("dfsd/11.png"));
					date11.setBounds(x, y, 50, 50);
					add(date11);
					break;
				case 12:
					JButton date12 = new JButton(new ImageIcon("dfsd/12.png"));
					date12.setBounds(x, y, 50, 50);
					add(date12);
					break;
				case 13:
					JButton date13 = new JButton(new ImageIcon("dfsd/13.png"));
					date13.setBounds(x, y, 50, 50);
					add(date13);
					break;
				case 14:
					JButton date14 = new JButton(new ImageIcon("dfsd/14.png"));
					date14.setBounds(x, y, 50, 50);
					add(date14);
					break;
				case 15:
					JButton date15 = new JButton(new ImageIcon("dfsd/15.png"));
					date15.setBounds(x, y, 50, 50);
					add(date15);
					break;
				case 16:
					JButton date16 = new JButton(new ImageIcon("dfsd/16.png"));
					date16.setBounds(x, y, 50, 50);
					add(date16);
					break;
				case 17:
					JButton date17 = new JButton(new ImageIcon("dfsd/17.png"));
					date17.setBounds(x, y, 50, 50);
					add(date17);
					break;
				case 18:
					JButton date18 = new JButton(new ImageIcon("dfsd/18.png"));
					date18.setBounds(x, y, 50, 50);
					add(date18);
					break;
				case 19:
					JButton date19 = new JButton(new ImageIcon("dfsd/19.png"));
					date19.setBounds(x, y, 50, 50);
					add(date19);
					break;
				case 20:
					JButton date20 = new JButton(new ImageIcon("dfsd/20.png"));
					date20.setBounds(x, y, 50, 50);
					add(date20);
					break;
				case 21:
					JButton date21 = new JButton(new ImageIcon("dfsd/21.png"));
					date21.setBounds(x, y, 50, 50);
					add(date21);
					break;
				case 22:
					JButton date22 = new JButton(new ImageIcon("dfsd/22.png"));
					date22.setBounds(x, y, 50, 50);
					add(date22);
					break;
				case 23:
					JButton date23 = new JButton(new ImageIcon("dfsd/23.png"));
					date23.setBounds(x, y, 50, 50);
					add(date23);
					break;
				case 24:
					JButton date24 = new JButton(new ImageIcon("dfsd/24.png"));
					date24.setBounds(x, y, 50, 50);
					add(date24);
					break;
				case 25:
					JButton date25 = new JButton(new ImageIcon("dfsd/25.png"));
					date25.setBounds(x, y, 50, 50);
					add(date25);
					break;
				case 26:
					JButton date26 = new JButton(new ImageIcon("dfsd/26.png"));
					date26.setBounds(x, y, 50, 50);
					add(date26);
					break;
				case 27:
					JButton date27 = new JButton(new ImageIcon("dfsd/27.png"));
					date27.setBounds(x, y, 50, 50);
					add(date27);
					break;
				case 28:
					JButton date28 = new JButton(new ImageIcon("dfsd/28.png"));
					date28.setBounds(x, y, 50, 50);
					add(date28);
					break;
				case 29:
					JButton date29 = new JButton(new ImageIcon("dfsd/29.png"));
					date29.setBounds(x, y, 50, 50);
					add(date29);
					break;
				case 30:
					JButton date30 = new JButton(new ImageIcon("dfsd/30.png"));
					date30.setBounds(x, y, 50, 50);
					add(date30);
					break;
				case 31:
					JButton date31 = new JButton(new ImageIcon("dfsd/31.png"));
					date31.setBounds(x, y, 50, 50);
					add(date31);
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

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (days[i][j] == 0)
					System.out.print("    ");
				else {

					if (days[i][j] < 10) {
						System.out.print("   ");
						System.out.print(days[i][j]);
					}
					else {
						System.out.print("  ");
						System.out.print(days[i][j]);
					}
				}
			}
			System.out.println(" ");
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
		//fprintf ('        %s %d\n' ,getMonthName(number), year);
		//fprintf ('  ma  ti  on  to  fr  lø  sø  \n');
		//printDays(getCalendar(year,number));
		System.out.println(cal.getMonthName(month) + year);
		System.out.println("ma ti on to fr lø sø " + "\n");
		printDays(sek);
	}
}
