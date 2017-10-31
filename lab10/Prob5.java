package lab10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

class Colors extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton button;
	
	public Colors (String text)
	{
		super(text);
		button = new JButton ("Colors");
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setMinimumSize (new Dimension (100, 100));
		getContentPane ().setBackground(Color.BLACK);
		setLayout (new FlowLayout ());
		button.addActionListener (this);
		button.setMnemonic(KeyEvent.VK_C);
		add(button);
		setVisible(true);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource ();
		Color[] col = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, 
				Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.WHITE, 
				Color.MAGENTA, Color.ORANGE, Color.RED, Color.PINK};
		if (button.getText ().equals ("Colors")) {
			Random rand = new Random ();
			int random_1 = rand.nextInt(12);
			int random_2 = rand.nextInt(12);
			while (random_1 == random_2)
				random_2 = rand.nextInt(12);
			button.setBackground(col[random_1]);
			button.setForeground(col[random_2]);
		}
	}
}

public class Prob5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Colors("plm");
	}

}
