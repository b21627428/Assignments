import java.util.LinkedList;
import java.util.Queue;

public class BST {

	public static final boolean RED = true;
	public static final boolean BLACK = false;
	
	private Node root; 
	
	//Constructors
	public BST() {
			
		setRoot(null);
	}
	
	//********************************
	
	//Create functions
	public void createBTS(String temp) {
		
		deleteAll();
		String []array = temp.split(",");
		for(int i=0; i<array.length ;i++) {
			setRoot( putBTS( getRoot(), Integer.parseInt(array[i]), 0));
		}
	}
	public void createFullBST(int height) {
		
		deleteAll();
	
		for(int i=1 ; i< Math.pow(2, height+1) ; i++) {
			setRoot( putFullBTS(getRoot(),i,0) );
		}
		updateLevels(getRoot(),0);
				
	}

	
	//********************************
	
	//Put functions
	private Node putBTS(Node x,int data,int level) {
		
		if(x==null) return new Node(data,level+1);
		
		int cmp = x.compareTo(data);
	
		if      (cmp == -1 ) x.setLeft (  putBTS(x.getLeft(),data,level+1)    );
		else if (cmp ==  0 ) x.setData (  data                             );
		else if (cmp ==  1 ) x.setRight(  putBTS(x.getRight(),data,level+1)   );
		
		return x;
	}
	private Node putFullBTS(Node x,int data,int level) {
		
		if(x==null) {
			
			if (  getRoot() == null)      return new Node(data,BLACK,level+1);
			else                          return new Node(data,RED,  level+1);
		}
		
		int cmp = x.compareTo(data);
	
		if      (cmp == -1 ) x.setLeft (  putFullBTS(x.getLeft(),data,level+1)    );
		else if (cmp ==  0 ) x.setData (  data                     );
		else if (cmp ==  1 ) x.setRight(  putFullBTS(x.getRight(),data,level+1)   );

		 if (isRed(x.getRight()) && !isRed(x.getLeft()))            x = rotateLeft(x);
		 if (isRed(x.getLeft()) && isRed(x.getLeft().getLeft()))    x = rotateRight(x);
		 if (isRed(x.getLeft()) && isRed(x.getRight()))             flipColors(x);
		 
		return x;
	}	
	
	

	
	//Rotate Left function
	private Node rotateLeft(Node x) {
		
		Node temp = x.getRight();
		
		x.setRight(temp.getLeft());
		temp.setLeft(x);
		temp.setColor(x.isColor());
		x.setColor(RED);
		
		return temp;
	}
	
	//Rotate Right
	private Node rotateRight(Node x) {
	
		Node temp = x.getLeft();
		
		x.setLeft( temp.getRight() );
		temp.setRight(x);
		temp.setColor(x.isColor());
		x.setColor(RED);
		
		return temp;
	}
	
	//Flip colors
	private void flipColors(Node x) {
	
		x.setColor(RED);
		x.getLeft().setColor(BLACK);
		x.getRight().setColor(BLACK);
	}
	
	
	//IsRed
	private boolean isRed(Node x) {
		
		if(x==null) return BLACK;
		return x.isColor() == RED ? true : false ;
	}
	

	//Delete All
	private void deleteAll() {
		setRoot(null);
	}
	// Deletes minimum node
	private Node deleteMin(Node x) {   
	
		if(x.getLeft() == null) return x.getRight();
		else x.setLeft( deleteMin(x.getLeft())  );
		return x;
	}
	// Returns minimum node
	private Node min(Node x) {  
		
		if(x.getLeft() == null) return x;
		else                    return min(x.getLeft());
	}
	//Delete function
	public Node delete(Node x) {
		
		if(x == null) return null;  // If node is null
		else {
			
			if(x.getLeft() == null && x.getRight() == null)  return null; // If it has no child
			else if(x.getRight() == null) return x.getLeft();             // If it has only left child
			else {                                                        // If it has left and right child
				
				Node t = x;
				x = min(t.getRight());
				
				x.setRight( deleteMin(t.getRight()) );
				x.setLeft(t.getLeft());
			
				return x;
			}
		}
	}
	
	
	
	//Find height function
	public int findHeight(Node x) {
		
		if(x==null) return 0; // if tree is empty
		return Math.max( findHeight(x.getLeft()), findHeight(x.getRight()) )+1;
	}
	//Find width function
	public int findWidth(Node x) {  // butun levellerin genislikleri ayni ise ne olacak?
		
		if(x == null) return 0;  // if tree is empty
		else {
			
			int level = 1 , counter = 0,  max=0;
			
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(x);

			while( queue.size() != 0) {
				
				x = queue.remove();
				
				// MaxLevel finding
				
				
				if(x.getLevel() == level ) counter++;
				else { if(counter>=max) max = counter;  counter=1;  level++; }
				//***********
				
				if(x.getLeft()  != null ) queue.add(x.getLeft());
				if(x.getRight() != null ) queue.add(x.getRight());
			}
			if(counter>=max) max = counter;
			
			return max;
		}
	}
	
	
	
	//Preorder
	public String preOrder(Node x) {
		
		String temp = "";
		
		if(x!=null) {
			
			temp = temp+x.getData()+" ";
			temp = temp+preOrder(x.getLeft());
			temp = temp+preOrder(x.getRight());
		}
		return temp;
	}
	//Inorder
	public String inOrder(Node x) {
		
		String temp = "";
		
		if(x!=null) {
			
			temp = temp+inOrder(x.getLeft());
			temp = temp+x.getData()+" ";
			temp = temp+inOrder(x.getRight());
		}
		return temp;
	}
	//LeavesAsc
	public String leavesAsc(Node x) {
		
		String temp = "";
		
		if(x == null) temp =  "Empty Tree";
		else {
			if(x.getLeft() == null && x.getRight() == null) temp = temp+x.getData()+" ";
			
			if(x.getLeft() != null) temp = temp+leavesAsc(x.getLeft());
			if(x.getRight() != null) temp = temp+leavesAsc(x.getRight());
		}
		return temp;
	}
	
	//Update levels funtionc for full BST because of rotating and flipping
	private void updateLevels(Node x,int level) {
		
		if(x==null) return;
		x.setLevel(level+1);
		updateLevels(x.getLeft(),level+1);
		updateLevels(x.getRight(),level+1);
	}
	
	//Set-get
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}

}
