import java.util.HashMap;

public class Pattern {

	private String text;
	private HashMap<Character,Integer> badCharacterTable;
	private HashMap<Integer,Integer> suffixTable,goodSuffixTable;
	
	public Pattern(String text) {
		setText(text);
		
		setBadCharacterTable(new HashMap<Character,Integer>());
		setGoodSuffixTable(new HashMap<Integer,Integer>());
		setSuffixTable(new HashMap<Integer,Integer>());
		createTables();
	}
	
	private void createTables() {
		createBadCharacterTable();
		createSuffixTable();
		createGoodSuffixTable();
	}
	private void createBadCharacterTable() {
		
		for(int i=getText().length()-2 ; i>=0 ; i--) {
			if( !getBadCharacterTable().containsKey(getText().charAt(i))) {
				getBadCharacterTable().put(getText().charAt(i), getText().length()-i-1);
			}
		}
		getBadCharacterTable().put('*',getText().length());
	}
	private void createSuffixTable() {
		
		for(int i=0 ; i< getText().length() ; i++) {
			
			int counter = 0;
			for(int j = getText().length()-1 ; j >= getText().length()-1-i ; j-- ) {
				if(getText().charAt(j) == getText().charAt(i-counter)) {
					counter++;
				}
				else {
					break;
				}
			}
			getSuffixTable().put(i, counter);
		}
	}
	private void createGoodSuffixTable() {
		
		for(Integer temp : getSuffixTable().keySet() ) {
			
			if(getSuffixTable().get(temp) == 0 || getSuffixTable().get(temp) == 1)      getGoodSuffixTable().put(temp, getText().length()-1);
			else if( getSuffixTable().get(temp) == getText().length())                  getGoodSuffixTable().put(temp, getText().length()-temp);
			else                                                                        getGoodSuffixTable().put(temp, getSuffixTable().get(temp));
		}
	}

	
	//Set-get
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public HashMap<Character,Integer> getBadCharacterTable() {
		return badCharacterTable;
	}


	public void setBadCharacterTable(HashMap<Character,Integer> badCharacterTable) {
		this.badCharacterTable = badCharacterTable;
	}

	public HashMap<Integer, Integer> getSuffixTable() {
		return suffixTable;
	}

	public void setSuffixTable(HashMap<Integer, Integer> suffixTable) {
		this.suffixTable = suffixTable;
	}

	public HashMap<Integer, Integer> getGoodSuffixTable() {
		return goodSuffixTable;
	}

	public void setGoodSuffixTable(HashMap<Integer, Integer> goodSuffixTable) {
		this.goodSuffixTable = goodSuffixTable;
	}

	
}
