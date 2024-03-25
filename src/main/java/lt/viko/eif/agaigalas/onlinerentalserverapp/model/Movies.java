package lt.viko.eif.agaigalas.onlinerentalserverapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Table
@Entity(name= "movies")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    private int id;
    @XmlElement(name = "movieName")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_name_id")
    private MovieName movieName;

    /*@XmlElement(name = "genres")*/
    @XmlTransient
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private Set<Genres> movieGenres = new HashSet<>();

   /* @XmlElement(name = "actors")*/
    @XmlTransient
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private Set<Actors> movieActors = new HashSet<>();
    @XmlElement(name = "director")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id")
    private Director director;
    @XmlElement(name = "company")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private ProductionCompany productionCompany;

    public Movies() {
    }
    @Override
    public String toString(){
        return String.format("""
                Movie:
                    Movie name : %s
                    %s%s%s
                    %s""",
                this.movieName, constructGenre(), constructActors(),this.productionCompany,this.director);
    }
    private String constructGenre() {
        StringBuilder result = new StringBuilder();
        List<String> genresList = getGenresAsList();
        result.append("Genres: \n");
        for (String genres : genresList) {
            result.append("\t\tGenre: ").append(genres).append("\n");
        }
        return result.toString();
    }
    private String constructActors() {
        StringBuilder result = new StringBuilder();
        List<String> actorsAsList = getActorsAsList();
            result.append("\tActors List:\n");
            for (String actors : actorsAsList) {
                result.append(actors);
            }
        return result.toString();
    }

    public void setMovieName(MovieName movieName) {
        this.movieName = movieName;
    }

    public MovieName getMovieName() {
        return movieName;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @XmlElement(name = "genres")
    public List<String> getGenresAsList() {
        List<String> genresList = new ArrayList<>();
        for (Genres genre : movieGenres) {
            genresList.add(genre.getGenreName());
        }
        return genresList;
    }

    public void setMovieGenres(Set<Genres> movieGenres) {
        this.movieGenres = movieGenres;
    }

    @XmlElement(name = "actors")
    public List<String> getActorsAsList() {
        List<String> actorsList = new ArrayList<>();
        for (Actors actor : movieActors) {
            actorsList.add(actor.getActorsFirstName() + " " + actor.getActorsLastName());
        }
        return actorsList;
    }

    public void setMovieActors(Set<Actors> movieActors) {
        this.movieActors = movieActors;
    }

    public ProductionCompany getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(ProductionCompany productionCompany) {
        this.productionCompany = productionCompany;
    }

    public void assignGenres(Genres genre) {
        movieGenres.add(genre);
    }
    public void assignActors(Actors actor) {
        movieActors.add(actor);
    }

}
