package lt.viko.eif.agaigalas.onlinerentalserverapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Table
@Entity(name= "movieName")
@XmlAccessorType(XmlAccessType.FIELD)
public class MovieName {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_name_id")
    private int id;

    @XmlElement(name = "movieName")
    private String movieName;

    public MovieName(String movieName) {
        this.movieName = movieName;
    }

    public MovieName() {

    }

    @Override
    public String toString() {
        return String.format("%s", this.movieName);
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
}