package gui;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import acm.graphics.GImage;
import acm.program.GraphicsProgram;

import database.CalenderLogic;

public class CalenderGUI extends GraphicsProgram{
	int year; int month;
	CalenderLogic cal = new CalenderLogic();


	public void init() {
		addKeyListeners();
		addMouseListeners();
		setSize(400, 350);

		// blankArea.addMouseListener(this)
		
		printCalender(2014,3);
	}



	public void printDays(int[][] days) {
		int y = 0;
		for (int i = 0; i < 6; i++) {
			int x = 0;
			for (int j = 0; j < 7; j++) {
				switch (days[i][j]) {
				case 1:
					add(new GImage("01.png"), x, y);
					break;
				case 2:
					add(new GImage("02.png"), x, y);
					break;
				case 3:
					add(new GImage("03.png"), x, y);
					break;
				case 4:
					add(new GImage("04.png"), x, y);
					break;
				case 5:
					add(new GImage("05.png"), x, y);
					break;
				case 6:
					add(new GImage("06.png"), x, y);
					break;
				case 7:
					add(new GImage("07.png"), x, y);
					break;
				case 8:
					add(new GImage("08.png"), x, y);
					break;
				case 9:
					add(new GImage("09.png"), x, y);
					break;
				case 10:
					add(new GImage("10.png"), x, y);
					break;
				case 11:
					add(new GImage("11.png"), x, y);
					break;
				case 12:
					add(new GImage("12.png"), x, y);
					break;
				case 13:
					add(new GImage("13.png"), x, y);
					break;
				case 14:
					add(new GImage("14.png"), x, y);
					break;
				case 15:
					add(new GImage("15.png"), x, y);
					break;
				case 16:
					add(new GImage("16.png"), x, y);
					break;
				case 17:
					add(new GImage("17.png"), x, y);
					break;
				case 18:
					add(new GImage("18.png"), x, y);
					break;
				case 19:
					add(new GImage("19.png"), x, y);
					break;
				case 20:
					add(new GImage("20.png"), x, y);
					break;
				case 21:
					add(new GImage("21.png"), x, y);
					break;
				case 22:
					add(new GImage("22.png"), x, y);
					break;
				case 23:
					add(new GImage("23.png"), x, y);
					break;
				case 24:
					add(new GImage("24.png"), x, y);
					break;
				case 25:
					add(new GImage("25.png"), x, y);
					break;
				case 26:
					add(new GImage("26.png"), x, y);
					break;
				case 27:
					add(new GImage("27.png"), x, y);
					break;
				case 28:
					add(new GImage("28.png"), x, y);
					break;
				case 29:
					add(new GImage("29.png"), x, y);
					break;
				case 30:
					add(new GImage("30.png"), x, y);
					break;
				case 31:
					add(new GImage("31.png"), x, y);
					break;
				default:
					add(new GImage("00.png"), x, y);
					break;
				}
				x += 55;
			}
			y += 55;
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
		if (event.getClickCount() > 1);
			System.out.println("det fungerer");
	}


	public void printCalender(int year, int month) {
		int[][] sek = cal.getCalender(year, month);
		//fprintf ('        %s %d\n' ,getMonthName(number), year);
		//fprintf ('  ma  ti  on  to  fr  lø  sø  \n');
		//printDays(getCalendar(year,number));
		System.out.println("       %s %d\n" + cal.getMonthName(month) + year);
		System.out.println("ma ti on to fr lø sø " + "\n");
		printDays(sek);
	}
}
