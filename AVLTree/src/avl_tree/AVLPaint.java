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

public class AVLPaint extends JPanel
{

	private ArrayList <NodeEdge> mTree;
	
	@Override
	public void paintComponent(Graphics g)
	{
		for (NodeEdge i : mTree)
		{
			switch(i.rectangleColor)
			{
			case 'b':
				g.setColor(Color.BLUE);
				break;
			case 'g':
				g.setColor(Color.GREEN);
				break;
			case 'r':
				g.setColor(Color.RED);
				break;
			}
			//g.setColor(Color.BLUE);
			g.fillRect (i.x, i.y, 10, 10);
			g.drawString(i.key, i.x, i.y);
	    	g.setColor(Color.BLACK);
	    	g.drawLine(i.x, i.y, i.xLeftEdge, i.yLeftEdge);
	    	g.drawLine(i.x, i.y, i.xRightEdge, i.yRightEdge);
		}
	}
	
	public void setTree(ArrayList <NodeEdge> param)
	{
		mTree = param;
	}

}
