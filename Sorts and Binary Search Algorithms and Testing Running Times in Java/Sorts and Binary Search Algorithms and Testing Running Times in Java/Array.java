import java.util.ArrayList;

public abstract class Array {

	private ArrayList<Integer> array ;
	
	public Array() {
		
		array = new ArrayList<Integer>();
	}
	public abstract void create(int numberOfElements);
	
	//Set-get method
	public ArrayList<Integer> getArray() {
		return array;
	}
	public void setArray(ArrayList<Integer> array) {
		this.array = array;
	}
}
