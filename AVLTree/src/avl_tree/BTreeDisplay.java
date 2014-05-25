package avl_tree;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class BTreeDisplay extends NodeEdge
{
	static JFrame jfrm;
	static AVLPaint panel;
	
	static ArrayList <NodeEdge> Tree = new ArrayList<NodeEdge>();
	
	static 
	{
	jfrm = new JFrame("Paint Demo");
	panel = new AVLPaint();
	//panel.setTree(Tree);
	jfrm.add(panel); 
	jfrm.setSize(500, 500);
	jfrm.setLocationRelativeTo(null);
	jfrm.setVisible(true);
	panel.setLayout(null);
	panel.setTree(Tree);
	//panel.setBounds(0, 0, 250, 250);
	}

	
	BTreeDisplay(AVLNode tree, int x, int y)
	{
		if (tree != null) 
		{ 
			String value = String.valueOf(tree.value);
			this.x = x;
			this.y = y;
			this.xLeftEdge = x - 20;
			this.yLeftEdge = y + 20;
			this.xRightEdge = x + 20;
			this.yRightEdge = y + 20;
			this.key = value;
			this.rectangleColor = tree.color;
			Tree.add(new BTreeDisplay(tree.left, x - 20, y + 20));
			Tree.add(new BTreeDisplay(tree.right, x + 20, y + 20));
			this.initialised = true;
		} 
	}
	
	/*BTreeDisplay(AVLNode tree, int x, int y)
	{ 
		super
		BTreeDisplay b;
		if (tree != null) 
		{ 
			String value = String.valueOf(tree.value);
			if ((tree.left != null) && (tree.right != null))
				Tree.add(new NodeEdge(x, y, x - 20, y + 20, x + 20, y + 20, value, tree.color ));
			else
				if ((tree.left == null) && (tree.right == null))
					Tree.add(new NodeEdge(x, y, x, y, x, y, value, tree.color ));
				else
					if (tree.left == null)
						Tree.add(new NodeEdge(x, y, x, y, x + 20, y + 20, value, tree.color ));
					else
						Tree.add(new NodeEdge(x, y, x - 20, y + 20, x, y, value, tree.color ));
			b = new BTreeDisplay(tree.left, x - 20, y + 20);
			b = new BTreeDisplay(tree.right, x + 20, y + 20);
			//tree.panel.add(new BTreeDisplay(tree.left, x - 20, y + 20));
			//tree.panel.add(new BTreeDisplay(tree.right, x + 20, y + 20)); 
		}
	} */
}		
