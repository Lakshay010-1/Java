package org.program.Hibernate_ORM;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.program.Hibernate_ORM.model.Coder;
import org.program.Hibernate_ORM.model.Cohort;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Configuration configuration=new Configuration().configure().addAnnotatedClass(org.program.Hibernate_ORM.model.Coder.class);
        configuration.addAnnotatedClass(org.program.Hibernate_ORM.model.Cohort.class);
        StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySetting(configuration.getProperties());
        SessionFactory factory=configuration.buildSessionFactory(builder.build());
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();

//      CRUD Operations
        Cohort team1=new Cohort(1,"ABC");
//        Create
        Coder c1=new Coder(1,"A",5,team1);
        session.save(c1);

//        Read
        Coder c2=session.get(Coder.class,2);
        System.out.println("Details of Coder 2 are "+c2);

//        Update
        Coder c3=session.get(Coder.class,3);
        c3.setName("X");
        c3.setRating(10);
        session.save(c3);
        
//        Delete
        Coder c4=session.get(Coder.class,4);
        session.delete(c4);



//        HQL - Hibernate Query Language
        Query findall=session.createQuery("from myDBCoder");
        List<Coder> coderList=findall.list();
        System.out.println("Coder details :");
        for(Coder c:coderList){
            System.out.println(c);
        }
        Query findByName=session.createQuery("from myDBCoder where name=:name");
        findByName.setParameter("name","X");
        System.out.println(findByName);

        Query findById=session.createQuery("from myDBCoder where id between :id1 and :id2 order by name asc");
        findById.setParameter("id1",2);
        findById.setParameter("id2",10);
        List<Coder> idList=findById.list();
        System.out.println(idList);



//        Mapping
        Cohort team2=new Cohort(3,"CDE");
        Coder c5=new Coder(5,"L",10,team2);

        transaction.commit();
        session.close();

        
    }
}
