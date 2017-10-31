package lab11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

@SuppressWarnings("serial")
class FileSystem extends JFrame {
	
	public JTree tree;
	public JTable table;
	public DefaultMutableTreeNode tree_node;
	
	@SuppressWarnings("null")
	public DefaultMutableTreeNode addPaths (String tree)
	{
		DefaultMutableTreeNode node = null;
		DefaultMutableTreeNode system = null;
		File root = new File(tree);
		File[] files = root.listFiles();
		for (File fisier: files)
		{
			node = addPaths(fisier.getName());
			system.add(node);
		}
		return system;
	}
	
	public FileSystem (String text, String directory)
	{
		super(text);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setMinimumSize (new Dimension (700, 450));
		getContentPane ().setBackground(Color.black);
		setLayout (new GridLayout (1, 0));
		setVisible(true);
		DefaultMutableTreeNode tree_node = new DefaultMutableTreeNode (directory);
		DefaultMutableTreeNode kek = new DefaultMutableTreeNode ("kek");
		tree_node.add(kek);
		tree_node.add(new DefaultMutableTreeNode("pederast"));
		kek.add(new DefaultMutableTreeNode("get rekt"));
		tree = new JTree(tree_node);
		String[] columns = {"File name", "Size", "Last Modified", "Type"};
		String[][] rows = {{directory, "128K", "19/07/2017", "Folder"}, {"kek", "69K", "19/07/2017", "Script"}};
		table = new JTable(rows, columns);
		table.setLayout(new BorderLayout(1, 0));
		add(tree);
		add(table);
		pack();
	}
	
}

public class Prob4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileSystem("Files", "‪D:\\rufus_files");
	}

}
