package Embeddable;

import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User2 user = new User2();
        user.setName("neupane");

        Address adrs = new Address();
        adrs.setCity("ktm");
        adrs.setCountry("nepal");

        user.setHomeAddress(adrs);

        session.save(user);
        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();

    }
}
