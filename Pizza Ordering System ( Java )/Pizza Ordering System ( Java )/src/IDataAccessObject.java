import java.util.ArrayList;

public interface IDataAccessObject {

   
            Object getByID(int ID); //Id ye gore listeden o objeyi ceker.
            
            String deleteByID(int ID); //Id ye gore listeden siler eger yoksa false return eder
            
            boolean	add(Object object); //Gelen objeyi listeye ekler.

            ArrayList<Object> getAll(); // listeyi doner.

            void update();  // Listeyi sort eder.
}
