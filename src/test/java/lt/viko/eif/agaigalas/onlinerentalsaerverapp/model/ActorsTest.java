package lt.viko.eif.agaigalas.onlinerentalsaerverapp.model;

import lt.viko.eif.agaigalas.onlinerentalserverapp.model.Actors;
import lt.viko.eif.agaigalas.onlinerentalserverapp.model.Movies;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorsTest {
    Actors actors = new Actors("Name","SurName");
    @Test
    public void getActorFirstName() {
        String testActor = actors.getActorsFirstName();
        assertEquals("Name", testActor);
    }

    @Test
    public void setActorsLastName() {
        actors.setActorsLastName("LastName");
        String testActorLastName = actors.getActorsLastName();
        assertEquals("LastName", testActorLastName);
    }

}
