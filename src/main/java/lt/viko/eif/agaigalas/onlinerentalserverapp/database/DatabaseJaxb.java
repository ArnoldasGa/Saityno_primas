package lt.viko.eif.agaigalas.onlinerentalserverapp.database;

import lt.viko.eif.agaigalas.onlinerentalserverapp.model.Movies;
import lt.viko.eif.agaigalas.onlinerentalserverapp.util.HibernateUtil;
import lt.viko.eif.agaigalas.onlinerentalserverapp.util.JaxbUtil;
import lt.viko.eif.agaigalas.onlinerentalserverapp.util.MoviesWrapper;
import org.hibernate.Session;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for handling JAXB operations related to movies in the database.
 */
public class DatabaseJaxb {
    /**
     * Loads all movies from the database and marshals them into an XML file using JAXB.
     */
    public static void loadAllMovies() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Movies> moviesList = session.createQuery("from movies", Movies.class).list();
            MoviesWrapper moviesWrapper = new MoviesWrapper();
            moviesWrapper.setMovies(new ArrayList<>(moviesList));
            JaxbUtil.marshalToXML(moviesWrapper, new File("movies.xml"));
            System.out.println("Movies xml created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
