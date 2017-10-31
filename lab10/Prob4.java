package lab10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;

class Slider extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JSlider one;
	public JSlider two;
	public JSlider three;
	
	public Slider (String text)
	{
		super(text);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize (new Dimension (900 , 400));
		getContentPane().setBackground(Color.green);
		setLayout (null);
		one = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		two = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		three = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		one.setBounds(0, 0, 200, 10);
		two.setBounds(0, 100, 200, 10);
		three.setBounds(0, 200, 200, 10);
		JTextField texting = new JTextField(30);
		texting.setBounds(10, 300, 100, 30);
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(one, BorderLayout.PAGE_START);
		panel.add(two, BorderLayout.CENTER);
		panel.add(three, BorderLayout.PAGE_END);
		add(one);
		add(two);
		add(three);
		add(texting);
		setVisible(true);
		pack();
	}
	public void stateChanged(ChangeEvent h) {
        System.out.println("Slider2: " + one.getValue());
      }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		one.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent h) {
		        System.out.println("Slider2: " + one.getValue());
		      }
		    });
	}
	
}

public class Prob4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Slider("window");
	}

}
