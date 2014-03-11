package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import logikk.LoginLogic;
import logikk.SpringUtilities;

public class Login extends JFrame implements ActionListener {

	private JTextField textField1;
	private JPasswordField textField2;
	private LoginLogic ll;
	private JFrame frame;
	public String bruker;
	JButton b2;

	public Login() {
		String[] labels = {"Brukernavn: ", "Passord: "};

		JPanel p = new JPanel(new SpringLayout());

		// Brukernavn
		JLabel l1 = new JLabel(labels[0], JLabel.TRAILING);
		p.add(l1);
		textField1 = new JTextField(10);
		l1.setLabelFor(textField1);
		p.add(textField1);
		textField1.addActionListener(this);

		// Passord
		JLabel l2 = new JLabel(labels[1], JLabel.TRAILING);
		p.add(l2);
		textField2 = new JPasswordField(10);
		l2.setLabelFor(textField2);
		p.add(textField2);
		textField2.addActionListener(this);

		//Logg-inn knapp
		JButton b1 = new JButton("Log inn");
		b2 = new JButton("Registrer bruker");
		p.add(b1);
		p.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);

		SpringUtilities.makeCompactGrid(p,
				3, 2, 		 //rows, cols
				6, 6,        //initX, initY
				6, 6);       //xPad, yPad

		frame = new JFrame("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.setOpaque(true); 
		frame.setContentPane(p);
		frame.pack();
		frame.setVisible(true);

	}

	public String getBruker() {
		return bruker;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		ll = new LoginLogic(textField1.getText());

		char[] arr = textField2.getPassword();
		String output ="";
		for(char str: arr)
			output=output+str;

		if(e.getSource() == b2) {
			boolean check = ll.registrer(textField1.getText(),output);
			if (check == false) System.out.println("failed"); else System.out.println("Sucess");
		} else {

			if(output != "") {
				if (ll.isTrue(output) == true){
					System.out.println("Ja");
					bruker = textField1.getText();
					frame.dispose();
					new Avtale(getBruker());
				} else {
					System.out.println("Nei");
				}
			} else {
				System.out.println("Nei");
			}
		}
	}
}
