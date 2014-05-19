package avl_tree;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class BTreeDisplay extends JPanel
{
	JFrame jfrm = new JFrame("Paint Demo");
        
        
        BTreeDisplay(AVLNode tree)
        {           
        
           
           JPanel panel = new JPanel();  
           if (tree != null) 
           {          
               String value = String.valueOf(tree.value);  
               int pos = SwingConstants.CENTER;
               JLabel rootLabel = new JLabel(value, pos);
               //JLabel rootLabel = new JLabel(value);
               //panel.add(rootLabel, BorderLayout.NORTH);
               panel.add(rootLabel);
               panel.add(new BTreeDisplay(tree.left));
               panel.add(new BTreeDisplay(tree.right));    
               //add(panel);
               //jfrm.add(panel);
               //panel.setVisible(true);
               //jfrm.setVisible(true);
           }       
           jfrm.add(panel);
           jfrm.setSize(200, 200);
           jfrm.setVisible(true);
        }   
 }		
