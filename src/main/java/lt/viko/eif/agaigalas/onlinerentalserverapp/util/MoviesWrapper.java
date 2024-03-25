package lt.viko.eif.agaigalas.onlinerentalserverapp.util;

import lt.viko.eif.agaigalas.onlinerentalserverapp.model.Movies;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "moviesList")
@XmlAccessorType(XmlAccessType.FIELD)
public class MoviesWrapper {
    @XmlElement(name = "movie")
    private List<Movies> movies;

    public MoviesWrapper() {
        movies = new ArrayList<>();
    }

    public List<Movies> getMovies() {
        return movies;
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }
}