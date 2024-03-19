package lt.viko.eif.agaigalas.onlinerentalserverapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity(name= "actors")
public class Actors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actors_id")
    private int id;
    @XmlAttribute(name = "firstName")
    public String actorsFirstName;
    @XmlAttribute(name = "lastName")
    public String actorsLastName;

    @ManyToMany(mappedBy = "movieActors")
    private Set<Movies> actors = new HashSet<>();

    public Actors(String actorsFirstName, String actorsLastName) {
        this.actorsFirstName = actorsFirstName;
        this.actorsLastName = actorsLastName;
    }

    public Actors() {

    }

    @Override
    public String toString() {
        return String.format(
                """
                \t\tActor:
                \t\t\tFirst Name: %s
                \t\t\tLast name: %s
                """,this.actorsFirstName,this.actorsLastName);
    }

    public Set<Movies> getActors() {
        return actors;
    }

    public void setActors(Set<Movies> actors) {
        this.actors = actors;
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
