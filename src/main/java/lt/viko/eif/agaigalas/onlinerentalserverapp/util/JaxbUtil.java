package lt.viko.eif.agaigalas.onlinerentalserverapp.util;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.logging.Logger;
import javax.xml.validation.Validator;
/**
 * Utility class for JAXB (Java Architecture for XML Binding) operations.
 * This class provides methods for marshalling and unmarshalling XML data using JAXB,
 * as well as XML validation against an XSD schema.
 */

public class JaxbUtil {
    private static final Logger LOGGER = Logger.getLogger(JaxbUtil.class.getName());

    /**
     * Marshals the given object to an XML file.
     *
     * @param object  The object to be marshalled.
     * @param xmlFile The XML file to which the object will be marshalled.
     */
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

    /**
     * Unmarshal XML data from the given file into an object of the specified type.
     *
     * @param type    The class type of the object to unmarshal.
     * @param xmlFile The XML file containing the data to be unmarshalled.
     * @param <T>     The generic type of the unmarshalled object.
     * @return The unmarshalled object.
     * @throws JAXBException If an error occurs during unmarshalling.
     */
        public static <T> T unmarshalFromXML(Class<T> type, File xmlFile) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(type);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return type.cast(unmarshaller.unmarshal(xmlFile));
    }
    /**
     * Validates the given XML file against the specified XSD schema file.
     *
     * @param xmlFilePath The path to the XML file to be validated.
     * @param xsdFilePath The path to the XSD schema file for validation.
     */

    public static void validateXml(String xmlFilePath, String xsdFilePath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File xsdFile = new File(xsdFilePath);
            Schema schema = factory.newSchema(xsdFile);

            Validator validator = schema.newValidator();

            Source xmlFile = new StreamSource(new File(xmlFilePath));
            validator.validate(xmlFile);

            System.out.println("Validation successful: " + xmlFilePath);
        } catch (Exception e) {
            System.err.println("Validation failed: " + e.getMessage());
        }
    }
}