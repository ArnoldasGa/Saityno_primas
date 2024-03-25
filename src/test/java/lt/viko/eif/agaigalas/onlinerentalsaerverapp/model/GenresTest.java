package lt.viko.eif.agaigalas.onlinerentalsaerverapp.model;

import lt.viko.eif.agaigalas.onlinerentalserverapp.model.Genres;
import lt.viko.eif.agaigalas.onlinerentalserverapp.model.Movies;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GenresTest {
    Movies movies = new Movies();
    Genres genres = new Genres("Action");
    @Test
    public void getGenre() {
        String testGenre = genres.getGenreName();
        assertEquals("Action", testGenre);
    }
    @Test
    public void setGenres() {
        genres.setGenreName("Comedy");
        String testGenre = genres.getGenreName();
        assertEquals("Comedy",testGenre);
    }
}
