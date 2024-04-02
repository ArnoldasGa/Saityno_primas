package lt.viko.eif.agaigalas.onlinerentalserverapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * This is the Genres class
 */

@Table
@Entity(name= "genres")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private int id;
    @XmlAttribute(name = "genre")
    private String genreName;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movies movie;


    public Genres(String genreName) {
        this.genreName = genreName;
    }

    public Genres() {

    }

    @Override
    public String toString() {
        return String.format(this.genreName);
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String name) {
        this.genreName = name;
    }
}