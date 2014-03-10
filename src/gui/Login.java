package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import logikk.SpringUtilities;

public class Login extends JFrame {
	
	public Login() {
	String[] labels = {"Brukernavn: ", "Passord: "};
	int numPairs = labels.length;

	//Create and populate the panel.
	JPanel p = new JPanel(new SpringLayout());
	for (int i = 0; i < numPairs; i++) {
	    JLabel l = new JLabel(labels[i], JLabel.TRAILING);
	    p.add(l);
	    JTextField textField = new JTextField(10);
	    l.setLabelFor(textField);
	    p.add(textField);
	}
	JButton b1 = new JButton("Log inn");
	JLabel l = new JLabel(" ");
	p.add(b1);
	p.add(l);
	
	SpringUtilities.makeCompactGrid(p,
                3, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
	
    JFrame frame = new JFrame("Login");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Set up the content pane.
    p.setOpaque(true);  //content panes must be opaque
    frame.setContentPane(p);

    //Display the window.
    frame.pack();
    frame.setVisible(true);
    
	}
}
