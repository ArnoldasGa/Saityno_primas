package lt.viko.eif.agaigalas.onlinerentalserverapp.database;

import lt.viko.eif.agaigalas.onlinerentalserverapp.model.*;
import lt.viko.eif.agaigalas.onlinerentalserverapp.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.*;

/**
 * This is a class to add to Database a new entry
 */
public class DatabaseAdd {
    /**
     * Adds a new movie entry to the database.
     *
     * @param Name        The name of the movie.
     * @param actorsList  A list of actors starring in the movie.
     * @param genresList  A list of genres associated with the movie.
     * @param director    The director of the movie.
     * @param studio The production company of the movie.
     */
public static void addMovie(String Name, List<String> actorsList, List<String> genresList, Director director, ProductionCompany studio) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Movies movie = new Movies();
    MovieName movieName = new MovieName(Name);
    movie.setMovieName(movieName);
    for (String actor : actorsList) {
        String[] actorInfo = actor.split(",");
        String firstName = actorInfo[0];
        String lastName = actorInfo[1];
        Actors actors = new Actors(firstName, lastName);
        actors.setMovie(movie);
        movie.assignActors(actors);
    }
    for (String genre : genresList) {
        Genres genres = new Genres(genre);
        genres.setMovie(movie);
        movie.assignGenres(genres);
    }
    movie.setDirector(director);
    movie.setProductionCompany(studio);
    Transaction transaction = null;
    try {
        transaction = session.beginTransaction();
        session.save(movie);
        transaction.commit();
        System.out.println("Movie added successfully.");
    } catch (HibernateException e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    } finally {
        session.close();
    }
}
}
