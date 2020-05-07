public class Main {
	
	public static void main(String[] args){
		
		
		ReadWrite.inputTxt( args[0] );                   // Girilen argümandaki komutlara göre database de değişiklik yapilir
		ReadWrite.outputTxt("output.txt");	             // inputTxt ( String filename ) fonksiyonu sonucunda bir array oluşur ve bu array içindekiler outputTxt ( String filename ) fonksiyonunda output.txt ye basılır. 
		ReadWrite.customerTxtUpdate("customer.txt");	 // Değişiklikler sonucunda elimizde bulunan customer database i dosyaya aktarılır.
		ReadWrite.orderTxtUpdate("order.txt"); 			 // Değişiklikler sonucunda elimizde bulunan order database i dosyaya aktarılır.
	
	}
}