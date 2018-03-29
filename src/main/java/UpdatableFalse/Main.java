package UpdatableFalse;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        final User user = new User();
        user.setName("USER");
        user.setCreationDate(LocalDate.now());

        session.save(user);
        session.getTransaction().commit();
        session.close();

        Session session1 = HibernateUtil.getSessionFactory().openSession();
        session1.beginTransaction();

        final User user1 = session1.get(User.class, 1L);
        user1.setName("Updated User");
        user1.setCreationDate(LocalDate.now().minus(10, ChronoUnit.DAYS));
        System.out.println("After Setting: " + user1);

        session1.update(user1);
        session1.refresh(user1); // sync db values and object values
        System.out.println("After Refresh: " + user1);
        session1.getTransaction().commit();
        session1.close();

        Session session2 = HibernateUtil.getSessionFactory().openSession();
        session2.beginTransaction();
        final User user2 = session2.get(User.class, 1L);
        System.out.println("Fetching " + user2);
        session2.getTransaction().commit();
        session2.close();
        HibernateUtil.shutdown();

    }
}
