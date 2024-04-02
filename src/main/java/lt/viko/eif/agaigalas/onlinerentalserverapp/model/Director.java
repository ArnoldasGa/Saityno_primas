package lt.viko.eif.agaigalas.onlinerentalserverapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * This is the Directors model class
 */

@Table
@Entity(name= "director")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "director_id")
    private int id;
    @XmlElement(name = "firstName")
    private String directorFirstName;
    @XmlElement(name = "lastName")
    private String directorLastName;

    public Director(String directorFirstName, String directorLastName) {
        this.directorFirstName = directorFirstName;
        this.directorLastName = directorLastName;
    }

    public Director() {

    }

    @Override
    public String toString() {
        return String.format("""
                Director:
                \t\tFirst Name: %s
                \t\tLast name: %s
                """,this.directorFirstName,this.directorLastName);
    }

    public String getDirectorFirstName() {
        return directorFirstName;
    }

    public void setDirectorFirstName(String firstName) {
        this.directorFirstName = firstName;
    }

    public String getDirectorLastName() {
        return directorLastName;
    }

    public void setDirectorLastName(String lastName) {
        this.directorLastName = lastName;
    }

}
