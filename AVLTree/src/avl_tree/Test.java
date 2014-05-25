package avl_tree;

import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;

public class Test {

	public static void main(String[] args) throws Exception
	{
		  //AVLTree tree = new AVLTree(10,5,20,8,128,88,4,7,2);
		  AVLTree tree = new AVLTree(10,5,20,8);
		  final AVLNode root = tree.getRoot();
		  //AVLNode root = tree.getRoot();
		  System.out.println(root.getValue() + ", with height " + root.getHeight());
		  System.out.println(root.getLeft().getValue() + ", with height " + root.getLeft().getHeight());
		  System.out.println(root.getRight().getValue() + ", with height " + root.getRight().getHeight());
		  tree.print();
		  //String key = JOptionPane.showInputDialog( "Enter key" ); //add Exceptions
		  //int value = Integer.parseInt(key); 
		  //tree.delete(value);
		  tree.insert(75);
		  //tree.insert(0);
		  System.out.println(tree.getRoot().value);
		  tree.print();
		  updateScreenTree(tree.getRoot());
		  Thread.sleep(10000);
		  tree.insert(36);
		  updateScreenTree(tree.getRoot());
		  //
		  //String key = JOptionPane.showInputDialog( "Enter key" ); //add Exceptions
		  //int value = Integer.parseInt(key); 
		  //tree.delete(value);
		  //SwingUtilities.invokeLater(new Runnable() { public void run() {new BTreeDisplay(root, 250, 50);}});
		  //System.out.println(root.getLeft().getRight().getValue() + ", with height " + root.getLeft().getRight().getLeft().getHeight());
		  //System.out.println(root.getRight().getRight().getValue() + ", with height " + root.getRight().getRight().getHeight());
		  //tree.print();  //new tree print for check GitHub
	}
	
	static public void updateScreenTree(final AVLNode Root)
	  {
		  SwingUtilities.invokeLater(new Runnable() 
		  { 
		  public void run() 
		  {  
			  if (!BTreeDisplay.Tree.isEmpty())
				  BTreeDisplay.Tree.clear();
			  {
				  BTreeDisplay.Tree.add(new BTreeDisplay(Root, 250, 50)); 
				  BTreeDisplay.panel.invalidate(); 
				  BTreeDisplay.panel.repaint();
			  }
		  }
		  });
	  }

}
