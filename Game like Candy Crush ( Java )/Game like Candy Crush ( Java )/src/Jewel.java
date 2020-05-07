

public interface Jewel {               /* Diamond , Square , Triangle , Wildcard , Minus ,Line ,Slash ,ReverseSlash , Plus birer jeweldir. Her jewelin compare
                                        fonksiyonu farklı olduğu için ayrıca mapi jewellerden oluşturabilmek için bu interface yazılmıştır. */
    boolean compare(int rowCoordinate ,int columnCoordinate ,int row ,int column , Jewel[][] array  );
    
    String getName();
    int getPoint();
    String getType();
    



}
