package lt.viko.eif.agaigalas.onlinerentalserverapp.database;

import lt.viko.eif.agaigalas.onlinerentalserverapp.model.*;
import lt.viko.eif.agaigalas.onlinerentalserverapp.util.HibernateUtil;
import org.hibernate.Session;
import java.util.List;
/**
 * This class is responsible for loading movies from the database.
 */
public class DatabaseLoad {
    public static void loadAllMovies() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List < Movies > movies =
                    session.createQuery( "from movies", Movies.class).list();
            movies.forEach(System.out::println);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
