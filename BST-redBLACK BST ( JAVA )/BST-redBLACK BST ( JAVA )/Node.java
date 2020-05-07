
public class Node {

	private int data;
	private Node left;
	private Node right;
	private boolean color;
	private int level;
	
	//Constructor for BST
	public Node(int data,int level) {
		
		setData(data);
		setLeft(null);
		setRight(null);
		setColor(false);
		setLevel(level);
	}
	//Constructor for FullBST
	public Node(int data,boolean color,int level) {
		
		setData(data);
		setLeft(null);
		setRight(null);
		setColor(color);
		setLevel(level); 
	}
	
	//Data Compare function
	public int compareTo(int data) {
		return getData()<data ? 1 :     getData()>data ? -1 :      0 ;
	}
	
	
	
	
	
	//Data set-get
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	//Node set-get
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public boolean isColor() {
		return color;
	}
	public void setColor(boolean color) {
		this.color = color;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	



	
}
