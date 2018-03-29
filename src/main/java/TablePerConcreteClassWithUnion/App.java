package TablePerConcreteClassWithUnion;

import org.hibernate.Session;

public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();


        session.getTransaction().commit();
        session.close();

        HibernateUtil.shutdown();
    }
}
