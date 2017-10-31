package lab10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

class Window extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	public JTextField disk;
	public JTextField path; 
	public JTextField name;
	public JTextField full;
	public JButton button;
	
	public Window (String text)
	{
		super(text);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setMinimumSize (new Dimension (400, 900));
		getContentPane ().setBackground(Color.green);
		setLayout (new FlowLayout ());
		button = new JButton ("Press");
		button.addActionListener (this);
		add (button);
		disk = new JTextField (15);
		add (disk);
		path = new JTextField (15);
		add (path);
		name = new JTextField (15);
		add (name);
		full = new JTextField (15);
		add (full);
		setVisible(true);
		pack();
	}
	
	@Override
	public void actionPerformed (ActionEvent e) {
		JButton button = ( JButton )e.getSource ();
		if (button.getText ().equals ("Press")) {
			full.setText(disk.getText () + "\\\\" + path.getText () + "\\\\" + name.getText()); 
}
	
}}

public class Prob1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Window ("First try");
	}

}
