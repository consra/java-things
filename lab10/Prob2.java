package lab10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

class Question extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	public JRadioButton one;
	public JRadioButton two;
	public JRadioButton three;
	public JRadioButton four;
	public JButton button;
	public JLabel asking;
	
	public Question (String text, String question, String a, String b, String c, String d)
	{
		super(text);
		one = new JRadioButton (a);
		two = new JRadioButton (b);
		three = new JRadioButton (c);
		four = new JRadioButton (d);
		asking = new JLabel (question);
		button = new JButton ("Press");
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setMinimumSize (new Dimension (400, 900));
		getContentPane ().setBackground(Color.green);
		setLayout (new FlowLayout ());
		button.addActionListener(this);
		ButtonGroup group = new ButtonGroup();
		group.add(one);
		group.add(two);
		group.add(three);
		group.add(four);
		add(asking);
		add(one);
		add(two);
		add(three);
		add(four);
		add(button);
		setVisible(true);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof JRadioButton)
		{
			button.setEnabled(true);
		}
		JButton button = (JButton)e.getSource ();
		if (button.getText ().equals ("Press"))
		{
			if (one.isSelected())
				one.setBackground(Color.green);
			if (two.isSelected())
				two.setBackground(Color.red);
			if (three.isSelected())
				three.setBackground(Color.red);
			if (four.isSelected())
				four.setBackground(Color.red);
		}
	}
	
	
}

public class Prob2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = null;
		try {
			scan = new Scanner (new File ("C:\\Users\\User\\Desktop\\intrebare.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String question = scan.nextLine();
		String one = scan.nextLine();
		String two = scan.nextLine();
		String three = scan.nextLine();
		String four = scan.nextLine();
		new Question ("Question time!", question, one, two, three, four);
		scan.close();
	}

}
