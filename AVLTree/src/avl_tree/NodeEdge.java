package avl_tree;

public class NodeEdge 
{
	public int x;
	public int y;
	public int xLeftEdge;
	public int yLeftEdge;
	public int xRighrEdge;
	public int yRighrEdge;
	public int key;
	
	public NodeEdge(int xn, int yn, int xel, int yel, int xer, int yer, int k)
	{
		this.x = xn;
		this.y = yn;
		this.xLeftEdge = xel;
		this.yLeftEdge = yel;
		this.xRighrEdge = xer;
		this.yRighrEdge = yer;
		this.key = k;
	}
}
