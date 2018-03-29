package UpdatableFalse;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashMap;
import java.util.Map;

import static org.hibernate.cfg.AvailableSettings.*;

public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                // Create registry builder
                final StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                final Map<String, String> settings = new HashMap<>();
                settings.put(URL, "jdbc:mysql://localhost:3306/demo");
                settings.put(USER, "root");
                settings.put(PASS, "");
                settings.put(DIALECT, "org.hibernate.dialect.MySQL55Dialect");
                settings.put(HBM2DDL_AUTO, "create-drop");
                settings.put(SHOW_SQL, "true");
                settings.put(FORMAT_SQL, "true");
                settings.put(STORAGE_ENGINE, "innodb");

                // Apply settings
                registryBuilder.applySettings(settings);

                // Create registry
                registry = registryBuilder.build();

                // Create MetadataSources
                final MetadataSources sources = new MetadataSources(registry);
                sources.addAnnotatedClass(User.class);

                // Create Metadata
                final Metadata metadata = sources.getMetadataBuilder().build();

                // Create SessionFactory
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

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
