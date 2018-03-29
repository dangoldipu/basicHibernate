package ColumnTransformer;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

//        final User user = new User();
//        user.setHeightInInches(10L);
//        session.save(user);
//        session.getTransaction().commit();
//        session.close();
//        User user = new User();
//        user.setId(1);
//
//        user.setAddress();
//
//        Session session1 = HibernateUtil.getSessionFactory().openSession();
//        session1.beginTransaction();
//        final User user1 = session1.get(User.class, 1L);
//        System.out.println(user1);
//        session1.close();

    }
}
