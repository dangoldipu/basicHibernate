package AttributeOverride;

import org.hibernate.Session;

public class App {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User3 user = new User3();
        user.setName("Ramrijhan");

        Address homeAddress = new Address();
        homeAddress.setCity("siraha");
        homeAddress.setCountry("nepal");
        user.setHomeAddress(homeAddress);

        Address workAddress = new Address();
        workAddress.setCountry("Nepal");
        workAddress.setCity("Nueakot");
        user.setWorkAddress(workAddress);

        session.save(user);
        System.out.println(user);
        session.getTransaction().commit();
        session.close();

        Session session1 = HibernateUtil.getSessionFactory().openSession();
        session1.beginTransaction();
        final User3 user1 = session1.get(User3.class, 1L);
        System.out.println(user1);
        session1.close();

        HibernateUtil.shutdown();
    }
}
