

public class Main {

 
    public static void main(String[] args) {
        
        
        ReadWrite.createMap("gameGrid.txt");               // gameGrid.txt yi açıp 2 boyutlu bir array oluşturur.
        ReadWrite.fillMap("gameGrid.txt");                 // createMap methodunda oluşan arraye atamalar yapılır
        ReadWrite.playGame(System.in);                       // konsoldan girilen dosyanın içindeki komutlara göre arrayden silme ve kaydırma işlemleri yapan fonksiyonlar çağırılır.
        ReadWrite.compareLeaderBoard("leaderboard.txt");   // leaderboard.txt açılıp insanlar bir ArrayList e atılır ve güncellenir.

        
    }
    
}
