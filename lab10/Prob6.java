package lab10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Fisier extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton button;
	public JScrollPane scroll;
	public JTextField field;
	public JLabel label;
	public JTextArea file_text;
	
	public Fisier (String text)
	{
		super(text);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setMinimumSize (new Dimension (900, 400));
		getContentPane ().setBackground(Color.BLACK);
		setLayout (new FlowLayout ());
		button = new JButton ("Show");
		button.addActionListener(this);
		label = new JLabel ("Path");
	//	button.setBounds(60, 30, 150, 20);
	//	label.setBounds(120, 60, 60, 20);
		label.setForeground(Color.WHITE);
		field = new JTextField(20);
		file_text = new JTextArea (20, 30);
	//	field.setBounds(50, 80, 300, 400);
		scroll = new JScrollPane(file_text);
		scroll.setPreferredSize(new Dimension(40,40));
		file_text.setLineWrap (true);
		file_text.setWrapStyleWord (true);
		file_text.setFont (new Font ("Times New Roman", 0, 12));
		scroll.setVisible(false);
		add(file_text);
		add(scroll);
		add(field);
		add(label);
		add(button);
		setVisible(true);
		pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		if (button.getText().equals("Show"))
		{
			File file = new File (field.getText());
			if (file.exists() && !file.isDirectory())
			{
				scroll.setVisible(true);
				Scanner scan = null;
				try {
					scan = new Scanner (file);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String text = "";
				while (scan.hasNextLine())
					text = text + scan.nextLine() + "\n";
				scan.close();
				file_text.setText(text);
			}
			else {
				field.setText("");
			}
		}
			
	}
	
}

public class Prob6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Fisier ("MOCANU GAY");
	}

}
