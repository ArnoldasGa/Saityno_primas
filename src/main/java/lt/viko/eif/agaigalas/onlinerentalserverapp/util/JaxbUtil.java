package lt.viko.eif.agaigalas.onlinerentalserverapp.util;

import lt.viko.eif.agaigalas.onlinerentalserverapp.model.Movies;

import javax.xml.bind.*;
import java.io.File;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JaxbUtil {
    private static final Logger LOGGER = Logger.getLogger(JaxbUtil.class.getName());

    public static void marshalToXML(Object object, File xmlFile) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(object, xmlFile);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

        public static <T> T unmarshalFromXML(Class<T> type, File xmlFile) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(type);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return type.cast(unmarshaller.unmarshal(xmlFile));
    }
}