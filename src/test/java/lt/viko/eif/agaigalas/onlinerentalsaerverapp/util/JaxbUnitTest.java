package lt.viko.eif.agaigalas.onlinerentalsaerverapp.util;

import lt.viko.eif.agaigalas.onlinerentalserverapp.model.*;
import lt.viko.eif.agaigalas.onlinerentalserverapp.util.JaxbUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JaxbUnitTest {
    Movies movies = new Movies();
    MovieName movieName = new MovieName("Movies");
    Actors actors = new Actors("First","Last");
    Director director = new Director("FirstName", "LastName");
    Genres genres = new Genres("Action");
    ProductionCompany productionCompany = new ProductionCompany("Company");


@Test
public void transformToXML() {
    movies.setMovieName(movieName);
    movies.setProductionCompany(productionCompany);
    movies.setDirector(director);
    movies.assignGenres(genres);
    movies.assignActors(actors);
    File xmlFile = new File("movieTest.xml");

    try {
        JaxbUtil.marshalToXML(movies, xmlFile);
        assertTrue(xmlFile.exists());
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    @Test
    public void testUnmarshalToPOJO() {
        File xmlFile = new File("movie.xml");

        try {
            Movies movie = JaxbUtil.unmarshalFromXML(Movies.class, xmlFile);
            Assertions.assertNotNull(movie);
            assertEquals("Movies", movie.getMovieName().getMovieName());
            assertEquals("FirstName", movie.getDirector().getDirectorFirstName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
