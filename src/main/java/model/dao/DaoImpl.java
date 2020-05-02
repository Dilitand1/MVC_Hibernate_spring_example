package model.dao;
import model.entities.Account;
import model.entities.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoImpl implements Dao {

    private SessionFactory sessionFactory;

    @Autowired
    public DaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Person getClientById(int id) {
        Session session = sessionFactory.openSession();
        Person person = (Person) session.get(Person.class,id);
        return person;
    }

    @Override
    public List<Person> getClientsByName(String name) {
        Session session = sessionFactory.openSession();
        List list = session.createQuery("Select p FROM Person p where name = :name").setParameter("name",name).list();
        return list;
    }

    @Override
    public List getAllClients() {
        List list = sessionFactory.openSession().createQuery("FROM Person").list();
        return list;
    }

    @Override
    public void addClient(Object o) {

    }

    @Override
    public void dropClient(int id) {

    }

    @Override
    public void changeClient() {

    }

    @Override
    public void deposit(Object o) {

    }

    @Override
    public void withdraw(Object o) {

    }

    @Override
    public void moneyTransfer(Object o1, Object o2) {

    }

    @Override
    public List getAllClientsSimulation() {
        List list = new ArrayList();

        Person p1 = new Person();
        p1.setId(1);
        p1.setName("first");

        Person p2 = new Person();
        p2.setId(2);
        p2.setName("second");

        list.add(p1);
        list.add(p2);

        return list;
    }
}
