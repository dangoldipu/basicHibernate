package TablePerHierarchy;

import org.hibernate.Session;

public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Child1 child = new Child1();
        child.setAddr("ktm");
        child.setId(1);
        child.setGender("m");
        session.save(child);

        Child2 child2 = new Child2();
        child2.setAddr("npl");
        child2.setId(2);
        child2.setGender("f");
        session.save(child2);


        session.getTransaction().commit();
        session.close();

        Session session1 = HibernateUtil.getSessionFactory().openSession();
        session1.beginTransaction();
        Parent parent = session1.get(Parent.class,1);
        System.out.println(parent);
        session1.getTransaction().commit();
        session1.close();

        Session session2 = HibernateUtil.getSessionFactory().openSession();
        session2.beginTransaction();
        Parent parent1 = session2.get(Child1.class,1);
        System.out.println(parent1);

        session2.getTransaction().commit();
        session2.close();

        HibernateUtil.shutdown();
    }
}
