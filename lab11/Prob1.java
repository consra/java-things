package lab11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("unused")
class Book {
	public String title;
	public String author;
	
	public Book (String title, String author)
	{
		this.title = title;
		this.author = author;
	}
	
	public void setAuthor (String author)
	{
		this.author = author;
	}
	
	public String setAuthor ()
	{
		return this.author;
	}
	
	public void setTitle (String title)
	{
		this.title = title;
	}
	
	public String getTitle ()
	{
		return this.title;
	}
	
	public String toString ()
	{
		String book = this.title + " by " + this.author;
		return book;
	}
}

@SuppressWarnings("serial")
class Books extends JFrame implements ListSelectionListener {
	
	public JList<Book> list;
	public JPanel panel;
	
	public Books (String text)
	{
		super(text);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setMinimumSize (new Dimension (500, 600));
		getContentPane ().setBackground(Color.BLACK);
		setLayout (new FlowLayout());
		panel = new JPanel();
		Vector <Book> books = new Vector<>();
		books.add(new Book ("Morometii", "Marin Preda"));
		books.add(new Book ("Cel mai iubit dintre pamanteni", "Marin Preda"));
		books.add(new Book ("Delirul", "Marin Preda"));
		books.add(new Book ("Intrusul", "Marin Preda"));
		books.add(new Book ("Marele singuratic", "Marin Preda"));
		books.add(new Book ("Ion", "Liviu Rebreanu"));
		books.add(new Book ("Rascoala", "Liviu Rebreanu"));
		books.add(new Book ("Gorila", "Liviu Rebreanu"));
		books.add(new Book ("Amandoi", "Liviu Rebreanu"));
		books.add(new Book ("Padurea spanzuratilor", "Liviu Rebreanu"));
		books.add(new Book ("Ciuleandra", "Liviu Rebreanu"));
		books.add(new Book ("Craisorul", "Liviu Rebreanu"));
		books.add(new Book ("1984", "George Orwell"));
		books.add(new Book ("Patul lui Procust", "Camil Petrescu"));
		books.add(new Book ("Ultima noapte de dragoste, intaia noapte de razboi", "Camil Petrescu"));
		books.add(new Book ("Trei dinti din fata", "Marin Sorescu"));
		books.add(new Book ("Craisorul", "Liviu Rebreanu"));
		books.add(new Book ("Craisorul", "Liviu Rebreanu"));
		
		list = new JList<> (books);
		//list.setBounds(5, 5, 400, 200);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(2);
	    JScrollPane scrollableList = new JScrollPane(list);
	    //scrollableList.setAutoscrolls(true);
	    scrollableList.setPreferredSize(new Dimension(20, 100));
	    scrollableList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    panel.setLayout(new FlowLayout());
	    panel.add(scrollableList);
	    panel.add(list);
	    add(panel); 
	    //add(list);
	    //add(scrollableList);
		setVisible(true);
		pack();
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

public class Prob1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Books ("Books");
	}

}
