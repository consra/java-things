package lab11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



@SuppressWarnings("serial")
class Carti extends JFrame implements ListSelectionListener, ActionListener {
	
	public JList<Book> list;
	public JPanel panel_1;
	public JPanel panel_2;
	public JTextField autor;
	public JTextField titlu;
	public JButton button;
	public DefaultListModel <Book> listing;
	
	public Carti (String text)
	{
		super(text);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setMinimumSize (new Dimension (700, 600));
		getContentPane ().setBackground(Color.BLACK);
		setLayout (new FlowLayout());
		panel_1 = new JPanel();
		panel_2 = new JPanel();
		listing = new DefaultListModel<>();
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
	    add(panel_1); 
	    add(button);
		setVisible(true);
		pack();
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		if (list.isSelectionEmpty())
			{
				return;
			}

			button.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {

	            	button = (JButton)e.getSource();
	        			if (button.getText().equals("Delete"))
	        			{
	        				listing.remove(list.getSelectedIndex());
	        			}
	            }
	        });

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton)e.getSource();
		if (list.isSelectionEmpty())
			button.setEnabled(false);
		System.out.println(list.getLeadSelectionIndex());
		if (list.getSelectedIndex() != -1)
		{
			if (button.getText().equals("Delete"))
			{
				list.remove(list.getSelectedIndex());
			}
		}
	}
	
}

public class Prob3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Carti ("Books");
	}

}