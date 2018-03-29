package Criteria;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx;
        tx = session.beginTransaction();
        Student student = new Student();
        student.setId(1);
        student.setAddress("raniban");
        student.setMarks(90);
        student.setName("ramu");
        student.setStandard(10);
        session.save(student);
        tx.commit();

        tx = session.beginTransaction();
        Student student1 = new Student();
        student1.setId(2);
        student1.setAddress("ranibari");
        student1.setMarks(93);
        student1.setName("amol");
        student1.setStandard(10);
        session.save(student1);
        tx.commit();

        Criteria criteria = session.createCriteria(Student.class);
        criteria.add(Restrictions.gt("marks",90));

        List<Student> result = criteria.list();
        System.out.println(result);

        Criterion crn = Restrictions.gt("marks",90);
        Criterion crn1 = Restrictions.like("address","raniban");
        LogicalExpression le = Restrictions.or(crn,crn1);
        criteria.add(le);
        List<Student> topper = criteria.list();
        System.out.println(topper);

        session.close();

        HibernateUtil.shutdown();


    }
}
