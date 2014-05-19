package avl_tree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AVLTree 
{
	public AVLNode root;
	
	public AVLTree()
	{
		root = null;
	}
	
	public AVLTree(int... values) 
	{
		 for (int value : values)
			 insert(value);
	}
	
	public AVLNode getRoot() 
	{
		return root;
	}
	
	public void insert(AVLNode node)
	{
		 if (root == null)
			 root = node;
		 else 
		 {
			 root.insertToLeaf(node);
		 AVLNode keyNode = updateHeightsAndDetectKeyNode(node);
		 if (keyNode != null) // rotate to adjust the tree
			   adjustTreeByRotation(keyNode);
		 }
	}
	
	public void insert(int value)
	{
		  if (root == null)
			  root = new AVLNode(value);
		  else 
		  {
			   AVLNode newNode = new AVLNode(value);
			   root.insertToLeaf(newNode);
			   AVLNode keyNode = updateHeightsAndDetectKeyNode(newNode);
			   if (keyNode != null) // rotate to adjust the tree
				   adjustTreeByRotation(keyNode);
		  }
	}
	
	public void delete(AVLNode node)
	{
		  int value = node.value;
		  delete(value);
	}
		  
	public void delete(int value) 
	{
		  AVLNode parentOfDeletedLeaf = deleteBeforeAdjustment(value);
		  if (parentOfDeletedLeaf != null) 
		  {
			  AVLNode keyNode = detectKeyNode(parentOfDeletedLeaf);
			  if (keyNode != null)
			  {
				  AVLNode newkeyNode = adjustTreeByRotation(keyNode);
				  updateHeights(newkeyNode.parent);
			  }
		  } 
		  else 
		  {
			  System.out.println("The AVLTree doesn't contain " + value);
		  }
	}
		 
	public AVLNode detectKeyNode(AVLNode parentOfDeletedLeaf)
	{
		AVLNode currentNode = parentOfDeletedLeaf;
		while (currentNode != null) 
		{
				   int bf = currentNode.getBalanceFactor();
				   if (bf == 2 || bf == -2)
					   return currentNode;
				   else
					   currentNode = currentNode.parent;
		}
		return null;
	}
		  
	public AVLNode deleteBeforeAdjustment(int value) 
	{
		AVLNode currentNode = root;
		while (currentNode != null) 
		{
			if (currentNode.value == value)
				 break;
			else
				 currentNode = value < currentNode.value ? currentNode.left : currentNode.right;
		}
		System.out.println();System.out.println(currentNode.getParent().getValue());
		if (currentNode != null) 
		{
		    while (!currentNode.isLeaf()) 
		    {
		    	AVLNode replacement = currentNode.getBalanceFactor() < 0 ? currentNode.right.getLeftmost() : currentNode.left.getRightmost();
		    	//System.out.println(replacement.value);
		    	System.out.println(replacement.getParent().value);
		    	//currentNode.value = replacement.value;
		    	currentNode = replacement;
		    	if (currentNode.value == (replacement.value))
		    		System.out.println("iiiiiii");
		    	System.out.println(replacement.getParent().getParent().value);
		   }
		   System.out.println("yyy" + currentNode.value);
		 
		   AVLNode parent = currentNode.getParent();
		   System.out.println(parent.getParent().getValue());
		   //System.out.println("yyy" + parent.value);
		   if (parent == null) 
			   root = null;
		   else 
			   if (currentNode == parent.left) 
				   parent.setLeft(null);
			   else
				   parent.setRight(null);
		   //System.out.println(parent.value);
		   updateHeights(parent);
		   //System.out.println(parent.value);
		   return parent;
		  }
		return null;
	}
		 
	public void updateHeights(AVLNode fromParentOfDeletedLeaf)
	{
		AVLNode currentNode = fromParentOfDeletedLeaf;
		currentNode.adjustHeight();
		while (currentNode != null)
		{
			currentNode.adjustHeight();
			currentNode = currentNode.parent;
		}
	}
		  
		 
	public AVLNode updateHeightsAndDetectKeyNode(AVLNode newNode) 
	{
		 AVLNode keyNode = null;
		 while (newNode.parent != null) 
		 {
			 if (newNode.getParent().height - newNode.height != 1) 
			 {
				if (keyNode == null) 
				{
					int bf_parent = newNode.getParent().getBalanceFactor();
					if (bf_parent > 1 || bf_parent < -1) 
					{
					      keyNode = newNode.getParent();
					      break;
					}
			    }
			   newNode.getParent().height++;
			   newNode = newNode.getParent();
		     }
		     else
			    break;
		  }
		 return keyNode;
	}
		 
	public AVLNode lookup(int value) 
	{
		AVLNode currentNode = root;
		while (currentNode != null) 
		{
			 if (currentNode.value == value)
				  return currentNode;
			 else
				  currentNode = value < currentNode.value ? currentNode.left : currentNode.right;
		}
		System.out.println("The AVLTree doesn't contain " + value);
		return null;
	}
		 
	public AVLNode adjustTreeByRotation(AVLNode keyNode) 
	{
		AVLNode newKeyNode = null;
		int bf_keyNode = keyNode.getBalanceFactor();
		if (bf_keyNode == 2) 
		{
			 if (keyNode.left.getBalanceFactor() == -1) // LR
				 keyNode.setLeft(keyNode.left.rotateLeft());
			 newKeyNode = keyNode.rotateRight();
		} 
		else 
			 if (bf_keyNode == -2) 
			 {
				  if (keyNode.right.getBalanceFactor() == 1) // RL
					  keyNode.setRight(keyNode.right.rotateRight());
				  newKeyNode = keyNode.rotateLeft();
			 }
			 else 
			 {
				  new Exception("There are some bugs").printStackTrace();
			 }
		 
		if (keyNode.parent == null) 
		{
			   root = newKeyNode;
			   root.parent = null;
		}
		else 
		{
			  if (keyNode == keyNode.parent.left)
				  keyNode.parent.setLeft(newKeyNode);
			  else
				  keyNode.parent.setRight(newKeyNode);
			  newKeyNode.parent.adjustHeight();
		}
		return newKeyNode;
	}
		 
	public void print() 
	{	  
		root.print_inorder();
	}	 	  
}
