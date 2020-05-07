
public class Student {
	
	private String name ,  average ;
	private int firstExam , finalExam;

	public Student( String name , String firstExam , String finalExam , String average  ) {
		
		setName(name);
		setFirstExam( Integer.parseInt(firstExam) );
		setFinalExam( Integer.parseInt(finalExam) );
		setAverage(average);
	}
	public Student() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAverage() {
		return average;
	}
	public void setAverage(String average) {
		this.average = average;
	}

	public int getFirstExam() {
		return firstExam;
	}
	public void setFirstExam(int firstExam) {
		this.firstExam = firstExam;
	}
	public int getFinalExam() {
		return finalExam;
	}
	public void setFinalExam(int finalExam) {
		this.finalExam = finalExam;
	}


}
