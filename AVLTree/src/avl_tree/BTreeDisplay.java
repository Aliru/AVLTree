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

public class BTreeDisplay extends AVLPaint
{
	static JFrame jfrm;
	static JPanel panel;
	
	static ArrayList <NodeEdge> Tree = new ArrayList();
	
	static 
	{
	jfrm = new JFrame("Paint Demo");
	panel = new JPanel();
	jfrm.add(panel); 
	jfrm.setSize(500, 500);
	jfrm.setLocationRelativeTo(null);
	jfrm.setVisible(true);
	panel.setLayout(null);
	//panel.setBounds(0, 0, 250, 250);
	}

	BTreeDisplay(AVLNode tree, int x, int y)
	{ 
		
		if (tree != null) 
		{ 
			String value = String.valueOf(tree.value); 
			int pos = SwingConstants.CENTER;
			//Tree.add(new NodeEdge(250, 50, ));
			setBounds(new Rectangle(new Point(x, y), getPreferredSize()));
			panel.add(new BTreeDisplay(tree.left, x - 25, y + 20));
			panel.add(new BTreeDisplay(tree.right, x + 15, y + 20)); 
		} 
	}
}		
