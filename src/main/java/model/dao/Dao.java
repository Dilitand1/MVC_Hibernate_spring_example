package model.dao;

import model.entities.Account;
import model.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface Dao  {

    public List<Person> getClientsByName(String name);
    public Person getClientById(int id);
    public List getAllClients();
    public void addClient(Person o);
    public void dropClient(Person p);
    public void changeClient();

    public Account getAccountByNum(String acc);
    public List getAllOperations(String acc);

    public void deposit(Account o, double sum, String from);
    public void withdraw(Account o, double sum, String to) throws Exception;
    public void moneyTransfer(Account from, Account to, double sum);
    public void moneyTransfer(String from, String to, double sum) throws Exception;

    public List getAllClientsSimulation();
}
