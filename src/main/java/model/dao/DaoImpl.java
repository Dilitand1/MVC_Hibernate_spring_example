package model.dao;
import model.entities.Person;
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
    public void getClient(int id) {

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
