package Mapping;


import ManyToOne.HibernateUtil;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Student st = new Student();
        st.setSName("rajiv");


        College clg = new College();
        clg.setName("NCCS");
//        clg.setStudent(st);
        session.save(clg);



        session.save(st);
        session.getTransaction().commit();
        session.close();
    }
}
