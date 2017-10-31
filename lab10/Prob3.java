package lab10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Kek extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	public JCheckBox one;
	public JCheckBox two;
	public JCheckBox three;
	public JCheckBox four;
	public JButton button;
	public JLabel asking;
	
	public Kek (String text, String question, String a, String b, String c, String d)
	{
		super(text);
		one = new JCheckBox (a);
		two = new JCheckBox (b);
		three = new JCheckBox (c);
		four = new JCheckBox (d);
		asking = new JLabel (question);
		button = new JButton ("Press");
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setMinimumSize (new Dimension (400, 900));
		getContentPane ().setBackground(Color.green);
		setLayout (new FlowLayout ());
		button.addActionListener(this); /*
		ButtonGroup group = new ButtonGroup();
		group.add(one);
		group.add(two);
		group.add(three);
		group.add(four); */
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
		if (e.getSource() instanceof JCheckBox)
		{
			button.setEnabled(true);
		}
		JButton button = (JButton)e.getSource ();
		if (button.getText ().equals ("Press"))
		{
			
			//if (one.isSelected())
				one.addItemListener(new ItemListener() {    
		             public void itemStateChanged(ItemEvent e) {                 
		            	 one.setBackground(Color.green);    
		             }    
		          }); 
			//if (two.isSelected())
				two.addItemListener(new ItemListener() {    
		             public void itemStateChanged(ItemEvent e) {                 
		            	 two.setBackground(Color.red);    
		             }    
		          });
			//if (three.isSelected())
				three.addItemListener(new ItemListener() {    
		             public void itemStateChanged(ItemEvent e) {                 
		            	 three.setBackground(Color.red);    
		             }    
		          });
			//if (four.isSelected())
				four.addItemListener(new ItemListener() {    
		             public void itemStateChanged(ItemEvent e) {                 
		            	 four.setBackground(Color.red);    
		             }    
		          });
			     
		}
	}
	
	
}

public class Prob3 {

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
		new Kek ("Question time!", question, one, two, three, four);
		scan.close();
	}

}