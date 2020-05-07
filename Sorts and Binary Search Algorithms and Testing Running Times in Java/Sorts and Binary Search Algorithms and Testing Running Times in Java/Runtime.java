import java.io.BufferedWriter;
import java.io.FileWriter;

public abstract class Runtime {

	private static long startTime,endTime,totalTime;
	
	public static void calculate( ) {
	
		FileWriter fWriter = null;
		BufferedWriter writer = null;
		
		try {
			
			fWriter = new FileWriter("output.txt");
			writer = new BufferedWriter(fWriter);
			try {
				
				
				//SORT KISMI
				
				
				
				String []sorts = {"radixSort","selectionSort","insertionSort","mergeSort"};
				
				for(int j=0 ; j<4 ; j++) {
					
					
					
					//REVERSEDSORTED
					writer.write("begin worst "+sorts[j].substring(0, sorts[j].indexOf("S") ));  writer.newLine();
					for(int i=120 ; i<7000 ; i=i+250) {
						
						double toplam =0;
						
						for(int k=0 ; k<10; k++) {
							
							toplam+= Sort.HelpSort(sorts[j],(new reversedSortedArray(i)).getArray() );
						}
						writer.write(i+" : "+(toplam/10));
						writer.newLine();
					}
					writer.write("end"); 
					writer.newLine(); writer.newLine();
					
					
					
					//MIXED
					writer.write("begin avr "+sorts[j].substring(0, sorts[j].indexOf("S") ));  writer.newLine();
					for(int i=120 ; i<7000 ; i=i+250) {
					
						double toplam =0;
						
						for(int k=0 ; k<10; k++) {
							
							toplam+= Sort.HelpSort(sorts[j],(new mixedArray(i)).getArray() );
						}
						writer.write(i+" : "+(toplam/10));
						writer.newLine();
					}
					writer.write("end"); 
					writer.newLine();  writer.newLine();
					
					
					
					//Sorted
					writer.write("begin best "+sorts[j].substring(0, sorts[j].indexOf("S") ));  writer.newLine();
					for(int i=120 ; i<7000 ; i=i+250) {

						double toplam =0;
						
						for(int k=0 ; k<10; k++) {
							
							toplam+= Sort.HelpSort(sorts[j],(new sortedArray(i)).getArray() );
						}
						writer.write(i+" : "+(toplam/10));
						writer.newLine();
					}
					writer.write("end"); 
					writer.newLine(); writer.newLine();
				}
				
				
				
				
				
				

				//SEARCH KISMI
				
				//Worst -> Eleman olmama durumu
				writer.write("begin worst binary");  writer.newLine();
				for(int i=120 ; i<7000 ; i=i+250) {
					
					double toplam =0;
					
					for(int k=0 ; k<10; k++) {
						
						startTime = System.nanoTime();
						Search.binarySearch( (new sortedArray(i)).getArray(), i );
						endTime   = System.nanoTime();
						totalTime = endTime - startTime;
						
						toplam+= totalTime/10e5;
					}
					writer.write(i+" : "+(toplam/10));
					writer.newLine();
				}
				writer.write("end"); 
				writer.newLine();  writer.newLine();
				
				
				//Average -> Eleman var fakat middle da degil
				writer.write("begin avr binary");  writer.newLine();
				int random = 0;
				for(int i=120 ; i<7000 ; i=i+250) {
					
					double toplam =0;
					
					for(int k=0 ; k<10; k++) {
						
						random = (int )(Math.random() *i );
						startTime = System.nanoTime();
						Search.binarySearch( (new sortedArray(i)).getArray(), random );
						endTime   = System.nanoTime();
						totalTime = endTime - startTime;
						
						toplam+= totalTime/10e5;
					}
					writer.write(i+" : "+(toplam/10));
					writer.newLine();
				}
				writer.write("end"); 
				writer.newLine();  writer.newLine();
				
				
				//Best -> Eleman var ve middle da
				writer.write("begin best binary");  writer.newLine();
				for(int i=120 ; i<7000 ; i=i+250) {
					
					double toplam =0;
					
					for(int k=0 ; k<10; k++) {
						
						startTime = System.nanoTime();
						Search.binarySearch( (new sortedArray(i)).getArray(), (i-1)/2 );
						endTime   = System.nanoTime();
						totalTime = endTime - startTime;
						
						toplam+= totalTime/10e5;
					}
					writer.write(i+" : "+(toplam/10));
					writer.newLine();
				}
				writer.write("end"); 
				writer.newLine();  writer.newLine();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			writer.close();
		}
		catch(Exception e) {
			System.out.println("Dosya Hatasi");
		}		
	}
	
	
	
	


}
