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
				System.out.println(days[i][j]);
				System.out.println("0" + days[i][j] + ".png");
				if (days[i][j] < 10)
					add(new GImage("0" + days[i][j] + ".png"), x, y);
				else
					add(new GImage("" + days[i][j] + ".png"), x, y);	
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
