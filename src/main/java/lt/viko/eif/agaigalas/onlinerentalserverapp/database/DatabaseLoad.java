package lt.viko.eif.agaigalas.onlinerentalserverapp.database;

import lt.viko.eif.agaigalas.onlinerentalserverapp.model.*;
import lt.viko.eif.agaigalas.onlinerentalserverapp.util.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

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
    public static void loadAllGenres() {
        List<Genres> genres = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            genres = session.createQuery("from genres", Genres.class).list();
            genres.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
