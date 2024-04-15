package lt.viko.eif.agaigalas.onlinerentalserverapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * This is the actors model class
 */
@Table
@Entity(name= "actors")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Actors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actors_id")
    private int id;
    @XmlAttribute(name = "firstName")
    private String actorsFirstName;
    @XmlAttribute(name = "lastName")
    private String actorsLastName;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movies movie;

    public Actors(String actorsFirstName, String actorsLastName) {
        this.actorsFirstName = actorsFirstName;
        this.actorsLastName = actorsLastName;
    }

    public Actors(Movies movie) {
        this.movie = movie;
    }

    public Actors() {

    }

    @Override
    public String toString() {
        return String.format(
                """
                \n\t\tActor:
                \t\t\tFirst Name: %s
                \t\t\tLast name: %s""",
                this.actorsFirstName, this.actorsLastName);
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    public String getActorsFirstName() {
        return actorsFirstName;
    }

    public void setActorsFirstName(String actorsFirstName) {
        this.actorsFirstName = actorsFirstName;
    }

    public String getActorsLastName() {
        return actorsLastName;
    }

    public void setActorsLastName(String actorsLastName) {
        this.actorsLastName = actorsLastName;
    }

}