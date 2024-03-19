package lt.viko.eif.agaigalas.onlinerentalserverapp.model;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity(name= "genres")
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private int id;
    @XmlAttribute(name = "genre")
    private String genreName;
    @ManyToMany(mappedBy = "movieGenres", cascade = CascadeType.ALL)
    private Set<Movies> genres = new HashSet<>();

    public Genres() {
    }

    public Genres(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public String toString() {
        return String.format(this.genreName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Movies> getGenres() {
        return genres;
    }

    public void setGenres(Set<Movies> genres) {
        this.genres = genres;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String name) {
        this.genreName = name;
    }
}
