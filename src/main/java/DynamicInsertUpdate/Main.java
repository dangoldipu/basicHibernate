package DynamicInsertUpdate;

import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = DynamicInsertUpdate.HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        final User user = new User();
        user.setFirstName("dipu");
        session.save(user);
        session.getTransaction().commit();
        session.close();

        Session session1 = DynamicInsertUpdate.HibernateUtil.getSessionFactory().openSession();
        session1.beginTransaction();
        user.setLastName("rai");
        session1.save(user);
        session1.getTransaction().commit();
        session1.close();
        DynamicInsertUpdate.HibernateUtil.shutdown();
    }
}
