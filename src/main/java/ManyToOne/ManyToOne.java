package ManyToOne;

import org.hibernate.Session;

public class ManyToOne {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        College college = new College();
        college.setName("NCCs");

        session.save(college);

        Student student = new Student();
        student.setName("raman");
        student.setCollege(college);

        session.save(student);

        Student student1 = new Student();
        student1.setCollege(college);
        student1.setName("rajiv");
        session.save(student1);

        session.getTransaction().commit();
        session.close();

        Session session1 = HibernateUtil.getSessionFactory().openSession();
        session1.beginTransaction();

        Student student2=session1.get(Student.class,1L);
        System.out.println(student2);

        session1.getTransaction().commit();
        session1.close();

        HibernateUtil.shutdown();
    }
}
