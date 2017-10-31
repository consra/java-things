package lab11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;


import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



@SuppressWarnings("serial")
class Booking extends JFrame implements ListSelectionListener {
	
	public JList<Book> list;
	public JPanel panel_1;
	public JPanel panel_2;
	public JTextField autor;
	public JTextField titlu;
	public JButton button;
	
	public Booking (String text)
	{
		super(text);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setMinimumSize (new Dimension (700, 600));
		getContentPane ().setBackground(Color.BLACK);
		setLayout (new FlowLayout());
		panel_1 = new JPanel();
		panel_2 = new JPanel();
		DefaultListModel <Book> listing = new DefaultListModel<>();
		listing.addElement(new Book ("Morometii", "Marin Preda"));
		listing.addElement(new Book ("Cel mai iubit dintre pamanteni", "Marin Preda"));
		listing.addElement(new Book ("Delirul", "Marin Preda"));
		listing.addElement(new Book ("Intrusul", "Marin Preda"));
		listing.addElement(new Book ("Marele singuratic", "Marin Preda"));
		listing.addElement(new Book ("Ion", "Liviu Rebreanu"));
		listing.addElement(new Book ("Rascoala", "Liviu Rebreanu"));
		listing.addElement(new Book ("Gorila", "Liviu Rebreanu"));
		listing.addElement(new Book ("Amandoi", "Liviu Rebreanu"));
		listing.addElement(new Book ("Padurea spanzuratilor", "Liviu Rebreanu"));
		listing.addElement(new Book ("Ciuleandra", "Liviu Rebreanu"));
		listing.addElement(new Book ("Craisorul", "Liviu Rebreanu"));
		listing.addElement(new Book ("1984", "George Orwell"));
		listing.addElement(new Book ("Patul lui Procust", "Camil Petrescu"));
		listing.addElement(new Book ("Ultima noapte de dragoste, intaia noapte de razboi", "Camil Petrescu"));
		listing.addElement(new Book ("Trei dinti din fata", "Marin Sorescu"));
		button = new JButton ("Delete");
		list = new JList<> (listing);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(2);
	    JScrollPane scrollableList = new JScrollPane(list);
	    scrollableList.setPreferredSize(new Dimension(20, 300));
	    scrollableList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    panel_1.setLayout(new FlowLayout());
	    panel_1.add(scrollableList);
	    panel_1.add(list);
	    JLabel author = new JLabel ("Author");
	    JLabel title = new JLabel ("Title");
	    autor = new JTextField(40);
	    titlu = new JTextField(40);
	    panel_2.setLayout(new GridLayout());
	    panel_2.add(author);
	    panel_2.add(title);
	    panel_2.add(autor);
	    panel_2.add(titlu);
	    add(panel_1); 
	    add(panel_2);
	    //add(button);
		setVisible(true);
		pack();
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		if (list.isSelectionEmpty())
			return;
		if (arg0.getValueIsAdjusting())
		{
			int index = list.getSelectedIndex();
			if (index != -1)
			{
				autor.setText(list.getSelectedValue().author);
				titlu.setText(list.getSelectedValue().title);
			}
				
		}
	}
}

public class Prob2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Booking ("Books");
	}

}