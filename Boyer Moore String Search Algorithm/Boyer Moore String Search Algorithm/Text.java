
public class Text {

	//FÝELDS
	private String mainText;
	private Pattern searchingPattern;
	
	//CONSTRUCTOR
	public Text(String mainText) {
		setMainText(mainText);
		setSearchingPattern(null);
	}
	
	//SEARCH FUNCTÝON
	public int search(String searchingText) {
		
		setSearchingPattern( new Pattern(searchingText) );
		
		int counter = 0 , bmBC , bmGS; 
		int current_index =  searchingText.length()-1;
		
		while(current_index < getMainText().length()) {
			
			for(int i = 0 ; i<= searchingText.length() ; i++) {
				
				if( i == searchingText.length() ) {
					current_index += getSearchingPattern().getGoodSuffixTable().get(0);
					counter++;
				}
				else if( getMainText().charAt(current_index-i) == searchingText.charAt( searchingText.length()-1-i)){
					continue;
				}
				else {
					
					bmBC = badCharacterShiftingAmount( getSearchingPattern().getText().length()-1-i , getMainText().charAt(current_index-i));
					bmGS = getSearchingPattern().getGoodSuffixTable().get( getSearchingPattern().getText().length()-1-i );
					
					if( bmBC > bmGS) current_index += bmBC;
					else             current_index += bmGS;
					break;
				}
			}
		}
		return counter;
	}
	
	
	private int badCharacterShiftingAmount(int index , char bdc) {
		
		if( getSearchingPattern() != null )
			if( getSearchingPattern().getBadCharacterTable().containsKey(bdc))
				return getSearchingPattern().getBadCharacterTable().get(bdc)     - getSearchingPattern().getText().length()     + 1     + index;
			else
				return getSearchingPattern().getBadCharacterTable().get('*')     - getSearchingPattern().getText().length()     + 1     + index;
		else
			return -1;
	}

	
	//SET - GET FUNCTÝONS
	public String getMainText() {
		return mainText;
	}

	public void setMainText(String mainText) {
		this.mainText = mainText;
	}

	public Pattern getSearchingPattern() {
		return searchingPattern;
	}

	public void setSearchingPattern(Pattern searchingPattern) {
		this.searchingPattern = searchingPattern;
	}

	
}
