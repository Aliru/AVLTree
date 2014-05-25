package avl_tree;

public class AVLNode 
{
		 
		 public AVLNode left, right, parent;
		 public int value;
		 public int height;
		 public char color;
		 
		 public AVLNode(AVLNode node)
		 {
			  this.value = node.value;
			  this.height = node.height;
			  this.left = node.left;
			  this.right = node.right;
			  this.color = 'g';
		 }
		  
		 public AVLNode(int v)
		 {
			  this.value = v;
			  this.height = 0;
			  this.color = 'g';
		 }
		  
		 public int getValue()
		 {
			 return value;
		 }
		  
		 public AVLNode getParent() 
		 {
			 return parent;
		 }
		  
		 public AVLNode getLeft() 
		 {
			 return left;
		 }
		  
		 public void setLeft(AVLNode l)
		 {
			  this.setBlue();
			  this.left = l;
			  if (l != null)
				  l.parent = this;
		 }
		  
		 public AVLNode getRight() 
		 {
			 return right;
		 }
		  
		 public void setRight(AVLNode r)
		 {
			  this.setBlue();
			  this.right = r;
			  if (r != null)
				  r.parent = this;
		 }
		  
		 public int getHeight() 
		 {
			 return height;
		 }
		  
		 public int getLevel()
		 {
			  int level = 0;
			  AVLNode currentNode = this;
			  while ((currentNode = currentNode.parent) != null)
				  level++;
			  return level;
		 }
		  
		 public int getBalanceFactor()
		 {
			  int leftHeight = getLeftHeight();
			  int rightHeight = getRightHeight();
			  return leftHeight - rightHeight;
		 }
		 
		 public void adjustHeight()
		 {
			  int leftHeight = getLeftHeight();
			  int rightHeight = getRightHeight();
			  height = (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
		 } 
			  
		 public int getLeftHeight()
		 {
			  return left == null ? -1 : left.height; 
		 }
			  
		 public int getRightHeight()
		 {
			  return right == null ? -1 : right.height;
		 }
			  
		 public boolean isLeaf()
		 {
			  return (left == null && right == null);
		 }
		 			  
		 public void insertToLeaf(AVLNode node)
		 {
			  this.setBlue();
			  if (node.value == value)
			  {
				   System.out.println("Duplicate node " + value);
				   return;
			  }
			  else 
			  {
				  
				  if (node.value < value)
				  {
				    if (left == null)   
				    	setLeft(node);
				    else 
				    	left.insertToLeaf(node);
				  }
				  else 
				  {
					  if (right == null) 
						  setRight(node);
					  else 
						  right.insertToLeaf(node);
				  }
			  }
		  }
		 
		 public AVLNode getLeftmost()
		 {
			  AVLNode leftmost = this;
			  while (leftmost.left != null)
				  leftmost = leftmost.left;
			  return leftmost;
		 }
			  
		 public AVLNode getRightmost()
		 {
			  AVLNode rightmost = this;
			  while (rightmost.right != null)
				  rightmost = rightmost.right;
			  return rightmost;
		 }
		 
		 
		 public AVLNode rotateRight()
		 {
			  AVLNode newRight = new AVLNode(this);
			  newRight.height = getRightHeight() + 1;
			  newRight.setLeft(left.right);
			  left.setRight(newRight);
			  left.adjustHeight();
			  return left;
		 }
		 
		  public AVLNode rotateLeft()
		  {
			  AVLNode newLeft = new AVLNode(this);
			  newLeft.height = getLeftHeight() + 1;
			  newLeft.setRight(right.left);
			  right.setLeft(newLeft);
			  right.adjustHeight();
			  return right;
		  }
		 
		 public void print_inorder()
		 {
			  if (left != null) 
				  left.print_inorder();
			  System.out.print(value + " ");
			  if (right != null) 
				  right.print_inorder();
		 }
		 
		 public void setBlue()
		 {
			 if (left != null) 
				 left.setBlue();
		  	 this.color = 'b';
		  	 if (right != null)
		  		 right.setBlue();
		 }
		 
		 public void get()
		 {
			  System.out.println(this.value + this.right.value + this.left.value + this.parent.value);
		 }
}
