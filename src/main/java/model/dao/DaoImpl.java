package model.dao;
import model.entities.Account;
import model.entities.Accountop;
import model.entities.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class DaoImpl implements Dao {

    private SessionFactory sessionFactory;

    @Autowired
    public DaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Person> getClientsByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        List list = session.createQuery("Select p FROM Person p where name = :name").setParameter("name",name).list();
        return list;
    }

    @Override
    public List getAllClients() {
        List list = sessionFactory.getCurrentSession().createQuery("FROM Person").list();
        return list;
    }

    @Override
    @Transactional
    public Person getClientById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person person = (Person) session.get(Person.class,id);
        return person;
    }

    @Override
    @Transactional(readOnly = true)
    public Account getAccountByNum(String account) {
        Session session = sessionFactory.getCurrentSession();
        //Вариант без костылей
        Account acc = (Account) session.bySimpleNaturalId(Account.class).load(account);
        //Вариант с костылями
        //List<Account> querry = session.createQuery("Select a FROM Account a where acc = :acc").setParameter("acc",account).list();
        //Integer id = querry.get(0).getId();
        //Account acc = (Account) session.get(Account.class,id);
        return acc;
    }

    @Override
    public List getAllOperations(String acc) {
        return sessionFactory.getCurrentSession()
        .createQuery("select  op FROM Account a join Accountop op on a.id = op.account where a.acc = :acc")
                .setParameter("acc",acc).list();
    }

    @Override
    @Transactional
    public void addClient(Person o) {
        sessionFactory.getCurrentSession().save(o);
    }

    @Override
    @Transactional
    public void dropClient(Person p) {
        sessionFactory.getCurrentSession().delete(p);
    }

    @Override
    public void changeClient() {

    }


    @Override
    @Transactional
    public void deposit(Account a, double sum, String from) {
        sum = Math.abs(sum);
        Session session = sessionFactory.getCurrentSession();

        //Если объявлена аннотация transactional то это не нужно:
        //Transaction transaction = session.beginTransaction();
        //transaction.commit();

        Accountop accountop = new Accountop(new Date(),sum);
        accountop.setDebet(from);
        Account account = (Account) session.load(Account.class,a.getId());
        account.addAccountOp(accountop);
        session.saveOrUpdate(account);
    }

    @Override
    @Transactional
    public void withdraw(Account a, double sum, String to) throws Exception {
        sum = sum > 0 ? sum*(-1) : sum;
        if (a.getBalance() < Math.abs(sum)) throw new Exception("Недостаточно средств");
        Session session = sessionFactory.getCurrentSession();
        Accountop accountop = new Accountop(new Date(),sum);
        accountop.setDebet(to);
        Account account = (Account) session.load(Account.class,a.getId());
        account.addAccountOp(accountop);
        session.saveOrUpdate(account);
    }

    @Override
    @Transactional
    public void moneyTransfer(Account from, Account to, double sum) {

    }

    @Override
    @Transactional
    public void moneyTransfer(String from, String to, double sum) throws Exception {
        Account accFrom = getAccountByNum(from);
        Account accTo = getAccountByNum(to);
        withdraw(accFrom,sum,accTo.getAcc());
        deposit(accTo,sum, accFrom.getAcc());
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

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
