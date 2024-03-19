package lt.viko.eif.agaigalas.onlinerentalserverapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;


@Table
@Entity(name= "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    private int id;
    @XmlAttribute(name = "movieName")
    @Column(name = "movie_name")
    private String movieName;
    @XmlElement(name = "genres")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "genre_list",
    joinColumns = @JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genres> movieGenres = new HashSet<>();
    @XmlElement(name = "actors")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "actors_list",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actors_id"))
    private Set<Actors> movieActors = new HashSet<>();
    @XmlElement(name = "director")
    @OneToOne(cascade = CascadeType.ALL)
    private Director director = new Director();
    @XmlElement(name = "company")
    @OneToOne(cascade = CascadeType.ALL)
    private ProductionCompany productionCompany = new ProductionCompany();
    public Movies(String movieName) {
        this.movieName = movieName;
    }

    public Movies() {
    }

    @Override
    public String toString(){
        return String.format("""
                Movie name : %s
                    Genres: %s
                %s%s
                %s""",
                this.movieName, constructGenre(), constructActors(),this.productionCompany,this.director);
    }
    private String constructGenre() {
        StringBuilder result = new StringBuilder();
        for (Genres genres : movieGenres) {
            result.append(genres).append(", ");
        }
        if (!result.isEmpty()) {
            result.setLength(result.length() - 2);
        }
        return result.toString();
    }
    private String constructActors() {
        StringBuilder result = new StringBuilder();
            result.append("\tActors List:\n");
            for (Actors actors : movieActors) {
                result.append(actors);
            }
        return result.toString();
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

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Set<Genres> getMovieGenres() {
        return movieGenres;
    }

    public void setMovieGenres(Set<Genres> movieGenres) {
        this.movieGenres = movieGenres;
    }

    public Set<Actors> getMovieActors() {
        return movieActors;
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
