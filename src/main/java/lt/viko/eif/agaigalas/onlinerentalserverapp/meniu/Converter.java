package lt.viko.eif.agaigalas.onlinerentalserverapp.meniu;

import  lt.viko.eif.agaigalas.onlinerentalserverapp.model.*;
import lt.viko.eif.agaigalas.onlinerentalserverapp.util.HibernateUtil;
import org.hibernate.Session;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class Converter {
    public static void pojoToJaxb(){
/*        List<Movies> movies = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            movies = session.createQuery("from movies", Movies.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            JAXBContext context = JAXBContext.newInstance(Movies.class);
            Marshaller mar= context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(movies, new File("movie.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        List<Movies> moviesList = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            moviesList = session.createQuery("from Movies", Movies.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            MoviesWrapper wrapper = new MoviesWrapper();
            wrapper.setMovies(moviesList);

            JAXBContext context = JAXBContext.newInstance(MoviesWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(wrapper, new File("movie.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
