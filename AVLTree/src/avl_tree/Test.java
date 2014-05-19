package avl_tree;

import javax.swing.SwingUtilities;

public class Test {

	public static void main(String[] args)
	{
		  AVLTree tree = new AVLTree(10,5,20,8,128,88,4,7,2);
		  //AVLTree tree = new AVLTree(10,5,20);
		  final AVLNode root = tree.getRoot();
		 //AVLNode root = tree.getRoot();
		  System.out.println(root.getValue() + ", with height " + root.getHeight());
		  System.out.println(root.getLeft().getValue() + ", with height " + root.getLeft().getHeight());
		  System.out.println(root.getRight().getValue() + ", with height " + root.getRight().getHeight());
		  tree.print();
		  //tree.delete(8);
		  SwingUtilities.invokeLater(new Runnable() { public void run() {new BTreeDisplay(root, 50, 250);}});
		  //System.out.println(root.getLeft().getRight().getValue() + ", with height " + root.getLeft().getRight().getLeft().getHeight());
		  //System.out.println(root.getRight().getRight().getValue() + ", with height " + root.getRight().getRight().getHeight());
		  //tree.print();  //new tree print for check GitHub
	}

}
