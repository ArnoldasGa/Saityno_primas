package lt.viko.eif.agaigalas.onlinerentalserverapp.util;
import org.hibernate.SessionFactory;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;
/**
 * Utility class for managing the Hibernate SessionFactory.
 * This class provides methods to obtain the SessionFactory object.
 */

public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;
    /**
     * Retrieves the Hibernate SessionFactory instance.
     * If the SessionFactory is not initialized, it configures and builds it.
     *
     * @return The Hibernate SessionFactory instance.
     */
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            try {
                registry = new StandardServiceRegistryBuilder().configure().build();
                MetadataSources sources = new MetadataSources(registry);
                Metadata metadata = sources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }
    /**
     * Shuts down the Hibernate registry.
     * This method should be called when the application is shutting down to release resources.
     */
    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

}
