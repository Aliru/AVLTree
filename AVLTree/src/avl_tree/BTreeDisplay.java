package avl_tree;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class BTreeDisplay extends JLabel
{
	static JFrame jfrm;
	static JPanel panel;
	static 
	{
		jfrm = new JFrame("Paint Demo");
		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		//jfrm.setLayout(null);
		jfrm.add(panel);
		jfrm.setSize(500, 500);
		//jfrm.setLocationByPlatform(true);
		jfrm.setVisible(true);
	}
        
        BTreeDisplay(AVLNode tree, int x, int y)
        {           
           if (tree != null) 
           {          
               String value = String.valueOf(tree.value);  
               int pos = SwingConstants.CENTER;
               setText(value);
               //setHorizontalAlignment(pos);
               panel.add(this);
               //setLocation(x, y);
               setBounds(new Rectangle(new Point(x, y), getPreferredSize()));
               panel.add(new BTreeDisplay(tree.left,  x - 20, y + 20));
               panel.add(new BTreeDisplay(tree.right,  x + 20, y + 20));    
           }       
        }   
 }		
