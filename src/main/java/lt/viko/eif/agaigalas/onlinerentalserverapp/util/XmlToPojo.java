package lt.viko.eif.agaigalas.onlinerentalserverapp.util;
import lt.viko.eif.agaigalas.onlinerentalserverapp.model.Movies;
import java.io.File;
import static lt.viko.eif.agaigalas.onlinerentalserverapp.util.JaxbUtil.unmarshalFromXML;
/**
 * Utility class for converting XML data to POJO (Plain Old Java Object) using JAXB.
 * This class provides a method to unmarshal XML data from a file into a list of Movie objects.
 */
public class XmlToPojo {
    /**
     * Unmarshal XML data from the specified file into a list of Movie objects and prints them.
     */
    public static void xmlToPojo()
    {
        try {
            File xmlFile = new File("movies.xml");
            MoviesWrapper moviesList = unmarshalFromXML(MoviesWrapper.class, xmlFile);

            for (Movies movie : moviesList.getMovies()) {
                System.out.println("Movie: " + movie.getMovieName().getMovieName());
                System.out.println("Director: " + movie.getDirector().getDirectorFirstName() + " " + movie.getDirector().getDirectorLastName());
                System.out.println("Production Company: " + movie.getProductionCompany().getCompanyName());
                System.out.println("Actors: " + String.join(", ", movie.getActorsAsList()));
                System.out.println("Genres: " + String.join(", ", movie.getGenresAsList()));
                System.out.println();
            }
        } catch (javax.xml.bind.JAXBException e) {
            e.printStackTrace();
        }
    }

}
