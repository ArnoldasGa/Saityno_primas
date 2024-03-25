package lt.viko.eif.agaigalas.onlinerentalsaerverapp.model;

import lt.viko.eif.agaigalas.onlinerentalserverapp.model.Director;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectorTest {
    Director director = new Director("FirstName", "Last");
    @Test
    public void getActorFirstName() {
        String testDirector = director.getDirectorFirstName();
        assertEquals("FirstName", testDirector);
    }

    @Test
    public void setActorsLastName() {
        director.setDirectorLastName("LastName");
        String testDirectorLastName = director.getDirectorLastName();
        assertEquals("LastName", testDirectorLastName);
    }
}
